package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.cardcombat.model.type.AttackType;

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUnitCardId() {
    return unitCardId;
  }

  public void setUnitCardId(long unitCardId) {
    this.unitCardId = unitCardId;
  }

  @NonNull
  public AttackType getAttackType() {
    return attackType;
  }

  public void setAttackType(@NonNull AttackType attackType) {
    this.attackType = attackType;
  }

}