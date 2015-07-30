package com.kolesnic.controller;

/**
 * Created by Администратор on 27.07.15.
 */
import com.kolesnic.service.CinemasService;
import com.kolesnic.service.MoviesService;
import com.kolesnic.service.ScheduleService;
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

    @Autowired
    private MoviesService moviesService;

    @Autowired
    private  CinemasService cinemasService;

    @Autowired
    private ScheduleService scheduleService;




    @RequestMapping(value = "/movies")
    public String toMovies( Model model) throws SQLException {
      moviesService.setTableMovies();
        model.addAttribute("moviesList", moviesService.getMoviesRepository().getMovies());
    return "hello";
    }

    @RequestMapping(value = "/cinemas")
    public String toCinemas( Model model) throws SQLException {

        cinemasService.setTableCinemas();
        model.addAttribute("cinemasList", cinemasService.getCinemasRepository().getAllCinemas());
        return "cinemas";
    }
    @RequestMapping(value = "/schedule")
    public String toSchedule( Model model) throws SQLException {

        scheduleService.setTableSchedule();
        model.addAttribute("scheduleList", scheduleService.getScheduleRepository().getAllSchedule());
        return "schedule";
    }

}
