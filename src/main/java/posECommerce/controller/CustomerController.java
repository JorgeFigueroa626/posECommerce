package posECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import posECommerce.domain.entity.dto.ProductDto;
import posECommerce.service.customer.ICustomerProductService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerProductService customerProductService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos = customerProductService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductByName(@PathVariable String name){
        List<ProductDto> productDtos = customerProductService.getAllProductsByTitle(name);
         return ResponseEntity.ok(productDtos);
    }

}
