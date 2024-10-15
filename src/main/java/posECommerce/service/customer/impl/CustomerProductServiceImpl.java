package posECommerce.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posECommerce.domain.entity.dto.ProductDto;
import posECommerce.domain.entity.request.Product;
import posECommerce.repository.IProductRepository;
import posECommerce.service.customer.ICustomerProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerProductServiceImpl implements ICustomerProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllProductsByTitle(String name) {
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
}
