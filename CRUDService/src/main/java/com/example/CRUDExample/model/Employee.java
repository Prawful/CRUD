package com.example.CRUDService.model;


import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    private String firstName;
    private String lastName;
    private Date dob;
    private int ssn;
    
   
    
    public Employee(String firstName, String lastName, Date dob, int ssn ) {
    	this.firstName= firstName;
    	this.lastName = lastName;
    	this.dob = dob;
    	this.ssn = ssn;
    	
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
}
