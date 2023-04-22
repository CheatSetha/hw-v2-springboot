package co.istad.thymeleafwebapp.controller;

import co.istad.thymeleafwebapp.models.Article;
import co.istad.thymeleafwebapp.models.Category;
import co.istad.thymeleafwebapp.services.ArticleService;
import co.istad.thymeleafwebapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    @GetMapping("/")
    String homePage(Model model){
        List<Article> articles = articleService.findAll();
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("articles", articles);
        model.addAttribute("categories", categories);
        return "index";
    }
}
