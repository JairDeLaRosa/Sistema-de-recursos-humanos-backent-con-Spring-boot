package Jair.rh.cotrolador;

import Jair.rh.modelo.Empleado;
import Jair.rh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("rh")
@CrossOrigin(value = "http://localhost:5173")
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);
    @Autowired
    private IEmpleadoServicio empleadoServicio;

    // http://localhost:8080/rh/empleados
    @GetMapping("/empleados")
    public List<Empleado> optenerEmpleados() {
        var empleados = empleadoServicio.listarEmpleado();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return empleados;
    }
    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a agregar "+empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }


}
