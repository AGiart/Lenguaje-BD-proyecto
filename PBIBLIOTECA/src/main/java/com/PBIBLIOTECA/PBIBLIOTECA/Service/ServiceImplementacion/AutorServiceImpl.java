/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Dao.AutorDao;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Autor;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.AutorService;
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
public class AutorServiceImpl implements AutorService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private AutorDao autorDao;

    @Override
    public List<Autor> obtenerAutores() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.ObtenerAutores");
        query.registerStoredProcedureParameter("p_cursor", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();
    }

    @Override
    public void savelibros(Autor autor) {
        autorDao.insertarAutor(autor.getNombre(), autor.getApellido(), autor.getNacionalidadID());
       
    }

    @Override
    public void eliminarAutorPorId(Long id) {
      StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.EliminarAutorPorId");
        query.registerStoredProcedureParameter("p_id", Long.class, ParameterMode.IN);
        query.setParameter("p_id", id);
        query.execute(); 
    }

    @Override
    public void actualizarAutor(Autor autor) {
        autorDao.actualizarAutor(autor.getAutorID(), autor.getNombre(), autor.getApellido(), autor.getNacionalidadID());
    }

    @Override
    public List<Autor> obtenerAutorID(Long id) {
        
        
        
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.BuscarAutorPorId");
        query.registerStoredProcedureParameter("p_AutorId", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_cursor", void.class, ParameterMode.REF_CURSOR);
        query.setParameter("p_AutorId", id);
        
        
        query.execute();

        return query.getResultList();
       
    }
    
    
    
    
    
    

}
