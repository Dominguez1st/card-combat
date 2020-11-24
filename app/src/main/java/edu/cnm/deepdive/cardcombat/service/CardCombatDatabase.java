package edu.cnm.deepdive.cardcombat.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.cardcombat.model.dao.AttackCardDao;
import edu.cnm.deepdive.cardcombat.model.dao.DeckDao;
import edu.cnm.deepdive.cardcombat.model.dao.GameDao;
import edu.cnm.deepdive.cardcombat.model.dao.UnitCardDao;
import edu.cnm.deepdive.cardcombat.model.dao.UserDao;
import edu.cnm.deepdive.cardcombat.model.entity.AttackCard;
import edu.cnm.deepdive.cardcombat.model.entity.Deck;
import edu.cnm.deepdive.cardcombat.model.entity.Game;
import edu.cnm.deepdive.cardcombat.model.entity.UnitCard;
import edu.cnm.deepdive.cardcombat.model.entity.User;
import edu.cnm.deepdive.cardcombat.model.type.AttackType;
import edu.cnm.deepdive.cardcombat.model.type.Unit;
import edu.cnm.deepdive.cardcombat.service.CardCombatDatabase.Converters;
import java.nio.ByteBuffer;
import java.util.UUID;

@Database(entities = {AttackCard.class, Deck.class, Game.class, UnitCard.class, User.class}, version = 1, exportSchema = true)
@TypeConverters(value = {Converters.class, AttackType.class, Unit.class})
public abstract class CardCombatDatabase extends RoomDatabase {

  private static final String DB_NAME = "card_combat_db";

  private static Application context;

  public static void setContext(Application context) {
    CardCombatDatabase.context = context;
  }

  public static CardCombatDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract AttackCardDao getAttackCardDao();

  public abstract DeckDao getDeckDao();

  public abstract GameDao getGameDao();

  public abstract UnitCardDao getUnitCardDao();

  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final CardCombatDatabase INSTANCE =
        Room.databaseBuilder(context, CardCombatDatabase.class, DB_NAME)
            .build();

  }

  public static class Converters {

    @TypeConverter
    public static byte[] uuidToBytes(UUID value) {
      byte[] bytes = null;
      if (value != null) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.putLong(value.getMostSignificantBits())
            .putLong(value.getLeastSignificantBits());
        bytes = buffer.array();
      }
      return bytes;
    }

    @TypeConverter
    public static UUID bytesToUUID(byte[] value) {
      UUID uuid = null;
      if (value != null) {
        ByteBuffer buffer = ByteBuffer.wrap(value);
        uuid = new UUID(buffer.getLong(), buffer.getLong());
      }
      return uuid;
    }
  }
}