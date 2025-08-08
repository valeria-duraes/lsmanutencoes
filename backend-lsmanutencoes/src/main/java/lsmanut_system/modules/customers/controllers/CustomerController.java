package lsmanut_system.modules.customers.controllers;

import lsmanut_system.exceptions.CustomerNotFoundException;
import lsmanut_system.modules.customers.entity.Customer;
import lsmanut_system.modules.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("customers")
public class CustomerController {

    // Service Dependency Injection
    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomerController(){
        return customerService.getAllCustomersService();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> getCustomerByIdController(@PathVariable Integer id){
//        return customerService.getCustomerByIdService(id)
//                .map(ResponseEntity::ok)
////        Aqui, usamos .map() do Optional para montar a resposta HTTP:
////        Se achou o usuário, retorna 200 OK.
//                .orElse(ResponseEntity.notFound().build());
////        Se não achou, retorna 404 Not Found.
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getCustomerByIdController(@PathVariable Integer id){
        Customer customer = customerService.getCustomerByIdService(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomerController(@RequestBody Customer customerCont){
        Customer newCustomer = customerService.createCustomerService(customerCont);
        return ResponseEntity.ok(newCustomer);
    //  return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

//    @DeleteMapping("/{idCont}")
//    public void deleteCustomerByIdController(@PathVariable Integer idCont){
//        customerService.deleteCustomerByIdService(idCont);
//    }

    @DeleteMapping("/{idCont}")
    public ResponseEntity<Void> deleteCustomerByIdController(@PathVariable Integer idCont){
        try {
            customerService.deleteCustomerByIdService(idCont);
            return ResponseEntity.noContent().build(); // status 204
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build(); // status 404
        }
//        customerService.deleteCustomerByIdService(idCont);
//        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomerByIdController(@PathVariable Integer id, @RequestBody Customer customerUDetails){
        try{
            Customer updatedCustomer = customerService.updateCustomerByIdService(id, customerUDetails);
            return ResponseEntity.ok(updatedCustomer);
//            customerService.updateCustomerByIdService(id, customerUDetails);
//            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Opção para CORS
//    Opção 2 — Liberar CORS de forma global (para vários controllers)
//    Se preferir liberar CORS de forma global para o projeto todo:
//
//    Crie uma classe chamada CorsConfig.java no seu pacote config (ou configuração, se tiver um):
//
//    java
//            Copiar
//    Editar
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//    @Configuration
//    public class CorsConfig {
//
//        @Bean
//        public WebMvcConfigurer corsConfigurer() {
//            return new WebMvcConfigurer() {
//                @Override
//                public void addCorsMappings(CorsRegistry registry) {
//                    registry.addMapping("/**")
//                            .allowedOrigins("http://localhost:5173")
//                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//                }
//            };
//        }
//    }
}
