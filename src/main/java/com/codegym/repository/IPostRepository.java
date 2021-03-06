package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends PagingAndSortingRepository<Post,Long> {
    Iterable<Post> getPostsByCategory(Category category);
}
