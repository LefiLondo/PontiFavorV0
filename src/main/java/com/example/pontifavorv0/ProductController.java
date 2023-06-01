package com.example.pontifavorv0;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProductController {
    private RestaurantController controli;
    private Stage Productostage;
    @FXML private Label L1;
    @FXML private Label L2;
    @FXML private Label L3;
    @FXML private Button B1;
    @FXML private Button B2;
    @FXML private Button B3;
    @FXML private Button B4;
    @FXML private Label RestaurantName;
    @FXML private Label O1;
    @FXML private Label O2;

    @FXML private Label O3;

    @FXML private Button botonvolver;



    @FXML private ImageView img1;
    @FXML private ImageView img2;
    @FXML private ImageView img3;
    @FXML private ImageView carrito;
    @FXML private ListView ListaCarrito;
    private int cuenta;
    @FXML private AnchorPane PCr;
    @FXML private AnchorPane PCr2;

    @FXML private AnchorPane Cr;
    @FXML private Label tot;
    private int contador=0;

    public ProductController() {
       // carrito = new ImageView(new Image(getClass()
          //      .getResourceAsStream("imagenes/carrito.jpg")));
    }


    public void GetCarrito1(){
            ListaCarrito.getItems().add(O1.getText()+"        "+ L1.getText());
        contador+=Integer.parseInt(L1.getText());



    }
    public void GetCarrito2(){
        ListaCarrito.getItems().add(O2.getText()+"                  " +L2.getText());
        contador+=Integer.parseInt(L2.getText());


    }
    public void GetCarrito3(){
        ListaCarrito.getItems().add(O3.getText()+"     " +L3.getText());
        contador+=Integer.parseInt(L3.getText());


    }
    public void valortot(){
        tot.setText(Integer.toString( contador));

    }

    public void PantCarrito(){
        PCr.setVisible(false);
        PCr2.setVisible(false);
        Cr.setVisible(true);
        valortot();
    }
    public void PantProductos(){
        PCr.setVisible(true);
        PCr2.setVisible(true);
        Cr.setVisible(false);
    }

    public void init(Stage stage, RestaurantController restaurantController) {
        this.Productostage = stage;
        this.controli = restaurantController;

    }

}
