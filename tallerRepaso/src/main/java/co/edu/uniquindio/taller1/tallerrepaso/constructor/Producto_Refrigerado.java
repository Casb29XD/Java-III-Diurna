package co.edu.uniquindio.taller1.tallerrepaso.constructor;

public class Producto_Refrigerado extends Producto{
    private int codigoAprobacion;
    private float temperaturaRecomendada;

    public Producto_Refrigerado(int codigo, String nombre, String descripcion, float valorUnitario, int cantidadExistente, String tipoProducto, int codigoAprobacion, float temperaturaRecomendada) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistente, tipoProducto);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public int getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(int codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public float getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public void setTemperaturaRecomendada(float temperaturaRecomendada) {
        this.temperaturaRecomendada = temperaturaRecomendada;
    }
}
