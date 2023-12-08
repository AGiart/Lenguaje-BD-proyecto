/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.DTO.UsuarioDto;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.AuthService;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.RolServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.UsuarioServiceImpl;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 *
 * @author jason
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private RolServiceImpl rolServiceImpl;

    @Autowired
    private AuthService authService;


    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8);







    @GetMapping("/listado")
    public String page(Model model) {
        // Obtiene el usuario de la sesión
        UsuarioDto usuario = authService.getUsuarioFromSession();
        
        if (!authService.isUserRolePresent()) {
            return "redirect:/"; // o redirige a otra página de error
        }
        
        // Verifica si el usuario tiene el rol 'Admin'
        boolean isAdmin = authService.hasPermission("ADMIN");
        
        

        // Si el usuario no tiene el rol 'Admin', redirige a una página de error o realiza alguna acción adecuada
        if (!isAdmin) {
            // Puedes redirigir a una página de error o realizar otra acción aquí
            return "/error";
        }

        // Continúa con el código original
        var usuarios = usuarioServiceImpl.obtenerInfoUsuarios();
        var roles = rolServiceImpl.obtenerRoles();
        model.addAttribute("usuario", usuarios);
        model.addAttribute("roles", roles);

        return "/usuario/listado";
    }

    // Otros métodos del controlador...



    
    @PostMapping("/eliminarUsuario")
    public String eliminarUsuarios(@RequestParam Long idUsuario, Model model) {

        usuarioServiceImpl.eliminarUsuarioPorId(idUsuario);

        // Luego, agrega el modelo y realiza las operaciones necesarias
        return "redirect:/usuario/listado";
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

        // Obtiene el usuario de la sesión
        UsuarioDto usuario = authService.getUsuarioFromSession();

        if (!authService.isUserRolePresent()) {
            return "redirect:/"; // o redirige a otra página de error
        }

        // Verifica si el usuario tiene el rol 'Admin'
        boolean isAdmin = authService.hasPermission("ADMIN");



        // Si el usuario no tiene el rol 'Admin', redirige a una página de error o realiza alguna acción adecuada
        if (!isAdmin) {
            // Puedes redirigir a una página de error o realizar otra acción aquí
            return "redirect:/error";
        }

        String hashedPassword = passwordEncoder.encode(contrasena);

        var guardarUsuario =usuarioServiceImpl.guardarUsuario(nombre, apellido, email, hashedPassword, rolID,cedula);
        model.addAttribute("respuesta", guardarUsuario);
        
        return "redirect:listado";
    }


    @GetMapping("/editarUsuario/{cedula}/{nombre}/{apellido}/{correo}/{cargo}/{estado}")
    public String mostrarEditarUsuario(
            @PathVariable("cedula") Long cedula,
            @PathVariable("nombre") String nombre,
            @PathVariable("apellido") String apellido,
            @PathVariable("correo") String correo,
            @PathVariable("cargo") String cargo,
            @PathVariable("estado") String estado,
            Model model


    ){
        // Obtiene el usuario de la sesión
        UsuarioDto usuario = authService.getUsuarioFromSession();

        if (!authService.isUserRolePresent()) {
            return "redirect:/"; // o redirige a otra página de error
        }

        // Verifica si el usuario tiene el rol 'Admin'
        boolean isAdmin = authService.hasPermission("ADMIN");



        // Si el usuario no tiene el rol 'Admin', redirige a una página de error o realiza alguna acción adecuada
        if (!isAdmin) {
            // Puedes redirigir a una página de error o realizar otra acción aquí
            return "redirect:/error";
        }

        var roles =rolServiceImpl.obtenerRoles();

        model.addAttribute("cedula",cedula);
        model.addAttribute("nombre",nombre);
        model.addAttribute("apellido",apellido);
        model.addAttribute("correo",correo);
        model.addAttribute("cargo",cargo);
        model.addAttribute("estado",estado);
        model.addAttribute("roles",roles);

        return "/usuario/editarUsuario";
    }

    @PostMapping("/actualizarUsuario")
    public String actualizarUsuario(
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("email") String email,
            @RequestParam("roles") Long roles,
            @RequestParam("cedula") Long cedula,
            @RequestParam("estado") String estado

    ){

          usuarioServiceImpl.actualizar(nombre, apellido, email, roles,cedula,estado);

          return "redirect:/usuario/listado";

    }


    
}
