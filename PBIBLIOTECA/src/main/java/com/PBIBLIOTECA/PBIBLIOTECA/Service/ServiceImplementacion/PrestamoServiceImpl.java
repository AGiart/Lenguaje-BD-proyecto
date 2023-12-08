/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Dao.PrestamoDao;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Prestamo;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.PrestamoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 *
 * @author jason
 */
@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    PrestamoDao prestamoDao;
    
     @Override
     public void realizarPrestamo(Long usuarioCedula, Long libroID,  Date fechaDevolucion) {
    Integer resultado = 0;

    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Prestamos.CrearPrestamo");
    query.registerStoredProcedureParameter("p_fecha_devolucion", Date.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("p_usuario_cedula", Long.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("p_libro_id", Long.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("p_resultado", Integer.class, ParameterMode.OUT);

    query.setParameter("p_fecha_devolucion", fechaDevolucion);
    query.setParameter("p_usuario_cedula", usuarioCedula);
    query.setParameter("p_libro_id", libroID);

    query.execute();

    resultado = (Integer) query.getOutputParameterValue("p_resultado");

    if (resultado == 1) {
        System.out.println("Préstamo creado exitosamente.");
    } else {
        System.out.println("No se pudo crear el préstamo debido a multas pendientes.");
    }
}


    @Override
    public List<Prestamo> obtenerPrestamos() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PRESTAMOS.ObtenerPrestamos");
        query.registerStoredProcedureParameter("p_Prestamos", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();
    }

    @Override
    public List<Prestamo> obtenerPrestamosDevueltos() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PRESTAMOS.ObtenerPrestamosDevoluciones");
        query.registerStoredProcedureParameter("p_Prestamos", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();
    }

}
