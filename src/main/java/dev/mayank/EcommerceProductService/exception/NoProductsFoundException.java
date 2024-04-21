package dev.mayank.EcommerceProductService.exception;

public class NoProductsFoundException extends RuntimeException {
    public NoProductsFoundException() {
    }

    public NoProductsFoundException(String message) {
        super(message);
    }
}
