/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Autor;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Editorial;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Genero;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Libro;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.OutParameter;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.AutorServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.EditorialServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.GeneroServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.IdiomaServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.NacionalidadServiceImpl;
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

    @Autowired
    private NacionalidadServiceImpl nacionalidadServiceImpl;

    @GetMapping("/inicio")
    public String irALibros(Model model) {

        var Libros = ServiceImpl.obtenerInformacionLibros();
        var Editoriales = editorialServiceImpl.obtenerEditoriales();
        var Autores = autorServiceImpl.obtenerAutores();
        var Generos = generoServiceImpl.obtenerGeneros();
        var Idiomas = idioamServiceImpl.obtenerIdioma();
        var Nacionalidades = nacionalidadServiceImpl.obtenerNacionalides();

        model.addAttribute("libros", Libros);
        model.addAttribute("Editorial", Editoriales);
        model.addAttribute("Autor", Autores);
        model.addAttribute("Genero", Generos);
        model.addAttribute("Idioma", Idiomas);
        model.addAttribute("Nacionalidad", Nacionalidades);
        return "/libros/libros";
    }

    @GetMapping("/editar/{libro}")
    public String editarLibro(@PathVariable String libro, Model model) {

        String titulo = libro;
        var editarLibro = ServiceImpl.obtenerLibroPorTitulo(titulo);
        var idLibro = ServiceImpl.obtenerLibroIdPorTitulo(titulo);

        var Editoriales = editorialServiceImpl.obtenerEditoriales();
        var Autores = autorServiceImpl.obtenerAutores();
        var Generos = generoServiceImpl.obtenerGeneros();
        var Idiomas = idioamServiceImpl.obtenerIdioma();

        model.addAttribute("Editorial", Editoriales);

        model.addAttribute("Autor", Autores);
        model.addAttribute("Genero", Generos);
        model.addAttribute("Idioma", Idiomas);
        model.addAttribute("idLibro", idLibro);

        model.addAttribute("editarLibro", editarLibro);

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "/libros/editarLibros";
    }

    @GetMapping("/editarAutor/{libro}")
    public String editarAutor(@PathVariable Long libro, Model model) {
        var nacionalidades =  nacionalidadServiceImpl.obtenerNacionalides();
     
        var Autores = autorServiceImpl.obtenerAutorID(libro);

        model.addAttribute("Autor", Autores);
         model.addAttribute("nacionalidad", nacionalidades);

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "/libros/editarAutor";
    }

    @PostMapping("/eliminarLibro")
    public String eliminarLibros(@RequestParam Long idLibro, Model model) {

        ServiceImpl.eliminarLibroPorId(idLibro);

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "redirect:/";
    }

    @PostMapping("/eliminarAutor")
    public String eliminarAutor(@RequestParam Long idAutor, Model model) {

        autorServiceImpl.eliminarAutorPorId(idAutor);

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "redirect:/";
    }

    @PostMapping("/eliminarEditorial")
    public String eliminarEditorial(@RequestParam Long idEditorial, Model model) {

        editorialServiceImpl.eliminarEditorialPorId(idEditorial);

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "redirect:/";
    }

    @PostMapping("/eliminarGenero")
    public String eliminarGenero(@RequestParam Long idGenero, Model model) {

        generoServiceImpl.eliminarGeneroPorId(idGenero);

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "redirect:/";
    }

    @PostMapping("/actualizar")
    public String actualizarLibro(
            @RequestParam("idLibro") Long idLibro,
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
        LibroActualizado.setBookID(idLibro);
        LibroActualizado.setTitulo(titulo);
        LibroActualizado.setAutorID(autorID);
        LibroActualizado.setGeneroID(generoID);
        LibroActualizado.setEditorialID(editorialID);
        LibroActualizado.setIdiomaID(idiomaID);
        LibroActualizado.setAnioPublicacion(anioPublicacion);
        LibroActualizado.setISBN(isbn);
        LibroActualizado.setCantidadCopiasDisponibles(cantidadCopias);

        ServiceImpl.actualizarLibro(LibroActualizado);

        return "redirect:/";
    }
    
    
    @PostMapping("/actualizarAutor")
    public String actualizarAutor(
            @RequestParam("idAutor") Long idAutor,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("nacionalidad") Long nacionalidad,
            Model model
    ) {
        Autor autor = new Autor();
        autor.setAutorID(idAutor);
        autor.setNombre(nombre);
        autor.setApellido(apellido);
        autor.setNacionalidadID(nacionalidad);
        
        autorServiceImpl.actualizarAutor(autor);




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

    @PostMapping("/insertarAutor")
    public String insertarAutor(
            @RequestParam("nacionalidadID") Long nacionalidadID,
            @RequestParam("nombre") String nombreAutor,
            @RequestParam("apellido") String apellidoAutor,
            Model model
    ) {
        Autor autor = new Autor();
        // Si autorID es generado automáticamente en la base de datos, no es necesario pasarlo aquí
        autor.setNacionalidadID(nacionalidadID);
        autor.setNombre(nombreAutor);
        autor.setApellido(apellidoAutor);

        autorServiceImpl.savelibros(autor);

        model.addAttribute("mensaje", "Autor insertado correctamente");
        return "redirect:/";
    }

    @PostMapping("/insertarEditorial")
    public String insertarEditorial(
            @RequestParam("nombreEditorial") String nombreEditorial,
            Model model
    ) {
        Editorial editorial = new Editorial();
        editorial.setNombreEditorial(nombreEditorial);
        editorialServiceImpl.save(editorial);

        model.addAttribute("mensaje", "Autor insertado correctamente");
        return "redirect:/";
    }

    @PostMapping("insertarGenero")
    public String insertarGenero(
            @RequestParam("nombreGenero") String nombreGenero, Model model) {
        Genero genero = new Genero();
        genero.setNombreGenero(nombreGenero);
        generoServiceImpl.insertarGeneros(genero);

        return "redirect:/";

    }

    @GetMapping("/mostrarAutores")
    public String mostrarAutores(Model model) {

        var Autores = autorServiceImpl.obtenerAutores();
        model.addAttribute("Autores", Autores);

        return "/libros/Autores";
    }

    @GetMapping("/mostraEditoriales")
    public String mostraEditoriales(Model model) {

        var Editoriales = editorialServiceImpl.obtenerEditoriales();
        model.addAttribute("editorial", Editoriales);

        return "/libros/Editoriales";
    }

    @GetMapping("/mostrarGeneros")
    public String mostrarGeneros(Model model) {
        var Generos = generoServiceImpl.obtenerGeneros();
        model.addAttribute("genero", Generos);

        return "/libros/Generos";
    }

}
