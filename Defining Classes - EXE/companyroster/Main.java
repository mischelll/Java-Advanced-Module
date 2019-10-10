package JavaAdvancedExe.companyroster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Set<String> departments = new HashSet<>();
        List<Employee> people = new LinkedList<>();
        while (N-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            String department = data[3];
            Employee employee = createEmployee(data);
            people.add(employee);
            departments.add(department);
        }

        double highestAvgSalary = 0;
        String bestDepartment = "";

        for (String department : departments) {

            double averageSalary = 0;
            int employeeCount = 0;
            for (Employee employee : people) {
                if (department.equals(employee.getDepartment())) {
                    employeeCount++;
                    averageSalary += employee.getSalary();
                }
            }

            averageSalary /= employeeCount;
            if (averageSalary > highestAvgSalary) {
                highestAvgSalary = averageSalary;
                bestDepartment = department;
            }
        }

        System.out.println("Highest Average Salary: " + bestDepartment);
        String finalBestDepartment = bestDepartment;

        people.stream()
                .filter(e -> e.getDepartment().equals(finalBestDepartment))
                .sorted((a,b) -> Double.compare(b.getSalary(),a.getSalary()))
                .forEach(e -> System.out.printf("%s %.2f %s %d%n",
                        e.getName(),e.getSalary(),e.getEmail(),e.getAge()));


    }

    static Employee createEmployee(String[] data) {
        String name = data[0];
        double salary = Double.parseDouble(data[1]);
        String position = data[2];
        String department = data[3];
        Employee employee = new Employee(name, salary, position, department);
        if (data.length == 5) {
            String something = data[4];
            if (Character.isDigit(something.charAt(0))) {
                int age = Integer.parseInt(data[4]);
                employee.setAge(age);
            } else {
                String email = data[4];
                employee.setEmail(email);
            }
        } else if(data.length == 6){
            String email = data[4];
            int age = Integer.parseInt(data[5]);
            employee.setEmail(email);
            employee.setAge(age);
        }
        return employee;
    }
}
