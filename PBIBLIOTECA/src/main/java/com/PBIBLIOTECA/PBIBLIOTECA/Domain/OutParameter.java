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
@Data
@Entity
@Table(name="LIBROS")
public class OutParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookID")
    private Long bookID;

    @Column(name = "titulo")
    private String titulo;

   

    @Column(name = "GeneroID")
    private String generoID;

    @Column(name = "EditorialID")
    private String editorialID;

    @Column(name = "IdiomaID")
    private String idiomaID;
    


    

    @Column(name = "ISBN")
    private String ISBN;

   
}