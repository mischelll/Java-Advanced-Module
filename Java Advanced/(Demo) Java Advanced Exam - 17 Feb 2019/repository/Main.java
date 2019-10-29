package repository;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();
        Person person = new Person("Pesho", 14, "13-07-2004");
        repository.add(person);

        Person person1 = new Person("Gosho", 42, "21-09-1976");
        repository.add(person1);

        System.out.println(repository.get(0).toString());
        System.out.println(repository.get(1).toString());

        repository.update(1, new Person("Success",20,"01-01-1999"));
        System.out.println(repository.get(1).toString());

        repository.delete(0);
        System.out.println(repository.getCount());



    }
}
