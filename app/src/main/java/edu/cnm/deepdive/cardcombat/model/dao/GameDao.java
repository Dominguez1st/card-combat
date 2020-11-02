package edu.cnm.deepdive.cardcombat.model.dao;

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

@Dao
public interface GameDao {

  @Insert
  Single<Long> insert(Game game);

  @Insert
  Single<List<Long>> insert(Game... games);

  @Insert
  Single<List<Long>> insert(Collection<Game> games);

  @Update
  Single<Integer> updates(Game game);

  @Update
  Single<Integer> update(Game... games);

  @Update
  Single<Integer> update(Collection<Game> games);

  @Delete
  Single<Integer> delete(Game game);

  @Delete
  Single<Integer> delete(Game... games);

  @Delete
  Single<Integer> delete(Collection<Game> games);

  @Query("SELECT * FROM Game WHERE game_id = :id")
  List<Game> findByGameId(int id);

}
