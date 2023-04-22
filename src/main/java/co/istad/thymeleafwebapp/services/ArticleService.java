package co.istad.thymeleafwebapp.services;

import co.istad.thymeleafwebapp.models.Article;
import co.istad.thymeleafwebapp.models.Author;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    // find all article
    // POJO
    List<Article> findAll();

    List<Author> auths();
    Article singleArticle(String uuid);

    boolean save(Article article, MultipartFile file);

    List<Article> getArticleByAuthor(Author author);

    void deleteArticle(String uuid);

    Integer getIndex(Article article);

    Article updateArticle(String uuid, Article article, MultipartFile file);

}
