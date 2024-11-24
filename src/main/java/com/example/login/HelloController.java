package com.example.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
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

    public void signupButtonOnAction() {
        Stage stage = (Stage) signupButton.getScene().getWindow();
        stage.close();
    }

    public void loginValidation() {
        DBConnection connectNow = new DBConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM accounts WHERE Username = '" + usernameTextField.getText()
                + "' AND Password = '" + passwordPasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    messageLabelField.setText("Welcome...");
                } else {
                    messageLabelField.setText("Please try again");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}