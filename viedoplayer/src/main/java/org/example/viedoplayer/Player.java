package org.example.viedoplayer;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Window;

import java.io.File;
import java.util.Optional;

public class Player {
    private VBox root;
    public Player(VBox root, Window owner) {
        this.root=root;


//        Media videomedia = new Media(videoFile.toURI().toString());
//        MediaPlayer mdplayer = new MediaPlayer(videomedia);
//        MediaView viewmedia = new MediaView(mdplayer);
//        viewmedia.setFitHeight(455);
//        viewmedia.setFitWidth(500);
//        Button pause = new Button("Pause");
//        Button resume = new Button("Resume");
//        HBox box = new HBox(20, pause, resume);
//        box.setAlignment(Pos.CENTER);
//        pause.setOnAction(act -> mdplayer.pause());
//        resume.setOnAction(act -> mdplayer.play());
//        VBox root = new VBox(20);
//        root.setAlignment(Pos.CENTER);
//        root.getChildren().addAll(viewmedia, box);
        Dialog<String> dialog = new Dialog<>();
        dialog.initOwner(owner);
        dialog.setTitle("Player");
        dialog.getDialogPane().setContent(root);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(owner);
        Optional<String> result = dialog.showAndWait();
        owner.setOnCloseRequest((e) -> {
            // System.out.println("Closing");
            System.exit(0);
            // e.consume();

            
        });
        

    }

}
