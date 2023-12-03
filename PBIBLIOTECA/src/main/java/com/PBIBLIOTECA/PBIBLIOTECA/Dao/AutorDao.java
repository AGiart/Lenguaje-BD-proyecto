/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Dao;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jason
 */
public interface AutorDao extends JpaRepository<Autor, Long>{
    
     @Procedure(procedureName = "LIBRO.InsertarAutor")
    void insertarAutor(
            @Param("p_NOMBREAUTOR") String nombreAutor,
            @Param("p_APELLIDOAUTOR") String apellidoAutor,
            @Param("p_NACIONALIDAD") Long nacionalidadId
    );
    
 
    
            
    @Procedure(procedureName = "LIBRO.ActualizarAutor")
    void actualizarAutor(
        @Param("p_autorId") Long autorId,
        @Param("p_nombreAutor") String nombre,
        @Param("p_apellidoAutor") String apellido,
        @Param("p_nacionalidadID") Long nacionalidadId
    
    );

 
    
    
}
