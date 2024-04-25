package dev.mayank.EcommerceProductService.controller;

import dev.mayank.EcommerceProductService.dto.fakeStoreDto.FakeStoreAllCartsResponseDto;
import dev.mayank.EcommerceProductService.dto.fakeStoreDto.FakeStoreCartByUserIdResponseDto;
import dev.mayank.EcommerceProductService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartByUserId(@PathVariable("userId") int userid)
    {
        List<FakeStoreCartByUserIdResponseDto> fakeStoreCartByUserIdResponseDto =
                cartService.getCartBYUserId(userid);
        return ResponseEntity.ok(fakeStoreCartByUserIdResponseDto);
    }

    @GetMapping("/carts")
    public ResponseEntity getAllCarts()
    {
        List<FakeStoreAllCartsResponseDto> fakeStoreAllCartsResponseDto =
                cartService.getAllCarts();
        return ResponseEntity.ok(fakeStoreAllCartsResponseDto);

    }

}
