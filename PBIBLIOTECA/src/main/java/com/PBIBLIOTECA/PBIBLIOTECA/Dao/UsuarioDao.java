/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Dao;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Usuario;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jason
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    @Procedure(procedureName = "OBTENER_INFO_USUARIOS", outputParameterName = "p_resultado")
    StoredProcedureQuery obtenerInfoUsuarios();

    @Procedure(procedureName = "LLAMAR_INSERTAR_USUARIO", outputParameterName = "p_RESULTADO")
    String llamarInsertarUsuario(
            @Param("p_NOMBRE") String nombre,
            @Param("p_APELLIDO") String apellido,
            @Param("p_EMAIL") String email,
            @Param("p_CONTRASENA") String contrasena,
            @Param("p_ROLID") Long rolId,
            @Param("p_CEDULA") Long cedula
    );

}
