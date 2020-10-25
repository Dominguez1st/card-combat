package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private UUID id;

  @ForeignKey(entity = User.class, parentColumns = "user_id", childColumns = "user_id")
  private UUID userId;

  @ForeignKey(entity = Deck.class, parentColumns = "deck_id", childColumns = "player_deck_id")
  private UUID playerDeckId;

  @ForeignKey(entity = Deck.class, parentColumns = "deck_id", childColumns = "computer_deck_id")
  private UUID computerDeckId;

  private int playerHitPoints;

  private  int computerHitPoints;

}
