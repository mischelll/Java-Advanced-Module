package JavaAdvancedExe.companyroster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int  age = -1;

    public Employee(String name, double salary, String position,String department){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
