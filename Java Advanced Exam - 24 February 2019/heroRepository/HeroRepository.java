package heroRepository;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HeroRepository {
        private Map<String, Hero> heroMap;

    public HeroRepository() {
        this.heroMap = new HashMap<>();
    }

    public void add(Hero hero){
        heroMap.putIfAbsent(hero.getName(),hero);
    }

    public void remove(String name){
        heroMap.remove(name);
    }

    public Hero getHeroWithHighestStrength(){
        return heroMap.values()
                .stream()
                .sorted((a,b) -> Integer.compare(b.getItem().getStrength(),a.getItem().getStrength()))
                .collect(Collectors.toList())
                .get(0);
    }

    public Hero getHeroWithHighestAgility() {
        return heroMap.values()
                .stream()
                .sorted((a,b) -> Integer.compare(b.getItem().getAgility(),a.getItem().getAgility()))
                .collect(Collectors.toList())
                .get(0);
    }

    public Hero getHeroWithHighestIntelligence()  {
        return heroMap.values()
                .stream()
                .sorted((a,b) -> Integer.compare(b.getItem().getIntelligence(),a.getItem().getIntelligence()))
                .collect(Collectors.toList())
                .get(0);
    }

    public int getCount(){
        return heroMap.size();
    }
    @Override
    public String toString(){
        return String.join("\n"
                ,heroMap.values()
                .stream()
                .map(Hero::toString)
                .collect(Collectors.toList()));
    }

}
