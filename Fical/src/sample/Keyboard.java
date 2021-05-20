package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Keyboard extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField txt_key = new TextField();
        BorderPane root = new BorderPane();
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10.0);
        gp.setVgap(10.0);
        root.setTop(txt_key );

        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7= new Button("7");
        Button btn8= new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");
        Button buttonDOT = new Button(".");

        Button buttonEQU = new Button("=");
        setButtonSize(btn1);
        setButtonSize(btn2);
        setButtonSize(btn3);
        setButtonSize(btn4);
        setButtonSize(btn5);
        setButtonSize(btn6);
        setButtonSize(btn7);
        setButtonSize(btn8);
        setButtonSize(btn9);
        setButtonSize(btn0);
        setButtonSize(buttonDOT);

        setButtonSize(buttonEQU);

        gp.add(btn7, 0, 0);
        gp.add(btn8, 1, 0);
        gp.add(btn9, 2, 0);


        gp.add(btn4, 0, 1);
        gp.add(btn5, 1, 1);
        gp.add(btn6, 2, 1);


        gp.add(btn1, 0, 2);
        gp.add(btn2, 1, 2);
        gp.add(btn3, 2, 2);


        gp.add(btn0, 0, 3);
        gp.add(buttonDOT, 1, 3);
        gp.add(buttonEQU, 2, 3);


        root.setCenter(gp);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public void setButtonSize(Button button){
        button.setPrefHeight(35.0);
        button.setPrefWidth(35.0);
    }
}