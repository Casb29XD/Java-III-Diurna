package co.edu.uniquindio.taller1.tallerrepaso;

import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Buscador;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_ProductoEnvasado;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_ProductoPerecedero;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_ProductoRefigerado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewControlerEliminarProductos {

    @FXML
    private Button BtnEliminarClient;

    @FXML
    private Button BtnREgresarPrincipal;

    @FXML
    private Pane InterInicio;

    @FXML
    private TextField TxtEliminarUser;

    @FXML
    private Text mensaje;

    @FXML
    void RegresarPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InterPrincipalCrud.fxml"));
        Stage stage = (Stage) BtnREgresarPrincipal.getScene().getWindow();
        stage.setTitle("Registro Clientes");
        stage.setScene(new Scene(root));
        stage.show();
    }
    Buscador buscador = new Buscador();
    @FXML
    void eliminarProducto(ActionEvent event) {
        if(TxtEliminarUser.getText().isEmpty()){
            mensaje.setText("Ingrese un valor");
        }else{
            int codigo = Integer.parseInt(TxtEliminarUser.getText());
            if (buscador.buscarProductosRefrigerados(codigo)!= -1){
                Crud_ProductoRefigerado.eliminar_ProducRegigerado(codigo);
                mensaje.setText("Producto Eliminado");
            }else if (buscador.buscadarProductoPerecedero(codigo)!=-1){
                Crud_ProductoPerecedero.eliminar_ProducRegigerado(codigo);
                mensaje.setText("Producto Eliminado");
            } else if (buscador.buscarProductoEnvasado(codigo) != -1 ) {
                Crud_ProductoEnvasado.eliminar_ProducEnvasado(codigo);
                mensaje.setText("Producto Eliminado");
            }else {
                mensaje.setText("NO se encontro el producto");
            }
        }
    }
}
