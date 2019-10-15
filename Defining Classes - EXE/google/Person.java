package JavaAdvancedExe.google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Car car;
    private Company company;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.car = new Car();
        this.company = new Company();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public Company getCompany() {
        return company;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(System.getProperty("line.separator"));

        sb.append("Company:");
        sb.append(System.getProperty("line.separator"));
        if (company.getName() != null) {
            sb.append(company.toString());
        }

        sb.append("Car:");
        sb.append(System.getProperty("line.separator"));
        if (car.getModel() != null) {
            sb.append(car.toString());
        }

        sb.append("Pokemon:");
        sb.append(System.getProperty("line.separator"));
        if (!pokemons.isEmpty()) {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString());
            }
        }

        sb.append("Parents:");
        sb.append(System.getProperty("line.separator"));
        if(!parents.isEmpty()){
            for (Parent parent : parents) {
                sb.append(parent.toString());
            }
        }

        sb.append("Children:");
        sb.append(System.getProperty("line.separator"));
        if (!children.isEmpty()){
            for (Child child : children) {
                sb.append(child.toString());
            }
        }
        String str = sb.toString();
        return str;
    }
}
