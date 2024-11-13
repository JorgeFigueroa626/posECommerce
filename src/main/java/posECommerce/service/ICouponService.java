package posECommerce.service;

import posECommerce.domain.entity.request.Coupon;

import java.util.List;

public interface ICouponService {

    public Coupon createCoupon(Coupon coupon);

    List<Coupon> findAllCoupon();

    public Coupon getByCouponId(Long couponId);

    public Coupon updateByCouponId(Long couponId, Coupon coupon);

    public void deleteByCouponId(Long couponId);
}
