/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Dao.GeneroDao;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Genero;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.GeneroService;
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
public class GeneroServiceImpl implements GeneroService {
    
    
    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private GeneroDao generoDao;

    @Override
    public List<Genero> obtenerGeneros() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.ObtenerGeneros");
        query.registerStoredProcedureParameter("p_cursor", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();
    }

    @Override
    public void insertarGeneros(Genero genero) {
        generoDao.insertarGenero(genero.getNombreGenero());
       
    }

    @Override
    public void eliminarGeneroPorId(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.EliminarGeneroPorId");
        query.registerStoredProcedureParameter("p_id", Long.class, ParameterMode.IN);
        query.setParameter("p_id", id);
        query.execute();
       
    }

    @Override
    public void actualizarGenero(Genero genero) {
        generoDao.actualizarGenero(genero.getGenreID(), genero.getNombreGenero());
     
    }
    
}
