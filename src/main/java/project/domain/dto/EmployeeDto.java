package project.domain.dto;

public class EmployeeDto {
    private String fullName;
    private String password;

    public EmployeeDto(){}

    public EmployeeDto(String fullName, String password){
        this.fullName = fullName;
        this.password = password;
    }
}
