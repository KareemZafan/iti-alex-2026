package org.iti.app;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private boolean isActive;
    private String address;
    private String phone;
    private LocalDate birthday;
    private LocalDate hireDate;
    private String email;
    private String department;

    public Employee() {
    }

    public Employee(int id, String name, String department, boolean isActive) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public boolean isActive() {
        return isActive;
    }
    public String getDepartment() {
        return department;
    }



}
