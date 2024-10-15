package posECommerce.domain.entity.request;

import jakarta.persistence.*;
import lombok.Data;
import posECommerce.domain.entity.dto.OrderDto;
import posECommerce.domain.enums.OrderStatus;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDescription;

    private Date date;

    private Long amount;

    private String address;

    private String payment;

    private OrderStatus orderStatus;

    private  Long totalAmount;

    private Long discount;

    private UUID trackingId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    private Coupon coupon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<CartItems> cartItems;


    public OrderDto getOrderDto(){
        OrderDto orderDto = new OrderDto();

        orderDto.setId(id);
        orderDto.setOrderDescription(orderDescription);
        orderDto.setAddress(getAddress());
        orderDto.setTrackingId(getTrackingId());
        orderDto.setAmount(getAmount());
        orderDto.setDate(date);
        orderDto.setOrderStatus(orderStatus);
        orderDto.setUserName(user.getName());
        if (coupon != null) {
            orderDto.setCouponName(coupon.getName());
        }
        return  orderDto;
    }

}