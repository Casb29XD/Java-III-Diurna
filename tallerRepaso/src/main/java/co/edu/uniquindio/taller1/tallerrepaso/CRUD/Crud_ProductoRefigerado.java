package co.edu.uniquindio.taller1.tallerrepaso.CRUD;

import co.edu.uniquindio.taller1.tallerrepaso.constructor.Producto_Refrigerado;

import java.io.*;
import java.util.ArrayList;

public class Crud_ProductoRefigerado {
    static Buscador buscador = new Buscador();
    static String archivo="CRUD_ProduRefigerado.txt";
    public static void guardar_ProductoRefigerado(Producto_Refrigerado productoRefrigerado){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(archivo,true))) {
            writer.write(productoRefrigerado.getCodigo()+";"+ productoRefrigerado.getNombre()+";"
                    +productoRefrigerado.getDescripcion()+";"+productoRefrigerado.getValorUnitario()+";"+
                    productoRefrigerado.getCantidadExistente()+";"+productoRefrigerado.getTipoProducto()+";"
                +productoRefrigerado.getCodigoAprobacion()+";"+productoRefrigerado.getTemperaturaRecomendada()+"\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Producto_Refrigerado> leer_productoRefrigerados(){
        ArrayList<Producto_Refrigerado> productoRefrigerados= new ArrayList<>();
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
                int codigoAprobacion= Integer.parseInt(dato[6]);
                float temperaturaRecomendada= Float.parseFloat(dato[7]);
                productoRefrigerados.add(new Producto_Refrigerado(codigo,nombre,descripcion,
                        valorUnitario,cantidadExistente,tipoProducto,codigoAprobacion,temperaturaRecomendada));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return productoRefrigerados;
    }
    public static void actualizar_ProducRegigerado(int codigo, Producto_Refrigerado productoRefrigerado){
        ArrayList<Producto_Refrigerado> productoRefrigerados= leer_productoRefrigerados();
        int pos= buscador.buscarProductosRefrigerados(codigo);
        if (codigo == productoRefrigerados.get(pos).getCodigo()){
            productoRefrigerados.set(pos,productoRefrigerado);
            guardar_ProductosRefigerados(productoRefrigerados);
        }
    }
    public static void eliminar_ProducRegigerado(int codigo){
        ArrayList<Producto_Refrigerado> productoRefrigerados= leer_productoRefrigerados();
        int pos= buscador.buscarProductosRefrigerados(codigo);
        if (codigo == productoRefrigerados.get(pos).getCodigo()){
            productoRefrigerados.remove(pos);
            guardar_ProductosRefigerados(productoRefrigerados);
        }
    }
    public static void guardar_ProductosRefigerados(ArrayList<Producto_Refrigerado> productoRefrigerados){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(archivo))) {
            for (int i =0; i <productoRefrigerados.size();i++){
                writer.write(productoRefrigerados.get(i).getCodigo()+";"+ productoRefrigerados.get(i).getNombre()+";"
                        +productoRefrigerados.get(i).getDescripcion()+";"+productoRefrigerados.get(i).getValorUnitario()+";"+
                        productoRefrigerados.get(i).getCantidadExistente()+";"+productoRefrigerados.get(i).getTipoProducto()+";"
                        +productoRefrigerados.get(i).getCodigoAprobacion()+";"+productoRefrigerados.get(i).getTemperaturaRecomendada()+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
