package dev.mayank.EcommerceProductService.exception;

import dev.mayank.EcommerceProductService.controller.ProductController;
import dev.mayank.EcommerceProductService.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class,NoProductsFoundException.class})
    public ResponseEntity handleProductNotFoundException(ProductNotFoundException pe)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(404,pe.getMessage());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleInvalidInputException(InvalidInputException e)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(400,e.getMessage());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
    }
}
