package org.example.viedoplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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
            if(videoFile!=null){
                Media videomedia = new Media(videoFile.toURI().toString());
                MediaPlayer mdplayer = new MediaPlayer(videomedia);
                MediaView viewmedia = new MediaView(mdplayer);
                viewmedia.setFitHeight(455);
                viewmedia.setFitWidth(500);
                Button exitDialog=new Button("exit");
                Button pause = new Button("Pause");
                Button resume = new Button("Resume");
                Button play=new Button("play");
                Button stop=new Button("stop");
                exit.setOnAction(ex->{
                    System.exit(0);
                });
                HBox box = new HBox(20, play,pause, resume,stop,exitDialog);
                box.setAlignment(Pos.CENTER);
                pause.setOnAction(act -> mdplayer.pause());
                resume.setOnAction(act -> mdplayer.play());
                stop.setOnAction(act-> mdplayer.stop());
                play.setOnAction(act->mdplayer.play());
                VBox root = new VBox(20);
                root.setAlignment(Pos.CENTER);
                root.getChildren().addAll(viewmedia, box);
                Player player=new Player(root,stage);
            }
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
