package edu.cnm.deepdive.cardcombat.model.type;

public enum Skill {
  HEAL(20),
  DOUBLE_DAMAGE(10),
  TARGET(10),
  ADD_CRITICAL(5),
  ASSASSINATE(7),
  SHIELD(5);

  private int cost;

  Skill(int cost) {
    this.cost = cost;
  }

  public int getCost() {
    return cost;
  }
}
