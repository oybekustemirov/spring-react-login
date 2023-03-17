package qqb.uz.springreactlogin.service;


import qqb.uz.springreactlogin.dto.EmployeeDTO;
import qqb.uz.springreactlogin.dto.LoginDTO;
import qqb.uz.springreactlogin.response.LoginResponse;


public interface EmployeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
