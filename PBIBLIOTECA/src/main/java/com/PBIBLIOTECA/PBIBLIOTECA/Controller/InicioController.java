/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Libro;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jason
 */
@Controller
public class InicioController {
    @Autowired
    private ServiceImpl ServiceImpl;
    
    

    @GetMapping("/libros")
    public String irALibros() {
        // Puedes agregar cualquier lógica adicional aquí antes de redirigir
        return "/libros/libros";
    }
    
     @PostMapping("/insertar")
    public String insertarLibro(
            @RequestParam("titulo") String titulo,
            @RequestParam("autorID") Long autorID,
            @RequestParam("generoID") Long generoID,
            @RequestParam("editorialID") Long editorialID,
            @RequestParam("idiomaID") Long idiomaID,
            @RequestParam("anioPublicacion") Integer anioPublicacion,
            @RequestParam("isbn") String isbn,
            @RequestParam("cantidadCopias") Integer cantidadCopias,
            Model model
    ) {
        Libro nuevoLibro = new Libro();
        nuevoLibro.setTitulo(titulo);
        nuevoLibro.setAutorID(autorID);
        nuevoLibro.setGeneroID(generoID);
        nuevoLibro.setEditorialID(editorialID);
        nuevoLibro.setIdiomaID(idiomaID);
        nuevoLibro.setAnioPublicacion(anioPublicacion);
        nuevoLibro.setISBN(isbn);
        nuevoLibro.setCantidadCopiasDisponibles(cantidadCopias);

        ServiceImpl.saveLibro(nuevoLibro);

        model.addAttribute("mensaje", "Libro insertado correctamente");
        return "redirect:/libros";
    }

}
