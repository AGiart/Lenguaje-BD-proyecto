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
@Table(name="Multas")
public class Multa {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MULTAID")
    private Long multaID;

    @Column(name = "PRESTAMOID")
    private Long prestamoId;
    
    @Column(name = "USUARIOCEDULA")
    private Long usuarioCedula;;
    
    @Column(name = "MONTO")
    private int monto;
    
    @Column(name = "FECHACREACION")
    private Date fechaCreacion;
    
    @Column(name = "ESTADO")
    private String fechaDevolucion;
    
    
}
