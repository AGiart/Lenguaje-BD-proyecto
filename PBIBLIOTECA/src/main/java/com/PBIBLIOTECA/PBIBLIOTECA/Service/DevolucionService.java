package com.PBIBLIOTECA.PBIBLIOTECA.Service;

import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Devolucion;
import java.util.List;
public interface DevolucionService {

    public void crearDevolucion(Devolucion devolucion);

    public List<Devolucion>obtenerDevoluciones();


}
