package Objs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;


public class VideoStore {
    ArrayList<Cliente> clientes;
    ArrayList<Pelicula> peliculas;
    ArrayList<Boleta> boletas;

    public VideoStore() {
        clientes = new ArrayList<>();
        peliculas = new ArrayList<>();
        boletas = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void consultarAlquileres() {
        for (Boleta aux : boletas) {
            System.out.println(aux);
        }
    }

    public void consultarAlquilerXdia ()
    {
        LocalDate hoy = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        for (Boleta aux : boletas) {
            if (aux.getDevolucion().isEqual(hoy)) {
                    System.out.println(aux);
            }
        }
    }

        /**ALQUILERES VIGENTES*/


        public Pelicula buscarPelicula (String titulo)
        {
            for (Pelicula p : peliculas) {
                if (titulo.equals(p.getTitulo())) {
                    return p;
                }
            }
            return null;
        }


    /**GENERA UN ARRAYLIST LOCAL CON LAS PELICULAS POR GENERO Y LO DEVUELVE, ASI SE PUEDE PRINTEAR CON SOUT EN EL MAIN*/
        public ArrayList peliculasXgenero (String genero)
        {
            ArrayList<Pelicula> peliculasXgenero=new ArrayList<>();
            for (Pelicula p  : peliculas){
                if(genero.equals(p.getGenero())){
                    peliculasXgenero.add(p);
                }
            }
            return peliculasXgenero;
        }
    /**encontre esta forma de ordenar en internet y funciona, ahora esta puesto con la duracion para probarlo link: https://jarroba.com/ordenar-un-arraylist-en-java/*/
        public void ordenarXPopularidad(){
            Collections.sort(peliculas, new Comparator<Pelicula>() {
                @Override
                public int compare(Pelicula o1, Pelicula o2) {
                    return new Integer(o2.getDuracion()).compareTo(new Integer(o1.getDuracion()));
                }
            });
        }

        public Cliente buscarCliente (String cliente)/**Nombre y Apellido*/
        {
            for (Cliente c : clientes) {
                if (cliente.equals(c.getNombre())) {
                    return c;
                }
            }
            return null;
        }

        public void retirarPelicula (ArrayList < Pelicula > pelis)
        {
            for (Pelicula m : pelis) {
                for (Pelicula p : peliculas) {
                    if (m.getTitulo().equals(p.getTitulo())) {
                        int index = peliculas.indexOf(p);/**Variable index no usada*/
                        if (p.getStock() > 1) {
                            p.modificarStock(-1);
                        }
                    }
                }
            }
        }

        public void devolverPelicula (ArrayList < Pelicula > pelis)
        {
            for (Pelicula m : pelis) {
                for (Pelicula p : peliculas) {
                    if (m.getTitulo().equals(p.getTitulo())) {
                        int index = peliculas.indexOf(p);/**Variable index no usada*/
                        if (p.getStock() > 1) {
                            p.modificarStock(1);
                        }
                    }
                }
            }
        }

        public void alquilar (ArrayList < Pelicula > pelis, Cliente cliente)
        {
            retirarPelicula(pelis);
            Boleta boleta = new Boleta(cliente, peliculas);
            cliente.agregarBoleta(boleta);
            boletas.add(boleta);
        }

        public void devolver (Boleta boleta)
        {

        }
    }

/**
 * ● Quiere una forma de poder consultar los alquileres vigentes.X
 * ● Quiere una forma de poder consultar las devoluciones que deberían hacerse en el dia de la fecha.V
 * ● Quiere poder consultar los últimos 10 alquileres de cada cliente.V
 * ● Quiere una forma de consultar los títulos que fueron más alquilados.X
 * ● También quiere poder buscar títulos por género y ordenarlos según popularidad.X
 * ● Quiere poder ver información detallada de un determinado título.V*/