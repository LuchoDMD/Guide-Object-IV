package Objs;

import java.time.LocalDate;
import java.util.ArrayList;

public  class Cliente {
    private String nombre;
    private String apellido;
    private  int telefono;
    private String direccion;
    private ArrayList<Boleta> boletas;
    private static int lBoleta=10;


    public Cliente() {
        boletas=new ArrayList<>();
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

    public void agregarBoleta(Boleta boleta)
    {
        if(boletas.size()<lBoleta)
        {
            this.boletas.add(boleta);
        }else
            {
                boletas.remove(0);
                agregarBoleta(boleta);
            }
    }


    public String mostrarBoletas()
    {
        String rta="";
        for(Boleta b : boletas)
        {
            rta=rta+"["+b.toString()+"]\n";
        }
        return rta;
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
