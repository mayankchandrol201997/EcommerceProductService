package dev.mayank.EcommerceProductService.exception;

import dev.mayank.EcommerceProductService.controller.CartController;
import dev.mayank.EcommerceProductService.controller.ProductController;
import dev.mayank.EcommerceProductService.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException pe)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(404,pe.getMessage());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoCartsFoundException.class)
    public ResponseEntity handleNoCartsFoundException(NoCartsFoundException e)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(404,e.getMessage());
        return new ResponseEntity<>(exceptionResponseDto,HttpStatus.NOT_FOUND);
    }
}
