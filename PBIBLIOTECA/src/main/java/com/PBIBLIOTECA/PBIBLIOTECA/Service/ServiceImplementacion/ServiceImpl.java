/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Dao.LibroDao;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Libro;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.OutParameter;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.LibroService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jason
 */
@Service
public class ServiceImpl implements LibroService {
    @Autowired
    LibroDao libroDao;
    
    


    @Autowired
    private EntityManager entityManager;
    

    @Override
    public void saveLibro(Libro libro) {
        
        libroDao.insertarLibro(
            libro.getTitulo(),
            libro.getAutorID(),
            libro.getGeneroID(),
            libro.getEditorialID(),
            libro.getIdiomaID(),
            libro.getAnioPublicacion(),
            libro.getISBN(),
            libro.getCantidadCopiasDisponibles()
        );
        
        
        
        
        
    }
    @Transactional
    @Override
    public List<OutParameter> obtenerInformacionLibros() {
        
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("ObtenerInformacionLibros", OutParameter.class);
        storedProcedure.registerStoredProcedureParameter("p_cursor", void.class, ParameterMode.REF_CURSOR);

        storedProcedure.execute();

        return storedProcedure.getResultList();
        
        
    }
    
}
