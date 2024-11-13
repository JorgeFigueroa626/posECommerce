package posECommerce.service;

import org.springframework.http.ResponseEntity;
import posECommerce.domain.entity.dto.AddProductInCartDto;
import posECommerce.domain.entity.dto.OrderDto;
import posECommerce.domain.entity.dto.PlaceOrderDto;
import posECommerce.domain.entity.request.CartItems;

import java.util.List;
import java.util.UUID;

public interface ICartService {

    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

    List<CartItems> findAllCarts();

    OrderDto getCartByUserId(Long userId);

    OrderDto applyCoupon(Long userId, String code);

    OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto placeOrder(PlaceOrderDto placeOrderDto);

    List<OrderDto> getMyPlaceOrders(Long userId);

    OrderDto searchOrderByTrackingId(UUID trackingId);

}
