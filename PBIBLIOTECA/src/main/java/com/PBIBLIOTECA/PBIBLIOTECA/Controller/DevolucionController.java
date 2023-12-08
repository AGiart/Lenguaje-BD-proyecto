package com.PBIBLIOTECA.PBIBLIOTECA.Controller;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.PBIBLIOTECA.PBIBLIOTECA.Domain.Devolucion;
import com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion.DevolucionServiceImpl;

@RequestMapping("/devolucion")
@Controller
public class DevolucionController {

    @Autowired
    private DevolucionServiceImpl devolucionServiceImpl;

    @GetMapping("/listado")
    public String verDevoluciones(Model model) {

        var devolucion =  devolucionServiceImpl.obtenerDevoluciones();
        model.addAttribute("devolucion", devolucion);

        return "/Devoluciones/listado";

    }









    @GetMapping("/registrarDevolucion/{Prestamo}/{Cedula}/{idlibro}")
    public String formularioCreacion(
            @PathVariable("Prestamo") Long prestamo,
            @PathVariable("Cedula") Long cedula,
            @PathVariable("idlibro") Long idlibro,
            Model model) {

        model.addAttribute("prestamo", prestamo);
        model.addAttribute("cedula", cedula);
        model.addAttribute("idlibro", idlibro);

        return "/Devoluciones/crearDevolucion";
    }

    @PostMapping("/guardarDevolucion")
    public String guardarDevolucion(
            @RequestParam("cedula") Long cedula,
            @RequestParam("prestamoId") Long prestamoId,
            @RequestParam("Observaciones") String Observaciones,
            @RequestParam("idlibro") Long idlibro,  // Cambiado a 'libroID'
            Devolucion devolucion
    ){
        Long a = Long.valueOf(141);
        devolucion.setPrestamoId(prestamoId);
        devolucion.setUsuarioCedula(cedula);
        devolucion.setObservaciones(Observaciones);
        devolucion.setIdlibro(idlibro);
        devolucionServiceImpl.crearDevolucion(devolucion);

        return "redirect:/prestamos/listado";
    }
}
