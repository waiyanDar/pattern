package com.example.webui.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;
    private String cubicleNo;
    private double salary;

    public EmployeeDto(int id, String firstName, String lastName, String cubicleNo, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cubicleNo = cubicleNo;
        this.salary = salary;
    }

    public EmployeeDto() {
    }
}
