package co.edu.uniquindio.taller1.tallerrepaso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewControllerprincipal {
    @FXML
    private Button BtnEliminarClient;

    @FXML
    private Button BtnEliminarProducto;

    @FXML
    private Button BtnInicio;

    @FXML
    private Button BtnRegistrarClient;

    @FXML
    private Button BtnRegistroProd;

    @FXML
    void eliminarCLientes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InterEliminarUser.fxml"));
        Stage stage = (Stage) BtnEliminarClient.getScene().getWindow();
        stage.setTitle("Eliminar Clientes");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void eliminarProductos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InterEliminarProducto.fxml"));
        Stage stage = (Stage) BtnEliminarClient.getScene().getWindow();
        stage.setTitle("Eliminar Producto");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void registrarClientes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InterRegistroPersona.fxml"));
        Stage stage = (Stage) BtnRegistrarClient.getScene().getWindow();
        stage.setTitle("Registro Clientes");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void registrarProductos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InterRegistroProducto.fxml"));
        Stage stage = (Stage) BtnRegistroProd.getScene().getWindow();
        stage.setTitle("Registro Productos");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
