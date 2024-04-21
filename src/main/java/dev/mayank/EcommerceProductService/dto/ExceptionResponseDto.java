package dev.mayank.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDto {
    private int errorCode;
    private String message;

    public ExceptionResponseDto(int code, String message) {
        this.errorCode = code;
        this.message = message;
    }
}
