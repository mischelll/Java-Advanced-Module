package JavaAdvancedExe.pokemontrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String name;
    private int badges = 0;
    private Map<String, List<Pokemon>> pokemons;

    public Map<String, List<Pokemon>> getPokemons() {
        return pokemons;
    }


    public Trainer(String name) {
        this.name = name;
        this.setPokemons();
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public void addBadges(int badges) {
        this.badges += badges;
    }

    public int getPokemonsSize() {
        int size = 0;
        for (List<Pokemon> value : this.pokemons.values()) {
            size += value.size();
        }
        return size;
    }

    public String toString() {
        return String.format("%s %d %d", getName(), getBadges(), getPokemonsSize());
    }

    private void setPokemons() {
        this.pokemons = new HashMap<>();
        this.pokemons.put("Fire", new ArrayList<>());
        this.pokemons.put("Water", new ArrayList<>());
        this.pokemons.put("Electricity", new ArrayList<>());
    }

    public void addPokemon(Pokemon pokemon) {

        this.pokemons.putIfAbsent(pokemon.getElement(),new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);

    }

    public boolean hasElement(String element) {
        return this.pokemons.get(element).size() != 0;
    }
}
