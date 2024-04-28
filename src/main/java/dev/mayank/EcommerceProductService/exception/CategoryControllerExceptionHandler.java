package dev.mayank.EcommerceProductService.exception;

import dev.mayank.EcommerceProductService.controller.CategoryController;
import dev.mayank.EcommerceProductService.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CategoryController.class)
public class CategoryControllerExceptionHandler {

    @ExceptionHandler(NoCategoryFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleNoCategoryFoundException(NoCategoryFoundException e)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(404,e.getMessage());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleCategoryNotFoundException(CategoryNotFoundException e)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(404,e.getMessage());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCategoryInputException.class)
    public ResponseEntity<ExceptionResponseDto> handleInvalidCategoryInputException(InvalidCategoryInputException e)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(404,e.getMessage());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
    }
}
