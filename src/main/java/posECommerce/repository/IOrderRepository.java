package posECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posECommerce.domain.entity.request.Order;
import posECommerce.domain.enums.OrderStatus;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    public Order findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);

    List<Order> findAllByOrderStatusIn(List<OrderStatus> orderStatusList);

    List<Order> findByUserIdAndOrderStatusIn(Long userId, List<OrderStatus> orderStatusList);
}
