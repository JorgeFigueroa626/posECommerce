package posECommerce.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posECommerce.domain.entity.dto.OrderDto;
import posECommerce.domain.entity.request.Order;
import posECommerce.domain.enums.OrderStatus;
import posECommerce.repository.IOrderRepository;
import posECommerce.service.admin.IOrderService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    public List<OrderDto> getAllPlaceOrders(){
        List<Order> orderList = orderRepository.findAllByOrderStatusIn(List.of(OrderStatus.PLACED, OrderStatus.SHIPPED, OrderStatus.DELIVERED, OrderStatus.PENDING));
        return  orderList.stream().map(Order::getOrderDto).collect(Collectors.toList());
    }

    public OrderDto changeOrderStatus(Long orderId, String status){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();

            if (Objects.equals(status, "SHIPPED")) {
                order.setOrderStatus(OrderStatus.SHIPPED);
            } else if (Objects.equals(status, "DELIVERED")) {
                order.setOrderStatus(OrderStatus.DELIVERED);
            }else if (Objects.equals(status, "PLACED")) {
                order.setOrderStatus(OrderStatus.PLACED);
            }else if (Objects.equals(status, "PENDING")) {
                order.setOrderStatus(OrderStatus.PENDING);
            }
            return orderRepository.save(order).getOrderDto();
        }
        return null;
    }
}
