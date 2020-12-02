package edu.cnm.deepdive.cardcombat.model.dao;

import androidx.lifecycle.LiveData;
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

  /**
   * Inserts a single attack card into the database.
   *
   * @param attackCard the attack card to be used.
   * @return {@code Single} holding the id of the attack card.
   */
  @Insert
  Single<Long> insert(AttackCard attackCard);

  /**
   * Inserts multiple attack cards into the database.
   *
   * @param attackCards the attack cards to be used.
   * @return A {@code Single} holding a {@code List} of ids of the attack cards.
   */
  @Insert
  Single<List<Long>> insert(AttackCard... attackCards);

  /**
   * Inserts multiple attack cards into the database.
   *
   * @param attackCards the attack cards to be used.
   * @return A {@code Single} holding a {@code List} of ids of the attack cards.
   */
  @Insert
  Single<List<Long>> insert(Collection<AttackCard> attackCards);

  /**
   * Updates a single attack card in the database.
   *
   * @param attackCard the attack card to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(AttackCard attackCard);

  /**
   * Updates multiple attack cards in the database.
   *
   * @param attackCards the attack cards to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(AttackCard... attackCards);

  /**
   * Updates multiple attack cards in the database.
   *
   * @param attackCards the attack cards to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(Collection<AttackCard> attackCards);

  /**
   * Deletes a single attack card from the database.
   *
   * @param attackCard The attack card to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(AttackCard attackCard);

  /**
   * Deletes multiple attack card from the database.
   *
   * @param attackCards The attack cards to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(AttackCard... attackCards);

  /**
   * Deletes multiple attack card from the database.
   *
   * @param attackCards The attack cards to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(Collection<AttackCard> attackCards);

  /**
   * Queries the database for a specific attack card, based on id.
   *
   * @param id The attack card's id.
   * @return {@code LiveData} of the selected attack card.
   */
  @Query("SELECT * FROM AttackCard WHERE attack_card_id = :id")
  LiveData<AttackCard> findByAttackCardId(long id);

  /**
   * Queries the database for all attack cards.
   *
   * @param id The attack card's id.
   * @return {@code LiveData} of a {@code List} of attack card.
   */
  @Query("SELECT * FROM AttackCard WHERE unit_card_id = :id")
  LiveData<List<AttackCard>> findByUnitCardId(long id);
}
