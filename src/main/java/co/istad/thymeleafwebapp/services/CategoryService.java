package co.istad.thymeleafwebapp.services;

import co.istad.thymeleafwebapp.models.Category;
import co.istad.thymeleafwebapp.models.CategoryArticles;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    CategoryArticles getCategoryById(Integer id);
}
