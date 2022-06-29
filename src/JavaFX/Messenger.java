package JavaFX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Messenger extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Мессенджер");

        Parent parent = initInterface();

        stage.setScene(new Scene(parent));
        stage.show();
    }


    private HBox initInterface() {
        TextField textField = new TextField();
        Button sendButton = new Button("Отправить");
        HBox sendMessege = new HBox(textField, sendButton);

        TextArea  textArea = new TextArea();

        Label contactsLabel = new Label("  Контакты");
        ListView<String> contactsList = new ListView<>();
        textArea.setEditable(false);
        contactsList.setItems(FXCollections.observableArrayList("Контакт1", "Контакт2"));

        VBox textBox = new VBox(textArea, sendMessege);
        VBox contactsBox = new VBox(contactsLabel, contactsList);
        HBox hBox = new HBox(textBox, contactsBox);

        VBox.setVgrow(textArea, Priority.ALWAYS);
        HBox.setHgrow(textField, Priority.ALWAYS);
        HBox.setHgrow(textBox, Priority.ALWAYS);
        VBox.setVgrow(contactsList, Priority.ALWAYS);

        sendButton.setPrefWidth(150);
        contactsBox.setPrefWidth(200);
        textField.setPrefHeight(50);
        sendButton.setPrefHeight(50);
        contactsLabel.setPrefHeight(100);
        hBox.setPrefHeight(350);

        textArea.setEditable(false);
        sendButton.setOnAction(event -> {
                    textArea.appendText(textField.getText() + "\n");
                    textField.clear();
                });

        textArea.setEditable(false);

        return hBox;
    }
}