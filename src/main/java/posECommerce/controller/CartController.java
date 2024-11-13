package posECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posECommerce.domain.entity.dto.AddProductInCartDto;
import posECommerce.domain.entity.dto.OrderDto;
import posECommerce.domain.entity.dto.PlaceOrderDto;
import posECommerce.domain.entity.request.CartItems;
import posECommerce.exception.ValidationException;
import posECommerce.service.ICartService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CartController {

    @Autowired
    private ICartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<?> addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto){
        return cartService.addProductToCart(addProductInCartDto);
    }

    @GetMapping("/carts")
    public ResponseEntity<List<CartItems>> findAllCarts(){
        List<CartItems> cartItems = cartService.findAllCarts();
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable Long userId){
        try {
            OrderDto orderDto = cartService.getCartByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(orderDto);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/cart/addition")
    public ResponseEntity<OrderDto> increaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.increaseProductQuantity(addProductInCartDto));
    }

    @PostMapping("/cart/decrease")
    public ResponseEntity<OrderDto> decreaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.decreaseProductQuantity(addProductInCartDto));
    }

    @GetMapping("/coupon/{userId}/{code}")
    public ResponseEntity<?> applyCoupon(@PathVariable Long userId, @PathVariable String code){
        try {
            OrderDto orderDto = cartService.applyCoupon(userId, code);
            return ResponseEntity.ok(orderDto);
        }catch (ValidationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/cart/placeOrder")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody PlaceOrderDto placeOrderDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cartService.placeOrder(placeOrderDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/myOrders/{userId}")
    public ResponseEntity<List<OrderDto>> getMyPlaceOrders(@PathVariable Long userId){
        return ResponseEntity.ok(cartService.getMyPlaceOrders(userId));
    }
}
