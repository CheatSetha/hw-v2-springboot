package co.istad.thymeleafwebapp.controller;

import co.istad.thymeleafwebapp.models.Article;
import co.istad.thymeleafwebapp.models.Author;
import co.istad.thymeleafwebapp.services.ArticleService;
import co.istad.thymeleafwebapp.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final ArticleService articleService;

    @GetMapping
    String authors(Model model){
        model.addAttribute("authors",authorService.getAuthors());
        return "authors/authors";
    }

    @GetMapping("/{id}")
    String authorProfile(@PathVariable Integer id,Model model){
        Author author = authorService.getAuthorById(id);
        List<Article> articles = articleService.getArticleByAuthor(author);
        author.setArticles(articles);
        model.addAttribute("author",author);
        return "authors/author-profile";
    }



}
