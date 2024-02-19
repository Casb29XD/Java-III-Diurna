package co.edu.uniquindio.taller1.tallerrepaso;

import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Buscador;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_ProductoEnvasado;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_ProductoPerecedero;
import co.edu.uniquindio.taller1.tallerrepaso.CRUD.Crud_ProductoRefigerado;
import co.edu.uniquindio.taller1.tallerrepaso.constructor.Producto_Envasado;
import co.edu.uniquindio.taller1.tallerrepaso.constructor.Producto_Perecedero;
import co.edu.uniquindio.taller1.tallerrepaso.constructor.Producto_Refrigerado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewControlerAgregarProducto implements Initializable {
    @FXML
    private Button BtnActualizarProduct;

    @FXML
    private Button BtnRegistrarProduc;

    @FXML
    private Button BtnRegresarPrincipal;

    @FXML
    private ComboBox<String> ComboBPais;

    @FXML
    private ComboBox<String> ComboBTipoProdu;

    @FXML
    private DatePicker DateEnvasado;

    @FXML
    private DatePicker DateVencimiento;

    @FXML
    private Pane InterInicio;

    @FXML
    private TextField TxtCantExistent;

    @FXML
    private TextField TxtCodeAprobacion;

    @FXML
    private TextField TxtCodeProduct;

    @FXML
    private TextArea TxtDescripcion;

    @FXML
    private TextField TxtNombreProduc;

    @FXML
    private TextField TxtPesoProd;

    @FXML
    private TextField TxtTempRecomend;

    @FXML
    private TextField TxtValorUnit;

    @FXML
    private Label mensaje;

    Buscador buscador= new Buscador();

    @FXML
    void BtnActualizar(ActionEvent event) {
        if (TxtCodeProduct.getText().isEmpty()|| TxtNombreProduc.getText().isEmpty() || TxtValorUnit.getText().isEmpty()
                || TxtDescripcion.getText().isEmpty() || TxtCantExistent.getText().isEmpty()){
            mensaje.setText("Ingrese todos los datos");
        }else {
            int codigo=Integer.parseInt(TxtCodeProduct.getText());
            String nombre = TxtNombreProduc.getText();
            String descripcion = TxtDescripcion.getText();
            float valorUnitario = Float.parseFloat(TxtValorUnit.getText());
            int cantidadExistente = Integer.parseInt(TxtCantExistent.getText());
            String tipoProducto = ComboBTipoProdu.getSelectionModel().getSelectedItem().toString();
            if (tipoProducto.equals("Envasados")){
                if (DateEnvasado.getValue() !=null || !TxtPesoProd.getText().isEmpty() ||
                        !ComboBPais.getSelectionModel().getSelectedItem().isEmpty()){
                    String fechaEnvasado = DateEnvasado.getValue().toString();
                    float pesoEnvase = Float.parseFloat(TxtPesoProd.getText());
                    String paisOrigen = ComboBPais.getSelectionModel().getSelectedItem().toString();
                    if (buscador.buscarProductoEnvasado(codigo) !=-1){
                        Crud_ProductoEnvasado.actualizar_ProducEnvasado(codigo,new Producto_Envasado(codigo,nombre,descripcion,valorUnitario,cantidadExistente,tipoProducto,fechaEnvasado,pesoEnvase,paisOrigen));
                        mensaje.setText("Producto Actualizado");
                    }else {
                        mensaje.setText("Ese producto no esta registrado");
                    }
                }else {
                    mensaje.setText("Ingrese los datos Faltantes");
                }
            }else if (tipoProducto.equals("Perecederos")){
                if (DateVencimiento.getValue() != null){
                    String FechaVencimiento=DateVencimiento.getValue().toString();
                    if (buscador.buscadarProductoPerecedero(codigo)!=-1){
                        Crud_ProductoPerecedero.actualizar_ProducPerecedero(codigo,new Producto_Perecedero(codigo,nombre,descripcion,valorUnitario,cantidadExistente,tipoProducto,FechaVencimiento));
                        mensaje.setText("Producto Actualizado");
                    }else {
                        mensaje.setText("Ese producto no esta registrado");
                    }
                }else {
                    mensaje.setText("Ingrese los datos Faltantes");
                }
            } else if (tipoProducto.equals("Refigerados")){
                if (!TxtCodeAprobacion.getText().isEmpty() || !TxtTempRecomend.getText().isEmpty()){
                    int codigoAprobacion=Integer.parseInt(TxtCodeAprobacion.getText());
                    float temperaturaReque=Float.parseFloat(TxtTempRecomend.getText());
                    if ( buscador.buscarProductosRefrigerados(codigo)!=-1){
                        Crud_ProductoRefigerado.actualizar_ProducRegigerado(codigo,new Producto_Refrigerado(codigo,nombre,descripcion,valorUnitario,cantidadExistente,tipoProducto,codigoAprobacion,temperaturaReque));
                        mensaje.setText("Producto Actualizado");
                    }else {
                        mensaje.setText("Ese producto no esta registrado");
                    }
                }else {
                    mensaje.setText("Ingrese los datos Faltantes");
                }
            }
        }
    }

    @FXML
    void BtnRegistrar(ActionEvent event) {
        if (TxtCodeProduct.getText().isEmpty()|| TxtNombreProduc.getText().isEmpty() || TxtValorUnit.getText().isEmpty()
        || TxtDescripcion.getText().isEmpty() || TxtCantExistent.getText().isEmpty()){
            mensaje.setText("Ingrese todos los datos");
        }else {
            int codigo=Integer.parseInt(TxtCodeProduct.getText());
            String nombre = TxtNombreProduc.getText();
            String descripcion = TxtDescripcion.getText();
            float valorUnitario = Float.parseFloat(TxtValorUnit.getText());
            int cantidadExistente = Integer.parseInt(TxtCantExistent.getText());
            String tipoProducto = ComboBTipoProdu.getSelectionModel().getSelectedItem().toString();
            if (tipoProducto.equals("Envasados")){
                if (DateEnvasado.getValue() !=null || !TxtPesoProd.getText().isEmpty() ||
                !ComboBPais.getSelectionModel().getSelectedItem().isEmpty()){
                    String fechaEnvasado = DateEnvasado.getValue().toString();
                    float pesoEnvase = Float.parseFloat(TxtPesoProd.getText());
                    String paisOrigen = ComboBPais.getSelectionModel().getSelectedItem().toString();
                    if (buscador.buscadarProductoPerecedero(codigo)==-1 && buscador.buscarProductosRefrigerados(codigo)==-1
                            && buscador.buscarProductoEnvasado(codigo) ==-1){
                        Crud_ProductoEnvasado.guardar_Productoenvasado(new Producto_Envasado(codigo,nombre,descripcion,valorUnitario,cantidadExistente,tipoProducto,fechaEnvasado,pesoEnvase,paisOrigen));
                        mensaje.setText("Producto guardado");
                    }else {
                        mensaje.setText("Ese producto ya esta registrado");
                    }
                }else {
                    mensaje.setText("Ingrese los datos Faltantes");
                }
            }else if (tipoProducto.equals("Perecederos")){
                if (DateVencimiento.getValue() != null){
                    String FechaVencimiento=DateVencimiento.getValue().toString();
                    if (buscador.buscadarProductoPerecedero(codigo)==-1 && buscador.buscarProductosRefrigerados(codigo)==-1
                    && buscador.buscarProductoEnvasado(codigo) ==-1){
                        Crud_ProductoPerecedero.guardar_ProductoPerecedero(new Producto_Perecedero(codigo,nombre,descripcion,valorUnitario,cantidadExistente,tipoProducto,FechaVencimiento));
                        mensaje.setText("Producto guardado");
                    }else {
                        mensaje.setText("Producto ya esta guardado");
                    }
                }else {
                    mensaje.setText("Ingrese los datos Faltantes");
                }
            }else if (tipoProducto.equals("Refigerados")){
                if (!TxtCodeAprobacion.getText().isEmpty() || !TxtTempRecomend.getText().isEmpty()){
                    int codigoAprobacion=Integer.parseInt(TxtCodeAprobacion.getText());
                    float temperaturaReque=Float.parseFloat(TxtTempRecomend.getText());
                    if (buscador.buscadarProductoPerecedero(codigo)==-1 && buscador.buscarProductosRefrigerados(codigo)==-1
                            && buscador.buscarProductoEnvasado(codigo) ==-1){
                        Crud_ProductoRefigerado.guardar_ProductoRefigerado(new Producto_Refrigerado(codigo,nombre,descripcion,valorUnitario,cantidadExistente,tipoProducto,codigoAprobacion,temperaturaReque));
                        mensaje.setText("Producto guardado");
                    }else {
                        mensaje.setText("Producto ya esta guardado");
                    }
                }
            }
        }
    }

    @FXML
    void regresarPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InterPrincipalCrud.fxml"));
        Stage stage = (Stage) BtnRegresarPrincipal.getScene().getWindow();
        stage.setTitle("Registro Clientes");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void tipoProducto(ActionEvent event) {
        String s= ComboBTipoProdu.getSelectionModel().getSelectedItem().toString();
        if (s.equals("Envasados")){
            DateEnvasado.setVisible(true);
            TxtPesoProd.setVisible(true);
            ComboBPais.setVisible(true);
            //perecederos
            DateVencimiento.setVisible(false);
            //Refigerados
            TxtCodeAprobacion.setVisible(false);
            TxtTempRecomend.setVisible(false);
        }else if (s.equals("Perecederos")){
            DateVencimiento.setVisible(true);
            //Envasados
            DateEnvasado.setVisible(false);
            TxtPesoProd.setVisible(false);
            ComboBPais.setVisible(false);
            //Refigerados
            TxtCodeAprobacion.setVisible(false);
            TxtTempRecomend.setVisible(false);
        }else if (s.equals("Refigerados")){
            TxtCodeAprobacion.setVisible(true);
            TxtTempRecomend.setVisible(true);
            //Envasados
            DateEnvasado.setVisible(false);
            TxtPesoProd.setVisible(false);
            ComboBPais.setVisible(false);
            //perecederos
            DateVencimiento.setVisible(false);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> listaProductos = FXCollections.observableArrayList("Envasados",
                "Perecederos", "Refigerados");
        ObservableList<String> listaPaices = FXCollections.observableArrayList("Argentina","Chile",
                "Colombia","Ecuador","Peru");
        ComboBTipoProdu.setItems(listaProductos);
        ComboBPais.setItems(listaPaices);
        //Envasados
        DateEnvasado.setVisible(false);
        TxtPesoProd.setVisible(false);
        ComboBPais.setVisible(false);
        //perecederos
        DateVencimiento.setVisible(false);
        //Refigerados
        TxtCodeAprobacion.setVisible(false);
        TxtTempRecomend.setVisible(false);
    }
}
