package com.prashant.movie.service;

import com.prashant.movie.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie addMovie(Movie movie);

    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    Movie updateMovie(Long id, Movie movie);

    void deleteMovie(Long id);
}