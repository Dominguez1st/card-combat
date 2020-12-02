package edu.cnm.deepdive.cardcombat.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.cardcombat.model.entity.UnitCard;
import edu.cnm.deepdive.cardcombat.model.entity.User;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * Provides an interface with methods that perform actions on the {@link User} table of the
 * database.
 */
@Dao
public interface UserDao {

  /**
   * Inserts a single user into the database.
   *
   * @param user The user to be inserted.
   * @return A {@code Single} holding the id of the user that was inserted.
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(User user);

  /**
   * Inserts multiple users into the database.
   *
   * @param users The users to be inserted.
   * @return A {@code Single} holding a {@code List} of ids of the the users that were inserted.
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(User... users);

  /**
   * Inserts multiple users into the database.
   *
   * @param users The users to be inserted.
   * @return A {@code Single} holding a {@code List} of ids of the the users that were inserted.
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<User> users);

  /**
   * Updates a single user in the database.
   *
   * @param user The user to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(User user);

  /**
   * Updates multiple users in the database.
   *
   * @param users The users to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(User... users);

  /**
   * Updates multiple users in the database.
   *
   * @param users The users to be updated.
   * @return A {@code Single} holding the number of updates performed.
   */
  @Update
  Single<Integer> update(Collection<User> users);

  /**
   * Deletes a single user from the database.
   *
   * @param user The user to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(User user);

  /**
   * Deletes multiple users from the database.
   *
   * @param users The users to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(User... users);

  /**
   * Deletes multiple users from the database.
   *
   * @param users The users to be deleted.
   * @return A {@code Single} holding the number of deletions performed.
   */
  @Delete
  Single<Integer> delete(Collection<User> users);

  /**
   * Queries the database for a specific user, based on id.
   *
   * @param id The user's id.
   * @return {@code LiveData} of the selected user.
   */
  @Query("SELECT * FROM `User` WHERE user_id = :id")
  LiveData<User> findByUserId(long id);

  /**
   * Queries the database for a specific user, based on OAuth key.
   *
   * @param oauthKey The user's OAuth key.
   * @return {@code LiveData} of the selected user.
   */
  @Query("SELECT * FROM `User` WHERE oauth_Key = :oauthKey")
  Maybe<User> findByOauthKey(String oauthKey);
}
