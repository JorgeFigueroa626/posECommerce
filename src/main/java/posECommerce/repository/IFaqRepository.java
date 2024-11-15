package posECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posECommerce.domain.entity.request.FAQ;
import posECommerce.domain.entity.request.Product;

import java.util.List;

@Repository
public interface IFaqRepository extends JpaRepository<FAQ, Long> {
    public List<FAQ> findAllByProductId(Long productId);
}
