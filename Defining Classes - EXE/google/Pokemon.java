package JavaAdvancedExe.google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    @Override
    public String toString(){
        return String.format("%s %s%n",getName(),getType());
    }
}
