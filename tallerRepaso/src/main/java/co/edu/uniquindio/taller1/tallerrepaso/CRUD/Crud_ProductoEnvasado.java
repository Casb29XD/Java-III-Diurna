package co.edu.uniquindio.taller1.tallerrepaso.CRUD;

import co.edu.uniquindio.taller1.tallerrepaso.constructor.Producto_Envasado;

import java.io.*;
import java.util.ArrayList;

public class Crud_ProductoEnvasado {
    static Buscador buscador = new Buscador();
    static String archivo="CRUD_ProduEnvasados.txt";
    public static void guardar_Productoenvasado(Producto_Envasado productoEnvasado){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(archivo,true))) {
            writer.write(productoEnvasado.getCodigo()+";"+ productoEnvasado.getNombre()+";"
                    +productoEnvasado.getDescripcion()+";"+productoEnvasado.getValorUnitario()+";"+
                    productoEnvasado.getCantidadExistente()+";"+productoEnvasado.getTipoProducto()+";"
                    +productoEnvasado.getFechaEnvasado()+";"+productoEnvasado.getPesoEnvase()+";"+
                    productoEnvasado.getPaisOrigen()+"\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Producto_Envasado> leer_productoEnvasados(){
        ArrayList<Producto_Envasado> productoEnvasados= new ArrayList<>();
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
                String fechaEnvasado = dato[6];
                float pesoEnvase = Float.parseFloat(dato[7]);
                String paisOrigen = dato[8];
                productoEnvasados.add(new Producto_Envasado(codigo,nombre,descripcion,
                        valorUnitario,cantidadExistente,tipoProducto,fechaEnvasado,pesoEnvase,paisOrigen));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return productoEnvasados;
    }
    public static void actualizar_ProducEnvasado(int codigo, Producto_Envasado productoEnvasado){
        ArrayList<Producto_Envasado> productoEnvasados= leer_productoEnvasados();
        int pos= buscador.buscarProductoEnvasado(codigo);
        if (codigo == productoEnvasados.get(pos).getCodigo()){
            productoEnvasados.set(pos,productoEnvasado);
            guardar_ProductosEnvasados(productoEnvasados);
        }
    }
    public static void eliminar_ProducEnvasado(int codigo){
        ArrayList<Producto_Envasado> productoEnvasados= leer_productoEnvasados();
        int pos= buscador.buscarProductoEnvasado(codigo);
        if (codigo == productoEnvasados.get(pos).getCodigo()){
            productoEnvasados.remove(pos);
            guardar_ProductosEnvasados(productoEnvasados);
        }
    }
    public static void guardar_ProductosEnvasados(ArrayList<Producto_Envasado> productoEnvasados){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(archivo))) {
            for (int i =0; i <productoEnvasados.size();i++){
                writer.write(productoEnvasados.get(i).getCodigo()+";"+ productoEnvasados.get(i).getNombre()+";"
                        +productoEnvasados.get(i).getDescripcion()+";"+productoEnvasados.get(i).getValorUnitario()+";"+
                        productoEnvasados.get(i).getCantidadExistente()+";"+productoEnvasados.get(i).getTipoProducto()+";"
                        +productoEnvasados.get(i).getFechaEnvasado()+";"+productoEnvasados.get(i).getPesoEnvase()+";"+
                        productoEnvasados.get(i).getPaisOrigen()+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
