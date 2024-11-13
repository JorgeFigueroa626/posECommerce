package posECommerce.service;

import posECommerce.domain.entity.dto.CategoryDto;
import posECommerce.domain.entity.request.Category;

import java.util.List;

public interface ICategoryService {

    public Category createCategory(CategoryDto categoryDto);

    public List<Category> findAllCategory();

    public Category getByCategoryId(Long categoryId);

    public Category updateByCategoryId(Long categoryId, Category category);

    public void deleteByCategoryId(Long categoryId);

}
