package lsmanut_system.modules.service_orders.service;

import lsmanut_system.exceptions.OrderNotFoundException;
import lsmanut_system.modules.service_orders.dto.OrderUpdateDTO;
import lsmanut_system.modules.service_orders.entity.Order;
import lsmanut_system.modules.service_orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    // Independency Injection
    public OrderService (OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // GET by customer id - filter
    public List<Order> getOrderByCustomerIdService(Integer customerId){
        return orderRepository.findByCustomer_Id(customerId);
    }

    // GET by order id
    public Optional<Order> getOrderByIdService(Integer id){
        return orderRepository.findById(id);
    }

    // GET all orders
    public List<Order> getAllOrdersService(){
        return orderRepository.findAll();
    }

    // POST order
    public Order createOrderService(Order orderServ){
        return orderRepository.saveAndFlush(orderServ);
    }

    // DELETE order
    public void deleteOrderByIdService(Integer idServ){
        orderRepository.deleteById(idServ);
    }

    // PUT order
    public Order updateOrderByIdService(Integer idServ, OrderUpdateDTO dto){
        Order existingOrder = orderRepository.findById(idServ).orElseThrow(
                () -> new OrderNotFoundException(idServ)
        );

        existingOrder.setM_name(dto.getM_name());
        existingOrder.setM_model(dto.getM_model());
        existingOrder.setVoltage(dto.getVoltage());
        existingOrder.setBrand(dto.getBrand());
        existingOrder.setSerial_number(dto.getSerial_number());
        existingOrder.setAccessories(dto.getAccessories());
        existingOrder.setObservations(dto.getObservations());
        existingOrder.setService_cost(dto.getService_cost());
        existingOrder.setParts(dto.getParts());
        existingOrder.setStatus_budget(dto.getStatus_budget());
        existingOrder.setStatus_delivery(dto.getStatus_delivery());
        existingOrder.setStatus_payment(dto.getStatus_payment());
        existingOrder.setPayment_method(dto.getPayment_method());
        existingOrder.setService_date(dto.getService_date());

        return orderRepository.saveAndFlush(existingOrder);
    }
}
