package com.ocr.p9_patient.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Model for Patient
 */
@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PATIENT_ID")
    private Integer Id;
    @Column(name="FAMILLY")
    private String familly;
    @Column(name="GIVEN")
    private String given;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="PHONE")
    private String phone;
    @Column(name="SEX")
    private String sex;
    @Basic
    @Column(name="BIRTH_DATE")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthDate;
    @Basic
    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;
    @Basic
    @Column(name="UPDATE_DATE")
    private LocalDateTime updateDate;

    public Patient() {
    }

    public Patient(String famillyName, String givenName, String address, String sex, LocalDate birthDate, String phone) {
        this.familly = famillyName;
        this.given = givenName;
        this.address = address;
        this.sex = sex;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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
