/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Dao;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jason
 */
public interface PrestamoDao  extends JpaRepository<Prestamo, Long>{
    
    
    @Procedure(procedureName = "REALIZAR_PRESTAMO_LIBRO")
    String crearPrestamo(
            @Param("p_NOMBRE") String nombre,
            @Param("p_APELLIDO") String apellido,
            @Param("p_EMAIL") String email,
            @Param("p_CONTRASENA") String contrasena,
            @Param("p_ROLID") Long rolId,
            @Param("p_CEDULA") Long cedula
    );
    
    
}
