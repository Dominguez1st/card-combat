package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.cardcombat.model.type.Unit;


/**
 * Holds data in the database for available unit cards to be used. This includes enumerated types from
 * the {@link Unit} enum.
 */
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Deck.class,
            parentColumns = "deck_id",
            childColumns = "deck_id"
        )
    },
    indices = {
        @Index(value = {"deck_id"}, unique = true)
    }
)
public class UnitCard {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "unit_card_id")
  private long id;

  @ColumnInfo(name = "deck_id")
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

  /**
   * Returns the auto-generated id for the unit card.
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
   * Returns the deck id for the unit card.
   *
   * @return
   */
  public long getDeckId() {
    return deckId;
  }

  /**
   * Sets the deck id for the unit card.
   *
   * @param deckId The deck id for the unit card.
   */
  public void setDeckId(long deckId) {
    this.deckId = deckId;
  }

  /**
   * Returns the unit of the unit card (SWORDMASTER, DRAGOON, etc.): an enumerated type from the {@code
   * Unit} enum.
   *
   * @return
   */
  @NonNull
  public Unit getUnit() {
    return unit;
  }

  /**
   * Sets the unit of the unit card (SWORDMASTER, DRAGOON, etc.): an enumerated type from the {@code
   * Unit} enum.
   *
   * @param unit The unit of the unit card.
   */
  public void setUnit(@NonNull Unit unit) {
    this.unit = unit;
  }

  /**
   * Returns the current hit points of the unit card.
   *
   * @return
   */
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  /**
   * Sets the current hit points of the unit card.
   *
   * @param currentHitPoints The amount of hit points for the unit card.
   */
  public void setCurrentHitPoints(int currentHitPoints) {
    this.currentHitPoints = currentHitPoints;
  }

  /**
   * Returns the current magic points of the unit card.
   *
   * @return
   */
  public int getCurrentMagicPoints() {
    return currentMagicPoints;
  }

  /**
   * Sets the current magic points of the unit card.
   *
   * @param currentMagicPoints The amount of magic points the unit card.
   */
  public void setCurrentMagicPoints(int currentMagicPoints) {
    this.currentMagicPoints = currentMagicPoints;
  }
}
