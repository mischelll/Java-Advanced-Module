package entities;


import entities.interfaces.Fighter;


public class FighterImpl extends BaseMachine implements Fighter {
    private static final double HEALTH_POINTS = 200;
    private static final double ATTACK_POINTS_STEP = 50.0;
    private static final double DEFENCE_POINTS_STEP = 25.0;
    private boolean aggressiveMode;
    private double attackPointsModifier;
    private double deffencePointsModifier;

    public FighterImpl(String name,
                       double attackPoints,
                       double defensePoints) {

        super(name, attackPoints , defensePoints, HEALTH_POINTS);
        this.setAggressiveModeTrue();
        this.attackPointsModifier = ATTACK_POINTS_STEP;
        this.deffencePointsModifier = DEFENCE_POINTS_STEP;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.getAggressiveMode()) {
            this.setAggressiveModeFalse();
        } else {
            this.setAggressiveModeTrue();
        }
    }


    @Override
    public String toString() {
        String mode = "";
        if (this.aggressiveMode) {
            mode = "(ON)";
        } else {
            mode = "(OFF)";
        }

        return super.toString() + String.format(" *Aggressive Mode%s", mode);
    }

    private void setAggressiveModeTrue() {
        this.aggressiveMode = true;
        super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_STEP);
        super.setDefensePoints(super.getDefensePoints() - DEFENCE_POINTS_STEP);
    }

    private void setAggressiveModeFalse() {
        this.aggressiveMode = false;
        super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_STEP);
        super.setDefensePoints(super.getDefensePoints() + DEFENCE_POINTS_STEP);
    }
}
