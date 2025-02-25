package com.example.dbproyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;

    // Mostrar todas las misiones y eventos
    @GetMapping("/")
    public String listarAnuncios(Model model) {
        model.addAttribute("misiones", anuncioService.obtenerMisiones());
        model.addAttribute("eventos", anuncioService.obtenerEventos());
        return "index";
    }

    // Formulario para crear nueva misión
    @GetMapping("/crearMision")
    public String crearMisionForm(Model model) {
        model.addAttribute("mision", new Mision());
        return "crearMision";
    }

    // Guardar nueva misión
    @PostMapping("/crearMision")
    public String crearMision(@ModelAttribute("mision") Mision mision) {
        anuncioService.insertarMision(mision);
        return "redirect:/anuncios/";
    }

    // Completar misión
    @PostMapping("/completarMision/{id}")
    public String completarMision(@PathVariable Long id) {
        anuncioService.completarMision(id); // Llamar al servicio para completar la misión
        return "redirect:/anuncios/";
    }

    // Formulario para crear nuevo evento
    @GetMapping("/crearEvento")
    public String crearEventoForm(Model model) {
        model.addAttribute("evento", new Evento());
        return "crearEvento";
    }

    // Guardar nuevo evento
    @PostMapping("/crearEvento")
    public String crearEvento(@ModelAttribute("evento") Evento evento) {
        anuncioService.insertarEvento(evento);
        return "redirect:/anuncios/";
    }
}
