package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.Client;
import org.example.IServices;
import org.example.ServiceException;

import java.awt.*;

public class LoginController {
    private IServices server;
    private UserController userCtr;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void setUserCtr(UserController userCtr) {
        this.userCtr = userCtr;
    }

    public void setServer(IServices server) {
        this.server = server;
    }

    @FXML
    public void pressLogin() {
        Client client = new Client();
        client.setEmail(username.getText());
        client.setPassword(password.getText());
        try {
            server.login(client, userCtr);
            Client rez = server.findClient(client);
            System.out.println(rez.getId());
        } catch (ServiceException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login failed");
            alert.setHeaderText("Authentication failure");
            alert.setContentText("Wrong username or password");
            alert.showAndWait();
        }
    }
}
