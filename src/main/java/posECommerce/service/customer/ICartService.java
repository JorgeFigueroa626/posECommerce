package posECommerce.service.customer;

import org.springframework.http.ResponseEntity;
import posECommerce.domain.entity.dto.AddProductInCartDto;
import posECommerce.domain.entity.dto.OrderDto;
import posECommerce.domain.entity.dto.PlaceOrderDto;

import java.util.List;

public interface ICartService {

    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

    OrderDto getCartByUserId(Long userId);

    OrderDto applyCoupon(Long userId, String code);

    OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto placeOrder(PlaceOrderDto placeOrderDto);

    List<OrderDto> getMyPlaceOrders(Long userId);

}
