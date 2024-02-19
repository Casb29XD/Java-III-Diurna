package co.edu.uniquindio.taller1.tallerrepaso.constructor;

public class Cliente_Juridica extends Cliente {
    int nit;

    public Cliente_Juridica(String nombre, String apellido, int identificacion, String direccion, int telefono, String tipo_Cliente, int nit) {
        super(nombre, apellido, identificacion, direccion, telefono, tipo_Cliente);
        this.nit = nit;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
}
