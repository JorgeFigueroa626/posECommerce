package posECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posECommerce.domain.entity.request.FAQ;

@Repository
public interface IFaqRepository extends JpaRepository<FAQ, Long> {
}
