package com.kolesnic;


import com.kolesnic.entity.Cinemas;
import com.kolesnic.entity.Movies;
import com.kolesnic.entity.Schedule;
import com.kolesnic.service.CinemasService;
import com.kolesnic.service.MoviesService;
import com.kolesnic.service.ScheduleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class AppMain {

    public static void main(String[] args) throws SQLException, IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MoviesService moviesService = applicationContext.getBean("moviesService", MoviesService.class);
//        ScheduleService scheduleService = applicationContext.getBean("scheduleService", ScheduleService.class);
//        CinemasService cinemasService = applicationContext.getBean("cinemasService", CinemasService.class);
        moviesService.setTableMovies();
//        scheduleService.setTableSchedule();
//        cinemasService.setTableCinemas();
        List<Movies> movies = moviesService.getMoviesRepository().getMovies();
        for (Movies movie : movies) {
            System.out.println(movie.getName());
        }
// List<Cinemas> cinemas = cinemasService.getCinemasRepository().findAllWithDetail();
//
//        for (Cinemas cinema : cinemas) {
//            System.out.println(cinema);
//            if (cinema.getSchedules() != null) {
//                for (Schedule schedule:
//                        cinema.getSchedules()) {
//                    System.out.println(schedule);
//                }
//            }

//            System.out.println();


//        System.out.println("Name of movie huhuuhuh :  " + scheduleService.getScheduleRepository().getAllSchedule().get(0).getDate().getTime());
//        System.out.println("Name of movie:  " + moviesService.getMoviesRepository().getMovies().get(0).getName());
//        HibernateUtils.getSessionFactory().close();
    }
}

