package qqb.uz.springreactlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import qqb.uz.springreactlogin.entity.Employee;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findOneByEmailAndPassword(String email, String encodedPassword);

    Employee findByEmail(String email);
}
