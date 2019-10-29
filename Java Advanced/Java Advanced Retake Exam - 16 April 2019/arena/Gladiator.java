package JavaAdvancedExams.arena;

public class Gladiator {
    private String name;
    private Stat stat;
    private Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getStatPower(){
        return stat.getAgility() + stat.getFlexibility() + stat.getIntelligence()
                + stat.getSkills() + stat.getStrength();
    }

    public int getWeaponPower(){
        return weapon.getSharpness() + weapon.getSize() + weapon.getSolidity();
    }

    public int getTotalPower(){
        return getStatPower() + getWeaponPower();
    }

    public String toString(){
        return String.format("%s - %d%n  Weapon Power: %d%n  Stat Power: %d%n",getName(),getTotalPower()
                ,getWeaponPower(),getStatPower());
    }
}
