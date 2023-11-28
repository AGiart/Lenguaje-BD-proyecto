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
import lombok.Data;

/**
 *
 * @author jason
 */
@Entity
@Data
@Table(name="Prestamos")
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOANID")
    private Long loanID;

    @Column(name = "CEDULA")
    private Long Cedula;
    
    @Column(name = "BOOKID")
    private String libroID;
    
    @Column(name = "FECHAINICIO")
    private String fechaInicio;
    
    @Column(name = "FECHADEVOLUCIONPREVISTA")
    private String fechaDevolucionPrevista;
    
    @Column(name = "ESTADOPRESTAMO")
    private String estadoPrestamo;
    
    
}
