package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.controller.LoginController;
import org.example.controller.UserController;
import org.example.rpc.ServicesProxy;

public class StartClient extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        String serverIP = "localhost";
        int serverPort = 55555;
        IServices server = new ServicesProxy(serverIP, serverPort);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("login-view.fxml"));
        Parent root = loader.load();
        LoginController controller = loader.getController();
        controller.setServer(server);
        FXMLLoader cloader = new FXMLLoader(getClass().getClassLoader().getResource("home-view.fxml"));
        Parent croot = cloader.load();
        UserController controller1 = cloader.getController();
        controller.setUserCtr(controller1);
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
