package teaching.streams;

import com.google.common.collect.Lists;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorExample {

    public static void main(String[] args) {

        CollectorExample employeesSalary = new CollectorExample();
        employeesSalary.doIt();
    }

    private boolean isActive(Employee employee) {
        return false;
    }

    private void doIt() {

        List<Employee> employees = getAllEmployees();
        employees.stream().collect(Collectors.toSet());
//        employees.stream().collect(Collectors.toMap(e -> e.getDeptId(), e -> e.));

        employees.stream().collect(Collectors.averagingInt(Employee::getSalary));
        IntSummaryStatistics statistics = employees.stream().collect(Collectors.summarizingInt(Employee::getSalary));


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
