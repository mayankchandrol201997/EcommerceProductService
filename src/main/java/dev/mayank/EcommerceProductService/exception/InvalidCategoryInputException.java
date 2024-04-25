package dev.mayank.EcommerceProductService.exception;

public class InvalidCategoryInputException extends RuntimeException {
    public InvalidCategoryInputException(String message) {
        super(message);
    }
}
