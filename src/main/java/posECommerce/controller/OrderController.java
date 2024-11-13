package posECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import posECommerce.domain.entity.dto.AnalyticsResponse;
import posECommerce.domain.entity.dto.OrderDto;
import posECommerce.service.IOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/placedOrders")
    public ResponseEntity<List<OrderDto>> getAllPlaceOrders(){
        return ResponseEntity.ok(orderService.getAllPlaceOrders());
    }
    
    @GetMapping("/{orderId}/{status}")
    public ResponseEntity<?> changeOrderStatus(@PathVariable Long orderId, @PathVariable String status){
        OrderDto orderDto = orderService.changeOrderStatus(orderId, status);
        if (orderDto == null)
            return  new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        return  ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    @GetMapping("/analytics")
    public ResponseEntity<AnalyticsResponse> getAnalytics(){
        return ResponseEntity.ok(orderService.calculationAnalytics());
    }
}
