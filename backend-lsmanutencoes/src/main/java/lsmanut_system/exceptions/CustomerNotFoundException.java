package lsmanut_system.exceptions;


public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Integer id ){
        super("Customer with ID " + id + " not found!");
    }
}
