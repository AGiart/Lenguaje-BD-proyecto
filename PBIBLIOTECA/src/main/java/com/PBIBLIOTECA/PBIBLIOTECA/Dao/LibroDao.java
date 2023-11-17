/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Dao;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Libro;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.OutParameter;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jason
 */
public interface LibroDao extends JpaRepository<Libro, Long> {

    @Procedure("InsertarLibro")
    void insertarLibro(
            @Param("p_Titulo") String titulo,
            @Param("p_AutorID") Long autorID,
            @Param("p_GeneroID") Long generoID,
            @Param("p_EditorialID") Long editorialID,
            @Param("p_IdiomaID") Long idiomaID,
            @Param("p_AnioPublicacion") Integer anioPublicacion,
            @Param("p_ISBN") String ISBN,
            @Param("p_CantidadCopias") Integer cantidadCopias
    );
    
    
     @Procedure(name = "ActualizarLibro")
    void actualizarLibro(
        @Param("p_libro_id") Long id,
        @Param("p_titulo") String titulo,
        @Param("p_autor_id") Long autorId,
        @Param("p_genero_id") Long generoId,
        @Param("p_editorial_id") Long editorialId,
        @Param("p_idioma_id") Long idiomaId,
        @Param("p_anio_publicacion") Integer anioPublicacion,
        @Param("p_isbn") String isbn,
        @Param("p_cantidad_copias") Integer cantidadCopias
    );

   

}
