package co.istad.thymeleafwebapp.services.impl;

import co.istad.thymeleafwebapp.models.Author;
import co.istad.thymeleafwebapp.repositories.StaticRepository;
import co.istad.thymeleafwebapp.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final StaticRepository staticRepository;
    @Override
    public List<Author> getAuthors() {
        return staticRepository.getAuthors();
    }

    @Override
    public Author getAuthorById(Integer id) {
        return staticRepository.getAuthors().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
