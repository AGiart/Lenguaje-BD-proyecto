/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.RolServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jason
 */
@RequestMapping("/usuario")
@Controller
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    
    @Autowired
    private RolServiceImpl rolServiceImpl;
    
    @GetMapping("/listado")
    public String page(Model model) {
        var usuario = usuarioServiceImpl.obtenerInfoUsuarios();
        var roles =rolServiceImpl.obtenerRoles();
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", roles);
        
        return "/usuario/listado";
    }
    
    
    @PostMapping("/eliminarUsuario")
    public String eliminarLibros(@RequestParam Long idUsuario, Model model) {

        usuarioServiceImpl.eliminarUsuarioPorId(idUsuario);

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "redirect: listado";
    }
    
    
    
    @PostMapping("/guardarUsuario")
    public String guardar(
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("email") String email,
            @RequestParam("contrasena") String contrasena,
            @RequestParam("ROLID") Long rolID,
            @RequestParam("cedula") Long cedula,
            Model model){
        
        var guardarUsuario =usuarioServiceImpl.guardarUsuario(nombre, nombre, email, contrasena, rolID,cedula);
        model.addAttribute("respuesta", guardarUsuario);
        
        return "redirect:listado";
    }
    
}
