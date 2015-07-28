package com.kolesnic.service;

import com.kolesnic.dao.MoviesRepository;
import com.kolesnic.entity.Movies;

import java.util.List;

/**
 * Created by Администратор on 26.07.15.
 */
public interface MoviesService {

    MoviesRepository getMoviesRepository();
    void setMoviesRepository(MoviesRepository moviesRepository);
    void setTableMovies();
}
