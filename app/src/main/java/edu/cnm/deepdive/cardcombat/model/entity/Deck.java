package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id"
        )
    },
    indices = {
        @Index(value = {"user_id"}, unique = true)
    }
)
public class Deck {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "deck_id")
  private long id;

  @ColumnInfo(name = "user_id")
  private long userId;

  @NonNull
  private String name;

  @NonNull
  private String qrCode;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public String getQrCode() {
    return qrCode;
  }

  public void setQrCode(@NonNull String qrCode) {
    this.qrCode = qrCode;
  }
}
