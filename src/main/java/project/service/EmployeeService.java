package project.service;

import project.dao.EmployeeRepository;
import project.domain.Employee;
import project.domain.dto.EmployeeDto;
import project.exceptions.UncorrectGrant;
import project.exceptions.UserAlreadyExists;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee registerEmployee(EmployeeDto employeeDto){
        if(employeeRepository.isEmployeeWithFullNameExists(employeeDto.getFullName())){
            throw new UserAlreadyExists(employeeDto.getFullName());
        }
        Employee employee = new Employee();
        employee.setFullName(employeeDto.getFullName());
        employee.setPasswordHash(encryptPassword(employeeDto.getPassword()));
        return employeeRepository.save(employee);
    }

    public Employee login(EmployeeDto employeeDto){
        return employeeRepository.findEmployeeByFullName(employeeDto.getFullName())
                .filter(employee -> checkPassword(employeeDto, employee))
                .orElseThrow(UncorrectGrant::new);
    }

    private boolean checkPassword(EmployeeDto employeeDto, Employee employee){
        String encryptPassword = encryptPassword(employeeDto.getPassword());
        return encryptPassword.equals(employee.getPasswordHash());
    }

    private static String encryptPassword(String password){
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes(UTF_8));
            return new BigInteger(1, crypt.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
