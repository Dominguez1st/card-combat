package edu.cnm.deepdive.cardcombat.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.cardcombat.model.dao.AttackCardDao;
import edu.cnm.deepdive.cardcombat.model.dao.DeckDao;
import edu.cnm.deepdive.cardcombat.model.dao.GameDao;
import edu.cnm.deepdive.cardcombat.model.dao.UnitCardDao;
import edu.cnm.deepdive.cardcombat.model.dao.UserDao;
import edu.cnm.deepdive.cardcombat.model.entity.Deck;
import edu.cnm.deepdive.cardcombat.model.entity.Game;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class DeckRepository {

  private final Context context;
  private final DeckDao deckDao;
  private final UserDao userDao;
  private final GameDao gameDao;


  public DeckRepository(Context context) {
    this.context = context;
    CardCombatDatabase database = CardCombatDatabase.getInstance();
    deckDao = database.getDeckDao();
    userDao = database.getUserDao();
    gameDao = database.getGameDao();
  }
  public Completable save(Deck deck){
    return ((deck.getId() == 0)
        ? deckDao.insert(deck)
        .doAfterSuccess(deck::setId)
        .ignoreElement()
        : deckDao.update(deck)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  public Completable delete (Deck deck){
    return ((deck.getId() == 0)
        ? Completable.complete()
        : deckDao.delete(deck)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  public LiveData<Deck> get(long id){
    return deckDao.findByDeckId(id);
  }

}
