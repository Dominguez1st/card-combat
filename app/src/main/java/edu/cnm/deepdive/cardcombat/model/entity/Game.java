package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Holds data in the database for the current game to use.
 */
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id"
        ),
        @ForeignKey(
            entity = Deck.class,
            parentColumns = "deck_id",
            childColumns = "player_deck_id"
        ),
        @ForeignKey(
            entity = Deck.class,
            parentColumns = "deck_id",
            childColumns = "computer_deck_id"
        )
    },
    indices = {
        @Index(value = {"user_id"}, unique = true),
        @Index(value = {"player_deck_id"}, unique = true),
        @Index(value = {"computer_deck_id"}, unique = true)
    }
)
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;

  @ColumnInfo(name = "user_id")
  private long userId;

  @ColumnInfo(name = "player_deck_id")
  private long playerDeckId;

  @ColumnInfo(name = "computer_deck_id")
  private long computerDeckId;

  @ColumnInfo(name = "is_player_units_alive")
  private boolean isPlayerUnitsAlive;

  @ColumnInfo(name = "is_computer_units_alive")
  private boolean isComputerUnitsAlive;

  @ColumnInfo(name = "player_critical_chance")
  private int playerCriticalChance;

  @ColumnInfo(name = "computer_critical_chance")
  private int computerCriticalChance;

  /**
   * Returns the auto-generated id for the scale.
   *
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the auto-generated id for the scale.
   *
   * @param id The id for the scale.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns the user id of the game.
   *
   * @return
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Sets the user id of the game.
   *
   * @param userId The user id of the game.
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Returns the player's deck id of the game.
   *
   * @return
   */
  public long getPlayerDeckId() {
    return playerDeckId;
  }

  /**
   * Sets the player's deck id of the game.
   *
   * @param playerDeckId The player's deck id of the game.
   */
  public void setPlayerDeckId(long playerDeckId) {
    this.playerDeckId = playerDeckId;
  }

  /**
   * Returns the computer's deck id of the game.
   *
   * @return
   */
  public long getComputerDeckId() {
    return computerDeckId;
  }

  /**
   * Sets the computer's deck id of the game.
   *
   * @param computerDeckId The computer's deck id of the game.
   */
  public void setComputerDeckId(long computerDeckId) {
    this.computerDeckId = computerDeckId;
  }

  /**
   * Returns a boolean that sees if the player's units are still alive in the game.
   *
   * @return
   */
  public boolean isPlayerUnitsAlive() {
    return isPlayerUnitsAlive;
  }

  /**
   * Sets the boolean sees if the player's units are still alive in the game.
   *
   * @param playerUnitsAlive The players units if their alive or not.
   */
  public void setPlayerUnitsAlive(boolean playerUnitsAlive) {
    isPlayerUnitsAlive = playerUnitsAlive;
  }

  /**
   * Returns a boolean that sees if the computer's units are still alive in the game.
   *
   * @return
   */
  public boolean isComputerUnitsAlive() {
    return isComputerUnitsAlive;
  }

  /**
   * Sets the boolean sees if the computer's units are still alive in the game.
   *
   * @param computerUnitsAlive The players units if their alive or not.
   */
  public void setComputerUnitsAlive(boolean computerUnitsAlive) {
    isComputerUnitsAlive = computerUnitsAlive;
  }

  /**
   * Returns the current critical chance that the player has for the turn.
   *
   * @return
   */
  public int getPlayerCriticalChance() {
    return playerCriticalChance;
  }

  /**
   * Sets the current critical chance that the player has for the turn.
   *
   * @param playerCriticalChance The player's critical hit chance.
   */
  public void setPlayerCriticalChance(int playerCriticalChance) {
    this.playerCriticalChance = playerCriticalChance;
  }

  /**
   * Returns the current critical chance that the computer has for the turn.
   *
   * @return
   */
  public int getComputerCriticalChance() {
    return computerCriticalChance;
  }

  /**
   * Sets the current critical chance that the computer has for the turn.
   *
   * @param computerCriticalChance The computer's critical hit chance.
   */
  public void setComputerCriticalChance(int computerCriticalChance) {
    this.computerCriticalChance = computerCriticalChance;
  }
}
