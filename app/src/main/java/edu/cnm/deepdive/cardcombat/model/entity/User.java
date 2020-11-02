package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

  @PrimaryKey
  @ColumnInfo(name = "user_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "oauthKey")
  private String oauthKey;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getOauthKey() {
    return oauthKey;
  }

  public void setOauthKey(@NonNull String oauthKey) {
    this.oauthKey = oauthKey;
  }
}
