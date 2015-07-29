package com.kolesnic.service;

import com.kolesnic.dao.HibernateMoviesRepositoryImpl;
import com.kolesnic.dao.MoviesRepository;
import com.kolesnic.entity.Movies;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.kolesnic.HibernateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Администратор on 15.07.15.
 */
@Service("moviesService")
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public MoviesServiceImpl (MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public MoviesServiceImpl () {}

    public MoviesRepository getMoviesRepository() {
        return moviesRepository;
    }

    public void setMoviesRepository(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

//    public  List<Movies> generateMovies(){ return moviesRepository.generateMovies();
//    }

    public void setTableMovies() {
        List<Movies> moviesList = moviesRepository.generateMovies();
        for (Movies movies : moviesList) {
            movies.setId(moviesRepository.addMovies(movies));
        }
    }


}
