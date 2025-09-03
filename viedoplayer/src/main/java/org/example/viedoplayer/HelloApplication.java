package org.example.viedoplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    File videoFile;
    @Override
    public void start(Stage stage) throws IOException {
        Button exit=new Button("Exit");
        Button searchButton=new Button("Choose video");
        //File videoFile;
        searchButton.setOnAction(s->{
            FileChooser f=new FileChooser();
            videoFile=f.showOpenDialog(stage);
        });
        exit.setOnAction(ex->{
            System.exit(0);
        });
        VBox mainPane=new VBox(20);
        mainPane.getChildren().addAll(searchButton,exit);
        mainPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainPane, 320, 240);
        stage.setTitle("Video Player");
        stage.setScene(scene);
        stage.show();
    }
}
