package JavaAdvancedExe.catlady;

public class Cat {
    private String name;
    private String breed;

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String toString() {
        return String.format("%s %s ",getBreed(), getName());
    }
}
