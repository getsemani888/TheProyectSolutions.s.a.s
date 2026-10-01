package com.theprojectsolutions.modelo;

public class Proyecto {

    private int idProyecto;
    private String nombre;
    private String cliente;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    private double presupuesto;

    public Proyecto() {
    }

    public Proyecto(int idProyecto, String nombre, String cliente, String fechaInicio, String fechaFin, String estado, double presupuesto) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.presupuesto = presupuesto;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "id=" + idProyecto + ", nombre=" + nombre + ", cliente=" + cliente
                + ", inicio=" + fechaInicio + ", fin=" + fechaFin
                + ", estado=" + estado + ", presupuesto=" + presupuesto + '}';
    }
}
