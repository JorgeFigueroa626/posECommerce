package posECommerce.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import posECommerce.domain.entity.dto.ProductDto;
import posECommerce.repository.IProductRepository;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    public ProductDto addProduct(ProductDto productDto) throws IOException;

    public List<ProductDto> findAllProduct();

    public List<ProductDto> findAllProductByName(String name);

    public boolean deleteByProductId(Long id);

    public ProductDto getByProductById(Long productId);

    public ProductDto updateProduct(Long productId, ProductDto productDto) throws IOException;

}
