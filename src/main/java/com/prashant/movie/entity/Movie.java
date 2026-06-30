package com.prashant.movie.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String genre;

    private String language;

    private Integer duration; // minutes

    private String releaseDate;

    @Column(length = 1000)
    private String description;

    private String posterUrl;

    private Double rating;

    @Builder.Default
    private Boolean active = true;
}