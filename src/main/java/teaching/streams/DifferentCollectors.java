package teaching.streams;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@SuppressWarnings("all")
public class DifferentCollectors {

    public static void main(String[] args) {

        DifferentCollectors employeesSalary = new DifferentCollectors();
        employeesSalary.doIt();
    }

    private boolean isActive(Employee employee) {
        return false;
    }

    private void doIt() {

        List<Employee> employees = getAllEmployees();

        // to list
        List<String> listOfEmps
                = employees.stream()
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toList());

        // to set
        Set<String> setOfEmps
                = employees.stream()
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toSet());

        // to map
        Map<String, Employee> empMap
                = employees.stream()
                .limit(3)
                .collect(Collectors.toMap(e -> e.name, e -> e));
        
        // john, amy, marcy
        String names
                = employees.stream()
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        // group by dept
        Map<String, List<Employee>> empByDept
                = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept));

        // count employees in each dept
        Map<String, Long> deptCounts
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

        // parallel streams
        Map<String, List<Employee>> empByDep
                = employees.stream()
                .parallel()  // very easy and deceptive
                .collect(Collectors.groupingBy(e -> e.dept));

        System.out.println(deptCounts);
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

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
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
