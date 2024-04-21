package dev.mayank.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FakeStoreCartByUserIdResponseDto {
    private int id;
    private int userId;
    private String date;
    private List<FakeStoreOrderedProductResponseDto> products;
    private int __v;

    /*
    {
        "id": 1,
            "userId": 1,
            "date": "2020-03-02T00:00:00.000Z",
            "products": [
        {
            "productId": 1,
                "quantity": 4
        },
        {
            "productId": 2,
                "quantity": 1
        },
        {
            "productId": 3,
                "quantity": 6
        }
        ],
        "__v": 0
    }

     */
}
