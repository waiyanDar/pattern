package com.example.employeeservice;

import com.example.employeeservice.dao.EmployeeDao;
import com.example.employeeservice.entity.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class EmployeeServiceApplication {

    private final EmployeeDao employeeDao;

    public EmployeeServiceApplication(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Bean @Profile("dev")
    @Transactional
    public ApplicationRunner runner(){
        return args -> {
            Employee e1 = new Employee("John","Doe","E01",3000);
            Employee e2 = new Employee("Thomas","Hardy","E02",2500);
            Employee e3 = new Employee("John","William","E03",3500);

            employeeDao.save(e1);
            employeeDao.save(e2);
            employeeDao.save(e3);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}
