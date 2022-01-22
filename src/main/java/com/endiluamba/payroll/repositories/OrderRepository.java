package com.endiluamba.payroll.repositories;

import com.endiluamba.payroll.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
