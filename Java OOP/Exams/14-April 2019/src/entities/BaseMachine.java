package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private static final String INVALID_TARGET ="Attack target cannot be null or empty string.";
    private static final String INVALID_MACHINE_NAME = "Machine name cannot be null or empty.";
    private static final String INVALID_PILOT = "Pilot cannot be null.";
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name,
                          double attackPoints,
                          double defensePoints,
                          double healthPoints) {

        this.setName(name);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.healthPoints = healthPoints;
        this.targets = new ArrayList<>();
    }


    @Override
    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException(INVALID_MACHINE_NAME);

        }

        this.name = name;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot == null){
            throw new IllegalArgumentException(INVALID_PILOT);
        }
        this.pilot = pilot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Pilot getPilot() {
        return pilot;
    }

    @Override
    public double getAttackPoints() {
        return attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return defensePoints;
    }

    @Override
    public double getHealthPoints() {
        return healthPoints;
    }

    @Override
    public List<String> getTargets() {
        return targets;
    }



    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public void attack(String target) {
        if (target == null || target.isEmpty()){
            throw new IllegalArgumentException(INVALID_TARGET);
        }

        this.targets.add(target);
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public String toString() {
        String size = "";
        if (getTargets().size() == 0){
            size = "None";
        }else {
            size = String.format("%s",String.join(", ",this.targets));
        }

        String type = "";
        if (getClass().getSimpleName().equals("FighterImpl")){
            type = "Fighter";
        }else if (getClass().getSimpleName().equals("TankImpl")){
            type = "Tank";
        }
        return String.format("- %s%n *Type: %s%n *Health: %.2f%n *Attack: %.2f%n *Defense: %.2f%n *Targets: %s%n",
                this.name,
                type,
                this.healthPoints,
                this.attackPoints,
                this.defensePoints,
                size);
    }
}
