package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        Functions.SceneChange(event,"login.fxml");
    }

    public void registerUser() {
        if (usernameTextField.getText().isBlank() || passwordPasswordField.getText().isBlank() || confirmPasswordPasswordField.getText().isBlank()) {
            messageLabel.setText("Please enter username & password.");
            usernameTextField.clear();
            passwordPasswordField.clear();
            confirmPasswordPasswordField.clear();
        } else if(!passwordPasswordField.getText().equals(confirmPasswordPasswordField.getText())) {
            passwordMatchMessage.setText("Password doesn't match!");
            usernameTextField.clear();
            passwordPasswordField.clear();
            confirmPasswordPasswordField.clear();
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
                usernameTextField.clear();
                passwordPasswordField.clear();
                confirmPasswordPasswordField.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void isUsernameTaken() {

    }
}
