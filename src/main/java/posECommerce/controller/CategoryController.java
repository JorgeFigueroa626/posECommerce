package posECommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posECommerce.domain.entity.dto.CategoryDto;
import posECommerce.domain.entity.request.Category;
import posECommerce.service.admin.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
        try {
            Category category = categoryService.createCategory(categoryDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @GetMapping("/categorys")
    public ResponseEntity<List<Category>> findAllCategory(){
        return ResponseEntity.ok(categoryService.findAllCategory());
    }

}
