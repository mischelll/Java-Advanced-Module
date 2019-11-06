package javaooplabs.randomarraylist;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<String> arrayList = new RandomArrayList<>();
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        System.out.println(arrayList.getRandomElement());

    }
}
