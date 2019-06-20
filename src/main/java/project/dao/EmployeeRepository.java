package project.dao;

import project.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    boolean isEmployeeWithFullNameExists(String fullName);

    Employee save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findEmployeeByFullName(String fullName);
}
