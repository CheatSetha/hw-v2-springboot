package com.begoingto.thymeleafwebapp.repositories;

import com.begoingto.thymeleafwebapp.models.Article;
import com.begoingto.thymeleafwebapp.models.Author;
import com.begoingto.thymeleafwebapp.models.Category;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Getter
public class StaticRepository {
    private List<Article> articles;
    private List<Author> authors;
    private List<Category> categories;
    private Faker faker;

    @Autowired
    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    @PostConstruct
    void init() {
        Random random = new Random();
        Author author = new Author(
                1, "setha cheat",
                "Setha", "male",
                "setha@gmail.com",
                faker.address().fullAddress() + ", " + faker.country().name(),
                "https://imgs.search.brave.com/1cvEGFdX2IJ2hKXMlD70ybgCxhfNByQoRXwZ0Afg1RQ/rs:fit:600:665:1/g:ce/aHR0cDovL2kwLmt5/bS1jZG4uY29tL3Bo/b3Rvcy9pbWFnZXMv/ZmFjZWJvb2svMDAx/LzE5My83NDYvMWIy/LnBuZw",
                "/resources/img/default/1.jpg"
        );


        List<String> gender = new ArrayList<>(List.of("male", "Female"));
        List<String> avatars = new ArrayList<>(List.of(
                "https://thicc.mywaifulist.moe/waifus/18952/02937b2553cbd8d6975618a564fc97dcf34d57e5b164a13c3d597cbd3bdcce2d_thumb.jpg",
                "https://c4.wallpaperflare.com/wallpaper/560/855/635/spy-x-family-anya-forger-hd-wallpaper-preview.jpg",
                "https://preview.redd.it/nugh7xj043o21.png?auto=webp&s=b4c883e131cf72089cf6fe3818a06f963ede6887",
                "https://pbs.twimg.com/media/FoHXg5caUAEFrUq?format=jpg&name=large"
        ));

        authors = new ArrayList<>() {{
            add(author);
            for (int i = 2; i < 8; i++) {
                add(new Author(
                        i,
                        faker.book().author(),
                        faker.name().username().toLowerCase(), gender.get(random.nextInt(2)),
                        faker.internet().safeEmailAddress(),
                        faker.address().fullAddress() + ", " + faker.country().name(),
                        avatars.get(random.nextInt(0, avatars.size())),
                        "https://images.pexels.com/photos/1327373/pexels-photo-1327373.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ));
            }
        }};

        categories = new ArrayList<>() {{
            for (int i = 1; i < 11; i++) {
//
                add(new Category(i, faker.animal().name()));
            }
        }};

        articles = new ArrayList<>() {{

            for (int i = 0; i < 12; i++) {

                add(
                        new Article(
                                UUID.randomUUID(),
                                faker.book().title(),
                                "/resources/img/default/" + (i % 2 == 0 ? "2" : "1") + ".jpg",
                                authors.get(random.nextInt(authors.size())),
                                faker.lorem().paragraphs(20).toString(),
                                categories.stream().filter(cat -> cat.getId().equals(random.nextInt(categories.size())))
                                        .collect(Collectors.toList())
                        )
                );
            }
        }};

    }
}
