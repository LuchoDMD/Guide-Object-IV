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
    private Cliente cliente;
    private ArrayList<Pelicula> alquiladas;
    private boolean vigencia=true;


    public Boleta()
    {
        cliente = new Cliente();
        alquiladas= new ArrayList<>();
    }

    public Boleta(Cliente cliente,ArrayList<Pelicula>alquiladas)
    {
        this.cliente=cliente;
        this.alquiladas=alquiladas;
    }

    public static String getDevolucion()
    {
        return devolucion;
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

    public void setVigente()
    {
        vigencia=false;
    }

    public boolean getVigente()
    {
        return vigencia;
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
