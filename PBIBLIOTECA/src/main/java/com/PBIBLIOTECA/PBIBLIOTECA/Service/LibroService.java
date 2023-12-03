/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Libro;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.OutParameter;
import java.util.List;

/**
 *
 * @author jason
 */
public interface LibroService {
    
    public void saveLibro(Libro libro);
    
    public List<OutParameter> obtenerInformacionLibros();
    
    public List<OutParameter> obtenerLibroPorTitulo(String titulo);
    
    public List<OutParameter> obtenerLibroIdPorTitulo(String titulo);
    
    public void actualizarLibro(Libro libro);
    
    public void eliminarLibroPorId(Long id);
    
    
    
}
