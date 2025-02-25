package com.example.dbproyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/misiones")
public class MisionController {
    @Autowired
    private MisionService misionService;

    @PutMapping("/{id}/completar")
    public ResponseEntity<String> completarMision(@PathVariable Long id) {
        boolean resultado = misionService.marcarComoCompletada(id);
        if (resultado) {
            return ResponseEntity.ok("Misión marcada como completada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Misión no encontrada");
        }
    }
}
