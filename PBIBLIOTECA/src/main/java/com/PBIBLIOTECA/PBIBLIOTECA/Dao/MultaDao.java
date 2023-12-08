/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Dao;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Multa;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jason
 */
public interface MultaDao extends JpaRepositoryImplementation<Multa, Long> {


    @Procedure("multa.crearMulta")
    void crearMulta(
            @Param("M_PRESTAMO_ID") Long prestamoId,
            @Param("M_USUARIO_CEDULA") Long usuarioCedula,
            @Param("M_MONTO") int monto

    );
    @Procedure("multa.actualizarMulta")
    void actualizarMulta(
            @Param("P_MULTA_ID") Long multaId

    );
    
}
