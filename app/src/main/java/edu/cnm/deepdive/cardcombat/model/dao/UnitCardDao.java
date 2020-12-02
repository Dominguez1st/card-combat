package edu.cnm.deepdive.cardcombat.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.cardcombat.model.entity.UnitCard;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * Provides an interface with methods that perform actions on the {@link UnitCard} table of the
 * database.
 */
@Dao
public interface UnitCardDao {

  /**
   * Inserts a single unit card into the database.
   *
   * @param unitCard The unit card to be inserted.
   * @return A {@code Single} holding the id of the unit card that was inserted.
   */
  @Insert
  Single<Long> insert(UnitCard unitCard);

  /**
   * Inserts multiple unit cards into the database.
   *
   * @param unitCards The unit cards to be inserted.
   * @return A {@code Single} holding {@code List} of ids of unit cards that were inserted.
   */
  @Insert
  Single<List<Long>> insert(UnitCard... unitCards);

  /**
   * Inserts multiple unit cards into the database.
   *
   * @param unitCards The unit cards to be inserted.
   * @return A {@code Single} holding {@code List} of ids of unit cards that were inserted.
   */
  @Insert
  Single<List<Long>> insert(Collection<UnitCard> unitCards);

  /**
   * Updates a single unit card in the database.
   *
   * @param unitCard The unit card to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(UnitCard unitCard);

  /**
   * Updates multiple unit cards in the database.
   *
   * @param unitCards The unit cards to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(UnitCard... unitCards);

  /**
   * Updates multiple unit cards in the database.
   *
   * @param unitCards The unit cards to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(Collection<UnitCard> unitCards);

  /**
   * Deletes a single unit card from the database.
   *
   * @param unitCard The unit card to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(UnitCard unitCard);

  /**
   * Deletes multiple unit cards from the database.
   *
   * @param unitCards The unit cards to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(UnitCard... unitCards);

  /**
   * Deletes multiple unit cards from the database.
   *
   * @param unitCards The unit cards to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(Collection<UnitCard> unitCards);

  /**
   * Queries the database for a specific unit card, based on id.
   *
   * @param id The unit card's id.
   * @return {@code LiveData} of the selected scale.
   */
  @Query("SELECT * FROM UnitCard WHERE unit_card_id = :id")
  LiveData<UnitCard> findByUnitCardId(long id);

  /**
   * Queries the database for all unit cards based on deck.
   *
   * @param id The deck's id
   * @return {@code LiveData} of a {@code List} of unit cards.
   */
  @Query("SELECT * FROM UnitCard WHERE deck_id = :id")
  LiveData<List<UnitCard>> findByDeckId(long id);
}
