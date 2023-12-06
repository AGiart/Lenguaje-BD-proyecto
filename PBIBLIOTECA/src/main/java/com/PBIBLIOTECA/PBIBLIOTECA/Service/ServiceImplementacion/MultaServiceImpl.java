/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Multa;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.MultaService;
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
public class MultaServiceImpl implements MultaService {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Multa> obtenerMultas() {
       StoredProcedureQuery query = entityManager.createStoredProcedureQuery("MULTA.obtener_informacion_multas");
        query.registerStoredProcedureParameter("p_resultado", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();
    }
    
}
