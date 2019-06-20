package project.domain.dto;

public class EmployeeDto {

    private String fullName;
    private String password;

    public EmployeeDto(){}

    public EmployeeDto(String fullName, String password){
        this.fullName = fullName;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
