package posECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posECommerce.domain.entity.dto.FaqDto;
import posECommerce.domain.entity.dto.ProductDto;
import posECommerce.service.admin.IFaqService;
import posECommerce.service.admin.IProductService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IFaqService faqService;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException {
        ProductDto productDto1 = productService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos = productService.findAllProduct();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/product/name/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductByName(@PathVariable String name){
        List<ProductDto> productDtos = productService.findAllProductByName(name);
        return ResponseEntity.ok(productDtos);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteByProductId(@PathVariable Long id){
           boolean deleted = productService.deleteByProductId(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/faq/{productId}")
    public ResponseEntity<FaqDto> createFaq(@PathVariable Long productId, @RequestBody FaqDto faqDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(faqService.createFAQ(productId, faqDto));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDto> getByProductId(@PathVariable Long productId){
        ProductDto productDto = productService.getByProductById(productId);
        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId, @ModelAttribute ProductDto productDto)throws IOException{
        ProductDto updateProduct = productService.updateProduct(productId, productDto);
        if (updateProduct  != null) {
            return ResponseEntity.ok(updateProduct);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
