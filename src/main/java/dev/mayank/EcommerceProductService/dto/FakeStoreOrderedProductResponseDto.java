package dev.mayank.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreOrderedProductResponseDto {
    private int productId;
    private int quantity;
    /*
    {
            "productId": 1,
                "quantity": 4
        }
     */
}
