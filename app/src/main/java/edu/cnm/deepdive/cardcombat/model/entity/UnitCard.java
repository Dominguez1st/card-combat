package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class UnitCard {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "unit_card_id")
  private long id;

  @ForeignKey(entity = Deck.class, parentColumns = "deck_id", childColumns = "deck_id")
  @ColumnInfo
  private long deckId;

  @NonNull
  @ColumnInfo
  private Unit unit;

  @NonNull
  @ColumnInfo(name = "current_hit_points")
  private int currentHitPoints;

  @NonNull
  @ColumnInfo(name = "magic_hit_points")
  private int currentMagicPoints;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getDeckId() {
    return deckId;
  }

  public void setDeckId(long deckId) {
    this.deckId = deckId;
  }

  @NonNull
  public Unit getUnit() {
    return unit;
  }

  public void setUnit(@NonNull Unit unit) {
    this.unit = unit;
  }

  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  public void setCurrentHitPoints(int currentHitPoints) {
    this.currentHitPoints = currentHitPoints;
  }

  public int getCurrentMagicPoints() {
    return currentMagicPoints;
  }

  public void setCurrentMagicPoints(int currentMagicPoints) {
    this.currentMagicPoints = currentMagicPoints;
  }

  public enum Unit{
    SWORDMASTER, MARKSMAN, DRAGOON, CHARIOTEER, WIZARD, ASSASSIN, BERSERKER;
  }
}
