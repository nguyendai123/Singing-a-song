package com.example.bth01.Controller;

import com.example.bth01.Model.Article;
import com.example.bth01.Model.Author;
import com.example.bth01.Model.Genre;
import com.example.bth01.Service.systemService;
import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SystemController {
    @Autowired
    private systemService service;
    //article
    @GetMapping("/nhactrutinh")
    public List<Article> getAllArticleByGenre() {
        return service.getArticlesByGenre();
    }

    @GetMapping("/nhacvietplus")
    public List<Article> getAllArticleByAuthor() {
        return service.getArticlesByAuthor();
    }

    @GetMapping("/keyword")
    public List<Article> getArticlesBySongTitleContainingKeywords() {
        return service.getArticlesBySongTitleContainingKeywords();
    }
    //genre
    @GetMapping("/notarticle")
    public List<Genre> getGenresWithoutArticles() {
        return service.getGenresWithoutArticles();
    }

    //Author
    @GetMapping("/2max_author")
    public List<Author> get2MaxAuthor() {
        return service.get2MaxAuthor();
    }
}
