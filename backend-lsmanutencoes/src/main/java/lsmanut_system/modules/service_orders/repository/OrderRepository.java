package lsmanut_system.modules.service_orders.repository;

import lsmanut_system.modules.service_orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer_Id(Integer customerId);
}

