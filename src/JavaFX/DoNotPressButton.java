package JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.spreadsheet.Grid;

public class DoNotPressButton extends Application {

    private Button button;
    int clickCount = 0;
    GridPane panel = new GridPane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Не нажимайте эту кнопку!");

        Parent parent = initInterface();
        initInteraction();

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    private Parent initInterface() {
        button = new Button("Не нажимайте эту кнопку");

        panel.setAlignment(Pos.CENTER);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        panel.add(button, 0, 0);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.ALWAYS);
        column1.setMinWidth(500);
        panel.getColumnConstraints().add(column1);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);
        row1.setMinHeight(500);
        panel.getRowConstraints().add(row1);

        return panel;
    }

    private void initInteraction() {
        String str0 = "Не нажимайте эту кнопку";
        String str1 = "Пожалуйста, не нажимайте больше эту кнопку!";
        String str2 = "И зачем вам это все? Прекратите нажимать эту кнопку!";
        String str3 = "Ну нормально же общались, зачем вы продолжаете ее трогать?!";
        String str4 = "Вы издеваетесь? Чего вы хотите этим добиться?";

        button.addEventHandler(ActionEvent.ACTION, event -> {
            if (clickCount == 0)
                System.out.println(str0);
            else if (clickCount == 1)
                System.out.println(str1);
            else if (clickCount == 2)
                System.out.println(str2);
            else if (clickCount == 3)
                System.out.println(str3);
            else if (clickCount == 4)
                System.out.println(str4);
            else{
                Image image = new Image("https://cdn.fishki.net/upload/post/2020/10/15/3447768/tn/1602785972123718897.jpg", 500, 500, false, false);
                panel.add(new ImageView(image), 0, 0);
                button.setVisible(false);
            }
            clickCount++;
        });
    }
}