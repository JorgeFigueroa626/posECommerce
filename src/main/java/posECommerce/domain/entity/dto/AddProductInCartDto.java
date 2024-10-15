package posECommerce.domain.entity.dto;

import lombok.Data;

@Data
public class AddProductInCartDto {

    private Long userId;

    private Long productId;
}
