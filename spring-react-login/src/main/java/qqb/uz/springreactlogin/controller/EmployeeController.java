package qqb.uz.springreactlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qqb.uz.springreactlogin.dto.EmployeeDTO;
import qqb.uz.springreactlogin.dto.LoginDTO;
import qqb.uz.springreactlogin.response.LoginResponse;
import qqb.uz.springreactlogin.service.EmployeService;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {


    @Autowired
    private final EmployeService employeService;

    public EmployeeController(EmployeService employeService) {
        this.employeService = employeService;
    }


    @PostMapping(path = "/save")
    public String saveEmploye(@RequestBody EmployeeDTO employeeDTO){
        return employeService.addEmployee(employeeDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = employeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
