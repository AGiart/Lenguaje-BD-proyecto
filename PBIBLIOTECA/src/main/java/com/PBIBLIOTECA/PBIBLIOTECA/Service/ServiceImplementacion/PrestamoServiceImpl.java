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
    public void realizarPrestamo(Long usuarioCedula, Long libroID, Date fechaPrestamo, Date fechaDevolucion) {
        prestamoDao.realizarPrestamo( fechaPrestamo, fechaDevolucion,usuarioCedula, libroID);
    }

    @Override
    public List<Prestamo> obtenerPrestamos() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PRESTAMOS.ObtenerPrestamos");
        query.registerStoredProcedureParameter("p_Prestamos", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();
    }

}
