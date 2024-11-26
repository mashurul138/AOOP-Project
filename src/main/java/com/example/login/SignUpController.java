package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class SignUpController {

    @FXML
    public TextField usernameTextField;

    @FXML
    public PasswordField passwordPasswordField;

    @FXML
    public PasswordField confirmPasswordPasswordField;

    @FXML
    public Button signupButton;

    @FXML
    public Button loginButton;

    @FXML
    public Label confirmMessageLabel;

    @FXML
    public Label passwordMatchMessage;

    @FXML
    public Label messageLabel;

    public void switchToLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void registerUser() {
        if(!passwordPasswordField.getText().equals(confirmPasswordPasswordField.getText())) {
            passwordMatchMessage.setText("Password doesn't match!");
        } else {
            DBConnection connectNow = new DBConnection();
            Connection connectDB = connectNow.getConnection();

            String username = usernameTextField.getText();
            String password = passwordPasswordField.getText();
            String insert = "INSERT INTO accounts(username, password) VALUES ('";
            String insertValues = username +"','" + password + "')";
            String insertToRegister = insert + insertValues;
            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);
                messageLabel.setText("User Registered Successfully");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
