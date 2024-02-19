package co.edu.uniquindio.taller1.tallerrepaso.constructor;

public class Cliente {
    String nombre;
    String apellido;
    int identificacion;
    String direccion;
    int telefono;
    String tipo_Cliente;

    public Cliente(String nombre, String apellido, int identificacion, String direccion, int telefono, String tipo_Cliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo_Cliente = tipo_Cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTipo_Cliente() {
        return tipo_Cliente;
    }

    public void setTipo_Cliente(String tipo_Cliente) {
        this.tipo_Cliente = tipo_Cliente;
    }
}
