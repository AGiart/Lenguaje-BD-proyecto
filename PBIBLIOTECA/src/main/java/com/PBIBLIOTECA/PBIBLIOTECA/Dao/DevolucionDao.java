package com.PBIBLIOTECA.PBIBLIOTECA.Dao;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Devolucion;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import java.util.Date;
public interface DevolucionDao extends JpaRepositoryImplementation <Devolucion,Long> {


    @Procedure(procedureName = "GESTION_DEVOLUCIONES.InsertarDevolucion")
    void crearDevolucion(@Param("p_prestamo_id")Long prestamoId,
                         @Param("p_usuario_cedula")Long usuarioCedula,
                         @Param("p_libro_id")Long idlibro,
                         @Param("p_observaciones")String observaciones
                         );
}
