package com.PBIBLIOTECA.PBIBLIOTECA.Service.ServiceImplementacion;

import com.PBIBLIOTECA.PBIBLIOTECA.DTO.UsuarioDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private HttpSession httpSession;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8);

    public String login(int cedula, String contrasena) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Login.IniciarSesionYObtenerUsuario");
        query.registerStoredProcedureParameter("p_cedula", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_contrasena", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_result", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("p_contrasena_almacenada", String.class, ParameterMode.OUT);

        query.setParameter("p_cedula", cedula);
        query.setParameter("p_contrasena", contrasena);

        query.execute();

        Integer loginSuccessful = (Integer) query.getOutputParameterValue("p_result");
        String contrasenaAlmacenada = (String) query.getOutputParameterValue("p_contrasena_almacenada");

        if (loginSuccessful != null && loginSuccessful == 1) {
            if (contrasenaAlmacenada != null && passwordEncoder.matches(contrasena, contrasenaAlmacenada)) {
                StoredProcedureQuery userDataQuery = entityManager.createStoredProcedureQuery("Login.ObtenerDatosUsuario");
                userDataQuery.registerStoredProcedureParameter("p_cedula", Integer.class, ParameterMode.IN);
                userDataQuery.registerStoredProcedureParameter("p_roles", ResultSet.class, ParameterMode.REF_CURSOR);

                userDataQuery.setParameter("p_cedula", cedula);

                List<Object[]> userRolesList = new ArrayList<>();

                try (ResultSet resultSet = (ResultSet) userDataQuery.getOutputParameterValue("p_roles")) {
                    while (resultSet.next()) {
                        Object[] userRoles = new Object[6]; // Ajusta el tamaño según la cantidad de columnas
                        userRoles[0] = resultSet.getInt("CEDULA");
                        userRoles[1] = resultSet.getString("NOMBRE");
                        userRoles[2] = resultSet.getString("APELLIDO");
                        userRoles[3] = resultSet.getString("EMAIL");
                        userRoles[4] = resultSet.getString("CONTRASENA");
                        userRoles[5] = resultSet.getString("ROL_NOMBRE");

                        userRolesList.add(userRoles);
                    }
                } catch (SQLException e) {
                    // Manejar la excepción según sea necesario
                    e.printStackTrace();
                }

                if (!userRolesList.isEmpty()) {
                    // Almacena la información del usuario en la sesión
                    Object[] userRoles = userRolesList.get(0);

                    UsuarioDto usuario = new UsuarioDto(
                            cedula,
                            (String) userRoles[1], // nombre
                            (String) userRoles[2], // apellido
                            (String) userRoles[3], // email
                            (String) userRoles[4], // contrasena
                            (String) userRoles[5]  // rolNombre
                    );

                    httpSession.setAttribute("usuario", usuario);
                    httpSession.setMaxInactiveInterval(1800);

                    return "Inicio de sesión exitoso";
                } else {
                    return "Error al obtener roles del usuario";
                }
            } else {
                return "Contraseña incorrecta";
            }
        } else {
            return "Credenciales incorrectas";
        }
    }

    public boolean hasPermission(String requiredRole) {
        UsuarioDto usuario = (UsuarioDto) httpSession.getAttribute("usuario");

        if (usuario != null) {
            String userRole = usuario.getRolNombre();
            return userRole.equals(requiredRole);
        }

        return false;
    }

    public UsuarioDto getUsuarioFromSession() {
        return (UsuarioDto) httpSession.getAttribute("usuario");
    }

    public boolean isUserRolePresent() {
        UsuarioDto usuario = (UsuarioDto) httpSession.getAttribute("usuario");

        return usuario != null && usuario.getRolNombre() != null;
    }
}
