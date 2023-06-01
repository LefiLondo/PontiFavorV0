package com.example.pontifavorv0;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Platform;

public class RestaurantController {
    @FXML
    private AnchorPane grande;

    @FXML
    private AnchorPane pequeno;
    @FXML
    private Text cosechas;
    @FXML
    private Text descosechas;
    @FXML
    private Text pecera;
    @FXML
    private Text despecera;
    @FXML
    private Button botonpecera;
    @FXML
    private Button botoncosechas;
    @FXML
    private ImageView imagencosechas;
    @FXML
    private ImageView imagenpecera;
    @FXML
    private ImageView canasta;
    private Stage EscenaRestaurante;
    private HelloController controller1;




    public void cerrarAplicacion() {
        Platform.exit();
        System.exit(0);
    }


    /*
    public void MostrarIniciarSesionView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        HelloController controller4 = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller4.initialize();
        stage.show();
        this.escena.close();
        //System.out.println("siuuuuu");
    }*/

    public void MostrarIniciarSesionView() throws IOException {
        controller1.show();
        EscenaRestaurante.close();
        //cerrarAplicacion();
    }




    public void init(Stage stage, HelloController control) {
        this.EscenaRestaurante = stage;
        this.controller1 = control;
    }


    public void CambioProductoco() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductoView.fxml"));
        Parent root = loader.load();
       ProductController controller5 = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller5.init(stage, this);
        stage.setTitle("Nueva Vista");
        stage.show();
        EscenaRestaurante.close();
    }

    public void CambioCarrito() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductoView.fxml"));
        Parent root = loader.load();
        ProductController controller5 = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller5.init(stage, this);
        stage.setTitle("Nueva Vista");
        stage.show();
        ProductController A = new ProductController();
        A.PantCarrito();
        EscenaRestaurante.close();
    }


}
