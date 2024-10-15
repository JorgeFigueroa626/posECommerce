package posECommerce.service.customer;

import posECommerce.domain.entity.dto.ProductDto;

import java.util.List;

public interface ICustomerProductService {

    public List<ProductDto> getAllProducts();

    public List<ProductDto> getAllProductsByTitle(String name);
}
