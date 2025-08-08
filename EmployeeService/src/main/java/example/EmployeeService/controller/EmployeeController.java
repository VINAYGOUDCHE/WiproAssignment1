package example.EmployeeService.controller;

import example.EmployeeService.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/details/{id}")
    public Employee getEmployeeDetails(@PathVariable String id) {
        return new Employee(id, "Vinay", "Engineering");
    }

    @GetMapping("/list")
    public String getEmployeeList() {
        return "This is the Employee Service, returning a list of all employees.";
    }
}