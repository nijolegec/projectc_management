package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.example.domain.Employee;
import org.example.domain.Project;
import org.example.repository.EmployeeRepository;
import org.example.repository.ProjectRepository;
import org.example.service.EmployeeService;
import org.example.service.ProjectService;

public class Main {

    public static EmployeeService employeeService;
    public static ProjectService projectService;
    public static EmployeeRepository employeeRepository;
    public static ProjectRepository projectRepository;

    public static void main(String[] args) {
        projectRepository = new ProjectRepository();
        employeeRepository = new EmployeeRepository();
        projectService = new ProjectService();
        employeeService = new EmployeeService(employeeRepository, projectRepository);

        printEmployeesForProject();
    }

    private static void printEmployeeFullNames() {
        List<Employee> employees = employeeService.getAllEmployees();

        for (Employee e : employees) {
            System.out.println(e.getName() + " " + e.getLastName());
        }
    }

    private static void printAllProjects() {
        List<Project> projects = projectService.getAllProjects();

        System.out.println(projects);
    }

    private static void printEmployeesForProject() {
        Map<Project, List<Employee>> employeesForProject = employeeService.getEmployeesForProject();

        Set<Project> mapKeys = employeesForProject.keySet();

        for (Project project : mapKeys) {
            System.out.println("= " + project.getName() + " =");

            List<Employee> employeeList = employeesForProject.get(project);

            int i = 1;
            for (Employee employee : employeeList) {
                System.out.println(i + ". " + employee.getName() + " " + employee.getLastName());
                i++;
            }
        }
    }
}