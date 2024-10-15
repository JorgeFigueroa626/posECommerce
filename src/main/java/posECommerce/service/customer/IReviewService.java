package posECommerce.service.customer;

import posECommerce.domain.entity.dto.OrderedProductsResponseDto;

public interface IReviewService {

    public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);
}
