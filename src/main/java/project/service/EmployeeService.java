package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.EmployeeRepository;
import project.domain.Employee;
import project.domain.dto.EmployeeAutorizationDto;
import project.domain.dto.EmployeeDto;
import project.domain.mappers.EmployeeMapper;
import project.exceptions.EntityNotFound;
import project.exceptions.IncorrectGrant;
import project.exceptions.UserAlreadyExists;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Transactional
    public Employee registerUser(EmployeeDto employeeDto){
        if(isEmployeeWithFullNameExists(employeeDto.getFullName())){
            throw new UserAlreadyExists(employeeDto.getFullName());
        }
//        Employee employee = new Employee();
//        employee.setFullName(employeeDto.getFullName());
        Employee employee = employeeMapper.toNewEmployee(employeeDto);
        employee.setPasswordHash(encryptPassword(employeeDto.getPassword()));
        return employeeRepository.saveAndFlush(employee);
    }

    public Employee login(EmployeeAutorizationDto employeeAutorizationDto){
        return employeeRepository.findEmployeeByFullName(employeeAutorizationDto.getFullName())
                .filter(employee -> checkPassword(employeeAutorizationDto, employee))
                .orElseThrow(IncorrectGrant::new);
    }

    @Transactional
    public Employee editEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = getEmployee(id);
        if(employee == null){
            throw new EntityNotFound();
        }
        Employee updatedEmployee = employeeMapper.toEmployee(employeeDto, employee);
        updatedEmployee.setId(id);
        updatedEmployee.setPasswordHash(encryptPassword(employeeDto.getPassword()));
        return employeeRepository.saveAndFlush(updatedEmployee);
    }

    public Page<Employee> getAllEmployees(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

    public void delete(EmployeeAutorizationDto employeeAutorizationDto){
        if(!employeeRepository.findEmployeeByFullName(employeeAutorizationDto.getFullName())
                .filter(employee -> checkPassword(employeeAutorizationDto, employee)).isPresent()){
            throw new IncorrectGrant();
        }
        Long id = employeeRepository.findEmployeeByFullName(employeeAutorizationDto.getFullName()).get().getId();
        employeeRepository.deleteById(id);
    }

    private boolean isEmployeeWithFullNameExists(String fullName){
        return employeeRepository.findEmployeeByFullName(fullName).isPresent();
    }

    private boolean checkPassword(EmployeeAutorizationDto employeeAutorizationDto, Employee employee){
        String encryptPassword = encryptPassword(employeeAutorizationDto.getPassword());
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

    private Employee getEmployee(long id){
        return employeeRepository.findById(id).orElseThrow(EntityNotFound::new);
    }
}
