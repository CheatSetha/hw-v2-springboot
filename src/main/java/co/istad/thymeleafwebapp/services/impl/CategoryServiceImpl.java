package co.istad.thymeleafwebapp.services.impl;

import co.istad.thymeleafwebapp.models.Article;
import co.istad.thymeleafwebapp.models.Category;
import co.istad.thymeleafwebapp.models.CategoryArticles;
import co.istad.thymeleafwebapp.services.CategoryService;
import co.istad.thymeleafwebapp.repositories.StaticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final StaticRepository staticRepository;

    @Override
    public List<Category> getCategories() {
        return staticRepository.getCategories();
    }

    @Override
    public CategoryArticles getCategoryById(Integer id) {
        Category category = staticRepository.getCategories().stream().filter(cate -> cate.getId().equals(id))
                            .findFirst().orElse(null);
        List<Article> articles = staticRepository.getArticles().stream()
                .filter(article -> article.getCategories().contains(category))
                .toList();
        return new CategoryArticles(category,articles);
    }
}
