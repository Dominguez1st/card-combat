package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.cardcombat.model.type.AttackType;

/**
 * Holds data in the database for attack cards. This includes enumerated types from
 *  * the {@link AttackType} enums.
 */
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = UnitCard.class,
            parentColumns = "unit_card_id",
            childColumns = "unit_card_id"
        ),
    },
    indices = {
        @Index(value = {"unit_card_id"}, unique = true)
    }
)
public class AttackCard {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "attack_card_id")
  private long id;

  @ColumnInfo(name = "unit_card_id")
  private long unitCardId;

  @NonNull
  @ColumnInfo
  private AttackType attackType;

  /**
   * Returns the auto-generated id for the attack card.
   *
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the auto-generated id for the player.
   *
   * @param id The id to be set.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns the unit card id of the attack card.
   *
   * @return
   */
  public long getUnitCardId() {
    return unitCardId;
  }

  /**
   * Sets the unit card id of the attack card.
   *
   * @param unitCardId The id of the unitcard.
   */
  public void setUnitCardId(long unitCardId) {
    this.unitCardId = unitCardId;
  }

  /**
   * Returns the attack type of the attack card: an enumerated type from the {@code AttackType} enum.
   *
   * @return
   */
  @NonNull
  public AttackType getAttackType() {
    return attackType;
  }

  /**
   * Sets the attack type of the attack card: an enumerated type from the {@code AttackType} enum.
   *
   * @param attackType The attack type of the attack card.
   */
  public void setAttackType(@NonNull AttackType attackType) {
    this.attackType = attackType;
  }
}