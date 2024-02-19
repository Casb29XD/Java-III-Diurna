package co.edu.uniquindio.taller1.tallerrepaso;

import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Buscador;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_clienteJuridico;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_clienteNormal;
import co.edu.uniquindio.taller1.tallerrepaso.constructor.Cliente_Juridica;
import co.edu.uniquindio.taller1.tallerrepaso.constructor.Cliente_Natural;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewControlerAgregarCliente implements Initializable {
    static Buscador buscador = new Buscador();

    @FXML
    private Button BtnActualizarPersona;

    @FXML
    private Button BtnRegistrarPersona;

    @FXML
    private Button BtnRegresar;

    @FXML
    private ComboBox ComboBTipoPers;

    @FXML
    private DatePicker DateNacimiento;

    @FXML
    private Pane InterInicio;

    @FXML
    private TextField TxtF_Apellido;

    @FXML
    private TextField TxtF_Correo;

    @FXML
    private TextField TxtF_Direccion;

    @FXML
    private TextField TxtF_Documento;

    @FXML
    private TextField TxtF_Nit;

    @FXML
    private TextField TxtF_Nombre;

    @FXML
    private TextField TxtF_Telefono;

    @FXML
    private Text Txt_Apellidos;

    @FXML
    private Text Txt_Direccion;

    @FXML
    private Text Txt_Documento;

    @FXML
    private Text Txt_Fecha;

    @FXML
    private Text Txt_Nombre;

    @FXML
    private Text Txt_Telefono;

    @FXML
    private Text Txt_correo;

    @FXML
    private Text Txt_nit;

    @FXML
    private Text mensaje;

    @FXML
    void btnActualizarClientes(ActionEvent event) {
        if (TxtF_Nombre.getText().isEmpty() || TxtF_Apellido.getText().isEmpty()
                || TxtF_Documento.getText().isEmpty() || TxtF_Direccion.getText().isEmpty()
                || ComboBTipoPers.getValue() == null || TxtF_Telefono.getText().isEmpty()) {
            mensaje.setText("Infrese Todos los datos");
        } else {
            String nombre = TxtF_Nombre.getText().toString();
            String apellidos = TxtF_Apellido.getText().toString();
            int identificacion = Integer.parseInt(TxtF_Documento.getText().toString());
            String direccion = TxtF_Direccion.getText().toString();
            int telefono = Integer.parseInt(TxtF_Telefono.getText());
            String tipoCliente = ComboBTipoPers.getSelectionModel().getSelectedItem().toString();
            if (tipoCliente.equals("natural")) {
                if (DateNacimiento.getValue() != null || !TxtF_Correo.getText().isEmpty()) {
                    String fechaNacimiento =DateNacimiento.getValue().toString();
                    String email = TxtF_Correo.getText().toString();
                    if (buscador.buscadarClienteNormal(identificacion) != -1) {
                        Cliente_Natural clienteNatural = new Cliente_Natural(nombre, apellidos, identificacion, direccion, telefono, tipoCliente, email, fechaNacimiento);
                        Crud_clienteNormal.actualizarClienteNatural(identificacion,clienteNatural);
                        mensaje.setText("Registro Actualizado");
                    }else {
                        mensaje.setText("El usuario no esta registrado");
                    }
                } else {
                    mensaje.setText("ingrese todos los datos");
                }
            }else if (tipoCliente.equals("juridica")) {
                if (!TxtF_Nit.getText().isEmpty()) {
                    if (buscador.buscadarJuridico(identificacion) != -1) {
                        int nit = Integer.parseInt(TxtF_Nit.getText());
                        Cliente_Juridica clienteJuridica = new Cliente_Juridica(nombre, apellidos, identificacion, direccion, telefono, tipoCliente, nit);
                        Crud_clienteJuridico.actualizar_Cjuridica(identificacion,clienteJuridica);
                        mensaje.setText("Registro Actualizado");
                    } else {
                        mensaje.setText("El usuario no esta registrado");
                    }
                }
            } else {
                mensaje.setText("Seleccione un tipo de cliente");
            }
        }
    }

    @FXML
    void btnRegresarPrincipal() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InterPrincipalCrud.fxml"));
        Stage stage = (Stage) BtnRegresar.getScene().getWindow();
        stage.setTitle("Registro Clientes");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void btnregistraPersona(ActionEvent event) {
        if (TxtF_Nombre.getText().isEmpty() || TxtF_Apellido.getText().isEmpty()
                || TxtF_Documento.getText().isEmpty() || TxtF_Direccion.getText().isEmpty()
                || ComboBTipoPers.getValue() == null || TxtF_Telefono.getText().isEmpty()) {
            mensaje.setText("Infrese Todos los datos");
        } else {
            String nombre = TxtF_Nombre.getText().toString();
            String apellidos = TxtF_Apellido.getText().toString();
            int identificacion = Integer.parseInt(TxtF_Documento.getText().toString());
            String direccion = TxtF_Direccion.getText().toString();
            int telefono = Integer.parseInt(TxtF_Telefono.getText());
            String tipoCliente = ComboBTipoPers.getSelectionModel().getSelectedItem().toString();
            if (tipoCliente.equals("natural")) {
                if (DateNacimiento.getValue() != null || !TxtF_Correo.getText().isEmpty()) {
                    String fechaNacimiento =DateNacimiento.getValue().toString();
                    String email = TxtF_Correo.getText().toString();
                    if (buscador.buscadarClienteNormal(identificacion) == -1) {
                        Cliente_Natural clienteNatural = new Cliente_Natural(nombre, apellidos, identificacion, direccion, telefono, tipoCliente, email, fechaNacimiento);
                        Crud_clienteNormal.crearClienteNatural(clienteNatural);
                        mensaje.setText("Registro Completo");
                    }else {
                        mensaje.setText("El usuario ya esta registrado");
                    }
                } else {
                    mensaje.setText("ingrese todos los datos");
                }
            }else if (tipoCliente.equals("juridica")) {
                if (!TxtF_Nit.getText().isEmpty()) {
                    if (buscador.buscadarJuridico(identificacion) == -1) {
                        int nit = Integer.parseInt(TxtF_Nit.getText().toString());
                        Cliente_Juridica clienteJuridica = new Cliente_Juridica(nombre, apellidos, identificacion, direccion, telefono, tipoCliente, nit);
                        Crud_clienteJuridico.guardar_ClienJuridica(clienteJuridica);
                        mensaje.setText("Registro Completo");

                    } else {
                        mensaje.setText("El usuario ya esta registrado");
                    }
                }
            } else {
                mensaje.setText("Seleccione un tipo de cliente");
            }
        }

    }

    @FXML
    void selectTipoCliente(ActionEvent event) {
        String s= ComboBTipoPers.getSelectionModel().getSelectedItem().toString();
        if (s.equals("natural")){
            TxtF_Nit.setVisible(false);
            Txt_nit.setVisible(false);

            Txt_correo.setVisible(true);
            TxtF_Correo.setVisible(true);
            Txt_Fecha.setVisible(true);
            DateNacimiento.setVisible(true);
        }else{
            Txt_correo.setVisible(false);
            TxtF_Correo.setVisible(false);
            Txt_Fecha.setVisible(false);
            DateNacimiento.setVisible(false);

            TxtF_Nit.setVisible(true);
            Txt_nit.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("natural","juridica");
        ComboBTipoPers.setItems(list);
    }
}
