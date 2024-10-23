package posECommerce.domain.entity.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;
import posECommerce.domain.entity.request.Product;
import posECommerce.domain.entity.request.User;

@Data
public class ReviewDto {

    private Long id;

    private Long rating;

    private String description;

    private MultipartFile img;

    private byte[] returnedImg;

    private Long userId;

    private Long productId;

    private String username;
}
