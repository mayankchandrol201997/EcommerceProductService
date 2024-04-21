package dev.mayank.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreAllCartsResponseDto {
    private int id;
    private int userId;
    private String date;
    private List<FakeStoreOrderedProductResponseDto> products;
}
