package posECommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posECommerce.domain.entity.dto.CategoryDto;
import posECommerce.domain.entity.request.Category;
import posECommerce.service.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
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

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findAllCategory(){
        return ResponseEntity.ok(categoryService.findAllCategory());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> getByCategoryId(@PathVariable Long categoryId){
        if (categoryId != null) {
            return ResponseEntity.ok(categoryService.getByCategoryId(categoryId));
        }else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId, @RequestBody Category category){
        Category update = categoryService.updateByCategoryId(categoryId, category);
        if (update != null) {
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteByCategoryId(categoryId);
        return ResponseEntity.noContent().build();
    }

}
