package posECommerce.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posECommerce.domain.entity.dto.OrderedProductsResponseDto;
import posECommerce.domain.entity.dto.ProductDto;
import posECommerce.domain.entity.request.CartItems;
import posECommerce.domain.entity.request.Order;
import posECommerce.repository.IOrderRepository;
import posECommerce.service.customer.IReviewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements IReviewService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        OrderedProductsResponseDto orderedProductsResponseDto = new OrderedProductsResponseDto();
        if (optionalOrder.isPresent()) {
            orderedProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());

            List<ProductDto> productDtoList = new ArrayList<>();
            for (CartItems cartItems : optionalOrder.get().getCartItems()){
                ProductDto productDto = new ProductDto();

                productDto.setId(cartItems.getProduct().getId());
                productDto.setName(cartItems.getProduct().getName());
                productDto.setPrice(cartItems.getPrice());
                productDto.setQuantity(cartItems.getQuantity());

                productDto.setByteImg(cartItems.getProduct().getImg());
                productDtoList.add(productDto);
            }
            orderedProductsResponseDto.setProductDtoList(productDtoList);
        }
        return orderedProductsResponseDto;
    }
}
