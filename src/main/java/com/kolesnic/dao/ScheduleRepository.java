package com.kolesnic.dao;

import com.kolesnic.entity.Schedule;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Администратор on 29.07.15.
 */
public interface ScheduleRepository {
    Collection getCinemasByMovieId(Long id) throws SQLException;
    List<Schedule> getSessionsStart(Long movieId, Long cinemaId);

    Long addSchedule(Schedule schedule) throws SQLException;
    void updateSchedule(Schedule schedule) throws SQLException;
    Schedule getScheduleById(Long id) throws SQLException;
    List<Schedule> getAllSchedule() throws SQLException;
    void deleteSchedule(Schedule schedule) throws SQLException;
    List<Schedule> generateSchedule();
}
