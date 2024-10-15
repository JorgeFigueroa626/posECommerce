package posECommerce.service.admin;

import posECommerce.domain.entity.dto.CategoryDto;
import posECommerce.domain.entity.request.Category;

import java.util.List;

public interface ICategoryService {

    public Category createCategory(CategoryDto categoryDto);

    public List<Category> findAllCategory();

}
