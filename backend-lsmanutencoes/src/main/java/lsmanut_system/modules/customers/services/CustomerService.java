package lsmanut_system.modules.customers.services;

import lsmanut_system.modules.customers.entity.Customer;
import lsmanut_system.modules.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
//    private final CustomerRepository customerRepository;

//    Repository Dependency Injection
//    public CustomerService (CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    // Repository Dependency Injection
    @Autowired private CustomerRepository customerRepository;

    // READ ALL - HTTP METHOD GET
    public List<Customer> getAllCustomersService(){
        return customerRepository.findAll();
    }

    // READ BY ID - HTTP METHOD GET BY ID
    public Optional<Customer> getCustomerByIdService(Integer idServ){
        return customerRepository.findById(idServ);
    }

    // CREATE - HTTP METHOD POST
    public Customer createCustomerService(Customer customerServ){
        return customerRepository.saveAndFlush(customerServ);
    }

    // DELETE - HTTP METHOD DELETE
    public void deleteCustomerByIdService(Integer idServ){
        customerRepository.deleteById(idServ);
    }

    // UPDATE - HTTP METHOD PUT
    public Customer updateCustomerByIdService(Integer id, Customer customerDetailsServ){
        Customer customerEntity = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer not found with id: " + id)
        );

        customerEntity.setName(customerDetailsServ.getName());
        customerEntity.setEmail(customerDetailsServ.getEmail());
        customerEntity.setCpf(customerDetailsServ.getCpf());
        customerEntity.setPhone(customerDetailsServ.getPhone());
        customerEntity.setCustomer_code(customerDetailsServ.getCustomer_code());
        customerEntity.setFc_citycode(customerDetailsServ.getFc_citycode());
        customerEntity.setFc_addresscode(customerDetailsServ.getFc_addresscode());
        customerEntity.setFc_professioncode(customerDetailsServ.getFc_professioncode());

        return customerRepository.saveAndFlush(customerEntity);

//        Customer customerUpdated = Customer.builder()
//                .email(customerDetailsServ.getEmail() != null ? customerDetailsServ.getEmail() : customerEntity.getEmail())
//                .name(customerDetailsServ.getName() != null ? customerDetailsServ.getName() : customerEntity.getName())
//                .cpf(customerDetailsServ.getCpf() != null ? customerDetailsServ.getCpf() : customerEntity.getCpf())
//                .phone(customerDetailsServ.getPhone() != null ? customerDetailsServ.getPhone() : customerEntity.getPhone())
//                .id(customerEntity.getId())
//                .build();
//
//        customerRepository.saveAndFlush(customerUpdated);
    }
}
