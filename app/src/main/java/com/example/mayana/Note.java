package com.example.mayana;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "notes")
public class Note implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String employerName;
    private String employerPosition;
    private String employerSalary;
    private String bonus;
    private String personalWage;
    private String monthSalary;

    @Ignore
    public Note(String employerName, String employerPosition, String employerSalary, String bonus, String personalWage, String monthSalary) {
        this.employerName = employerName;
        this.employerPosition = employerPosition;
        this.employerSalary = employerSalary;
        this.bonus = bonus;
        this.personalWage = personalWage;
        this.monthSalary = monthSalary;
    }

    public Note() {

    }

    public int getId() {
        return id;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getEmployerPosition() {
        return employerPosition;
    }

    public String getEmployerSalary() {
        return employerSalary;
    }

    public String getBonus() {
        return bonus;
    }

    public String getPersonalWage() {
        return personalWage;
    }

    public String getMonthSalary() {
        return monthSalary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public void setEmployerPosition(String employerPosition) {
        this.employerPosition = employerPosition;
    }

    public void setEmployerSalary(String employerSalary) {
        this.employerSalary = employerSalary;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public void setPersonalWage(String personalWage) {
        this.personalWage = personalWage;
    }

    public void setMonthSalary(String monthSalary) {
        this.monthSalary = monthSalary;
    }
}
