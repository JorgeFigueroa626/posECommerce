package posECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posECommerce.domain.entity.request.Product;
import posECommerce.domain.entity.request.Review;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Long> {

    public List<Review> findAllByProductId(Long productId);
}
