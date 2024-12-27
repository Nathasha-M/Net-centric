const apiUrl = "http://localhost:8082/api/employees"; // Replace with your API URL

// Utility function to format date
function formatDate(dateString) {
    const date = new Date(dateString);
    return date.toISOString().split("T")[0]; // Extracts the YYYY-MM-DD part
}

// Fetch all employees
async function fetchEmployees() {
    const response = await fetch(apiUrl);
    const employees = await response.json();
    const employeesTable = document.getElementById("employees");

    employeesTable.innerHTML = ""; // Clear existing rows

    employees.forEach((employee) => {
        const row = `
            <tr>
                <td>${employee.id}</td>
                <td>${employee.employeeNo}</td>
                <td>${employee.name}</td>
                <td>${formatDate(employee.dob)}</td> <!-- Format DoB -->
                <td>${employee.jobTitle}</td>
                <td>${employee.department}</td>
                <td>${employee.basicSalary}</td>
                <td class="actions">
                    <button onclick="deleteEmployee(${employee.id})">Delete</button>
                </td>
            </tr>
        `;
        employeesTable.innerHTML += row;
    });
}

// Add or Update Employee
async function saveEmployee(event) {
    event.preventDefault();

    const employee = {
        employeeNo: document.getElementById("employeeNo").value,
        name: document.getElementById("name").value,
        dob: document.getElementById("dob").value,
        jobTitle: document.getElementById("jobTitle").value,
        department: document.getElementById("department").value,
        basicSalary: parseFloat(document.getElementById("basicSalary").value),
    };

    const response = await fetch(apiUrl, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(employee),
    });

    if (response.ok) {
        alert("Employee saved successfully!");
        fetchEmployees();
        document.getElementById("form").reset();
    } else {
        alert("Failed to save employee!");
    }
}

// Delete Employee
async function deleteEmployee(id) {
    const response = await fetch(`${apiUrl}/${id}`, {
        method: "DELETE",
    });

    if (response.ok) {
        alert("Employee deleted successfully!");
        fetchEmployees();
    } else {
        alert("Failed to delete employee!");
    }
}

// Initialize
document.getElementById("form").addEventListener("submit", saveEmployee);
fetchEmployees();
