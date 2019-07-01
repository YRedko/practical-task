package project.domain.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class EmployeeDto {
    @NotNull
    @Size(min = 10, max = 50)
    private String fullName;
    @NotNull
    @Size(min = 5, max = 30)
    private String password;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @NotNull
    private String sex;
    private String nationality;
    @NotNull
    @Size(min = 5, max = 50)
    private String workLocation;
    @NotNull
    @Size(min = 2, max = 30)
    private String currentPosition;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startYearOfProfessionalExperience;

    public EmployeeDto(){}

    public EmployeeDto(String fullName, String password, Date dateOfBirth, String sex, String nationality, String workLocation, String currentPosition, Date startYearOfProfessionalExperience) {
        this.fullName = fullName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.nationality = nationality;
        this.workLocation = workLocation;
        this.currentPosition = currentPosition;
        this.startYearOfProfessionalExperience = startYearOfProfessionalExperience;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Date getStartYearOfProfessionalExperience() {
        return startYearOfProfessionalExperience;
    }

    public void setStartYearOfProfessionalExperience(Date startYearOfProfessionalExperience) {
        this.startYearOfProfessionalExperience = startYearOfProfessionalExperience;
    }
}
