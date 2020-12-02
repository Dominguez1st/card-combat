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

/**
 * The CardCombat Database provides abstract methods that return the DAOs for each entity. It
 * also provides methods to set the context and to return an instance of itself. It contains a
 * public nested class: Converters.
 */
@Database(entities = {AttackCard.class, Deck.class, Game.class, UnitCard.class, User.class}, version = 1, exportSchema = true)
@TypeConverters(value = {Converters.class, AttackType.class, Unit.class})
public abstract class CardCombatDatabase extends RoomDatabase {

  private static final String DB_NAME = "card_combat_db";

  private static Application context;

  /**
   * Sets the application context.
   *
   * @param context The application context.
   */
  public static void setContext(Application context) {
    CardCombatDatabase.context = context;
  }

  /**
   * Returns an instance of the singleton database.
   *
   * @return An instance of {@code ScaleScrollerDatabase}
   */
  public static CardCombatDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Returns the AttackCardDao.
   *
   * @return The AttackCardDao.
   */
  public abstract AttackCardDao getAttackCardDao();

  /**
   * Returns the DeckDao.
   *
   * @return The DeckDao.
   */
  public abstract DeckDao getDeckDao();

  /**
   * Returns the GameDao.
   *
   * @return The GameDao.
   */
  public abstract GameDao getGameDao();

  /**
   * Returns the UnitCardDao.
   *
   * @return The UnitCardDao.
   */
  public abstract UnitCardDao getUnitCardDao();

  /**
   * Returns the UserDao.
   *
   * @return The UserDao.
   */
  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final CardCombatDatabase INSTANCE =
        Room.databaseBuilder(context, CardCombatDatabase.class, DB_NAME)
            .build();

  }

  /**
   * Provides type converters to translate Java objects into data that can be stored in the SQLite
   * database.
   */
  public static class Converters {

    /**
     * Converts a {@link UUID} object into bytes.
     *
     * @param value A {@code UUID} object.
     * @return An byte
     */
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

    /**
     * Converts a byte  into a {@link UUID} object.
     *
     * @param value A {@code UUID} object.
     * @return An UUID
     */
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