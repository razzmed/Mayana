package com.example.mayana;

public class Note {

    private String employerName;
    private String employerPosition;
    private String employerSalary;
    private String personalWage;

    public Note(String employerName, String employerPosition, String employerSalary, String personalWage) {
        this.employerName = employerName;
        this.employerPosition = employerPosition;
        this.employerSalary = employerSalary;
        this.personalWage = personalWage;
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

    public String getPersonalWage() {
        return personalWage;
    }
}
