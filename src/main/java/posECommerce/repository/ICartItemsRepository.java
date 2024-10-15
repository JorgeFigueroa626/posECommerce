package posECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posECommerce.domain.entity.request.CartItems;

import java.util.Optional;

@Repository
public interface ICartItemsRepository extends JpaRepository<CartItems, Long> {

    Optional<CartItems> findByProductIdAndOrderIdAndUserId(Long productId, Long orderId, Long userId);

}
