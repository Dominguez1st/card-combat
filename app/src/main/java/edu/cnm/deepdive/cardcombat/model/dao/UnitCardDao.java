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

@Dao
public interface UnitCardDao {

  @Insert
  Single<Long> insert(UnitCard unitCard);

  @Insert
  Single<List<Long>> insert(UnitCard... unitCards);

  @Insert
  Single<List<Long>> insert(Collection<UnitCard> unitCards);

  @Update
  Single<Integer> updates(UnitCard unitCard);

  @Update
  Single<Integer> update(UnitCard... unitCards);

  @Update
  Single<Integer> update(Collection<UnitCard> unitCards);

  @Delete
  Single<Integer> delete(UnitCard unitCard);

  @Delete
  Single<Integer> delete(UnitCard... unitCards);

  @Delete
  Single<Integer> delete(Collection<UnitCard> unitCards);

  @Query("SELECT * FROM UnitCard WHERE unit_card_id = :id")
  LiveData<UnitCard> findByUnitCardId(long id);

  @Query("SELECT * FROM UnitCard WHERE deck_id = :id")
  LiveData<List<UnitCard>> findByDeckId(long id);

}
