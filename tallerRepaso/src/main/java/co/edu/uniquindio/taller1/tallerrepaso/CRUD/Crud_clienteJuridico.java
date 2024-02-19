package co.edu.uniquindio.taller1.tallerrepaso.CRUD;

import co.edu.uniquindio.taller1.tallerrepaso.constructor.Cliente_Juridica;

import java.io.*;
import java.util.ArrayList;

public class Crud_clienteJuridico {
    static Buscador buscador= new Buscador();
    private static final String archivo="ClientesJuridicos.txt";
    public static void guardar_ClienJuridica(Cliente_Juridica clinteJuridica){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo,true))) {
            writer.write(clinteJuridica.getNombre()+";"+clinteJuridica.getApellido()+";"+
                    clinteJuridica.getIdentificacion()+";"+clinteJuridica.getDireccion()+";"+
                    clinteJuridica.getTelefono()+";"+clinteJuridica.getTipo_Cliente()+";"+
                    clinteJuridica.getNit()+"\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Cliente_Juridica> leer_Cjuridica(){
        ArrayList<Cliente_Juridica> clienteJuridicas = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(archivo))){
            String line;
            while ((line = reader.readLine())!=null){
                String[] datos = line.split(";");
                String nombre= datos[0];
                String apellido= datos[1];
                int identificacion= Integer.parseInt(datos[2]);
                String direccion= datos[3];
                int telefono=Integer.parseInt(datos[4]);
                String tipo_Cliente=datos[5];
                int nit=Integer.parseInt(datos[6]);
                clienteJuridicas.add(new Cliente_Juridica(nombre,apellido,identificacion,direccion,telefono,tipo_Cliente,nit));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return clienteJuridicas;
    }
    public static void actualizar_Cjuridica(int identifiacion, Cliente_Juridica clinteJuridica){
        ArrayList<Cliente_Juridica> clientes = leer_Cjuridica();
        int pos=buscador.buscadarJuridico(identifiacion);
        if (clientes.get(pos).getIdentificacion() == identifiacion){
            clientes.set(pos,clinteJuridica);
            guradar_CJuridicas(clientes);
        }
    }
    public static void eliminar_Cjuridica(int identifiacion){
        ArrayList<Cliente_Juridica> clientes = leer_Cjuridica();
        int pos= buscador.buscadarJuridico(identifiacion);
        if (clientes.get(pos).getIdentificacion() == identifiacion){
            clientes.remove(pos);
            guradar_CJuridicas(clientes);
        }
    }
    public static void guradar_CJuridicas(ArrayList<Cliente_Juridica> clinteJuridica) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (int i=0; i < clinteJuridica.size();i++) {
                writer.write(clinteJuridica.get(i).getNombre() + ";" + clinteJuridica.get(i).getApellido() + ";" +
                        clinteJuridica.get(i).getIdentificacion() + ";" + clinteJuridica.get(i).getDireccion() + ";" +
                        clinteJuridica.get(i).getTelefono() + ";" + clinteJuridica.get(i).getTipo_Cliente() + ";" +
                        clinteJuridica.get(i).getNit() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
