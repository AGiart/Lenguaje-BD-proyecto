/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Dao.PrestamoDao;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Prestamo;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jason
 */
@Service
public class PrestamoServiceImpl implements PrestamoService{
    
    @Autowired
    PrestamoDao prestamoDao;

    @Override
    public void crearPrestamo(Prestamo prestamo) {
        prestamoDao.crearPrestamo(prestamo.getCedula(), prestamo.getLibroID(), prestamo.getFechaInicio(), prestamo.getFechaDevolucionPrevista(), prestamo.getEstadoPrestamo());

    }
    
}
