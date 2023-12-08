package com.PBIBLIOTECA.PBIBLIOTECA.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Devolucion")
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEVOLUCIONID")
    private Long devolucionId;

    @Column(name = "PRESTAMOID")
    private Long prestamoId;

    @Column(name = "FECHADEVOLUCION")
    private Date fechaDevolucion;

    @Column(name = "USUARIOCEDULA")
    private Long usuarioCedula;

    @Column(name = "LIBROID")
    private Long idlibro;

    @Column(name = "OBSERVACIONES")
    private String observaciones;;



}
