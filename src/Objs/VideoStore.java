package Objs;

import java.util.ArrayList;

public class VideoStore
{
    ArrayList<Cliente> clientes;
    ArrayList<Pelicula> peliculas;
    ArrayList<Boleta> boletas;

    public VideoStore(){
        clientes = new ArrayList<>();
        peliculas = new ArrayList<>();
        boletas = new ArrayList<>();
    }

    public void consultarAlquileres(){/**NOMBRE SUJETO A MODIFICACION*/
        for (Boleta aux:boletas) {
            System.out.println(aux);
        }
    }

    public void consultarXdia(){

    }


}
/**
 * ● Quiere una forma de poder consultar los alquileres vigentes.
 * ● Quiere una forma de poder consultar las devoluciones que deberían hacerse en el dia de la fecha.
 * ● Quiere poder consultar los últimos 10 alquileres de cada cliente.
 * ● Quiere una forma de consultar los títulos que fueron más alquilados.
 * ● También quiere poder buscar títulos por género y ordenarlos según popularidad.
 * ● Quiere poder ver información detallada de un determinado título.*/