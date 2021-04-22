package Objs;

public class Pelicula
{
    private String titulo, sinops, pais, genero, audiencia;
    private int duracion, fecha, copias;
    /**hacer el dato copia como static/final: y un contador, quitaria la funcion*/

    public Pelicula() {}

    public Pelicula(String titulo, String genero, int fecha, String pais, int duracion, int copias, String audiencia, String sinops)
    {
        this.titulo = titulo;
        this.genero = genero;
        this.fecha = fecha;
        this.pais = pais;
        this.duracion = duracion;
        this.copias = copias;
        this.audiencia = audiencia;
        this.sinops = sinops;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void modificarCopia(int mod) /**-1 o 1*/
    {
        copias=copias+mod;
    }

    @Override
    public String toString() {
        return ">Titulo: \"" + titulo +
                "\n>Genero: " + genero +
                "\".\n>Año: "+ fecha +
                ".\n>Pais: "+ pais +
                ".\n>Duracion: "+ duracion +
                ".\n>Copias:"+ copias +
                ".\n>Clasificación: "+ audiencia +
                ".\n>Descripcion: "+ sinops;
    }
}