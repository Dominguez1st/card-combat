package edu.cnm.deepdive.cardcombat.service;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import edu.cnm.deepdive.cardcombat.model.dao.DeckDao;
import edu.cnm.deepdive.cardcombat.model.dao.GameDao;
import edu.cnm.deepdive.cardcombat.model.dao.UserDao;
import edu.cnm.deepdive.cardcombat.model.entity.Deck;
import edu.cnm.deepdive.cardcombat.model.entity.User;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;

/**
 * {@code UserRepository} contains methods that provide a layer of abstraction above the {@link
 * UserDao}, and allows for creation, reading, updating, and deleting of attempts.
 */
public class UserRepository {

  private final Context context;
  private final DeckDao deckDao;
  private final UserDao userDao;
  private final GameDao gameDao;
  private final GoogleSignInService signInService;

  /**
   * The constructor initializes the context, the database, the dao, and the GoogleSignInService.
   *
   * @param context The application context.
   */
  public UserRepository(Context context) {
    this.context = context;
    CardCombatDatabase database = CardCombatDatabase.getInstance();
    deckDao = database.getDeckDao();
    userDao = database.getUserDao();
    gameDao = database.getGameDao();
    signInService = GoogleSignInService.getInstance();
  }

  /**
   * Creates a player record in the database given a Google Sign In account.
   *
   * @param account A GoogleSignInAccount that will be associated with the player.
   * @return A {@code Single} {@link User} that has been created.
   */
  @SuppressWarnings("ConstantConditions")
  public Single<User> getOrCreate(@NonNull GoogleSignInAccount account) {
    return userDao.findByOauthKey(account.getId())
        .switchIfEmpty(
            Single.fromCallable(() -> {
              User user = new User();
              user.setOauthKey(account.getId());
              userDao.insert(user)
                  .doAfterSuccess(user::setId)
                  .subscribe();
              return user;
            })
        )
        .subscribeOn(Schedulers.io());
  }

  /**
   * Creates or updates a player record in the database.
   *
   * @param user The {@code User} entity.
   * @return A {@code Completable} indicating the success or failure of the creation/update.
   */
  public Completable save(User user) {
    return ((user.getId() == 0)
        ? userDao.insert(user)
        .doAfterSuccess(user::setId)
        .ignoreElement()
        : userDao.update(user)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  /**
   * Deletes a user record in the database.
   *
   * @param user The {@code Player} entity.
   * @return A {@code Completable} indicating the success or failure of the deletion.
   */
  public Completable delete(User user) {
    return ((user.getId() == 0)
        ? Completable.complete()
        : userDao.delete(user)
            .ignoreElement())
        .subscribeOn(Schedulers.io());
  }

  /**
   * Returns LiveData on a user, given their id.
   *
   * @param id The user's id.
   * @return {@code LiveData} of a {@code User}.
   */
  public LiveData<User> get(long id) {
    return userDao.findByUserId(id);
  }
}
