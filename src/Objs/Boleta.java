package Objs;

import java.time.LocalDate;;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Boleta
{
    /**Formato dd/mm/aaaa*/
    private static final String retiro= LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    private static final String devolucion= LocalDate.now().plusDays(7).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    private ArrayList<Pelicula> alquiladas;
    private Cliente cliente;

    public Boleta(){
        alquiladas= new ArrayList<>();
        cliente = new Cliente();
    }

    private String listaPeliculas()
    {
        String rta="";
        for (Pelicula peli : alquiladas)
        {
            rta=rta+"[ \""+peli.getTitulo()+"\" ]\n";
        }
        return rta;
    }

    @Override
    public String toString()
    {
        return "\n>Retiro: "+retiro+
                "\n>Devolucion: "+devolucion+
                "\n>Cliente: "+cliente.getNombre()+
                "\n>Peliculas: \n"+listaPeliculas();
    }
}
