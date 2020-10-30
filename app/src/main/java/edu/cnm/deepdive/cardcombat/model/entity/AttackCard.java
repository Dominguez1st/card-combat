package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity
public class AttackCard {

  @NonNull
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "attack_card_id")
  private UUID id;

  @NonNull
  @ForeignKey(entity = UnitCard.class, parentColumns = "unit_card_id", childColumns = "unit_card_id")
  @ColumnInfo
  private UUID unitCardId;

  @NonNull
  @ColumnInfo
  private String type;

  @ColumnInfo
  private double damage;

  @ColumnInfo
  private int magicGeneration;

  @ColumnInfo
  private int criticalChance;

  public UUID getUnitCardId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int getMagicGeneration() {
    return magicGeneration;
  }

  public void setMagicGeneration(int magicGeneration) {
    this.magicGeneration = magicGeneration;
  }

  public int getCriticalChance() {
    return criticalChance;
  }

  public void setCriticalChance(int criticalChance) {
    this.criticalChance = criticalChance;
  }
}
