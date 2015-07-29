package com.kolesnic.dao;

import com.kolesnic.entity.Movies;

import java.util.List;

/**
 * Created by Администратор on 26.07.15.
 */
public interface MoviesRepository {
    Long addMovies(Movies movies);

    List<Movies> getMovies();

    void updateMovies(Movies movies);

    void deleetMovies(Movies movies);

    List<Movies> generateMovies();

}
