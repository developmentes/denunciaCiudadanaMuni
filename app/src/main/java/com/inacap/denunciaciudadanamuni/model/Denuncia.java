package com.inacap.denunciaciudadanamuni.model;

public class Denuncia {

    public String titulo;
    public String direccion;
    public String estado;
    public Denuncia(){

    }

    public Denuncia(String titulo, String direccion, String estado) {
        this.titulo = titulo;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}



