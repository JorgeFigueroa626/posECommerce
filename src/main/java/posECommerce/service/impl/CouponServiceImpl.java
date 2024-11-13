package posECommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posECommerce.domain.entity.request.Coupon;
import posECommerce.exception.ValidationException;
import posECommerce.repository.ICouponRepository;
import posECommerce.service.ICouponService;

import java.util.List;

@Service
public class CouponServiceImpl implements ICouponService {

    @Autowired
    private ICouponRepository couponRepository;

    public Coupon createCoupon(Coupon coupon){
        if (couponRepository.existsByCode(coupon.getCode())) {
            throw new ValidationException("Coupon code already exists.");
        }
        return couponRepository.save(coupon);
    }

    @Override
    public List<Coupon> findAllCoupon() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon getByCouponId(Long couponId) {
        Coupon coupon = couponRepository.findById(couponId).get();
        return coupon;
    }

    @Override
    public Coupon updateByCouponId(Long couponId, Coupon coupon) {
        Coupon updateCoupon = couponRepository.findById(couponId).get();
        if (updateCoupon != null) {
            updateCoupon.setId(coupon.getId());
            updateCoupon.setName(coupon.getName());
            updateCoupon.setCode(coupon.getCode());
            updateCoupon.setDiscount(coupon.getDiscount());
            updateCoupon.setExpirationDate(coupon.getExpirationDate());

            couponRepository.save(updateCoupon);
        }
        return null;
    }

    @Override
    public void deleteByCouponId(Long couponId) {
        couponRepository.deleteById(couponId);
    }


}
