package teaching.streams;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeesSalary {

    public static void main(String[] args) {

        EmployeesSalary employeesSalary = new EmployeesSalary();
        employeesSalary.doIt();
        employeesSalary.doItTraditionally();

    }

    private void doItTraditionally() {

        List<Employee> employees = getAllEmployees();

        // New list 
        List<Employee> copy = new ArrayList<>(employees);

        // Sort descending
        copy.sort((o1, o2) -> o2.getSalary() - o1.getSalary());

        // get first 3
        for (int i = 0; i < 3; i++) {
            Employee employee = copy.get(i);
            System.out.println(employee.getName());
        }
    }

    private boolean isActive(Employee employee) {
        return false;
    }

    private void doIt() {

        List<Employee> employees = getAllEmployees();
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getName)
                .forEach(System.out::println);
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
