package posECommerce.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posECommerce.domain.entity.dto.FaqDto;
import posECommerce.domain.entity.request.FAQ;
import posECommerce.domain.entity.request.Product;
import posECommerce.repository.IFaqRepository;
import posECommerce.repository.IProductRepository;
import posECommerce.service.admin.IFaqService;

import java.util.Optional;

@Service
public class FaqServiceImpl implements IFaqService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IFaqRepository faqRepository;

    public FaqDto createFAQ(Long productId, FaqDto faqDto){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            FAQ faq = new FAQ();

            faq.setQuestion(faqDto.getQuestion());
            faq.setAnswer(faqDto.getAnswer());
            faq.setProduct(optionalProduct.get());

            return faqRepository.save(faq).getFaqDto();
        }
        return null;
    }
}
