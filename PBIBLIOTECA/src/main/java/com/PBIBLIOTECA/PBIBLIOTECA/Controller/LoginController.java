/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 *
 * @author jason
 */
@Controller
@RequestMapping("login")
public class LoginController {
    
    
    @Autowired
    private AuthService authService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8);

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    
       
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalida la sesión actual
        session.invalidate();

        // Redirige a la página de inicio de sesión o a la página principal
        return "redirect:/login/login";
    }
    

    @PostMapping("/login")
    public String processLogin(@RequestParam("cedula") int cedula, @RequestParam("contrasena") String contrasena, Model model) {


        String result = authService.login(cedula, contrasena);





        if ("Inicio de sesión exitoso".equals(result)) {
            return "redirect:/libros/inicio"; // Redirige a la página principal después del inicio de sesión exitoso
        } else {
            model.addAttribute("error", result);
            return "login";
        }
    }
    
    
    
}
