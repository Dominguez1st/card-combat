package edu.cnm.deepdive.cardcombat.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.cardcombat.model.entity.Deck;
import edu.cnm.deepdive.cardcombat.model.entity.Game;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * Provides an interface with methods that perform actions on the {@link Deck} table of the
 * database.
 */
@Dao
public interface DeckDao {

  /**
   * Inserts a single deck into the database.
   *
   * @param deck The deck to be inserted.
   * @return A {@code Single} holding the id of the deck that was inserted.
   */
  @Insert
  Single<Long> insert(Deck deck);

  /**
   * Inserts multiple decks into the database.
   *
   * @param decks The decks to be inserted.
   * @return A {@code Single} holding {@code List} of ids of decks that were inserted.
   */
  @Insert
  Single<List<Long>> insert(Deck... decks);

  /**
   * Inserts multiple decks into the database.
   *
   * @param decks The deck to be inserted.
   * @return A {@code Single} holding {@code List} of ids of decks that were inserted.
   */
  @Insert
  Single<List<Long>> insert(Collection<Deck> decks);

  /**
   * Updates a single deck in the database.
   *
   * @param deck The deck to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(Deck deck);

  /**
   * Updates multiple decks in the database.
   *
   * @param decks The decks to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(Deck... decks);

  /**
   * Updates multiple decks in the database.
   *
   * @param decks The decks to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(Collection<Deck> decks);

  /**
   * Deletes a single deck from the database.
   *
   * @param deck The deck to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(Deck deck);

  /**
   * Deletes multiple decks from the database.
   *
   * @param decks The decks to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(Deck... decks);

  /**
   * Deletes multiple deck from the database.
   *
   * @param decks The scales to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(Collection<Deck> decks);

  /**
   * Queries the database for a specific deck, based on id.
   *
   * @param id The deck's id.
   * @return {@code LiveData} of the selected deck.
   */
  @Query("SELECT * FROM Deck WHERE deck_id = :id")
  LiveData<Deck> findByDeckId(long id);




}
