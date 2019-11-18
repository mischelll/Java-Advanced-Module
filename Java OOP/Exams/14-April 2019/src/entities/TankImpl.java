package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double HEALTH_POINTS = 100;
    private static final double ATTACK_POINTS_STEP = 40.0;
    private static final double DEFENCE_POINTS_STEP = 30.0;
    private boolean defenseMode;
    private double attackPointsModifier;
    private double deffencePointsModifier;

    public TankImpl(String name,
                    double attackPoints,
                    double defensePoints) {

        super(name, attackPoints , defensePoints , HEALTH_POINTS);
        this.setDefenseModeTrue();
        this.attackPointsModifier = ATTACK_POINTS_STEP;
        this.deffencePointsModifier = DEFENCE_POINTS_STEP;
    }


    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode()) {
            this.setDefenseModeFalse();
        } else {
            this.setDefenseModeTrue();
        }
    }

    @Override
    public String toString() {
        String mode = "";
        if (this.defenseMode) {
            mode = "(ON)";

        } else {
            mode = "(OFF)";
        }
        return super.toString() + String.format(" *Defense Mode%s", mode);
    }

    private void setDefenseModeTrue() {
        this.defenseMode = true;
        super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_STEP);
        super.setDefensePoints(super.getDefensePoints() + DEFENCE_POINTS_STEP);
    }

    private void setDefenseModeFalse() {
        this.defenseMode = false;
        super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_STEP);
        super.setDefensePoints(super.getDefensePoints() - DEFENCE_POINTS_STEP);
    }
}
