package com.codegym.service.post;

import com.codegym.model.Category;
import com.codegym.model.Post;
import com.codegym.service.IGeneralService;

public interface IPostService extends IGeneralService<Post> {
    String getCurrentDateTime();

    Iterable<Post> getPostsByCategory(Category category);
}
