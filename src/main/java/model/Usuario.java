
package model;

import java.util.Objects;

/**
 *
 * @author Ricardo Bermudez
 */
public class Usuario {
    
    private Long id;
    private String cedula, contrasenia;
    private Integer acceso;
    
    private String nombre, apellido;

    private String cargo;
    private String turno;
    private final int[] descanso = new int[3];
    
    private TurnoX horario;
    private Long horarioId;
    
    public Usuario() {
    }

    public Usuario(Long id, String cd, String contrasenia, Integer acceso) {
        this.id = id;
        this.cedula = cd;
        this.contrasenia = contrasenia;
        this.acceso = acceso;
    }

    public Long getId() {
        return id;
    }

    public Usuario setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getHorarioId() {
        return horarioId;
    }

    public Usuario setHorarioId(Long horarioId) {
        this.horarioId = horarioId;
        return this;
    }
    
    public TurnoX getHorario() {
        return horario;
    }

    public Usuario setHorario(TurnoX horario) {
        this.horario = horario;
        return this;
    }
    
    public String getCedula() {
        return cedula;
    }

    public Usuario setCedula(String cd) {
        this.cedula = cd;
        return this;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Usuario setContrasenia(String pass) {
        this.contrasenia = pass;
        return this;
    }

    public Integer getAcceso() {
        return acceso;
    }

    public Usuario setAcceso(Integer acceso) {
        this.acceso = acceso;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Usuario setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getCargo() {
        return cargo;
    }

    public Usuario setCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public String getTurno() {
        return turno;
    }

    public Usuario setTurno(String turno) {
        this.turno = turno;
        return this;
    }

    public int[] getDescanso() {
        return descanso;
    }
    
    public Usuario setDescanso(int mes, int dia1, int dia2) {
        descanso[0] = mes;
        descanso[1] = dia1;
        descanso[2] = dia2;
        return this;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", cedula=" + cedula + ", acceso=" + acceso + ", nombre=" + nombre + ", apellido=" + apellido + ", cargo=" + cargo + ", turno=" + turno + ", descanso=" + descanso + ", horarioId=" + horarioId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
