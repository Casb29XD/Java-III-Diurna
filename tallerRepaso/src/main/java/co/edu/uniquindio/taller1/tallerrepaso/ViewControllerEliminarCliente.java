package co.edu.uniquindio.taller1.tallerrepaso;

import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Buscador;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_clienteJuridico;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_clienteNormal;
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

public class ViewControllerEliminarCliente {
    @FXML
    private Button BtnEliminarClient;

    @FXML
    private Button BtnRegresarPrincipal;

    @FXML
    private Pane InterInicio;

    @FXML
    private Text Txt_mensaje;

    @FXML
    private TextField TxtF_documento;

    Buscador buscador = new Buscador();

    @FXML
    void EliminarCliente(ActionEvent event) {
        if (!TxtF_documento.getText().isEmpty()){
            int identificion= Integer.parseInt(TxtF_documento.getText());
            if(buscador.buscadarJuridico(identificion) != -1) {
                Crud_clienteJuridico.eliminar_Cjuridica(identificion);
                Txt_mensaje.setText("cliente eliminado");
            }
            else if (buscador.buscadarClienteNormal(identificion) != -1){
                Crud_clienteNormal.eliminarClienteNatu(identificion);
                Txt_mensaje.setText("cliente eliminado");
            }else {
                Txt_mensaje.setText("cliente no encontrado " + identificion);
            }
        }else {
            Txt_mensaje.setText("Ingrese la indentificacion");
        }
    }

    @FXML
    void RegresarPrinicpal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InterPrincipalCrud.fxml"));
        Stage stage = (Stage) BtnRegresarPrincipal.getScene().getWindow();
        stage.setTitle("Registro Clientes");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
