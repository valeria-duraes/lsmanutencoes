package lsmanut_system.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Integer id){
        super("Order with ID " + id + " not found.");
    }
}
