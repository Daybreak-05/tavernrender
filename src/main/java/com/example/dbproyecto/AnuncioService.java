package com.example.dbproyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnuncioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Obtener todas las misiones
    public List<Mision> obtenerMisiones() {
        String sql = "SELECT * FROM misiones";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Mision(rs.getLong("id"), rs.getString("nombre"),
                        rs.getString("descripcion"), rs.getBoolean("completado")));
    }

    // Completar misión (actualiza a true)
    public void completarMision(Long id) {
        String sql = "UPDATE misiones SET completado = true WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Obtener todos los eventos
    public List<Evento> obtenerEventos() {
        String sql = "SELECT * FROM eventos";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Evento(rs.getLong("id"), rs.getString("nombre"),
                        rs.getString("descripcion"), rs.getString("fecha")));
    }

    // Insertar una nueva misión
    public void insertarMision(Mision mision) {
        String sql = "INSERT INTO misiones (nombre, descripcion, completado) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, mision.getNombre(), mision.getDescripcion(), mision.isCompletado());
    }

    // Insertar un nuevo evento
    public void insertarEvento(Evento evento) {
        String sql = "INSERT INTO eventos (nombre, descripcion, fecha) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, evento.getNombre(), evento.getDescripcion(), evento.getFecha());
    }
}
