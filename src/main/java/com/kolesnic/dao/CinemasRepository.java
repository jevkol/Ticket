package com.kolesnic.dao;

import com.kolesnic.entity.Cinemas;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Администратор on 28.07.15.
 */
public interface CinemasRepository {
    Long addCinemas(Cinemas cinema) throws SQLException;
    void updateCinemas(Cinemas cinema) throws SQLException;
    Cinemas getCinemasById(Long id) throws SQLException;
    List<Cinemas> getAllCinemas() throws SQLException;
    void deleteCinemas(Cinemas cinema) throws SQLException;
    List<Cinemas> generateCinemas();
    List<Cinemas> findAllWithDetail();
}
