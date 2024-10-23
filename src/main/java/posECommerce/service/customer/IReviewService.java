package posECommerce.service.customer;

import posECommerce.domain.entity.dto.OrderedProductsResponseDto;
import posECommerce.domain.entity.dto.ReviewDto;

import java.io.IOException;

public interface IReviewService {

    public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

    public ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}
