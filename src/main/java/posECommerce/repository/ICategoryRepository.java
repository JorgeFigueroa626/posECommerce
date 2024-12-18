package posECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posECommerce.domain.entity.request.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
