package com.example.bth01.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "baiviet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bviet")
    private Long postId;

    @Column(name = "tieude")
    private String title;

    @Column(name="ten_bhat")
    private String name;
    @ManyToOne
    @JoinColumn(name = "ma_tloai")
    private Genre genre;

    @Column(name = "tomtat" , columnDefinition = "text")
    private String summary;

    @ManyToOne
    @JoinColumn(name = "ma_tgia")
    private Author author;

    @Column(name = "ngayviet")
    private Date postDate;

}
