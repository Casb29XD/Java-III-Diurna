package co.edu.uniquindio.taller1.tallerrepaso.CRUD;

import co.edu.uniquindio.taller1.tallerrepaso.constructor.Producto_Perecedero;

import java.io.*;
import java.util.ArrayList;

public class Crud_ProductoPerecedero {
    static Buscador buscador = new Buscador();
    static String archivo="CRUD_ProduPerecedero.txt";
    public static void guardar_ProductoPerecedero(Producto_Perecedero productoPerecedero){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(archivo,true))) {
            writer.write(productoPerecedero.getCodigo()+";"+ productoPerecedero.getNombre()+";"
                    +productoPerecedero.getDescripcion()+";"+productoPerecedero.getValorUnitario()+";"+
                    productoPerecedero.getCantidadExistente()+";"+productoPerecedero.getTipoProducto()+";"
                    +productoPerecedero.getFechaVencimiento()+"\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Producto_Perecedero> leer_productoPerecedero(){
        ArrayList<Producto_Perecedero> productoPerecederos= new ArrayList<>();
        try (BufferedReader reader= new BufferedReader(new FileReader(archivo))){
            String line;
            while ((line = reader.readLine())!= null){
                String[] dato=line.split(";");
                int codigo=Integer.parseInt(dato[0]);
                String nombre = dato[1];
                String descripcion = dato[2];
                float valorUnitario = Float.parseFloat(dato[3]);
                int cantidadExistente = Integer.parseInt(dato[4]);
                String tipoProducto = dato[5];
                String fechaVencimiento = dato[6];
                productoPerecederos.add(new Producto_Perecedero(codigo,nombre,descripcion,valorUnitario
                        ,cantidadExistente,tipoProducto,fechaVencimiento));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return productoPerecederos;
    }
    public static void actualizar_ProducPerecedero(int codigo, Producto_Perecedero productoPerecedero){
        ArrayList<Producto_Perecedero> productoPerecederos= leer_productoPerecedero();
        int pos= buscador.buscarProductosRefrigerados(codigo);
        if (codigo == productoPerecederos.get(pos).getCodigo()){
            productoPerecederos.set(pos,productoPerecedero);
            guardar_ProductosPeresederos(productoPerecederos);
        }
    }
    public static void eliminar_ProducRegigerado(int codigo){
        ArrayList<Producto_Perecedero> productoPerecederos= leer_productoPerecedero();
        int pos= buscador.buscarProductosRefrigerados(codigo);
        if (codigo == productoPerecederos.get(pos).getCodigo()){
            productoPerecederos.remove(pos);
            guardar_ProductosPeresederos(productoPerecederos);
        }
    }
    public static void guardar_ProductosPeresederos(ArrayList<Producto_Perecedero> productoPerecederos){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(archivo))) {
            for (int i =0; i <productoPerecederos.size();i++){
                writer.write(productoPerecederos.get(i).getCodigo()+";"+ productoPerecederos.get(i).getNombre()+";"
                        +productoPerecederos.get(i).getDescripcion()+";"+productoPerecederos.get(i).getValorUnitario()+";"+
                        productoPerecederos.get(i).getCantidadExistente()+";"+productoPerecederos.get(i).getTipoProducto()+";"
                        +productoPerecederos.get(i).getFechaVencimiento()+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
