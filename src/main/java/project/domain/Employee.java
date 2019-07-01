package project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String passwordHash;
    private Date dateOfBirth;
    private String sex;
    private String nationality;
    private String workLocation;
    private String currentPosition;
    private Date startYearOfProfessionalExperience;

    public Employee(){}

    public Employee(String fullName, String passwordHash, Date dateOfBirth, String sex, String nationality, String workLocation, String currentPosition, Date startYearOfProfessionalExperience) {
        this.fullName = fullName;
        this.passwordHash = passwordHash;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.nationality = nationality;
        this.workLocation = workLocation;
        this.currentPosition = currentPosition;
        this.startYearOfProfessionalExperience = startYearOfProfessionalExperience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
