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

/**
 * {@code DeckRepository} contains methods that provide a layer of abstraction above the {@link
 * DeckDao}, and allows for creation, reading, updating, and deleting of decks.
 */
public class DeckRepository {

  private final Context context;
  private final DeckDao deckDao;
  private final UserDao userDao;
  private final GameDao gameDao;

  /**
   * The constructor initializes the context, the database, and the dao.
   *
   * @param context The application context.
   */
  public DeckRepository(Context context) {
    this.context = context;
    CardCombatDatabase database = CardCombatDatabase.getInstance();
    deckDao = database.getDeckDao();
    userDao = database.getUserDao();
    gameDao = database.getGameDao();
  }

  /**
   * Creates or updates a deck in the database.
   *
   * @param deck The {@code Deck}.
   * @return A {@code Completable} indicating the success or failure of the creation/update.
   */
  public Completable save(Deck deck){
    return ((deck.getId() == 0)
        ? deckDao.insert(deck)
        .doAfterSuccess(deck::setId)
        .ignoreElement()
        : deckDao.update(deck)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  /**
   * Deletes a deck in the database.
   *
   * @param deck The {@code Deck}.
   * @return A {@code Completable} indicating the success or failure of the deletion.
   */
  public Completable delete (Deck deck){
    return ((deck.getId() == 0)
        ? Completable.complete()
        : deckDao.delete(deck)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  /**
   * Returns LiveData of a deck, given its id.
   *
   * @param id The id of the deck.
   * @return {@code LiveData} of a {@code Deck}.
   */
  public LiveData<Deck> get(long id){
    return deckDao.findByDeckId(id);
  }

}
