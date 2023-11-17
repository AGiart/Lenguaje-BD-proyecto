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
    
    @Procedure("BuscarAutorPorNombre")
    void insertarLibro(
        @Param("p_AutorNombre") String autorNombre
   
    );
    
    public void insertarAutor(@Param())
    
    
}
