package Modelos;

public class Estudiante extends Persona {
    public enum Estado {
        MATRICULADO, INACTIVO, GRADUADO
    }

    private Estado estado;

    public Estudiante(int id, String nombre, String apellido, String fechaDeNacimiento, Estado estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
