/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.OutParameter;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Prestamo;
import java.util.List;
import java.util.Date;

/**
 *
 * @author jason
 */
public interface PrestamoService {
    
    
     public void realizarPrestamo(Long usuarioCedula, Long libroID, Date fechaDevolucion);
    
    
    public List<Prestamo> obtenerPrestamos();
    public List<Prestamo> obtenerPrestamosDevueltos();

}
