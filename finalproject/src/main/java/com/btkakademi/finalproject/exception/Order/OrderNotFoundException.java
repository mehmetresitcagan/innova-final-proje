package com.btkakademi.finalproject.exception.Order;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException() {
        super();
    }
    public OrderNotFoundException(String message) {
        super(message);
    }
    public OrderNotFoundException(Throwable cause) {
        super(cause);
    }
    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
