/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Autor;
import java.util.List;

/**
 *
 * @author jason
 */
public interface AutorService {
    
    
    public List<Autor> obtenerAutores();
    
    public void savelibros(Autor autor);
    
    public void eliminarAutorPorId(Long id);
    
    public void actualizarAutor(Autor autor);
    
    public List<Autor>  obtenerAutorID(Long id);
    
    
    
}
