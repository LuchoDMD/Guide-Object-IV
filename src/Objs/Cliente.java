package Objs;

import java.util.ArrayList;

public  class Cliente {
    private String nombre;
    private String apellido;
    private  int telefono;
    private String direccion;
    private ArrayList<Boleta> boleta;


    public Cliente() {
        boleta=new ArrayList<>();
    }

    public Cliente(String nombre, String apellido, int telefono, String direccion) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre + " " + apellido;
    }

    public void peliculaAlquilada(Boleta boleta){
        this.boleta.add(boleta);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("Nombre= ").append(nombre);
        sb.append(", Apellido= ").append(apellido);
        sb.append(", Telefono= ").append(telefono);
        sb.append(", Direccion= ").append(direccion);
        return sb.toString();
    }
}
