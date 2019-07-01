package project.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeAutorizationDto {

    @NotNull
    @Size(min = 10, max = 50)
    private String fullName;
    @NotNull
    @Size(min = 5, max = 30)
    private String password;

    public EmployeeAutorizationDto(){}

    public EmployeeAutorizationDto(String fullName, String password){
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
