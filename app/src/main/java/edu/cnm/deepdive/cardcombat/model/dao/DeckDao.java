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

@Dao
public interface DeckDao {

  @Insert
  Single<Long> insert(Deck deck);

  @Insert
  Single<List<Long>> insert(Deck... decks);

  @Insert
  Single<List<Long>> insert(Collection<Deck> decks);

  @Update
  Single<Integer> updates(Deck deck);

  @Update
  Single<Integer> update(Deck... decks);

  @Update
  Single<Integer> update(Collection<Deck> decks);

  @Delete
  Single<Integer> delete(Deck deck);

  @Delete
  Single<Integer> delete(Deck... decks);

  @Delete
  Single<Integer> delete(Collection<Deck> decks);

  @Query("SELECT * FROM Deck WHERE deck_id = :id")
  LiveData<Deck> findByDeckId(int id);




}
