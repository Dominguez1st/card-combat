package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.UUID;

public class Deck {

  @NonNull
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "deck_id")
  private UUID id;

  @NonNull
  @ForeignKey(entity = User.class, parentColumns = "user_id", childColumns = "user_id")
  @ColumnInfo
  private UUID userId;

  @NonNull
  @ColumnInfo
  private String name;

  @NonNull
  @ColumnInfo
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
