package com.example.bth01.Repository;

import com.example.bth01.Model.Author;
import com.example.bth01.Model.Genre;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.authorId IN (SELECT ar.author.authorId FROM Article ar GROUP BY ar.author.authorId ORDER BY COUNT(ar.postId) DESC) ORDER BY a.name ASC")
    List<Author> find2MaxAuthor();
}
