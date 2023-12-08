package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.Dao.DevolucionDao;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Devolucion;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.DevolucionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevolucionServiceImpl implements DevolucionService{
    @Autowired
    DevolucionDao devolucionDao;


    @Autowired
    private EntityManager entityManager;


    public void crearDevolucion(Devolucion devolucion){

        devolucionDao.crearDevolucion(devolucion.getPrestamoId(),  devolucion.getUsuarioCedula(),devolucion.getIdlibro(),devolucion.getObservaciones());


    }

    @Override
    public List<Devolucion> obtenerDevoluciones() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GESTION_DEVOLUCIONES.ObtenerDatosDevolucionesProcedimiento");
        query.registerStoredProcedureParameter("p_resultado", void.class, ParameterMode.REF_CURSOR);
        query.execute();

        return query.getResultList();
    }





}
