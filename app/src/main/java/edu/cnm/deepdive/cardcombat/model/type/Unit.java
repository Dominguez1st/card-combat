package edu.cnm.deepdive.cardcombat.model.type;

import androidx.room.TypeConverter;
import edu.cnm.deepdive.cardcombat.model.entity.UnitCard;

public enum Unit {
  SWORDMASTER(120,30,12,4,6, Skill.SHIELD),
  MARKSMAN(100,50,10,6,6, Skill.TARGET),
  DRAGOON(120,50,10,4,6, Skill.DOUBLE_DAMAGE),
  CHARIOTEER(100,60,9,6,10, Skill.ADD_CRITICAL),
  WIZARD(70,100,6,20,4, Skill.HEAL),
  ASSASSIN(80,50,8,10,10, Skill.ASSASSINATE),
  BERSERKER(150,20,12,4,4, Skill.DOUBLE_DAMAGE);

  private final int startingHp;
  private final int maxMp;
  private final int attack;
  private final int magicChanceDieSides;
  private final int criticalChanceDieSides;
  private final Skill[] skills;

  Unit(int startingHp, int maxMp, int attack, int magicChanceDieSides,
      int criticalChanceDieSides, Skill... skills) {
    this.startingHp = startingHp;
    this.maxMp = maxMp;
    this.attack = attack;
    this.magicChanceDieSides = magicChanceDieSides;
    this.criticalChanceDieSides = criticalChanceDieSides;
    this.skills = skills;
  }

  public int getStartingHp() {
    return startingHp;
  }

  public int getMaxMp() {
    return maxMp;
  }

  public int getAttack() {
    return attack;
  }

  public int getMagicChanceDieSides() {
    return magicChanceDieSides;
  }

  public int getCriticalChanceDieSides() {
    return criticalChanceDieSides;
  }

  public Skill[] getSkills() {
    return skills;
  }

  @TypeConverter
  public static Integer unitToInteger(Unit value) {
    return (value != null) ? value.ordinal() : null;
  }

  @TypeConverter
  public static Unit integerToUnit(Integer value) {
    return (value != null) ? Unit.values()[value] : null;
  }

}
