package com.endiluamba.payroll.repositories;

import com.endiluamba.payroll.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
