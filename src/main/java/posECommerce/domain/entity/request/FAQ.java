package posECommerce.domain.entity.request;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import posECommerce.domain.entity.dto.FaqDto;

@Entity
@Data
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    public FaqDto getFaqDto(){
        FaqDto faqDto = new FaqDto();
        faqDto.setId(id);
        faqDto.setQuestion(question);
        faqDto.setAnswer(answer);
        faqDto.setProductId(product.getId());
        return faqDto;
    }
}
