package Jair.rh.cotrolador;

import Jair.rh.exepcion.RecursoNoEncontradoExepcion;
import Jair.rh.modelo.Empleado;
import Jair.rh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Empleado agregarEmpleado(@RequestBody Empleado empleado) {
        logger.info("Empleado a agregar " + empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Integer id) {
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if (empleado == null)
            throw new RecursoNoEncontradoExepcion("No se encontró el empleado con id " + id);
        return ResponseEntity.ok(empleado);
    }
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Empleado> eliminarEmpleado(@PathVariable Integer id){
        Empleado empleado=empleadoServicio.buscarEmpleadoPorId(id);
        empleadoServicio.eliminarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }
}
