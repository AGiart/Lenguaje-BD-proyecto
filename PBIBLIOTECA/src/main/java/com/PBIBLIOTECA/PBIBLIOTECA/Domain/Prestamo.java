/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PBIBLIOTECA.PBIBLIOTECA.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author jason
 */
@Entity
@Data
@Table(name="Prestamo")
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PrestamoID")
    private Long prestamoId;

    @Column(name = "usuarioCedula")
    private Long usuarioCedula;
    
    @Column(name = "libroId")
    private Long libroId;;
    
    @Column(name = "fechaPrestamo")
    private Date fechaPrestamo;
    
    @Column(name = "fechaDevolucion")
    private Date fechaDevolucion;
    

    
    
    
    
     
    
    
    
    
    
}
