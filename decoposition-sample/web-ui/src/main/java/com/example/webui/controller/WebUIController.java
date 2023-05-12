package com.example.webui.controller;

import com.example.webui.dto.AddressDto;
import com.example.webui.dto.Addresses;
import com.example.webui.dto.EmployeeDto;
import com.example.webui.dto.Employees;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/webui")
public class WebUIController {

    private final RestTemplate restTemplate;

    @GetMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("addresses", addressDtos);
        model.addAttribute("employees", employeeDtos);
        return "home";
    }

    List<AddressDto> addressDtos = new ArrayList<>();
    List<EmployeeDto> employeeDtos = new ArrayList<>();

    public WebUIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/addresses")
    public String listAllAddress(Model model){
        ResponseEntity<Addresses> addressResponse = restTemplate.getForEntity("http://localhost:8080/address/addresses", Addresses.class);
        if (addressResponse.getStatusCode().is2xxSuccessful()){
            addressDtos = addressResponse.getBody().getAddresses();
            model.addAttribute("addresses",addressDtos);
            model.addAttribute("hasAddresses",true);
            return "home";
        }else {
            model.addAttribute("addresses", List.of());
            return "home";
        }
    }

    @GetMapping("employees")
    public String listAllEmployee(Model model){
        ResponseEntity<Employees> employeesResponseEntity = restTemplate.getForEntity("http://localhost:8080/employee/employees", Employees.class);
        if (employeesResponseEntity.getStatusCode().is2xxSuccessful()){
            employeeDtos = employeesResponseEntity.getBody().getEmployeeDtos();
            model.addAttribute("employees",employeeDtos);
            model.addAttribute("hasEmployees",true);
            return "home";
        }else {
            model.addAttribute("employees",List.of());
            return "home";
        }
    }
}
