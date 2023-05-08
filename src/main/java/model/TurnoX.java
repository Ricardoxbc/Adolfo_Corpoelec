/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

/**
 *
 * @author Ricardo Bermudez
 */
public class TurnoX {

    public static enum Descanso {
        LM,
        MM,
        MJ,
        JV,
        VS,
        SD,
        DL
    }

    public static enum Turno {
        D,
        N,
        M
    }

    private Long id;
    private Turno[] turnos = new Turno[5];
    private Descanso descanso;
    private LocalDate inicioTurnoX, finTurnoX;

    public TurnoX() {

    }

    public TurnoX(Turno[] turnos, Descanso descanso, LocalDate inicioTurnoX) {
        this.turnos = turnos;
        this.descanso = descanso;
        this.inicioTurnoX = inicioTurnoX.minusDays(inicioTurnoX.getDayOfMonth() - 1);
        LocalDate dateAux = inicioTurnoX.plusMonths(1);
        this.finTurnoX = dateAux.minusDays(dateAux.getDayOfMonth());
//        Arrays.fill(turnos, null);
    }

    public Long getId() {
        return id;
    }

    public TurnoX setId(Long id) {
        this.id = id;
        return this;
    }

    public Turno[] getTurnos() {
        return turnos;
    }

    public TurnoX setTurnos(Turno[] turno) {
        this.turnos = turno;
        return this;
    }

    public Descanso getDescanso() {
        return descanso;
    }

    public TurnoX setDescanso(Descanso descanso) {
        this.descanso = descanso;
        return this;
    }

    public LocalDate getInicioTurnoX() {
        return inicioTurnoX;
    }

    public TurnoX setInicioTurnoX(LocalDate inicioTurnoX) {
        this.inicioTurnoX = inicioTurnoX.minusDays(inicioTurnoX.getDayOfMonth() - 1);
        LocalDate dateAux = inicioTurnoX.plusMonths(1);
        this.finTurnoX = dateAux.minusDays(dateAux.getDayOfMonth());
        return this;
    }

    public LocalDate getFinTurnoX() {
        return finTurnoX;
    }
//
//    public TurnoX setFinTurnoX(LocalDate finTurnoX) {
//        this.finTurnoX = finTurnoX;
//        return this;
//    }

}
