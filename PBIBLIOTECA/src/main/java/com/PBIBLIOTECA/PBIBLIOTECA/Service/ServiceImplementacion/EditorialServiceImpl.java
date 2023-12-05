/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Dao.EditorialDao;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Editorial;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.EditorialService;
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
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EditorialDao editorialDao;

    @Override
    public List<Editorial> obtenerEditoriales() {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.ObtenerEditoriales");
        query.registerStoredProcedureParameter("p_cursor", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();

    }

    @Override
    public void save(Editorial editorial) {
        editorialDao.insertarLibro(editorial.getNombreEditorial());

    }

    @Override
    public void eliminarEditorialPorId(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("LIBRO.EliminarEditorialPorId");
        query.registerStoredProcedureParameter("p_id", Long.class, ParameterMode.IN);
        query.setParameter("p_id", id);
        query.execute();

    }

    @Override
    public void editarEditorial(Editorial editorial) {
        editorialDao.actualizarEditorial(editorial.getPublisherId(), editorial.getNombreEditorial());
     
    }

}
