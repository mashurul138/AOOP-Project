package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SigningController {
    @FXML
    public Button loginButton;

    @FXML
    public PasswordField passwordPasswordField;

    @FXML
    public TextField usernameTextField;

    @FXML
    public Button signupButton;

    @FXML
    public Label messageLabelField;

    public void loginButtonOnAction() {

        if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            loginValidation();
        } else {
            messageLabelField.setText("Please enter username and password correctly");
        }
    }

    public void loginValidation() {
        DBConnection connectNow = new DBConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery("SELECT count(1) FROM accounts WHERE Username = '" + usernameTextField.getText()
                    + "' AND Password = '" + passwordPasswordField.getText() + "'");

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    messageLabelField.setText("Welcome...");
                } else {
                    messageLabelField.setText("Please try again");
                }
                usernameTextField.clear();
                passwordPasswordField.clear();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void switchTOSignup(ActionEvent event) {
        Functions.SceneChange(event,"signup.fxml");
    }
}