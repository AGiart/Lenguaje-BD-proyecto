/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Nacionalidad;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.NacionalidadService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jason
 */
@Service
public class NacionalidadServiceImpl implements NacionalidadService {
    
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Nacionalidad> obtenerNacionalides() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ObtenerNacionalidades");
        query.registerStoredProcedureParameter("p_cursor", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();
    }
    
}
