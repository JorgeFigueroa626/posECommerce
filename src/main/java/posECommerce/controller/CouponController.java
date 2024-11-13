package posECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posECommerce.domain.entity.request.Coupon;
import posECommerce.service.ICouponService;

import java.util.List;

@RestController
@RequestMapping("/api/coupon")
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

    @GetMapping("/{couponId}")
    public ResponseEntity<Coupon> getByCouponId(@PathVariable Long couponId){
        try {
            return ResponseEntity.ok(couponService.getByCouponId(couponId));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{couponId}")
    public ResponseEntity<Coupon> update(@PathVariable Long couponId, @RequestBody Coupon coupon){
        try {
            Coupon coupon1 = couponService.getByCouponId(couponId);
            if (coupon1 == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            return ResponseEntity.ok(couponService.updateByCouponId(couponId,coupon));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{couponId}")
    public ResponseEntity<Coupon> delete(@PathVariable Long couponId){
        couponService.deleteByCouponId(couponId);
        return ResponseEntity.noContent().build();
    }
}
