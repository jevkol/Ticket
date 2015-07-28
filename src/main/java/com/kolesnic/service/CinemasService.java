package com.kolesnic.service;

import com.kolesnic.dao.CinemasRepository;
import com.kolesnic.dao.MoviesRepository;

import java.sql.SQLException;

/**
 * Created by Администратор on 28.07.15.
 */
public interface CinemasService {
    CinemasRepository getCinemasRepository();
    void setCinemasRepository(CinemasRepository cinemasRepository);
    void setTableCinemas() throws SQLException;
}
