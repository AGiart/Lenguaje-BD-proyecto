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
@Table(name="LIBROS")
public class Libro {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private Long bookID;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "AutorID")
    private Long autorID;

    @Column(name = "GeneroID")
    private Long generoID;

    @Column(name = "EditorialID")
    private Long editorialID;

    @Column(name = "IdiomaID")
    private Long idiomaID;

    @Column(name = "AnioPublicacion")
    private Integer anioPublicacion;

    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "CantidadCopiasDisponibles")
    private Integer cantidadCopiasDisponibles;

    
}
