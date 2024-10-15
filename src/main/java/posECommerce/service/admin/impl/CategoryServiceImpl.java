package posECommerce.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posECommerce.domain.entity.dto.CategoryDto;
import posECommerce.domain.entity.request.Category;
import posECommerce.repository.ICategoryRepository;
import posECommerce.service.admin.ICategoryService;

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
}
