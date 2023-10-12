package vn.techmaster.blogapp.service;

import org.springframework.stereotype.Service;
import vn.techmaster.blogapp.entity.Category;
import vn.techmaster.blogapp.exception.BadRequestException;
import vn.techmaster.blogapp.exception.DuplicateException;
import vn.techmaster.blogapp.exception.NotFoundException;
import vn.techmaster.blogapp.model.dto.CategoryDto;
import vn.techmaster.blogapp.model.request.UpsertTopicRequest;
import vn.techmaster.blogapp.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category createCategory(UpsertTopicRequest request) {
        List<CategoryDto> categories = categoryRepository.getAllCategoryDtoNQ();
        for(CategoryDto ctg : categories) {
            if(ctg.getName().equals(request.getName())) {
                throw new BadRequestException("Duplicate value name in category list");
            }
        }
        Category category = new Category();
        category.setName(request.getName());
        return categoryRepository.save(category);
    }

    public Category updateCategory(Integer id,UpsertTopicRequest request) {
        List<CategoryDto> categories = categoryRepository.getAllCategoryDtoNQ();
        for(CategoryDto ctg : categories) {
            if(ctg.getName().equals(request.getName())) {
                throw new BadRequestException("Duplicate value name in category list");
            }
        }
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found category with id = " + id));

        category.setName(request.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found category with id = " + id));
        categoryRepository.delete(category);
    }
}
