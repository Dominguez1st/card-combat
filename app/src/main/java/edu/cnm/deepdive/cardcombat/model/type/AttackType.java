package edu.cnm.deepdive.cardcombat.model.type;

import androidx.room.TypeConverter;

/**
 * The type of attack that the attack card will be.
 */
public enum AttackType {
  RED(1.5, false, false),
  BLUE(1, false, true),
  GREEN(0.8, true, false);

  private final double attackValueModifier;
  private final boolean allowsCriticalRoll;
  private final boolean allowsMagicRoll;

  AttackType(double attackValueModifier, boolean allowsCriticalRoll, boolean allowsMagicRoll) {
    this.attackValueModifier = attackValueModifier;
    this.allowsCriticalRoll = allowsCriticalRoll;
    this.allowsMagicRoll = allowsMagicRoll;
  }

  /**
   * Gets the number that the unit card's attack value will be modified by.
   *
   * @return
   */
  public double getAttackValueModifier() {
    return attackValueModifier;
  }

  /**
   * Returns true if the card is green to allow the attack card to increase the unit card's critical
   * chance value.
   *
   * @return
   */
  public boolean isAllowsCriticalRoll() {
    return allowsCriticalRoll;
  }

  /**
   * Returns true if the card is blue to allow the attack card to increase the unit card's magic
   * points.
   *
   * @return
   */
  public boolean isAllowsMagicRoll() {
    return allowsMagicRoll;
  }

  @TypeConverter
  public static Integer typeToInteger(AttackType value) {
    return (value != null) ? value.ordinal() : null;
  }

  @TypeConverter
  public static AttackType integerToType(Integer value) {
    return (value != null) ? AttackType.values()[value] : null;
  }
}
