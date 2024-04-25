package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.dto.fakeStoreDto.FakeStoreAllCartsResponseDto;
import dev.mayank.EcommerceProductService.dto.fakeStoreDto.FakeStoreCartByUserIdResponseDto;
import dev.mayank.EcommerceProductService.exception.CartNotFoundException;

import java.util.List;

public interface CartService {
    List<FakeStoreCartByUserIdResponseDto> getCartBYUserId(int userId) throws CartNotFoundException;
    List<FakeStoreAllCartsResponseDto> getAllCarts();
}
