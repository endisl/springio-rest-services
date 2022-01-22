package com.endiluamba.payroll;

import com.endiluamba.payroll.entities.Employee;
import com.endiluamba.payroll.entities.Order;
import com.endiluamba.payroll.entities.Status;
import com.endiluamba.payroll.repositories.EmployeeRepository;
import com.endiluamba.payroll.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("John", "Doe", "developer"));
            employeeRepository.save(new Employee("Jane", "Doe", "designer"));
            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
