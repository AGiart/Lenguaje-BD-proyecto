/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Dao.UsuarioDao;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Usuario;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.UsuarioService;
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
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Usuario> obtenerInfoUsuarios() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("USUARIO.OBTENER_INFO_USUARIOS");

        query.registerStoredProcedureParameter("p_resultado", void.class, ParameterMode.REF_CURSOR);
        
        query.execute();

        return query.getResultList();
    }

    @Override
    public List<Usuario> ObtenerDatosUsuarioPorCedula(Long cedula) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("USUARIO.ObtenerDatosUsuario");
        query.registerStoredProcedureParameter("p_cedula", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_roles", void.class, ParameterMode.REF_CURSOR);
        query.setParameter("p_cedula", cedula);

        query.execute();

        return query.getResultList();
    }

    public String guardarUsuario(String nombre, String apellido, String email, String contrasena, Long rolId, Long cedula) {
        String resultado = usuarioDao.llamarInsertarUsuario(nombre, apellido, email, contrasena, rolId, cedula);
        // Aquí puedes manejar el resultado según tus necesidades.
        return resultado;
    }

    public void actualizar(String nombre, String apellido, String email,  Long rolId, Long cedula,String estado) {
        usuarioDao.actualizarUsuario(cedula, nombre, apellido, email, rolId, estado);
    }


    public void eliminarUsuarioPorId(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("USUARIO.ELIMINAR_USUARIO");
        query.registerStoredProcedureParameter("p_CEDULA", Long.class, ParameterMode.IN);
        query.setParameter("p_CEDULA", id);
        query.execute();
        
        
    }

   
}

