package edu.cnm.deepdive.cardcombat.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Holds data in the database for available decks to be used.
 */
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

  /**
   * Returns the auto-generated id for the deck.
   *
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the auto-generated id for the deck.
   *
   * @param id The id for the deck.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns the user id for the deck.
   *
   * @return
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Sets the user id for the deck.
   *
   * @param userId The user id for the deck.
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Returns the name for the deck.
   *
   * @return
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   * Sets the name for the deck.
   *
   * @param name The name for the deck.
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }

  /**
   * Returns the qr code associated with the deck.
   *
   * @return
   */
  @NonNull
  public String getQrCode() {
    return qrCode;
  }

  /**
   * Sets the qr code associated with the deck.
   *
   * @param qrCode The qr code associated with the deck.
   */
  public void setQrCode(@NonNull String qrCode) {
    this.qrCode = qrCode;
  }
}
