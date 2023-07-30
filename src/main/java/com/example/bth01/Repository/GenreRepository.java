package com.example.bth01.Repository;

import com.example.bth01.Model.Genre;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("SELECT g FROM Genre g WHERE g NOT IN (SELECT a.genre FROM Article a WHERE a.genre IS NOT NULL)")
    List<Genre> findGenresWithoutArticles();


}
