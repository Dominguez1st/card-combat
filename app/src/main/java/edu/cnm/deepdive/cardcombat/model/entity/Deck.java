package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import java.util.UUID;

public class Deck {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "deck_id")
  private UUID id;

  private String name;

  private String qrCode;

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQrCode() {
    return qrCode;
  }

  public void setQrCode(String qrCode) {
    this.qrCode = qrCode;
  }
}
