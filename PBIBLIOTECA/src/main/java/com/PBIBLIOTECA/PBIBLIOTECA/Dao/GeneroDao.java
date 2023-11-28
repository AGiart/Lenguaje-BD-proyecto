/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Dao;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Genero;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jason
 */
public interface GeneroDao extends JpaRepositoryImplementation<Genero, Long> {
    
    
    @Procedure("InsertarGenero")
    void insertarGenero(
            @Param("P_NOMBREGENERO") String nombreGenero
          
    );
    
    
}
