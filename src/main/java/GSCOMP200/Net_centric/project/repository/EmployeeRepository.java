package GSCOMP200.Net_centric.project.repository; // Your package path

import org.springframework.data.jpa.repository.JpaRepository;
import GSCOMP200.Net_centric.project.entity.Employee; // Import the Employee entity class

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // You can define custom queries here if needed, but basic CRUD operations are already available
}
