package com.ocr.p9_patient.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PATIENT_ID")
    private Integer Id;
    @NotBlank(message = "Please enter an lastName")
    @Column(name="LAST_NAME")
    private String lastName;
    @NotBlank(message = "Please enter an firstName")
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="FAMILLY")
    private String familly;
    @Column(name="GIVEN")
    private String given;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="SEX")
    private String sex;
    @Basic
    @Column(name="BIRTH_DATE")
    private Date birthDate;
    @Basic
    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;
    @Basic
    @Column(name="UPDATE_DATE")
    private LocalDateTime updateDate;

    public Patient() {
    }

    public Patient(String lastName, String firstName, String familly, String given, String address, String sex, Date birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.familly = familly;
        this.given = given;
        this.address = address;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilly() {
        return familly;
    }

    public void setFamilly(String familly) {
        this.familly = familly;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
