package edu.cnm.deepdive.cardcombat.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.cardcombat.model.dao.DeckDao;
import edu.cnm.deepdive.cardcombat.model.dao.GameDao;
import edu.cnm.deepdive.cardcombat.model.dao.UserDao;
import edu.cnm.deepdive.cardcombat.model.entity.Deck;
import edu.cnm.deepdive.cardcombat.model.entity.User;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

  private final Context context;
  private final DeckDao deckDao;
  private final UserDao userDao;
  private final GameDao gameDao;

  public UserRepository(Context context) {
    this.context = context;
    CardCombatDatabase database = CardCombatDatabase.getInstance();
    deckDao = database.getDeckDao();
    userDao = database.getUserDao();
    gameDao = database.getGameDao();
  }

  public Completable save(User user){
    return ((user.getId() == 0)
        ? userDao.insert(user)
        .doAfterSuccess(user::setId)
        .ignoreElement()
        : userDao.update(user)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  public Completable delete (User user){
    return ((user.getId() == 0)
        ? Completable.complete()
        : userDao.delete(user)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  public LiveData<User> get(long id){
    return userDao.findByUserId(id);
  }
}
