/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Prestamo;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.PrestamoServiceImpl;
import java.sql.Date;
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
@RequestMapping("/prestamos")
@Controller
public class PrestamosController {
    @Autowired
    PrestamoServiceImpl prestamoServiceImpl;
    
    @GetMapping("/listado")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "/prestamos/listado";
    }
     
    
    
    @PostMapping("/guardarPrestamo")
    public String guardar(
            @RequestParam("cedula") Long cedula,
            @RequestParam("libroID") Long libroID,
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaDevolucion") String fechaDevolucion,
            @RequestParam("estado") String estadoPrestamo,

            Model model){
        
        Prestamo prestamo = new Prestamo();
        
        prestamo.setCedula(cedula);
        prestamo.setLibroID(libroID);
        prestamo.setFechaInicio(fechaInicio);
        prestamo.setFechaDevolucionPrevista(fechaDevolucion);
        prestamo.setEstadoPrestamo(estadoPrestamo);
        
        
        prestamoServiceImpl.crearPrestamo(prestamo);
        
        
  
        
        return "redirect:listado";
    }
    
    
    
}
