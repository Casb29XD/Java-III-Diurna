package co.edu.uniquindio.taller1.tallerrepaso.CRUD;

import co.edu.uniquindio.taller1.tallerrepaso.constructor.Cliente_Natural;

import java.io.*;
import java.util.ArrayList;

public class Crud_clienteNormal {
    static Buscador buscador = new Buscador();
    static String archivo="CRUD_ClienteNatu.txt";
    public static void crearClienteNatural(Cliente_Natural clienteNatural) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo,true))) {
            writer.write(clienteNatural.getNombre()+";"
                    + clienteNatural.getApellido()+";"+ clienteNatural.getIdentificacion()
                    +";"+ clienteNatural.getDireccion()+";"+ clienteNatural.getTelefono()+
                    ";"+clienteNatural.getTipo_Cliente()+";"+clienteNatural.getEmail()+
                    ";"+clienteNatural.getFecha_Nacimineto()+"\n");

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Cliente_Natural> leerClienteNatural() {
        // Implementación para leer un cliente de la base de datos por identificación
        ArrayList<Cliente_Natural> clienteNaturals = new ArrayList<>();
        try(BufferedReader reader= new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] datos= line.split(";");
                String nombre = datos[0];
                String apellidos=datos[1];
                int identificacion = Integer.parseInt(datos[2]);
                String direccion= datos[3];
                int telefono= Integer.parseInt(datos[4]);
                String tipo_Cliente=datos[5];
                String email=datos[6];
                String fechaNacimiento =datos[7];
                clienteNaturals.add(new Cliente_Natural(nombre,apellidos,identificacion,direccion,telefono,tipo_Cliente,email,fechaNacimiento));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return  clienteNaturals;
    }
    public static void actualizarClienteNatural(int identificacion, Cliente_Natural  clienteNatural) {
        int posicion= buscador.buscadarClienteNormal(identificacion);
        ArrayList<Cliente_Natural> clienteNaturals = leerClienteNatural();
        if (clienteNaturals.get(posicion).getIdentificacion()== identificacion){
            clienteNaturals.set(posicion,clienteNatural);
            crearClientesNatus(clienteNaturals);
        }
    }

    public static void eliminarClienteNatu(int identificacion) {
        int posicion= buscador.buscadarClienteNormal(identificacion);
        ArrayList<Cliente_Natural> clienteNaturals = leerClienteNatural();
        if (clienteNaturals.get(posicion).getIdentificacion() == identificacion){
            clienteNaturals.remove(posicion);
            crearClientesNatus(clienteNaturals);
        }
    }
    public static void crearClientesNatus(ArrayList<Cliente_Natural> clienteNaturals) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (int i=0; i < clienteNaturals.size();i++){
                writer.write(clienteNaturals.get(i).getNombre()+";"
                        + clienteNaturals.get(i).getApellido()+";"+ clienteNaturals.get(i).getIdentificacion()
                        +";"+ clienteNaturals.get(i).getDireccion()+";"+ clienteNaturals.get(i).getTelefono()+";"
                        +clienteNaturals.get(i).getTipo_Cliente()+";"+clienteNaturals.get(i).getEmail()+
                        ";"+clienteNaturals.get(i).getFecha_Nacimineto()+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
