package sample;


import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox_all {

    public static void display(String title, String message) {
        Stage window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(300);

        Label label_Al = new Label();
        label_Al.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout_Al = new VBox(10);
        layout_Al.getChildren().addAll(label_Al, closeButton);
        layout_Al.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout_Al);
        window.setScene(scene);
        window.showAndWait();
    }

}