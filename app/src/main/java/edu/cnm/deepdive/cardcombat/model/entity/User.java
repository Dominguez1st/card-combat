package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity
public class User {

  @NonNull
  @PrimaryKey
  @ColumnInfo(name = "user_id")
  private UUID id;

  @NonNull
  @ColumnInfo
  private String oauthKey;

  public UUID getId() {
    return id;
  }

  public String getOauthKey() {
    return oauthKey;
  }

  public void setOauthKey(String oauthKey) {
    this.oauthKey = oauthKey;
  }
}
