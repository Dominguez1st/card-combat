package edu.cnm.deepdive.cardcombat.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.cardcombat.model.dao.DeckDao;
import edu.cnm.deepdive.cardcombat.model.dao.GameDao;
import edu.cnm.deepdive.cardcombat.model.dao.UserDao;
import edu.cnm.deepdive.cardcombat.model.entity.Game;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

/**
 * {@code GameRepository} contains methods that provide a layer of abstraction above the {@link
 * GameDao}, and allows for creation, reading, updating, and deleting of attempts.
 */
public class GameRepository {

  private final Context context;
  private final DeckDao deckDao;
  private final UserDao userDao;
  private final GameDao gameDao;

  /**
   * The constructor initializes the context, the database, and the dao.
   *
   * @param context The application context.
   */
  public GameRepository(Context context) {
    this.context = context;
    CardCombatDatabase database = CardCombatDatabase.getInstance();
    deckDao = database.getDeckDao();
    userDao = database.getUserDao();
    gameDao = database.getGameDao();
  }

  /**
   * Creates or updates a game record in the database.
   *
   * @param game The {@code Game}.
   * @return A {@code Completable} indicating the success or failure of the creation/update.
   */
  public Completable save(Game game){
    return ((game.getId() == 0)
        ? gameDao.insert(game)
            .doAfterSuccess(game::setId)
            .ignoreElement()
        : gameDao.update(game)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  /**
   * Deletes a scale record in the database.
   *
   * @param game The {@code Game}.
   * @return A {@code Completable} indicating the success or failure of the deletion.
   */
  public Completable delete (Game game){
    return ((game.getId() == 0)
        ? Completable.complete()
        : gameDao.delete(game)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  /**
   * Returns LiveData of a game, given its id.
   *
   * @param id The id of the game.
   * @return {@code LiveData} of a {@code Game}.
   */
  public LiveData<Game> get(long id){
    return gameDao.findByGameId(id);
  }
}
