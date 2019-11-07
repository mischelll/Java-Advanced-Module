package javaoopexe.animals;

public class Animal {
    private String name;
    private String gender;
    private int age;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setGender(gender);
        this.setAge(age);
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public void setAge(int age) {

        this.age = age;
    }


    public String produceSound() {
        return "";
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName()
                , getName()
                , getAge()
                , getGender()
                , produceSound());
    }
}
