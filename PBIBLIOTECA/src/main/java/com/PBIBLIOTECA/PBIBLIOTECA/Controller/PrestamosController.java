/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Prestamo;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.PrestamoServiceImpl;

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

    @GetMapping("/listado")
    public String page(Model model) {

        var prestamos = prestamoServiceImpl.obtenerPrestamos();
        model.addAttribute("prestamos", prestamos);

        return "/prestamos/listado";
    }

    @PostMapping("/guardarPrestamo")
    public String realizarPago(
            @RequestParam("cedula") Long cedula,
            @RequestParam("libroID") Long libroID,
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam("fechaDevolucion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDevolucion,
            Model model) {
        prestamoServiceImpl.realizarPrestamo(cedula, libroID, fechaInicio, fechaDevolucion);
        return "redirect:/";
    }

}
