package co.istad.thymeleafwebapp.repositories;

import co.istad.thymeleafwebapp.models.Article;
import co.istad.thymeleafwebapp.models.Author;
import co.istad.thymeleafwebapp.models.Category;
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
                1, "Cheat Setha",
                "寂しい男", "male",
                "setha@gmail.com",
                faker.address().fullAddress() + ", " + faker.country().name(),
                "https://api.duniagames.co.id/api/content/upload/file/15291419751619402938.jpg",
                "/resources/img/default/1.jpg"
        );


        List<String> gender = new ArrayList<>(List.of("male", "Female"));
        List<String> avatars = new ArrayList<>(List.of(
                "https://thicc.mywaifulist.moe/waifus/18952/02937b2553cbd8d6975618a564fc97dcf34d57e5b164a13c3d597cbd3bdcce2d_thumb.jpg",
                "https://c4.wallpaperflare.com/wallpaper/560/855/635/spy-x-family-anya-forger-hd-wallpaper-preview.jpg",
                "https://preview.redd.it/nugh7xj043o21.png?auto=webp&s=b4c883e131cf72089cf6fe3818a06f963ede6887",
                "https://pbs.twimg.com/media/FoHXg5caUAEFrUq?format=jpg&name=large",
               " https://pbs.twimg.com/media/EuABFpuVcAEZmIt.jpg",
                "https://img.cdn-pictorem.com/uploads/collection/E/EF5MND10RMF/900_Coolbits-Art_monkey13.jpg",
                "https://varnam.my/wp-content/uploads/2021/01/FB_IMG_1605666747087-2.jpg.webp",
                "https://fashionista.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTk2ODk2NjgzODEwODkxMDEx/rose-blackpink-sulwhasoo-promo.jpg",
                "https://w0.peakpx.com/wallpaper/45/495/HD-wallpaper-tzuyu-twice.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTQ5MzkzNTIyN15BMl5BanBnXkFtZTYwNzUzOTA2._V1_FMjpg_UX1000_.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Dwayne_Johnson_2014_%28cropped%29.jpg/640px-Dwayne_Johnson_2014_%28cropped%29.jpg"






        ));
        List<String> coverImages = new ArrayList<>(List.of(
                "/resources/img/default/1.jpg",
                "/resources/img/default/2.jpg",
                "/resources/img/default/3.webp",
                "/resources/img/default/4.jpg",
                "/resources/img/default/5.webp",
                "/resources/img/default/6.jpeg",
                "/resources/img/default/7.jpeg",
                "/resources/img/default/8.jpeg",
                "/resources/img/default/9.webp",
                "/resources/img/default/10.webp",
                "/resources/img/default/11.jpeg",
                "/resources/img/default/12.jpeg"

        ));
        List<String > thumnailImages = new ArrayList<>(List.of(
                "https://www.bleepstatic.com/content/hl-images/2021/12/28/hacker.jpg",
                "https://cdn.britannica.com/24/151224-050-E79BBF39/side-Earth-Moon-spacecraft-way-Jupiter-Galileo.jpg",
                "https://i.shgcdn.com/75f78936-484c-4642-ada7-3b0a602d23e0/-/format/auto/-/preview/3000x3000/-/quality/lighter/",
                "https://files.intocambodia.com/public/2022-07/khmer_lady_dressed_in_av_pak_during_khmer_new_year.jpg",
                "https://i0.wp.com/theluxurytravelexpert.com/wp-content/uploads/2020/05/visit-angkor-wat-cambodia.jpg?fit=1280%2C720&ssl=1",
                "https://img.theculturetrip.com/450x/smart/wp-content/uploads/2017/09/shutterstock_106075160.jpg",
                "https://images.pexels.com/photos/210243/pexels-photo-210243.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                "https://images.pexels.com/photos/1024993/pexels-photo-1024993.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                "https://images.pexels.com/photos/3775331/pexels-photo-3775331.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                "https://images.pexels.com/photos/1933318/pexels-photo-1933318.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                "https://images.pexels.com/photos/2695391/pexels-photo-2695391.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"







        ));

        authors = new ArrayList<>() {{
            add(author);
            //start from 2 bcuz 1 is already added as setha cheat
            for (int i = 2; i <11; i++) {
                add(new Author(
                        i,
                        faker.book().author(),
                        faker.name().username(), gender.get(random.nextInt(2)),
                        faker.internet().safeEmailAddress(),
                        faker.address().fullAddress() + ", " + faker.country().name(),
                        //avatars.get(random.nextInt(0, avatars.size())),
                        avatars.get(i),
                        coverImages.get(i)
                       // coverImages.get(random.nextInt(0, coverImages.size())

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

            for (int i = 0; i < 11; i++) {

                add(
                        new Article(
                                UUID.randomUUID(),
                                faker.book().title(),
//                                "/resources/img/default/" + (i%2==0 ? "1":2) + ".jpg",

                                thumnailImages.get(i),
                                authors.get(random.nextInt(authors.size())),

//                                10 sentences
                                faker.lorem().paragraph(10),
                                categories.stream().filter(cat -> cat.getId().equals(random.nextInt(categories.size())))
                                        .collect(Collectors.toList())
                        )
                );
            }
        }};

    }
}
