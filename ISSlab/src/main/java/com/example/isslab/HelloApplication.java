package com.example.isslab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String view = "/com/example/isslab/views/login-view.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(view));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        showView("/com/example/isslab/views/home-view.fxml", "homepage");
        showView("/com/example/isslab/views/movie-view.fxml", "movie");
        showView("/com/example/isslab/views/room-view.fxml", "room");
        showView("/com/example/isslab/views/register-view.fxml", "register");
    }

    public void showView(String view, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(view));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}