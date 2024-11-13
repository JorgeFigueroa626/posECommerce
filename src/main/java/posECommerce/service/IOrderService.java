package posECommerce.service;

import posECommerce.domain.entity.dto.AnalyticsResponse;
import posECommerce.domain.entity.dto.OrderDto;

import java.util.List;

public interface IOrderService {

    List<OrderDto> getAllPlaceOrders();

    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculationAnalytics();

}
