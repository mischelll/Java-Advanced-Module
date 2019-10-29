package JavaAdvancedExe.companyroster;

import java.util.List;

public class Department {
    public List<Employee> departments;

    public List<Employee> getDepartments() {
        return departments;
    }

    public void addEmployee(Employee employee) {
        this.departments.add(employee);
    }

    public double getAverageSalary(){
        return this.departments
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }


}
