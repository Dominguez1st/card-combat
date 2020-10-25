package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.UUID;
@Entity
public class UnitCard {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "unit_card_id")
  private UUID id;

  @ForeignKey(entity = Deck.class, parentColumns = "deck_id", childColumns = "deck_id")
  private UUID deckId;

  private String cardClass;

  private int damage;

  private String abilities;

  private int hitPoints;

  private int magicPoints;

  public UUID getId() {
    return id;
  }

  public String getCardClass() {
    return cardClass;
  }

  public void setCardClass(String cardClass) {
    this.cardClass = cardClass;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public String getAbilities() {
    return abilities;
  }

  public void setAbilities(String abilities) {
    this.abilities = abilities;
  }

  public int getHitPoints() {
    return hitPoints;
  }

  public void setHitPoints(int hitPoints) {
    this.hitPoints = hitPoints;
  }

  public int getMagicPoints() {
    return magicPoints;
  }

  public void setMagicPoints(int magicPoints) {
    this.magicPoints = magicPoints;
  }
}
