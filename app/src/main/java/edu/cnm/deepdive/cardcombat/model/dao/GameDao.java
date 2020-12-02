package edu.cnm.deepdive.cardcombat.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.cardcombat.model.entity.Game;
import edu.cnm.deepdive.cardcombat.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * Provides an interface with methods that perform actions on the {@link Game} table of the
 * database.
 */
@Dao
public interface GameDao {

  /**
   * Inserts a single game into the database.
   *
   * @param game The game to be inserted.
   * @return A {@code Single} holding the id of the game that was inserted.
   */
  @Insert
  Single<Long> insert(Game game);

  /**
   * Inserts multiple games into the database.
   *
   * @param games The games to be inserted.
   * @return A {@code Single} holding {@code List} of ids of games that were inserted.
   */
  @Insert
  Single<List<Long>> insert(Game... games);

  /**
   * Inserts multiple games into the database.
   *
   * @param games The games to be inserted.
   * @return A {@code Single} holding {@code List} of ids of games that were inserted.
   */
  @Insert
  Single<List<Long>> insert(Collection<Game> games);

  /**
   * Updates a single game in the database.
   *
   * @param game The game to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(Game game);

  /**
   * Updates multiple games in the database.
   *
   * @param games The games to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(Game... games);

  /**
   * Updates multiple games in the database.
   *
   * @param games The games to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(Collection<Game> games);

  /**
   * Deletes a single game from the database.
   *
   * @param game The game to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(Game game);

  /**
   * Deletes multiple games from the database.
   *
   * @param games The games to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(Game... games);

  /**
   * Deletes multiple games from the database.
   *
   * @param games The games to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(Collection<Game> games);

  /**
   * Queries the database for a specific game, based on id.
   *
   * @param id The game's id.
   * @return {@code LiveData} of the selected game.
   */
  @Query("SELECT * FROM Game WHERE game_id = :id")
  LiveData<Game> findByGameId(long id);

  /**
   * Queries the database for all scales, based on player's deck id.
   *
   * @param id The player's deck id.
   * @return {@code LiveData} of the selected game.
   */
  @Query("SELECT * FROM Game WHERE player_deck_id = :id")
  LiveData<List<Game>> findByPlayerDeckId(long id);
}
