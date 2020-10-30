package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity
public class Game {

  @NonNull
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private UUID id;

  @NonNull
  @ForeignKey(entity = User.class, parentColumns = "user_id", childColumns = "user_id")
  @ColumnInfo
  private UUID userId;

  @NonNull
  @ForeignKey(entity = Deck.class, parentColumns = "deck_id", childColumns = "player_deck_id")
  @ColumnInfo
  private UUID playerDeckId;

  @NonNull
  @ForeignKey(entity = Deck.class, parentColumns = "deck_id", childColumns = "computer_deck_id")
  @ColumnInfo
  private UUID computerDeckId;

  @NonNull
  @ColumnInfo
  private int playerHitPoints;

  @NonNull
  @ColumnInfo
  private  int computerHitPoints;

}
