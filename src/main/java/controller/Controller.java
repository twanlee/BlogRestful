package controller;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.impl.BlogService;
import service.impl.CategoryService;

@CrossOrigin(origins = {"*"})
@RestController
public class Controller {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
//    @RequestMapping(value = "/create-blog", method = RequestMethod.POST)
//    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
//        blogService.save(blog);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(blog.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
    @RequestMapping(value = "/create-cate" , method = RequestMethod.POST)
    public ResponseEntity<Void> createCate(@RequestBody Category category, UriComponentsBuilder builder){
        System.out.println("creating Category" + category.getName());
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/{id}").buildAndExpand(category.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @GetMapping("/list-blog")
    public ResponseEntity<Iterable<Blog>> getAll(){
        Iterable<Blog>  blogs = blogService.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping("/create-blog")
    public ResponseEntity<Blog> create(@ModelAttribute Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete-blog/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        blogService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
