package posECommerce.service.admin;

import posECommerce.domain.entity.request.Coupon;

import java.util.List;

public interface ICouponService {

    public Coupon createCoupon(Coupon coupon);

    List<Coupon> findAllCoupon();
}
