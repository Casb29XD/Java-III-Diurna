package co.edu.uniquindio.taller1.tallerrepaso.constructor;

public class Producto_Envasado extends Producto{
    private String fechaEnvasado;
    private float pesoEnvase;
    private String paisOrigen;

    public Producto_Envasado(int codigo, String nombre, String descripcion, float valorUnitario, int cantidadExistente, String tipoProducto, String fechaEnvasado, float pesoEnvase, String paisOrigen) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistente, tipoProducto);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public float getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(float pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
