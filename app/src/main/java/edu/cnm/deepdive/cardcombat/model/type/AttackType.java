package edu.cnm.deepdive.cardcombat.model.type;

import androidx.room.TypeConverter;

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

  public double getAttackValueModifier() {
    return attackValueModifier;
  }

  public boolean isAllowsCriticalRoll() {
    return allowsCriticalRoll;
  }

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
