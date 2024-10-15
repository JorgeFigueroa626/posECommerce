package posECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import posECommerce.domain.entity.dto.OrderedProductsResponseDto;
import posECommerce.service.customer.IReviewService;

@RestController
@RequestMapping("/api/customer")
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    @GetMapping("/ordered-products/{orderId}")
    public ResponseEntity<OrderedProductsResponseDto> getOrderedProductsDetailsByOrderId(@PathVariable Long orderId){
        return ResponseEntity.ok(reviewService.getOrderedProductsDetailsByOrderId(orderId));
    }
}
