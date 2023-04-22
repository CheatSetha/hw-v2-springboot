package co.istad.thymeleafwebapp.services.impl;

import co.istad.thymeleafwebapp.models.Article;
import co.istad.thymeleafwebapp.models.Author;
import co.istad.thymeleafwebapp.models.FileUpload;
import co.istad.thymeleafwebapp.services.ArticleService;
import co.istad.thymeleafwebapp.repositories.StaticRepository;
import co.istad.thymeleafwebapp.services.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final StaticRepository staticRepository;
    private final FileUploadService fileUploadService;
    @Override
    public List<Article> findAll() {
        return staticRepository.getArticles();
    }

    @Override
    public List<Author> auths() {
        return staticRepository.getAuthors();
    }

    @Override
    public Article singleArticle(String uuid){
        Article article = getArticle(uuid);
        return article;
    }

    private Article getArticle(String uuid) {
        return staticRepository.getArticles().stream()
                .filter(a -> a.getUuid().toString().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean save(Article article, MultipartFile file) {
        FileUpload fileUpload = getFileUpload(file);
        if (getFileUpload(file).isSuccess()){
            article.setUuid(UUID.randomUUID());
            article.setThumbnail("/files/" + fileUpload.fileName());
            if (staticRepository.getArticles().size()==0){
                staticRepository.getArticles().add(article);
            }else {
                staticRepository.getArticles().add(0,article);
            }
            System.out.println("Article create successful");
        }
        return true;
    }

    private FileUpload getFileUpload(MultipartFile file) {
        return fileUploadService.uploadSingle(file);
    }

    @Override
    public List<Article> getArticleByAuthor(Author author) {
        return staticRepository.getArticles().stream()
                .filter(article -> article.getAuthor().equals(author))
                .toList();
    }

    @Override
    public void deleteArticle(String uuid) {
        Article article_id = this.getArticle(uuid);
        staticRepository.getArticles().remove(article_id);


    }

    @Override
    public Integer getIndex(Article article) {
        return staticRepository.getArticles().indexOf(article);
    }

    @Override
    public Article updateArticle(String uuid, Article reqArticle, MultipartFile file) {
        Article oldArticle = this.getArticle(uuid);
        int index = this.getIndex(oldArticle);
        if (!file.getOriginalFilename().isEmpty()){
            FileUpload fileUpload = getFileUpload(file);
            if (getFileUpload(file).isSuccess()){
                reqArticle.setThumbnail("/files/" + fileUpload.fileName());
                System.out.println("Article change successful");
            }
        }else {
            reqArticle.setThumbnail(oldArticle.getThumbnail());
        }
        staticRepository.getArticles().set(index,reqArticle);
        System.out.println("Article update successful");
        return reqArticle;
    }

}
