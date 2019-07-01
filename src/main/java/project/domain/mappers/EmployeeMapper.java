package project.domain.mappers;

import org.springframework.stereotype.Component;
import project.domain.Employee;
import project.domain.dto.EmployeeDto;

@Component
public class EmployeeMapper {

    public Employee toNewEmployee(EmployeeDto employeeDto) {
        if(employeeDto == null){
            return null;
        }

        Employee employee = new Employee();

        employee.setFullName(employeeDto.getFullName());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setSex(employeeDto.getSex());
        employee.setNationality(employeeDto.getNationality());
        employee.setWorkLocation(employeeDto.getWorkLocation());
        employee.setCurrentPosition(employeeDto.getCurrentPosition());
        employee.setStartYearOfProfessionalExperience(employeeDto.getStartYearOfProfessionalExperience());

        return employee;
    }

    public Employee toEmployee(EmployeeDto employeeDto, Employee employee) {
        if(employeeDto == null) {
            return null;
        }
        if(employeeDto.getFullName() != null) {
            employee.setFullName(employeeDto.getFullName());
        }
        if(employeeDto.getDateOfBirth() != null) {
            employee.setDateOfBirth(employeeDto.getDateOfBirth());
        }
        if(employeeDto.getSex() != null){
            employee.setSex(employeeDto.getSex());
        }
        if(employeeDto.getNationality() != null){
            employee.setNationality(employeeDto.getNationality());
        }
        if(employeeDto.getWorkLocation() != null){
            employee.setWorkLocation(employeeDto.getWorkLocation());
        }
        if(employeeDto.getCurrentPosition() != null){
            employee.setCurrentPosition(employeeDto.getCurrentPosition());
        }
        if(employeeDto.getStartYearOfProfessionalExperience() != null){
            employee.setStartYearOfProfessionalExperience(employeeDto.getStartYearOfProfessionalExperience());
        }
        return employee;
    }
}
