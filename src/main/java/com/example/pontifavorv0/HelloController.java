package com.example.pontifavorv0;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.*;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


import javax.xml.transform.stream.StreamSource;
import java.util.Scanner;

public class HelloController {
    @FXML
    private AnchorPane Grande;
    @FXML
    private AnchorPane BarraSuperior;
    @FXML
    private AnchorPane PanelIniciarSesion;
    @FXML
    private AnchorPane PanelRegistrarse;
    @FXML
    private ImageView IniciarSesion;
    @FXML
    private ImageView Registrarse;
    @FXML
    private ComboBox<String> ComboBoxTipoUser;
    @FXML
    private Button BotonIniciarSesion;
    @FXML
    private Button BotonRegistro;
    @FXML
    private TextArea TextoUser;
    @FXML
    private TextArea TextoPhone;
    @FXML
    private TextArea TextoContraseña;
    @FXML
    private TextArea TextoUserIniciar;
    @FXML
    private TextArea TextoContraseñaIniciar;
    @FXML
    private ImageView PontiFavorRegistro;
    @FXML
    private ImageView MuñecoRegistro;
    @FXML
    private ImageView PontiFavorInicioSesion;
    @FXML
    private ImageView MuñecoInicioSesion;
    private Stage primarystage;
    private boolean flaginicio =false;

    String usuario;
    String contraseña;
    String phone;
    String tipoUser;


    public void MostrarRestauranteView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("restaurantes-view.fxml"));
        Parent root = loader.load();
        RestaurantController controller3 = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller3.init(stage, this);
        stage.show();
        primarystage.close();
    }
    public void iniciarSesion(){
        PanelIniciarSesion.setVisible(true);
        PanelRegistrarse.setVisible(false);
    }

    public void registrarse(){
        PanelRegistrarse.setVisible(true);
        PanelIniciarSesion.setVisible(false);
    }

    public void registroNuevousuario(){

        TextoUser.getText().toString();
    }
    public void selcTipoUser(String tipoUsuario) {
        tipoUsuario = String.valueOf(ComboBoxTipoUser.getSelectionModel());
    }

    public void initialize(){
        ObservableList<String> userItems = FXCollections.observableArrayList("Cliente", "Tendero", "Dueño restaurante");
        ComboBoxTipoUser.setItems(userItems);
    }

    //ConectarBase conectar = new ConectarBase ();
    //Connection tipocon = conectar.conexion;
    //PreparedStatement preparar;



    //String sql;

    @FXML
    private void setBotonRegistro (){

        Guardar ();
    }

    public void Guardar () {

            usuario = TextoUser.getText();
            contraseña = TextoContraseña.getText();
            phone = TextoPhone.getText();

            Mysql b = new Mysql();
            b.registrarse(usuario,contraseña);


        }
    /*public void textFieldEmptyEmp(Boolean confirmar) {
        boolean llen = false;
        boolean equals = false;
        if (!this.TextoUser.getText().isEmpty() && !this.TextoContraseña.getText().isEmpty() && !this.TextoPhone.getText().isEmpty() && !this.tipoUser.isEmpty()) {
            llen = true;
            confirmar = true;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Espacios vacios");
            alert.setHeaderText("Por favor asegúrese de que todos los espacios estén llenos");
            alert.showAndWait();
            llen = false;

        }*/

    public void lecturainiciarSesion () {
        boolean Iniciocorrecto;
    Mysql a = new Mysql();
        System.out.println(TextoUserIniciar.getText());
        System.out.println(TextoContraseñaIniciar.getText());
    Iniciocorrecto = a.UsuarioEncontrado(TextoUserIniciar.getText(), TextoContraseñaIniciar.getText());
    if (Iniciocorrecto){
        System.out.println("Inicio de sesión satisfactorio");
        try {
            MostrarRestauranteView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    else {
        System.out.println("Maaal");
    }
    }


    public void setStage(Stage stage) { this.primarystage = stage;
    }

    public void show() {

        primarystage.show();
    }


}