package javaooplabs.salaryincrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this(firstName, lastName, age);
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String value = "" + this.getSalary();
        String s = new DecimalFormat("0.####").format(Double.parseDouble(value));
        return String.format("%s %S gets %s leva",
                getFirstName(),
                getLastName(),
                s);
    }

    public void increaseSalary(double bonus) {
        if (getAge() < 30){
            bonus /= 2;
            double toAdd = this.getSalary() * bonus/ 100;
            this.setSalary(this.getSalary() + toAdd);
        }else {
            double toAdd = this.getSalary() * bonus/ 100;
            this.setSalary(this.getSalary() + toAdd);
        }
    }
}
