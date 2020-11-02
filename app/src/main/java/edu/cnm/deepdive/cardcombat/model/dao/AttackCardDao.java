package edu.cnm.deepdive.cardcombat.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.cardcombat.model.entity.AttackCard;
import edu.cnm.deepdive.cardcombat.model.entity.Game;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface AttackCardDao {

  @Insert
  Single<Long> insert(AttackCard attackCard);

  @Insert
  Single<List<Long>> insert(AttackCard... attackCards);

  @Insert
  Single<List<Long>> insert(Collection<AttackCard> attackCards);

  @Update
  Single<Integer> updates(AttackCard attackCard);

  @Update
  Single<Integer> update(AttackCard... attackCards);

  @Update
  Single<Integer> update(Collection<AttackCard> attackCards);

  @Delete
  Single<Integer> delete(AttackCard attackCard);

  @Delete
  Single<Integer> delete(AttackCard... attackCards);

  @Delete
  Single<Integer> delete(Collection<AttackCard> attackCards);

  @Query("SELECT * FROM AttackCard WHERE attack_card_id = :id")
  List<Game> findByAttackCardId(int id);


}
