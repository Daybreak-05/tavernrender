package com.example.dbproyecto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @PersistenceContext
    private EntityManager entityManager;

    // Guardar evento en la base de datos
    @Transactional
    public Evento guardarEvento(Evento evento) {
        entityManager.persist(evento);
        return evento;
    }

    // Buscar evento por ID
    public Evento buscarPorId(Long id) {
        return entityManager.find(Evento.class, id);
    }
}
