package dev.mayank.EcommerceProductService.exception;

public class NoCartsFoundException extends RuntimeException {
    public NoCartsFoundException(String message) {
        super(message);
    }
}
