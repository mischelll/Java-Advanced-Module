package javaooplabs.animals;

public class Main {
    public static void main(String[] args) {

        Animal a = new Cat("Jose","Vodka");
        Animal b = new Dog("Jaed","Vodka");

        System.out.println(a.explainSelf());
    }
}
