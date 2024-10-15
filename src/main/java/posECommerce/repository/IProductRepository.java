package posECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posECommerce.domain.entity.request.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByNameContaining(String title);
}
