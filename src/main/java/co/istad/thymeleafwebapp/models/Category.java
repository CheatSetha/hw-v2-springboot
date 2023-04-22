package co.istad.thymeleafwebapp.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Category {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    private List<Article> articles;
}
