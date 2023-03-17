package qqb.uz.springreactlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import qqb.uz.springreactlogin.dto.EmployeeDTO;
import qqb.uz.springreactlogin.dto.LoginDTO;
import qqb.uz.springreactlogin.entity.Employee;
import qqb.uz.springreactlogin.repository.EmployeeRepository;
import qqb.uz.springreactlogin.response.LoginResponse;

import java.util.Optional;

@Service
public class EmployeeIMPL implements EmployeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),

                this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepository.save(employee);

        return employee.getFirstName();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepository.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Login Not Match", false);
            }
        } else {
                    return new LoginResponse("Email Not Exsist", false);
                }
            }

        }
