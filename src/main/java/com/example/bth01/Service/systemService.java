package com.example.bth01.Service;

import com.example.bth01.Model.Article;
import com.example.bth01.Model.Author;
import com.example.bth01.Model.Genre;
import com.example.bth01.Repository.ArticleRepository;
import com.example.bth01.Repository.AuthorRepository;
import com.example.bth01.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class systemService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    //article
    public List<Article> getArticlesByGenre() {
        return articleRepository.findArticlesByGenre();
    }

    public List<Article> getArticlesByAuthor() {
        return articleRepository.findArticlesByAuthor();
    }


    public List<Article> getArticlesBySongTitleContainingKeywords(){
        return articleRepository.findArticlesBySongTitleContainingKeywords("yêu", "thương", "anh", "em");
    }

    //Genre
    public  List<Genre> getGenresWithoutArticles() {
     return genreRepository.findGenresWithoutArticles();
    }

    //Author
    public List<Author> get2MaxAuthor() {
        return authorRepository.find2MaxAuthor();
    }
}
