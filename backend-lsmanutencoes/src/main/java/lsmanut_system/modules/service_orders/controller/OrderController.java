package lsmanut_system.modules.service_orders.controller;

import lsmanut_system.exceptions.OrderNotFoundException;
import lsmanut_system.modules.service_orders.entity.Order;
import lsmanut_system.modules.service_orders.service.OrderService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

//    @GetMapping("/{id}")
    // FORMA MAIS SIMPLES DE TER O RETORNO
//    public Order getOrderByIdController(@PathVariable Integer id){
//        return orderService.getOrderById(id).orElseThrow(
//                () -> new RuntimeException("Order not found!")
//        );
//    }

    // UTILIZANDO O ResponseEntity
//    public ResponseEntity<?>getOrderByIdController(@PathVariable Integer id){
//        return orderService.getOrderById(id)
//                .<ResponseEntity<?>>map(ResponseEntity::ok)
//                .orElse(ResponseEntity
//                        .status(HttpStatus.NOT_FOUND)
//                        .body(Map.of("message", "Order not found!"))
//                );
//    }

    // UTILIZANDO O @ControllerAdvide e Global Handler Exception
    @GetMapping("/{id}")
    public ResponseEntity<?>getOrderByIdController(@PathVariable Integer id){
        Order order = orderService.getOrderByIdService(id)
                .orElseThrow( () -> new OrderNotFoundException(id));
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public List<Order> getAllOrdersController(){
        return orderService.getAllOrdersService();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrderByIdController(@PathVariable Integer idCont){
        try{
            orderService.deleteOrderByIdService(idCont);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrderController(@RequestBody Order orderCont){
        Order newOrder = orderService.createOrderService(orderCont);
        return ResponseEntity.ok(newOrder);
    }


}
