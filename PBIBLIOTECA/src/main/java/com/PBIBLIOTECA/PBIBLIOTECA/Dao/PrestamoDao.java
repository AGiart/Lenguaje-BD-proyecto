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

/**
 *
 * @author jason
 */
public interface PrestamoDao  extends JpaRepository<Prestamo, Long>{
    
    
    @Procedure(procedureName = "REALIZAR_PRESTAMO_LIBRO")
    String crearPrestamo(
            @Param("p_CEDULA")Long cedula,
            @Param("p_BOOKID") Long libroID,
            @Param("p_FECHA_INICIO") String FechaInicio,
            @Param("p_FECHA_DEVOLUCION_PREVISTA") String FechaDevolucion,
            @Param("p_ESTADO_PRESTAMO") String estadoPrestamo
   
    );
    
    
}
