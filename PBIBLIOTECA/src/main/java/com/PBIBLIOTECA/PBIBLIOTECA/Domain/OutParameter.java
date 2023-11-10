/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Domain;

import lombok.Data;

/**
 *
 * @author jason
 */
@Data
public class OutParameter {
    
    private String titulo;
    private String nombreAutor;
    private String nombreGenero;
    private String nombreEditorial;
    private String nombreIdioma;
    private int anioPublicacion;
    private String isbn;
    private int cantidadCopiasDisponibles;
    
    
    
}
