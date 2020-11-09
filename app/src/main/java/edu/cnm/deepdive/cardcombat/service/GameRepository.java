package edu.cnm.deepdive.cardcombat.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.cardcombat.model.dao.DeckDao;
import edu.cnm.deepdive.cardcombat.model.dao.GameDao;
import edu.cnm.deepdive.cardcombat.model.dao.UserDao;
import edu.cnm.deepdive.cardcombat.model.entity.Game;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class GameRepository {

  private final Context context;
  private final DeckDao deckDao;
  private final UserDao userDao;
  private final GameDao gameDao;


  public GameRepository(Context context) {
    this.context = context;
    CardCombatDatabase database = CardCombatDatabase.getInstance();
    deckDao = database.getDeckDao();
    userDao = database.getUserDao();
    gameDao = database.getGameDao();
  }

  public Completable save(Game game){
    return ((game.getId() == 0)
        ? gameDao.insert(game)
            .doAfterSuccess(game::setId)
            .ignoreElement()
        : gameDao.update(game)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  public Completable delete (Game game){
    return ((game.getId() == 0)
        ? Completable.complete()
        : gameDao.delete(game)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  public LiveData<Game> get(long id){
    return gameDao.findByGameId(id);
  }
}
