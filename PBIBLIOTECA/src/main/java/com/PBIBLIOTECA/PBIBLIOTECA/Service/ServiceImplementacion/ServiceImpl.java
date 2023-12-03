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
import java.sql.ResultSet;
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
    public void actualizarLibro(Libro libro) {
        
        libroDao.actualizarLibro(libro.getBookID(), libro.getTitulo(), libro.getAutorID(), libro.getGeneroID(), 
                libro.getEditorialID(),
                libro.getIdiomaID(), libro.getAnioPublicacion(), 
                libro.getISBN(), libro.getCantidadCopiasDisponibles());
    }
    
    
    
    
    

    @Transactional
    @Override
    public List<OutParameter> obtenerInformacionLibros() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.OBTENERINFORMACIONLIBROS");
        query.registerStoredProcedureParameter("p_cursor", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();
    }
    @Transactional
    @Override
    public List<OutParameter> obtenerLibroPorTitulo(String titulo) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.ObtenerLibroPorTitulo");
        query.registerStoredProcedureParameter("p_titulo", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_cursor", void.class, ParameterMode.REF_CURSOR);

        query.setParameter("p_titulo", titulo);
        query.execute();

        return query.getResultList();
    }
    @Transactional
    @Override
    public void eliminarLibroPorId(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.EliminarLibroPorId");
        query.registerStoredProcedureParameter("p_id", Long.class, ParameterMode.IN);
        query.setParameter("p_id", id);
        query.execute();
        
        
    }

    @Override
    public List<OutParameter> obtenerLibroIdPorTitulo(String titulo) {
       StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.ObtenerLibroIdPorTitulo");
        query.registerStoredProcedureParameter("p_titulo", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_cursor", void.class, ParameterMode.REF_CURSOR);

        query.setParameter("p_titulo", titulo);
        query.execute();

        return query.getResultList();
    }
    

}
