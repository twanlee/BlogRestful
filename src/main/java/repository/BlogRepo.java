package repository;

import model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepo extends PagingAndSortingRepository<Blog,Long> {
}
