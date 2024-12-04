package com.example.login;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Homepage extends Application {

    @FXML
    public ImageView messManagement;
    public ImageView bachelorShop;
    public ImageView to_let;
    public Rectangle rec1;


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("Homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    public void messManagement(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(Functions.class.getResource("login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void bachelorShop(MouseEvent event) {
    }

    public void to_let(MouseEvent event) {
    }

    public void messManagement1(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(Functions.class.getResource("signup.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
