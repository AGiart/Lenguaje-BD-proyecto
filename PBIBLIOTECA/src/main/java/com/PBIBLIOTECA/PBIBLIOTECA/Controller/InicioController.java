/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Libro;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.OutParameter;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.AutorServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.EditorialServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.GeneroServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.IdiomaServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jason
 */
@Controller
@RequestMapping("/libros")
public class InicioController {

    @Autowired
    private ServiceImpl ServiceImpl;
    
    @Autowired
    private EditorialServiceImpl editorialServiceImpl;
    
    @Autowired
    private AutorServiceImpl autorServiceImpl;
    
    @Autowired
    private GeneroServiceImpl generoServiceImpl;
    
    @Autowired
    private IdiomaServiceImpl idioamServiceImpl;
    
    
    
    
    
    
    

    @GetMapping("/inicio")
    public String irALibros(Model model) {
        
        
        var Libros = ServiceImpl.obtenerInformacionLibros();
        var Editoriales = editorialServiceImpl.obtenerEditoriales();
        var Autores = autorServiceImpl.obtenerAutores();
        var Generos = generoServiceImpl.obtenerGeneros();
        var Idiomas = idioamServiceImpl.obtenerIdioma();
        
        
        model.addAttribute("libros", Libros);
        model.addAttribute("Editorial", Editoriales);
        model.addAttribute("Autor", Autores);
        model.addAttribute("Genero", Generos);
        model.addAttribute("Idioma", Idiomas);
        return "/libros/libros";
    }

    @GetMapping("/editar/{libro}")
    public String editarLibro(@PathVariable String libro, Model model) {

        String titulo = libro;
        List<OutParameter>editarLibro = ServiceImpl.obtenerLibroPorTitulo(titulo);
        model.addAttribute("editarLibro", editarLibro);
        
        var Editoriales = editorialServiceImpl.obtenerEditoriales();
        var Autores = autorServiceImpl.obtenerAutores();
        var Generos = generoServiceImpl.obtenerGeneros();
        var Idiomas = idioamServiceImpl.obtenerIdioma();
        
        
         model.addAttribute("Editorial", Editoriales);
        model.addAttribute("Autor", Autores);
        model.addAttribute("Genero", Generos);
        model.addAttribute("Idioma", Idiomas);
    
   

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "/libros/editarLibros";
    }
    
    
    @PostMapping("/eliminarLibro")
    public String eliminarLibros(@RequestParam  Long idLibro, Model model) {
        
        ServiceImpl.eliminarLibroPorId(idLibro);

   

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "redirect:/libros";
    }
    
    
    @PostMapping("/actualizar")
    public String actualizarLibro(
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
        Libro LibroActualizado = new Libro();
        LibroActualizado.setTitulo(titulo);
        LibroActualizado.setAutorID(autorID);
        LibroActualizado.setGeneroID(generoID);
        LibroActualizado.setEditorialID(editorialID);
        LibroActualizado.setIdiomaID(idiomaID);
        LibroActualizado.setAnioPublicacion(anioPublicacion);
        LibroActualizado.setISBN(isbn);
        LibroActualizado.setCantidadCopiasDisponibles(cantidadCopias);
        
        
        

        ServiceImpl.actualizarLibro(LibroActualizado);

        model.addAttribute("mensaje", "Libro insertado correctamente");

       
        
        return "redirect:/";
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
        return "redirect:/";
    }

}
