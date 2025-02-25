package com.example.dbproyecto;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/misiones")
@Service
public class MisionService {
    @Autowired
    private EntityManager entityManager;

    public boolean marcarComoCompletada(Long id) {
        Mision mision = entityManager.find(Mision.class, id);
        if (mision != null) {
            mision.setCompletado(true);
            entityManager.merge(mision);
            return true;
        }
        return false;
    }
}

