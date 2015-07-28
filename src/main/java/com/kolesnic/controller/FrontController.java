package com.kolesnic.controller;

/**
 * Created by Администратор on 27.07.15.
 */
import com.kolesnic.service.CinemasService;
import com.kolesnic.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.SQLException;

@Controller

public class FrontController {



    @RequestMapping(value = "/movies")
    public String toMovies( Model model) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MoviesService moviesService = applicationContext.getBean("moviesService", MoviesService.class);
        moviesService.setTableMovies();
        model.addAttribute("moviesList", moviesService.getMoviesRepository().getMovies());
    return "hello";
    }

    @RequestMapping(value = "/cinemas")
    public String toCinemas( Model model) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CinemasService cinemasService = applicationContext.getBean("cinemasService", CinemasService.class);
        cinemasService.setTableCinemas();
        model.addAttribute("cinemasList", cinemasService.getCinemasRepository().getAllCinemas());
        return "cinemas";
    }

}
