package co.istad.thymeleafwebapp.services;

import co.istad.thymeleafwebapp.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();

    Author getAuthorById(Integer id);
}
