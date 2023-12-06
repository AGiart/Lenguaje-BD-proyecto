/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.MultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jason
 */
@RequestMapping("/multas")
@Controller
public class MultaController {
    @Autowired
    MultaServiceImpl multaServiceImpl;
    
    @GetMapping("/listado")
    public String listadoMultas(Model model) {
        var multas = multaServiceImpl.obtenerMultas();
        model.addAttribute("multas", multas);
        
        return "/Multas/multas";
    }
    
}
