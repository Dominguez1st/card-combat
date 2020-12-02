package edu.cnm.deepdive.cardcombat.model.type;

/**
 * The skills that the unit cards will be able to activate
 */
public enum Skill {
  HEAL(20),
  DOUBLE_DAMAGE(10),
  TARGET(10),
  ADD_CRITICAL(5),
  ASSASSINATE(7),
  SHIELD(5);

  private final int cost;

  Skill(int cost) {
    this.cost = cost;
  }

  /**
   * Returns how many magic points the skill will cost to activate
   *
   * @return
   */
  public int getCost() {
    return cost;
  }
}
