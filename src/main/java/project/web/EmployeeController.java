package project.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import project.domain.Employee;
import project.domain.dto.EmployeeAutorizationDto;
import project.domain.dto.EmployeeDto;
import project.service.EmployeeService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final HttpSession httpSession;

    public EmployeeController(EmployeeService employeeService, HttpSession httpSession) {
        this.employeeService = employeeService;
        this.httpSession = httpSession;
    }

    @PostMapping("/login")
    public Employee login(@Valid EmployeeAutorizationDto employeeAutorizationDto){
        Employee employee = employeeService.login(employeeAutorizationDto);
        httpSession.setAttribute("user", employee);
        return employee;
    }

    @PostMapping("/register")
    public Employee register(@Valid EmployeeDto employeeDto){
        return employeeService.registerUser(employeeDto);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable("id") Long id, @Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.editEmployee(id, employeeDto);
    }

    @GetMapping("/all")
    public Page<Employee> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return employeeService.getAllEmployees(pageable);
    }

    @PostMapping("/delete")
    public void delete(@Valid EmployeeAutorizationDto employeeAutorizationDto){
        employeeService.delete(employeeAutorizationDto);
    }
}
