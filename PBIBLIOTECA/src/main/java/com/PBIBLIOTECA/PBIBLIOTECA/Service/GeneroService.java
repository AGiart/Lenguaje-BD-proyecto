/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Genero;
import java.util.List;

/**
 *
 * @author jason
 */
public interface GeneroService {
    
    List<Genero>obtenerGeneros();
    
    public void insertarGeneros(Genero genero);
    
    public void eliminarGeneroPorId(Long id);
    
    public void actualizarGenero(Genero genero);
    
}
