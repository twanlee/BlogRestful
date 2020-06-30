package service.impl;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CategoryRepo;
import service.FullService;

import java.util.List;

public class CategoryService implements FullService<Category> {
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findOne(id);
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepo.delete(id);
    }
}
