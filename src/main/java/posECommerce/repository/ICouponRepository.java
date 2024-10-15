package posECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posECommerce.domain.entity.request.Coupon;

import java.util.Optional;

@Repository
public interface ICouponRepository extends JpaRepository<Coupon, Long> {

    boolean existsByCode(String code);

    Optional<Coupon> findByCode(String code);
}
