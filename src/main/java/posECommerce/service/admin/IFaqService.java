package posECommerce.service.admin;

import posECommerce.domain.entity.dto.FaqDto;

public interface IFaqService {

    FaqDto createFAQ(Long productId, FaqDto faqDto);
}
