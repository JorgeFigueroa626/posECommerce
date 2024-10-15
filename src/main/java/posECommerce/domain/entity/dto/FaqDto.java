package posECommerce.domain.entity.dto;

import lombok.Data;

@Data
public class FaqDto {

    private Long id;

    private String question;

    private String answer;

    private Long productId;
}
