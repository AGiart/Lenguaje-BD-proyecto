/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Dao;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Editorial;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jason
 */
public interface EditorialDao extends JpaRepositoryImplementation<Editorial, Long> {
    
    @Procedure("InsertarEditorial")
    void insertarLibro(
            @Param("P_NOMBREEDITORIAL") String nombreEditorial
          
    );
    
}
