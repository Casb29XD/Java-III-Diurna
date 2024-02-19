package co.edu.uniquindio.taller1.tallerrepaso.constructor;

public class Producto_Perecedero extends Producto{
    private String fechaVencimiento;

    public Producto_Perecedero(int codigo, String nombre, String descripcion, float valorUnitario, int cantidadExistente, String tipoProducto, String fechaVencimiento) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistente, tipoProducto);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String ToString(){
        return fechaVencimiento;
    }
}
