package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.client.FakeStoreClient;
import dev.mayank.EcommerceProductService.dto.fakeStoreDto.FakeStoreAllCartsResponseDto;
import dev.mayank.EcommerceProductService.dto.fakeStoreDto.FakeStoreCartByUserIdResponseDto;
import dev.mayank.EcommerceProductService.exception.CartNotFoundException;
import dev.mayank.EcommerceProductService.exception.NoCartsFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreCartServiceImpl implements CartService{
    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Override
    public List<FakeStoreCartByUserIdResponseDto> getCartBYUserId(int userId) throws CartNotFoundException{
         List<FakeStoreCartByUserIdResponseDto> fakeStoreCartByUserIdResponseDtoList
                 =fakeStoreClient.getCartBYUserId(userId);

         if (fakeStoreCartByUserIdResponseDtoList == null) {
             throw new CartNotFoundException("Cart not found");
         }

         return fakeStoreCartByUserIdResponseDtoList;
    }

    @Override
    public List<FakeStoreAllCartsResponseDto> getAllCarts() {
        List<FakeStoreAllCartsResponseDto> fakeStoreAllCartsResponseDtoList =
                fakeStoreClient.getAllCarts();

        if (fakeStoreAllCartsResponseDtoList == null)
            throw new NoCartsFoundException("No carts found");

        return fakeStoreAllCartsResponseDtoList;
    }
}
