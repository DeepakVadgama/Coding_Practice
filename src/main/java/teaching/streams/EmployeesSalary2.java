package teaching.streams;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesSalary2 {

    public static void main(String[] args) {

        EmployeesSalary2 employeesSalary = new EmployeesSalary2();
        employeesSalary.doIt();
        employeesSalary.doItTraditionally();

    }

    private void doItTraditionally() {

        List<Employee> employees = getAllEmployees();

        // Clone list
        List<Employee> copy = new ArrayList<>(employees);

        // Sort descending (not readable code)
        copy.sort((o1, o2) -> o2.getSalary() - o1.getSalary());

        // Get first 3 ACTIVE

        List<String> highestPaid = new ArrayList<>();
        Iterator<Employee> iterator = copy.iterator();
        int count = 0;

        while (count < 3 && iterator.hasNext()) {

            Employee employee = iterator.next();
            if (isActive(employee)) {
                String name = employee.getName();
                highestPaid.add(name);
                count++;
            }
        }
    }

    private boolean isActive(Employee employee) {
        return false;
    }

    private void doIt() {

        List<Employee> employees = getAllEmployees();
        List<String> names
                = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .filter(employee -> isActive(employee))
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toList());

    }


    private List<Employee> getAllEmployees() {
        return Lists.newArrayList(
                new Employee("John", 10000, "IT"),
                new Employee("John 2", 12000, "IT"),
                new Employee("John 3", 13000, "IT"),
                new Employee("John 4", 14000, "IT"),
                new Employee("John 5", 15000, "IT"),
                new Employee("John 6", 16000, "IT"));
    }

    private class Employee {
        public String name;
        public int salary;
        public String dept;

        public Employee(String name, int salary, String dept) {
            this.name = name;
            this.salary = salary;
            this.dept = dept;
        }

        public int getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", dept='" + dept + '\'' +
                    '}';
        }
    }
}
