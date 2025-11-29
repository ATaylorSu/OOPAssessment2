public class Employee extends Person {
    private String employeeId;   // Employee ID
    private String position;     // Position

    // 1. Default constructor
    public Employee() {
        super();
        this.employeeId = "EMP-000";
        this.position = "Unknown";
    }

    // 2. Constructor with parameters
    public Employee(String name, int age, String personId, String employeeId, String position) {
        super(name, age, personId); // Initialize the three properties of the parent class
        this.employeeId = employeeId;
        this.position = position;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}