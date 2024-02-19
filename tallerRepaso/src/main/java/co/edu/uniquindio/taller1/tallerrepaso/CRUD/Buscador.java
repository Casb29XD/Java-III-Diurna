package co.edu.uniquindio.taller1.tallerrepaso.CRUD;

import co.edu.uniquindio.taller1.tallerrepaso.constructor.*;

import java.util.ArrayList;

public class Buscador {
    Crud_ProductoPerecedero crudProductoPerecederos= new Crud_ProductoPerecedero();

    public Integer buscadarJuridico(int indetificacion){
        int pos=-1;
        ArrayList<Cliente_Juridica> clienteJuridicas= Crud_clienteJuridico.leer_Cjuridica();
        for (int i=0;i<clienteJuridicas.size(); i++){
            if (indetificacion == clienteJuridicas.get(i).getIdentificacion()){
                pos=i;
                break;
            }
        }
        return pos;
    }
    public Integer buscadarClienteNormal(int indetificacion){
        int pos=-1;
        ArrayList<Cliente_Natural> clienteNaturals= Crud_clienteNormal.leerClienteNatural();
        for (int i=0;i<clienteNaturals.size(); i++){
            if (indetificacion == clienteNaturals.get(i).getIdentificacion()){
                pos=i;
                break;
            }
        }
        return pos;
    }
    public Integer buscadarProductoPerecedero(int codigo){
        int pos=-1;
        ArrayList<Producto_Perecedero> productoPerecederos= crudProductoPerecederos.leer_productoPerecedero();
        for (int i=0;i<productoPerecederos.size(); i++){
            if (codigo == productoPerecederos.get(i).getCodigo()){
                pos=i;
                break;
            }
        }
        return pos;
    }
    public Integer buscarProductosRefrigerados(int codigo){
        int pos=-1;
        ArrayList<Producto_Refrigerado> productoRefrigerados = Crud_ProductoRefigerado.leer_productoRefrigerados();
        for (int i=0;i<productoRefrigerados.size(); i++){
            if (codigo == productoRefrigerados.get(i).getCodigo()){
                pos=i;
                break;
            }
        }
        return pos;
    }
    public Integer buscarProductoEnvasado(int codigo){
        int pos=-1;
        ArrayList<Producto_Envasado> productoEnvasados= Crud_ProductoEnvasado.leer_productoEnvasados();
        for (int i=0;i<productoEnvasados.size(); i++){
            if (codigo == productoEnvasados.get(i).getCodigo()){
                pos=i;
                break;
            }
        }
        return pos;
    }

}
