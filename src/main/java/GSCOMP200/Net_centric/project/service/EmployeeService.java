package GSCOMP200.Net_centric.project.service; // Your service package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import GSCOMP200.Net_centric.project.entity.Employee;
import GSCOMP200.Net_centric.project.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee); // Save employee to database
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Retrieve all employees
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id); // Find employee by ID
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id); // Delete employee by ID
    }
}

