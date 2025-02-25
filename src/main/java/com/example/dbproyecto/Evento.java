package com.example.dbproyecto;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Date fecha;

    // Constructor vacío
    public Evento() {}

    // Constructor con parámetros
    public Evento(Long id, String nombre, String descripcion, String fechaStr) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;

        // Convertir el String a Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.fecha = dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
            this.fecha = null; // Manejar el error de forma adecuada
        }
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}
