package model;

public class User {
    private String nombre;
    private int estado;
    private int id;

    public String getNombre() {
        return nombre;
    }

    public int getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
