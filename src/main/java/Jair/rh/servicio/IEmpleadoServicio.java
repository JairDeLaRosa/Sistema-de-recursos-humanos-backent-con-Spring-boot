package Jair.rh.servicio;

import Jair.rh.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listarEmpleado();
    public Empleado buscarEmpleadoPorId(Integer idEmpleado);
    public Empleado guardarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Empleado empleado);
}
