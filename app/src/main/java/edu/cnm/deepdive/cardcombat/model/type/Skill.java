package edu.cnm.deepdive.cardcombat.model.type;

/**
 * The skills that the unit cards will be able to activate
 */
public enum Skill {
  HEAL(20),
  DOUBLE_DAMAGE(15),
  TARGET(10),
  ADD_CRITICAL(5),
  ASSASSINATE(10),
  SHIELD(10);

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
