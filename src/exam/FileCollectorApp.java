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

public class FileCollectorApp extends Application{

    private final Button chooseButton = new Button("Выбрать файл");
    private final Label fileLabel = new Label();
    private final FileChooser fileChooser = new FileChooser();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("File Collector");
        VBox root = initInterface();
        stage.setScene(new Scene(root));
        initInteraction();
        stage.show();
    }

    private VBox initInterface() {
        return new VBox(chooseButton, fileLabel);
    }

    private void initInteraction() {
        chooseButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            File fileToChoose = fileChooser.showOpenDialog(null);
            if (fileToChoose == null)
                return;

            fileLabel.setText(fileToChoose.getPath());
        });
    }
}
