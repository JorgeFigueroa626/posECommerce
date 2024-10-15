package posECommerce.service.admin;

import posECommerce.domain.entity.dto.OrderDto;

import java.util.List;

public interface IOrderService {

    List<OrderDto> getAllPlaceOrders();

    OrderDto changeOrderStatus(Long orderId, String status);
}
