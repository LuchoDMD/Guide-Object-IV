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

    public void agregarCliente(Cliente cliente)
    {
        clientes.add(cliente);
    }

    public void agregarPelicula(Pelicula pelicula)
    {
        peliculas.add(pelicula);
    }

    public void consultarAlquileres()
    {
        for (Boleta aux:boletas)
        {
            System.out.println(aux);
        }
    }

    public void consultarAlquilerXdia()
    {
        LocalDate hoy = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        for(Boleta aux : boletas)
        {
            if(aux.getDevolucion().isEqual(hoy))
            {
                System.out.println(aux);
            }
        }
    }

    /**ALQUILERES VIGENTES*/


    public Pelicula buscarPelicula(String titulo)
    {
        for (Pelicula p: peliculas)
        {
            if(titulo.equals(p.getTitulo()))
            {
                return p;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String cliente)/**Nombre y Apellido*/
    {
        for(Cliente c : clientes)
        {
            if(cliente.equals(c.getNombre()))
            {
                return c;
            }
        }
        return null;
    }

    public void retirarPelicula(ArrayList<Pelicula>pelis)
    {
        for(Pelicula m : pelis)
        {
            for (Pelicula p : peliculas)
            {
                if(m.getTitulo().equals(p.getTitulo()))
                {
                    if(p.getStock()>1)
                    {
                        p.modificarStock(-1);
                    }
                }
            }
        }
    }

    public void devolverPelicula(ArrayList<Pelicula>pelis)
    {
        for(Pelicula m : pelis)
        {
            for (Pelicula p : peliculas)
            {
                if(m.getTitulo().equals(p.getTitulo()))
                {
                    if(p.getStock()>1)
                    {
                        p.modificarStock(1);
                    }
                }
            }
        }
    }

    public void alquilar(ArrayList<Pelicula>pelis, Cliente cliente)
    {
        retirarPelicula(pelis);
        Boleta boleta=new Boleta(cliente,peliculas);
        cliente.agregarBoleta(boleta);
        boletas.add(boleta);
    }

    public void devolver(Boleta boleta)
    {
        devolverPelicula(boleta.getAlquiladas());
    }
}
/**
 * ● Quiere una forma de poder consultar los alquileres vigentes.X
 * ● Quiere una forma de poder consultar las devoluciones que deberían hacerse en el dia de la fecha.V
 * ● Quiere poder consultar los últimos 10 alquileres de cada cliente.V
 * ● Quiere una forma de consultar los títulos que fueron más alquilados.X
 * ● También quiere poder buscar títulos por género y ordenarlos según popularidad.X
 * ● Quiere poder ver información detallada de un determinado título.V*/