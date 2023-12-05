/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Prestamo;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.AuthService;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.PrestamoServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jason
 */
@RequestMapping("/prestamos")
@Controller
public class PrestamosController {

    @Autowired
    PrestamoServiceImpl prestamoServiceImpl;
    
    @Autowired
    private ServiceImpl serviceImpl;

    @Autowired
    private AuthService authService;

    @GetMapping("/listado")
    public String page(Model model) {
        var libros = serviceImpl.obtenerInformacionLibros();
        var prestamos = prestamoServiceImpl.obtenerPrestamos();
        model.addAttribute("prestamos", prestamos);
        model.addAttribute("libros", libros);

        if (!authService.isUserRolePresent()) {
            return "redirect:/"; // o redirige a otra página de error
        }

        return "/prestamos/listado";
    }

    @PostMapping("/guardarPrestamo")
    public String realizarPago(
            @RequestParam("cedula") Long cedula,
            @RequestParam("libroID") Long libroID,
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam("fechaDevolucion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDevolucion,
            Model model) {

        if (!authService.isUserRolePresent()) {
            return "redirect:/"; // o redirige a otra página de error
        }

        prestamoServiceImpl.realizarPrestamo(cedula, libroID, fechaInicio, fechaDevolucion);

        return "redirect:/prestamos/listado";
    }

}
