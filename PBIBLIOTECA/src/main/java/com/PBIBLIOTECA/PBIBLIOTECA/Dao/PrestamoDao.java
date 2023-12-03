/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Dao;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Prestamo;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import java.util.Date;
/**
 *
 * @author jason
 */
public interface PrestamoDao  extends JpaRepository<Prestamo, Long>{
    
    
    @Procedure(procedureName = "Prestamos.CrearPrestamo")
    void realizarPrestamo(
            @Param("p_fecha_prestamo") Date fechaPrestamo,
            @Param("p_fecha_devolucion") Date fechaDevolucion,
            @Param("p_usuario_cedula") Long usuarioCedula,
            @Param("p_libro_id") Long libroID
          

    );
    
    
    
    
    
}
