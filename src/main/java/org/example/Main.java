package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "emrah", "kızıltan"));
        employees.add(new Employee(1, "emrah", "kızıltan"));
        employees.add(new Employee(2, "ahmet", "yılmaz"));
        employees.add(new Employee(2, "ahmet", "yılmaz"));
        employees.add(new Employee(3, "çağrı", "eren"));
        employees.add(new Employee(4, "Yusuf", "Korkmaz"));
        employees.add(new Employee(4, "Yusuf", "Korkmaz"));
        employees.add(new Employee(5, "ezgi", "yıldız"));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {

        duplicatedEmployees = new LinkedList<>();
        employeeMap = new HashMap<>();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null data buldum");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicatedEmployees.add(employee);

            } else {
                employeeMap.put(employee.getId(), employee);
            }

        }
        return duplicatedEmployees;

    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Iterator<Employee> iterator = employees.iterator();
        employeeMap = new HashMap<>();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null data buldum");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);

            }

        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }

}