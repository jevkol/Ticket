package com.kolesnic.service;

import com.kolesnic.dao.MoviesDao;
import com.kolesnic.entity.Movies;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.kolesnic.HibernateUtils;

/**
 * Created by Администратор on 15.07.15.
 */
public class MoviesService {
    static MoviesDao dao = new MoviesDao();

    public static List<Movies> generateMovies() {
        List<Movies> movieList = new ArrayList<Movies>();
        Movies movies1 = new Movies();

        movies1.setName("Godzila");
        movies1.setDescription("Grrrrr");
        movieList.add(movies1);

        Movies movies2 = new Movies();
        movies2.setName("Godzila2");
        movies2.setDescription("Grrrrrr2");
        movieList.add(movies2);

        Movies movies3 = new Movies();
        movies3.setName("Godzzzzzila3");
        movies3.setDescription("Vsex sogral grrrrrrr");
        movieList.add(movies3);

        return movieList;
    }

    public static void main(String[] args) throws SQLException, IOException {
        List<Movies> moviesList =  generateMovies();
        for (Movies movies : moviesList) {
            movies.setId(dao.addMovies(movies));
        }
        HibernateUtils.getSessionFactory().close();
    }
}
