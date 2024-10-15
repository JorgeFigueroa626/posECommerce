package posECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posECommerce.domain.entity.request.Coupon;
import posECommerce.service.admin.ICouponService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/coupons")
public class CouponController {

    @Autowired
    private ICouponService couponService;

    @PostMapping
    public ResponseEntity<?> createCoupon(@RequestBody Coupon coupon){
        try {
            Coupon createCoupon = couponService.createCoupon(coupon);
            return ResponseEntity.ok(createCoupon);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> findAllCoupons(){
        return ResponseEntity.ok(couponService.findAllCoupon());
    }
}
