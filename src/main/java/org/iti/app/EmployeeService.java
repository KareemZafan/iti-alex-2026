package org.iti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    List<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        // Calling Database;
        return List.of(new Employee(1, "Ahmed", "IT", true),
                new Employee(2, "Mina", "HR", false),
                new Employee(3, "Ali", "Sales", true),
                new Employee(4, "Alaa", "Sales", true));
    }

    // List of Active
    public List<String> getActiveEmployees(List<Employee> employees) {
        return employees.stream().filter(Employee::isActive).map(Employee::getName).collect(Collectors.toList());
    }


    // list 50000

    public List<String> getEmployeesWithHigherSalary(List<Employee> employees) {
        return employees.stream().filter(employee -> employee.getSalary() > 50000.00).map(Employee::getName).collect(Collectors.toList());
    }


    // AvgSalary

    public double getAverageSalary(List<Employee> employees) {
        double totalSalaries = employees.stream().mapToDouble(Employee::getSalary).sum();
        int count = employees.size();

        return totalSalaries / count;
    }

    // getDepartment Employees

    public List<String> getEmployeeNamesForDepartment(List<Employee> employees, String department) {
        return employees.stream().filter(employee -> employee.getDepartment().equals(department)).map(Employee::getName).collect(Collectors.toList());
    }



}
