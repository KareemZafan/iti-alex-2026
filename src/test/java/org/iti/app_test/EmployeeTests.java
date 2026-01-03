package org.iti.app_test;

import org.iti.app.Employee;
import org.iti.app.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeTests {

    @Mock
    Employee employee1;

    @Mock
    Employee employee2;

    @Mock
    Employee employee3;

    @Mock
    Employee employee4;

    @InjectMocks
    EmployeeService employeeService;


    @Test
    public void testGettingActiveEmployees() {
        when(employee1.isActive()).thenReturn(true);
        when(employee1.getName()).thenReturn("Ahmed");

        when(employee2.isActive()).thenReturn(false);
        when(employee2.getName()).thenReturn("Alaa");


        when(employee3.isActive()).thenReturn(true);
        when(employee3.getName()).thenReturn("Abdelrahman");

        when(employee4.isActive()).thenReturn(true);
        when(employee4.getName()).thenReturn("Mina");


        List<Employee> mockedEmployees = Arrays.asList(employee1, employee2, employee3, employee4);
        assertEquals(List.of("Ahmed", "Abdelrahman", "Mina"), employeeService.getActiveEmployees(mockedEmployees));

        assertFalse(employeeService.getActiveEmployees(mockedEmployees).contains(employee2.getName()));

    }

    @Test
    public void testGettingHigherSalary() {
        when(employee1.getSalary()).thenReturn(10000.00);
        when(employee1.getName()).thenReturn("Ahmed");

        when(employee2.getSalary()).thenReturn(60000.00);
        when(employee2.getName()).thenReturn("Alaa");

        when(employee3.getSalary()).thenReturn(3000.00);
        when(employee3.getName()).thenReturn("Abdelrahman");

        when(employee4.getSalary()).thenReturn(200000.00);
        when(employee4.getName()).thenReturn("Mina");


        List<Employee> mockedEmployees = Arrays.asList(employee1, employee2, employee3, employee4);

        assertEquals(List.of("Alaa", "Mina"), employeeService.getEmployeesWithHigherSalary(mockedEmployees));

        assertFalse(employeeService.getEmployeesWithHigherSalary(mockedEmployees).contains(List.of(employee1.getName(),employee3.getName(),employee3.getName())));

    }

    @Test
    public void testGettingDepartmentEmployees() {
        when(employee1.getDepartment()).thenReturn("Finance");
        when(employee1.getName()).thenReturn("Ahmed");

        when(employee2.getDepartment()).thenReturn("IT");
        when(employee2.getName()).thenReturn("Mohamed");

        when(employee3.getDepartment()).thenReturn("IT");
        when(employee3.getName()).thenReturn("Alaa");

        when(employee4.getDepartment()).thenReturn("QA");
        when(employee4.getName()).thenReturn("Mina");



        List<Employee> mockedEmployees = Arrays.asList(employee1, employee2, employee3, employee4);

        assertEquals(List.of("Mohamed", "Alaa"), employeeService.getEmployeeNamesForDepartment(mockedEmployees, "IT"));

        assertEquals(List.of("Mina"), employeeService.getEmployeeNamesForDepartment(mockedEmployees, "QA"));
        assertEquals(List.of("Ahmed"), employeeService.getEmployeeNamesForDepartment(mockedEmployees, "Finance"));

    }


}
