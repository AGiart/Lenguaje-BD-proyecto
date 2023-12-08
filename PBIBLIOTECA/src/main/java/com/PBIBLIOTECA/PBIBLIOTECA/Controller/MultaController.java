/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Controller;

import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.MultaServiceImpl;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Multa;

/**
 *
 * @author jason
 */
@RequestMapping("/multas")
@Controller
public class MultaController {
    @Autowired
    MultaServiceImpl multaServiceImpl;

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;
    
    @GetMapping("/listado")
    public String listadoMultas(Model model) {
        var multas = multaServiceImpl.obtenerMultas();
        model.addAttribute("multas", multas);
        
        return "/Multas/multas";
    }

    @GetMapping("/crearMultaFormulario/{Cedula}/{Prestamo}")
    public String crearMultaFormulario(
            @PathVariable("Prestamo") Long prestamo,
            @PathVariable("Cedula") Long cedula,
            Model model) {
        var usuario =usuarioServiceImpl.ObtenerDatosUsuarioPorCedula(cedula);
        model.addAttribute("prestamo",prestamo);
        model.addAttribute("cedula",cedula);
        model.addAttribute("usuario",usuario);


        return "/Multas/crearMulta";

    }
    @GetMapping("/actualizarMultaFormulario/{multaid}/{cliente}/{precio}/{estado}")
    public String actualizarMultaFormulario(
            @PathVariable("multaid") Long multaid,
            @PathVariable("cliente") String cliente,
            @PathVariable("precio") int precio,
            @PathVariable("estado") String estado,
            Model model

    ) {
        model.addAttribute("multaid",multaid);
        model.addAttribute("cliente",cliente);
        model.addAttribute("precio",precio);
        model.addAttribute("estado",estado);


        return "/Multas/editarMulta";
    }
    @PostMapping("/actualizarMulta")
    public String actualizarMulta(
            @RequestParam("idMulta") Long idMulta,
            Model model,
            Multa multa
    ) {
        String respuesta = "";
        multa.setMultaID(idMulta);
        multaServiceImpl.actualizarMulta(multa);


        return "redirect:/multas/listado";


    }


    @PostMapping("/crearMulta")
    public String crearMulta( @RequestParam("cedula") Long cedula,
                              @RequestParam("prestamoId") Long prestamoId,
                              Multa multa,
                              @RequestParam("monto") int monto){
        multa.setUsuarioCedula(cedula);
        multa.setPrestamoId(prestamoId);

        multa.setMonto(monto);

        multaServiceImpl.crearMulta(multa);




        return "redirect:/multas/listado";

    }
    
}
