package com.example.employeeservice.controller;

import com.example.employeeservice.dao.EmployeeDao;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.dto.Employees;
import com.example.employeeservice.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeDao employeeDao;

    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public Employees listAllEmployee(){
        List<EmployeeDto> employeeDtoList =employeeDao.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return new Employees(employeeDtoList);
    }
    private EmployeeDto toDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getCubicleNo(),
                employee.getSalary()
        );
    }
}
