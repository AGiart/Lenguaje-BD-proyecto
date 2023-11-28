/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Service;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Editorial;
import java.util.List;

/**
 *
 * @author jason
 */
public interface EditorialService {
    
    public List<Editorial>obtenerEditoriales();
    
    public void save(Editorial editorial);
    
}
