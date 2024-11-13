package posECommerce.service;

import posECommerce.domain.entity.dto.ProductDetailDto;
import posECommerce.domain.entity.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    public ProductDto addProduct(ProductDto productDto) throws IOException;

    public List<ProductDto> findAllProduct();

    public List<ProductDto> findAllProductByName(String name);

    /*
    public List<ProductDto> getAllProducts();
    public List<ProductDto> getAllProductsByTitle(String name);

     */

    public ProductDetailDto getProductDetailById(Long productId);

    public boolean deleteByProductId(Long id);

    public ProductDto getByProductById(Long productId);

    public ProductDto updateProduct(Long productId, ProductDto productDto) throws IOException;

}
