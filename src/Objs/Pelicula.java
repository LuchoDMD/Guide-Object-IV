package Objs;

public class Pelicula
{
    private String titulo, sinops, pais, genero, audiencia;
    private int duracion, fecha, stock, vista;/*Esta esta relacionada con la popularidad*/
    /**hacer el dato copia como static/final: y un contador, quitaria la funcion*/

    public Pelicula() {}

    public Pelicula(String titulo, String genero, int fecha, String pais, int duracion, int stock, String audiencia, String sinops)
    {
        this.titulo = titulo;
        this.genero = genero;
        this.fecha = fecha;
        this.pais = pais;
        this.duracion = duracion;
        this.stock = stock;
        this.audiencia = audiencia;
        this.sinops = sinops;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public int getStock()
    {
        return stock;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void modificarStock(int mod)
    {
        stock=stock+mod;
    }

    @Override
    public String toString() {
        return ">Titulo: \"" + titulo +
                "\n>Genero: " + genero +
                "\".\n>Año: "+ fecha +
                ".\n>Pais: "+ pais +
                ".\n>Duracion: "+ duracion +
                ".\n>Copias:"+ stock +
                ".\n>Clasificación: "+ audiencia +
                ".\n>Descripcion: "+ sinops;
    }
}