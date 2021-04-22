package Objs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class VideoStore
{
    ArrayList<Cliente> clientes;
    ArrayList<Pelicula> peliculas;
    ArrayList<Boleta> boletas;

    public VideoStore()
    {
        clientes = new ArrayList<>();
        peliculas = new ArrayList<>();
        boletas = new ArrayList<>();
    }

    public void consultarAlquileres()
    {
        for (Boleta aux:boletas)
        {
            System.out.println(aux);
        }
    }

    public void consultarXdia()
    {
        String hoy = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        for(Boleta aux : boletas)
        {
            if(aux.getDevolucion().equals(hoy))/**aux.getDevolucion() == hoy O con el equals()*/
            {
                System.out.println(aux);
            }
        }
    }

    public void alquileresVigentes()
    {
        String hoy = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        for(Boleta aux: boletas)
        {
            if(aux.getVigente())
            {
                System.out.println(aux);
            }
        }
    }

    public int existePelicula(String peli)
    {
        for (Pelicula p: peliculas)
        {
            if(peli.equals(p.getTitulo()))
            {
                return peliculas.indexOf(peli);
            }
        }
        return -1;
    }

    public int existeCliente(String cliente)/**Nombre y Apellido*/
    {
        for(Cliente c : clientes)
        {
            if(cliente.equals(c.getNombre()))
            {
                return clientes.indexOf(cliente);
            }
        }
        return -1;
    }

    public void tomarPelicula(ArrayList<Pelicula>pelis)
    {
        for(Pelicula m : pelis)
        {
            for (Pelicula p : peliculas)
            {
                if(m.getTitulo().equals(p.getTitulo()))
                {
                    int index=peliculas.indexOf(p);
                    if(p.getStock()>1)
                    {
                        p.modificarStock(-1);
                    }
                    /**remover p peliculas con el index add el p modificado a peliculas*/
                }
            }
        }
    }

    public void alquilar(ArrayList<Pelicula>peliculas, Cliente cliente)
    {

        Boleta boleta=new Boleta(cliente,peliculas);
        cliente.peliculaAlquilada(boleta);
        boletas.add(boleta);
    }

    public void devolver(ArrayList<Pelicula>peliculas, Cliente cliente, Boleta boleta)
    {

    }


}
/**
 * ● Quiere una forma de poder consultar los alquileres vigentes.
 * ● Quiere una forma de poder consultar las devoluciones que deberían hacerse en el dia de la fecha.
 * ● Quiere poder consultar los últimos 10 alquileres de cada cliente.
 * ● Quiere una forma de consultar los títulos que fueron más alquilados.
 * ● También quiere poder buscar títulos por género y ordenarlos según popularidad.
 * ● Quiere poder ver información detallada de un determinado título.*/