package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;

  @ForeignKey(entity = User.class, parentColumns = "user_id", childColumns = "user_id")
  @ColumnInfo
  private long userId;

  @ForeignKey(entity = Deck.class, parentColumns = "deck_id", childColumns = "player_deck_id")
  @ColumnInfo
  private long playerDeckId;

  @ForeignKey(entity = Deck.class, parentColumns = "deck_id", childColumns = "computer_deck_id")
  @ColumnInfo
  private long computerDeckId;

  @ColumnInfo(name = "is_player_units_alive")
  private boolean isPlayerUnitsAlive;

  @ColumnInfo(name = "is_computer_units_alive")
  private boolean isComputerUnitsAlive;

  @ColumnInfo(name = "player_critical_chance")
  private boolean playerCriticalChance;

  @ColumnInfo(name = "computer_critical_chance")
  private boolean computerCriticalChance;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getPlayerDeckId() {
    return playerDeckId;
  }

  public void setPlayerDeckId(long playerDeckId) {
    this.playerDeckId = playerDeckId;
  }

  public long getComputerDeckId() {
    return computerDeckId;
  }

  public void setComputerDeckId(long computerDeckId) {
    this.computerDeckId = computerDeckId;
  }

  public boolean isPlayerUnitsAlive() {
    return isPlayerUnitsAlive;
  }

  public void setPlayerUnitsAlive(boolean playerUnitsAlive) {
    isPlayerUnitsAlive = playerUnitsAlive;
  }

  public boolean isComputerUnitsAlive() {
    return isComputerUnitsAlive;
  }

  public void setComputerUnitsAlive(boolean computerUnitsAlive) {
    isComputerUnitsAlive = computerUnitsAlive;
  }

  public boolean isPlayerCriticalChance() {
    return playerCriticalChance;
  }

  public void setPlayerCriticalChance(boolean playerCriticalChance) {
    this.playerCriticalChance = playerCriticalChance;
  }

  public boolean isComputerCriticalChance() {
    return computerCriticalChance;
  }

  public void setComputerCriticalChance(boolean computerCriticalChance) {
    this.computerCriticalChance = computerCriticalChance;
  }
}
