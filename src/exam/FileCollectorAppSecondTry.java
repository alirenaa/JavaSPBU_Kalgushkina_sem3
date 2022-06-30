package exam;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileCollectorAppSecondTry extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("File Collector");

        FileChooser fileChooser = new FileChooser();
        Label fileLabel = new Label();
        Button button = new Button("Выберите файл");
        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            fileLabel.setText(selectedFile.getPath());
        });

        VBox root = new VBox(button, fileLabel);
        stage.setScene(new Scene(root));
        stage.show();
    }

}
