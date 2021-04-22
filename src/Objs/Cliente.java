package Objs;

public  class Cliente {
    private String nombre;
    private String apellido;
    private  int telefono;
    private String direccion;


    public Cliente(String nombre, String apellido, int telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre + apellido;
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
