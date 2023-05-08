package model;

/**
 *
 * @author Ricardo Bermudez
 */
public class Horario {

    private Usuario usuario;
    private TurnoX turno;

    public Horario() {
    }

    public Horario(Usuario usuario, TurnoX turno) {
        this.usuario = usuario;
        this.turno = turno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Horario setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public TurnoX getTurno() {
        return turno;
    }

    public Horario setTurno(TurnoX turno) {
        this.turno = turno;
        return this;
    }

}
