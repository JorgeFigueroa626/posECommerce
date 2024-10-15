package posECommerce.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posECommerce.domain.entity.request.Coupon;
import posECommerce.exception.ValidationException;
import posECommerce.repository.ICouponRepository;
import posECommerce.service.admin.ICouponService;

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
}
