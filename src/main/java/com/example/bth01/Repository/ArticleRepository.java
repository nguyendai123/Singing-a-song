package com.example.bth01.Repository;

import com.example.bth01.Model.Article;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a JOIN a.genre g WHERE g.name = 'Nhạc trữ tình'")
    List<Article> findArticlesByGenre();

    @Query("SELECT a FROM Article a JOIN a.author a1 WHERE a1.name = 'Nhacvietplus'")
    List<Article> findArticlesByAuthor();



    @Query("SELECT a FROM Article a WHERE a.name LIKE %:keyword1% OR a.name LIKE %:keyword2% OR a.name LIKE %:keyword3% OR a.name LIKE %:keyword4%")
    List<Article> findArticlesBySongTitleContainingKeywords(@Param("keyword1") String keyword1, @Param("keyword2") String keyword2, @Param("keyword3") String keyword3, @Param("keyword4") String keyword4);

    @Query("SELECT a FROM Article a WHERE a.title LIKE %:keyword1% OR a.name LIKE %:keyword1% OR a.title LIKE %:keyword2% OR a.name LIKE %:keyword2% OR a.title LIKE %:keyword3% OR a.name LIKE %:keyword3% OR a.title LIKE %:keyword4% OR a.name LIKE %:keyword4%")
    List<Article> findArticlesByTitleOrSongTitleContainingKeywords(@Param("keyword1") String keyword1, @Param("keyword2") String keyword2, @Param("keyword3") String keyword3, @Param("keyword4") String keyword4);
}
