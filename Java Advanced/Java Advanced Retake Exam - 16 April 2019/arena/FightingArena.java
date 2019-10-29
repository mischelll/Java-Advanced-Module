package JavaAdvancedExams.arena;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FightingArena {
    private Map<String, Gladiator> gladiatorMap;
    private String name;

    public FightingArena(String name) {
        this.name = name;
        this.gladiatorMap = new HashMap<>();
    }

    public void add(Gladiator gladiator){
        gladiatorMap.putIfAbsent(gladiator.getName(),gladiator);
    }

    public void remove(String name){
        gladiatorMap.remove(name);
    }

    public Gladiator getGladiatorWithHighestStat(){
        return gladiatorMap.values()
                .stream()
                .sorted((a,b) -> Integer.compare(b.getStatPower(),a.getStatPower()))
                .collect(Collectors.toList())
                .get(0);
    }

    public Gladiator getGladiatorWithHighestWeaponPower(){
        return gladiatorMap.values()
                .stream()
                .sorted((a,b) -> Integer.compare(b.getWeaponPower(),a.getWeaponPower()))
                .collect(Collectors.toList())
                .get(0);
    }

    public Gladiator getGladiatorWithHighestTotalPower(){
        return gladiatorMap.values()
                .stream()
                .sorted((a,b) -> Integer.compare(b.getTotalPower(),a.getTotalPower()))
                .collect(Collectors.toList())
                .get(0);
    }

    public int getCount(){
        return gladiatorMap.size();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        StringBuilder sb =  new StringBuilder();
        gladiatorMap.forEach((key, value) -> sb.append(value.toString()));

        return String.format("%s - %d%n%s",getName(),getCount(),sb.toString());
    }
}
