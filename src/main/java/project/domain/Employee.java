package project.domain;

import java.time.LocalDate;

public class Employee {

    private String fullName;
    private String passwordHash;
    private LocalDate dateOfBirth;
    private String sex;
    private String nationality;
    private String workLocation;
    private String currentPosition;
    private LocalDate startYearOfProfessionalExperience;

    public Employee(){}

    public Employee(String fullName, String passwordHash, LocalDate dateOfBirth, String sex, String nationality, String workLocation, String currentPosition, LocalDate startYearOfProfessionalExperience) {
        this.fullName = fullName;
        this.passwordHash = passwordHash;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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

    public LocalDate getStartYearOfProfessionalExperience() {
        return startYearOfProfessionalExperience;
    }

    public void setStartYearOfProfessionalExperience(LocalDate startYearOfProfessionalExperience) {
        this.startYearOfProfessionalExperience = startYearOfProfessionalExperience;
    }
}
