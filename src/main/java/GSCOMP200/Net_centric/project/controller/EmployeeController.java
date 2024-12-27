package GSCOMP200.Net_centric.project.controller; // Your controller package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import GSCOMP200.Net_centric.project.entity.Employee;
import GSCOMP200.Net_centric.project.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees") // The base URL for the employee API
@CrossOrigin(origins = "http://localhost:63342") // Allow requests from your frontend's origin
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED); // Return 201 CREATED status
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK); // Return 200 OK status
    }

    // Get a single employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK); // Return 200 OK if found
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 NOT FOUND if not found
        }
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee.isPresent()) {
            employee.setId(id); // Make sure to set the ID so it updates the existing record
            Employee updatedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK); // Return 200 OK with the updated employee
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 NOT FOUND if the employee doesn't exist
        }
    }

    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee.isPresent()) {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 NO CONTENT if deletion was successful
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 NOT FOUND if the employee doesn't exist
        }
    }
}
