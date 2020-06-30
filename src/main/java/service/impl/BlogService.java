package service.impl;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BlogRepo;
import service.FullService;

import java.util.List;

public class BlogService implements FullService<Blog> {
    @Autowired
    private BlogRepo blogRepo;
    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepo.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepo.findOne(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepo.delete(id);
    }
}
