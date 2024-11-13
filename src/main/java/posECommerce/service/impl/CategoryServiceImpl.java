package posECommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posECommerce.domain.entity.dto.CategoryDto;
import posECommerce.domain.entity.request.Category;
import posECommerce.repository.ICategoryRepository;
import posECommerce.service.ICategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescriptions(categoryDto.getDescriptions());

        return  categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getByCategoryId(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public Category updateByCategoryId(Long categoryId, Category category) {
        Category update = categoryRepository.findById(categoryId).get();
        if (update != null) {
            update.setId(category.getId());
            update.setName(category.getName());
            update.setDescriptions(category.getDescriptions());

            return categoryRepository.save(update);
        }else {
            return null;
        }

    }

    @Override
    public void deleteByCategoryId(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
