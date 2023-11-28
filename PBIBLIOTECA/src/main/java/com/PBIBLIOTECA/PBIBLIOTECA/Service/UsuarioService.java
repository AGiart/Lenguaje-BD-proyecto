/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Usuario;
import java.util.List;

/**
 *
 * @author jason
 */
public interface UsuarioService {
    
    public List<Usuario>obtenerInfoUsuarios();
    
    
    public String guardarUsuario(String nombre, String apellido, String email, String contrasena, Long rolId, Long cedula);
    
    
     public void eliminarUsuarioPorId(Long id);
}
