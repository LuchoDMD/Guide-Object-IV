package Objs;

import java.time.LocalDate;;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Boleta
{
    /**Formato dd/mm/aaaa*/
    private static final String retiro= LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    private static final String devolucion= LocalDate.now().plusDays(7).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    @Override
    public String toString()
    {
        return "[ Retiro: "+retiro+" - Devolucion: "+devolucion+" ]";
    }
}
