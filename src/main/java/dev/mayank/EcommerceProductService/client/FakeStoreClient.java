package dev.mayank.EcommerceProductService.client;

import dev.mayank.EcommerceProductService.dto.FakeStoreAllCartsResponseDto;
import dev.mayank.EcommerceProductService.dto.FakeStoreCartByUserIdResponseDto;
import dev.mayank.EcommerceProductService.dto.FakeStoreProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreApiProductPath;
    @Value("${fakestore.api.cart.by.userId.path}")
    private String fakeStoreApiCartByUserIdPath;
    @Value("${fakestore.api.all.cart.url}")
    private String fakeStoreApiAllCartUrl;

    public List<FakeStoreProductResponseDto> getAllProducts(){
        String fakeStoreGetAllProductUrl = fakeStoreBaseUrl.concat(fakeStoreApiProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto[]> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductUrl, FakeStoreProductResponseDto[].class);

        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDto getProduct(int productId) {
        String fakeStoreApiGetProductUrl=
                fakeStoreBaseUrl.concat(fakeStoreApiProductPath).concat("/"+productId);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto> productResponse =
                restTemplate.getForEntity(fakeStoreApiGetProductUrl, FakeStoreProductResponseDto.class);

        return productResponse.getBody();
    }

    public List<FakeStoreCartByUserIdResponseDto> getCartBYUserId(int userId)
    {
        if (userId<1)
            return null;
        String fakeStoregetCartByUserIdUrl = fakeStoreBaseUrl.concat(fakeStoreApiCartByUserIdPath+userId);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartByUserIdResponseDto[]> cartByUserIdResponse = restTemplate.getForEntity(fakeStoregetCartByUserIdUrl, FakeStoreCartByUserIdResponseDto[].class);
        return List.of(cartByUserIdResponse.getBody());
    }

    public List<FakeStoreAllCartsResponseDto> getAllCarts()
    {
        String fakeStoreApiToGetAllCartUrl = fakeStoreBaseUrl.concat(fakeStoreApiAllCartUrl);
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity <FakeStoreAllCartsResponseDto[]> fakeStoreAllCartResponse =restTemplate.getForEntity(fakeStoreApiToGetAllCartUrl, FakeStoreAllCartsResponseDto[].class);
        return List.of(fakeStoreAllCartResponse.getBody());
    }
}
