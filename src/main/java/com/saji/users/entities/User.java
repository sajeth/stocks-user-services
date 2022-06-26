package com.saji.users.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User extends BaseEntity {
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "PIN", nullable = false)
    private String pin;
    @Column(name = "TPIN", nullable = false)
    private String tpin;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    public User() {
    }

    public User(String password, String pin, String tpin, String email, String phoneNumber) {
        this.password = password;
        this.pin = pin;
        this.tpin = tpin;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getTpin() {
        return tpin;
    }

    public void setTpin(String tpin) {
        this.tpin = tpin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
