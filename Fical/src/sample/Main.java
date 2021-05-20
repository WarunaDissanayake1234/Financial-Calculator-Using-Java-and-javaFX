package sample;


import javafx.application.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.FileNotFoundException;



public class Main extends Application {

    Stage window;
    Scene scene1, scene2,scene3,scene4,scene5,scenemenu,scene6;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;




        //Scene 1 Home  Btn_And_lable
        Label lb1 = new Label("Financial Calculator");
        lb1.setLayoutX(150);
        lb1.setLayoutY(0);
        lb1.setTextFill(javafx.scene.paint.Color.WHITE);

        Button btn1 = new Button();
        btn1.setText("      Fixed Deposit     ");
        btn1.setLayoutX(350);
        btn1.setLayoutY(160);


        Button btn2 = new Button();
        btn2.setLayoutX(350);
        btn2.setLayoutY(190);
        btn2.setText("             Saving          ");

        Button btn3 = new Button();
        btn3.setText("               Loan           ");
        btn3.setLayoutX(350);
        btn3.setLayoutY(220);

        Button btn4 = new Button();
        btn4.setText("         Mortgage        ");
        btn4.setLayoutX(350);
        btn4.setLayoutY(250);

        Button btn_help_main = new Button("Help");
        btn_help_main.setLayoutX(450);
        btn_help_main.setLayoutY(20);
        btn_help_main.setOnAction(e -> AlertBox_all.display("Help", "select one calculator out of below four calculators..."));


        btn1.setOnAction(e -> window.setScene(scene2));
        btn2.setOnAction(e -> window.setScene(scene3));
        btn3.setOnAction(e -> window.setScene(scene4));
        btn4.setOnAction(e -> window.setScene(scene5));

        Image image = new Image("cal1.jpg");
        ImageView image1 = new ImageView(image);
        image1.setImage(image);
        image1.setFitWidth(520);
        image1.setFitHeight(350);

        //scene 1 Home pane main
        Pane root = new Pane();

        root.getChildren().addAll(image1);
        root.getChildren().add(btn_help_main);
        root.getChildren().addAll(lb1, btn1, btn2);
        root.getChildren().addAll(btn3);
        root.getChildren().addAll(btn4);

        scene1 = new Scene(root, 520, 350);









        //scene 2 btn and lables
        //---------------------------------------------------------------------------------------------------------------------------//
        //FD btn and lables//////
        Button btn_fd = new Button("Back");
        btn_fd.setLayoutX(450);
        btn_fd.setLayoutY(300);
        btn_fd.setTextFill(javafx.scene.paint.Color.WHITE);
        btn_fd.setOnAction(e -> window.setScene(scene1));

        Label lb2 = new Label("Fixed Deposit");
        lb2.setLayoutX(150);
        lb2.setLayoutY(0);
        lb2.setTextFill(javafx.scene.paint.Color.WHITE);

        Label lb_fd1 = new Label("Present Value");
        lb_fd1.setLayoutX(50);
        lb_fd1.setLayoutY(50);
        lb_fd1.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_fd1 = new TextField();
        txt_fd1.setLayoutX(160);
        txt_fd1.setLayoutY(50);

        Label lb_fd2 = new Label("Future Value");
        lb_fd2.setLayoutX(50);
        lb_fd2.setLayoutY(80);
        lb_fd2.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_fd2 = new TextField();
        txt_fd2.setLayoutX(160);
        txt_fd2.setLayoutY(78);

        Label lb_fd3 = new Label("I-Rate");
        lb_fd3.setLayoutX(50);
        lb_fd3.setLayoutY(110);
        lb_fd3.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_fd3 = new TextField();
        txt_fd3.setLayoutX(160);
        txt_fd3.setLayoutY(106);

        Label lb_fd4 = new Label("Number of period");
        lb_fd4.setLayoutX(50);
        lb_fd4.setLayoutY(140);
        lb_fd4.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_fd4 = new TextField();
        txt_fd4.setLayoutX(160);
        txt_fd4.setLayoutY(134);

        Label lb_ans1 = new Label();
        lb_ans1.setLayoutX(50);
        lb_ans1.setLayoutY(200);



        Button btn_fd1 = new Button();
        btn_fd1.setText("Calculate");
        btn_fd1.setLayoutX(210);
        btn_fd1.setLayoutY(200);
        //Formula for Fixed Deposit Calculator
        btn_fd1.setOnAction(e ->{

            if (txt_fd1.getText().isEmpty()){
                Float fv = Float.valueOf(txt_fd2.getText());
                Float rate = Float.valueOf(txt_fd3.getText());
                Float numofp = Float.valueOf(txt_fd4.getText());
                double pv = fv/(Math.pow((1+((rate/100)/12)),(12*numofp)));
                txt_fd1.setText(String.valueOf(pv));
            }
            if(txt_fd2.getText().isEmpty()){
                Float PresentValue = Float.valueOf(txt_fd1.getText());
                Float Rate1 = Float.valueOf(txt_fd3.getText());
                Float T1 = Float.valueOf(txt_fd4.getText());
                double fv = PresentValue*(Math.pow((1+((Rate1)/100/12)),(12*T1)));
                txt_fd2.setText(String.valueOf(fv));
            }
            if(txt_fd3.getText().isEmpty()){
                Float PresentV2 = Float.valueOf(txt_fd1.getText());
                Float Fv_2 = Float.valueOf(txt_fd2.getText());
                Float numofp_2 = Float.valueOf(txt_fd4.getText());
                double IR = 12*(Math.pow((Fv_2/PresentV2),(1/(12*numofp_2)))-1);
                txt_fd3.setText(String.valueOf(IR));
            }
            if (txt_fd4.getText().isEmpty()){
                Float PresentV_3 = Float.valueOf(txt_fd1.getText());
                Float FV_3 = Float.valueOf(txt_fd2.getText());
                Float rate_3 = Float.valueOf(txt_fd3.getText());
                double numofp_3 = (Math.log(FV_3/PresentV_3)/Math.log(2.71))/12 * ((Math.log(1+(rate_3/12))/Math.log(2.71)));
                txt_fd4.setText(String.valueOf(numofp_3));
            }

        });


        Image image_fd = new Image("fd.jpg");
        ImageView image_fd2 = new ImageView(image_fd);
        image_fd2.setImage(image);
        image_fd2.setFitWidth(520);
        image_fd2.setFitHeight(350);

        //Help Button
        Button btn_help = new Button("Help");
        btn_help.setLayoutX(450);
        btn_help.setLayoutY(20);
        btn_help.setOnAction(e -> AlertBox_all.display("Help", "please fill the data in the given boxes and click the 'calculator' button then you can executed the answer..."));


        //scene 2 FD pane
        Pane layout2 = new Pane();
        layout2.getChildren().addAll(image_fd2);
        layout2.getChildren().addAll(btn_fd, lb2, lb_fd1, lb_fd2, txt_fd1, txt_fd2, lb_fd3, txt_fd3, lb_fd4, txt_fd4, btn_fd1, btn_help, lb_ans1);
        scene2 = new Scene(layout2, 520, 350);
        //----------------------------------------------------------------------------------------------------------------------------------------//

        btn1.setOnAction(e -> window.setScene(scene2));
        btn2.setOnAction(e -> window.setScene(scene3));
        btn3.setOnAction(e -> window.setScene(scene4));
        btn4.setOnAction(e -> window.setScene(scene5));







        //---------------------------------------------------------------------------------------------------------------------------------------//
        //scene3 btn and lables Saving Calculator
        Button btn_close_saving = new Button("Back");
        btn_close_saving.setOnAction(e -> window.setScene(scene1));
        btn_close_saving.setLayoutX(450);
        btn_close_saving.setLayoutY(300);
        btn_close_saving.setTextFill(javafx.scene.paint.Color.WHITE);

        Label lb3 = new Label("Saving Calculator");
        lb3.setLayoutX(150);
        lb3.setLayoutY(0);
        lb3.setTextFill(javafx.scene.paint.Color.WHITE);


        Label lb_sa1 = new Label("Present Value");
        lb_sa1.setLayoutX(50);
        lb_sa1.setLayoutY(50);
        lb_sa1.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_sa1 = new TextField();
        txt_sa1.setLayoutX(160);
        txt_sa1.setLayoutY(50);

        Label lb_sa2 = new Label("Monthly Payment");
        lb_sa2.setLayoutX(50);
        lb_sa2.setLayoutY(80);
        lb_sa2.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_sa2 = new TextField();
        txt_sa2.setLayoutX(160);
        txt_sa2.setLayoutY(78);

        Label lb_sa3 = new Label("I-Rate");
        lb_sa3.setLayoutX(50);
        lb_sa3.setLayoutY(110);
        lb_sa3.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_sa3 = new TextField();
        txt_sa3.setLayoutX(160);
        txt_sa3.setLayoutY(106);

        Label lb_sa4 = new Label("Number of Period");
        lb_sa4.setLayoutX(50);
        lb_sa4.setLayoutY(140);
        lb_sa4.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_sa4 = new TextField();
        txt_sa4.setLayoutX(160);
        txt_sa4.setLayoutY(134);

        Label lb_sa5 = new Label("Future Value");
        lb_sa5.setLayoutX(50);
        lb_sa5.setLayoutY(170);
        lb_sa5.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_sa5 = new TextField();
        txt_sa5.setLayoutX(160);
        txt_sa5.setLayoutY(162);

        Label lb_ans2 = new Label("");
        lb_ans2.setLayoutX(150);
        lb_ans2.setLayoutY(200);


        Button btn_sa1 = new Button();
        btn_sa1.setText("Calculate");
        btn_sa1.setLayoutX(210);
        btn_sa1.setLayoutY(200);
        ////Formula for Saving Calculator
        btn_sa1.setOnAction(e ->{

            if (txt_sa1.getText().isEmpty()){
                Float Mpmt = Float.valueOf(txt_sa2.getText());
                Float rate_sa1 = Float.valueOf(txt_sa3.getText());
                Float numofp_sa1 = Float.valueOf(txt_sa4.getText());
                Float  FV_sa1  = Float.valueOf(txt_sa5.getText());
                double PV_sa1 = (FV_sa1- (Mpmt * ((Math.pow((1 + (rate_sa1/12)), 12 * numofp_sa1) - 1) / (rate_sa1/12))))/ (Math.pow((1 + (rate_sa1/12)), 12 * numofp_sa1));
                txt_sa1.setText(String.valueOf(PV_sa1));
            }
            if (txt_sa2.getText().isEmpty()){
                Float PV = Float.valueOf(txt_sa1.getText());
                Float rate_sa1 = Float.valueOf(txt_sa3.getText());
                Float numofp_sa2 = Float.valueOf(txt_sa4.getText());
                Float Fv_2 = Float.valueOf(txt_sa5.getText());
                double monthly = (Fv_2 - (PV * Math.pow((1 + (rate_sa1 / 12)), (12 * numofp_sa2)))) / ((Math.pow((1 + (rate_sa1 / 12)), (12 * numofp_sa2)) - 1) / (rate_sa1 / 12));
                txt_sa2.setText(String.valueOf(monthly));
            }
            if (txt_sa3.getText().isEmpty()){
                Float PV_sa3 = Float.valueOf(txt_sa1.getText());
                Float monthlypmt_3 = Float.valueOf(txt_sa2.getText());
                Float numofp_sa3 = Float.valueOf(txt_sa4.getText());
                Float time_sa3 = Float.valueOf(txt_sa5.getText());
                // double rate = ((monthlypmt_3 * 100) / Ir_lo) * 1 - ((monthlyPmt * 100) / Ir_lo) * (1 / (1 + (Math.pow((Ir_lo / 100), numofp_lo))));
                // txt_sa3.setText(String.valueOf(lo_a));
            }
            if (txt_sa4.getText().isEmpty()){
                Float Pv_sa4 = Float.valueOf(txt_sa1.getText());
                Float monthlypmt_sa4 = Float.valueOf(txt_sa2.getText());
                Float rate_sa4 = Float.valueOf(txt_sa3.getText());
                Float FV_sa4 = Float.valueOf(txt_sa5.getText());
                double Numofp_sa4 = Math.log(((((rate_sa4 * FV_sa4) / 12) + monthlypmt_sa4) / (((Pv_sa4 * rate_sa4) / 12) + monthlypmt_sa4))) / (12 * Math.log(1 + (rate_sa4/12)));
                txt_sa4.setText(String.valueOf(Numofp_sa4));
            }
            if (txt_sa5.getText().isEmpty()){
                Float Pv_5 = Float.valueOf(txt_sa1.getText());
                Float monthlypmt_sa5 = Float.valueOf(txt_sa2.getText());
                Float rate_sa5= Float.valueOf(txt_sa3.getText());
                Float numof_sa5 = Float.valueOf(txt_sa4.getText());
                double Fv_sa5 = (Pv_5 * Math.pow((1 + (rate_sa5 / 12)), (12 * numof_sa5))) + (monthlypmt_sa5 * ((Math.pow((1 + (rate_sa5 / 12)), (12 * numof_sa5)) - 1) / (rate_sa5/12)));
                txt_sa5.setText(String.valueOf(Fv_sa5));
            }


        });




        Image image_sa = new Image("sav.jpg");
        ImageView image_sa1 = new ImageView(image_sa);
        image_sa1.setImage(image_sa);
        image_sa1.setFitWidth(520);
        image_sa1.setFitHeight(350);

        //Help Button
        Button btn_help2 = new Button("Help");
        btn_help2.setLayoutX(450);
        btn_help2.setLayoutY(20);
        btn_help2.setOnAction(e -> AlertBox_all.display("Help", "please fill the data in the given boxes and click the 'calculator' button then you can executed the answer..."));


        //scene3 saving

        Pane pane_sa = new Pane();
        pane_sa.getChildren().add(image_sa1);
        pane_sa.getChildren().addAll(btn_close_saving, lb3, lb_sa1, txt_sa1, lb_sa2, txt_sa2, lb_sa3, txt_sa3, lb_sa4, txt_sa4, btn_sa1, btn_help2, lb_ans2,lb_sa5,txt_sa5);
        scene3 = new Scene(pane_sa, 520, 350);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------//











        //scene4 btn and lables (Loan Loan Calculator)

        Button btn_close_loan = new Button("Back");
        btn_close_loan.setOnAction((e -> window.setScene(scene1)));
        btn_close_loan.setLayoutX(450);
        btn_close_loan.setLayoutY(300);
        btn_close_loan.setTextFill(javafx.scene.paint.Color.WHITE);

        Label lb4 = new Label("Loan Calculator");
        lb4.setLayoutX(150);
        lb4.setLayoutY(0);
        lb4.setTextFill(javafx.scene.paint.Color.WHITE);

        Label lb_lo1 = new Label("Loan Amount");
        lb_lo1.setLayoutX(50);
        lb_lo1.setLayoutY(50);
        lb_lo1.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_lo1 = new TextField();
        txt_lo1.setLayoutX(160);
        txt_lo1.setLayoutY(50);

        Label lb_lo2 = new Label("I-Rate");
        lb_lo2.setLayoutX(50);
        lb_lo2.setLayoutY(80);
        lb_lo2.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_lo2 = new TextField();
        txt_lo2.setLayoutX(160);
        txt_lo2.setLayoutY(78);

        Label lb_lo3 = new Label("Number of months");
        lb_lo3.setLayoutX(50);
        lb_lo3.setLayoutY(110);
        lb_lo3.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_lo3 = new TextField();
        txt_lo3.setLayoutX(160);
        txt_lo3.setLayoutY(106);

        Label lb_lo4 = new Label("Monthly Payment");
        lb_lo4.setLayoutX(50);
        lb_lo4.setLayoutY(140);
        lb_lo4.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_lo4 = new TextField();
        txt_lo4.setLayoutX(160);
        txt_lo4.setLayoutY(134);

        Button btn_lo1 = new Button();
        btn_lo1.setText("Calculate");
        btn_lo1.setLayoutX(210);
        btn_lo1.setLayoutY(200);

        ////Formula for Loan calculator
        btn_lo1.setOnAction(e ->{

            if (txt_lo4.getText().isEmpty()){
                Float LA = Float.valueOf(txt_lo1.getText());
                Float Ir_lo2 = Float.valueOf(txt_lo2.getText());
                Float numofp_lo2 = Float.valueOf(txt_lo3.getText());
                double PMT_lo1 = (LA * (Ir_lo2/100)) / (1 - (1 / Math.pow((1 + (Ir_lo2/100)), numofp_lo2)));
                txt_lo4.setText(String.valueOf(PMT_lo1));
            }
            if (txt_lo3.getText().isEmpty()){
                Float La_2 = Float.valueOf(txt_lo1.getText());
                Float Ir_2 = Float.valueOf(txt_lo2.getText());
                Float montlypmt_2 = Float.valueOf(txt_lo4.getText());
                double numofp_la = Math.log((montlypmt_2 / Ir_2) / ((montlypmt_2 / Ir_2) - La_2)) / Math.log(1 + Ir_2);
                txt_lo3.setText(String.valueOf(numofp_la));
            }

        });

        Label lb_ans3 = new Label();
        lb_ans3.setLayoutX(150);
        lb_ans3.setLayoutY(200);

        Image image_lo = new Image("loan.jpg");
        ImageView image_lo1 = new ImageView();
        image_lo1.setImage(image_lo);
        image_lo1.setFitWidth(520);
        image_lo1.setFitHeight(350);

        //Help Button
        Button btn_help3 = new Button("Help");
        btn_help3.setLayoutX(450);
        btn_help3.setLayoutY(20);
        btn_help3.setOnAction(e -> AlertBox_all.display("Help", "please fill the data in the given boxes and click the 'calculator' button then you can executed the answer..."));


        //loan pane
        Pane pane_lo = new Pane();
        pane_lo.getChildren().add(image_lo1);
        pane_lo.getChildren().addAll(btn_close_loan, lb4, lb_lo1, txt_lo1, lb_lo2, txt_lo2, lb_lo3, txt_lo3, lb_lo4, txt_lo4, btn_lo1, btn_help3, lb_ans3);
        scene4 = new Scene(pane_lo, 520, 350);

        //----------------------------------------------------------------------------------------------------------------------------------------------------//










        //scene5 btn and lables (Mortgage Calculator)

        Button btn_close_Mortgage = new Button("Back");
        btn_close_Mortgage.setOnAction(e -> window.setScene(scene1));
        btn_close_Mortgage.setLayoutX(450);
        btn_close_Mortgage.setLayoutY(300);
        btn_close_Mortgage.setTextFill(javafx.scene.paint.Color.WHITE);

        Label lb5 = new Label("Mortgage Calculator");
        lb5.setLayoutX(150);
        lb5.setLayoutY(0);
        lb5.setTextFill(javafx.scene.paint.Color.WHITE);

        Label lb_mo1 = new Label("Mortgage Amount");
        lb_mo1.setLayoutX(50);
        lb_mo1.setLayoutY(50);
        lb_mo1.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_mo1 = new TextField();
        txt_mo1.setLayoutX(160);
        txt_mo1.setLayoutY(50);

        Label lb_mo2 = new Label("I-Rate");
        lb_mo2.setLayoutX(50);
        lb_mo2.setLayoutY(80);
        lb_mo2.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_mo2 = new TextField();
        txt_mo2.setLayoutX(160);
        txt_mo2.setLayoutY(78);

        Label lb_mo3 = new Label("Number of period");
        lb_mo3.setLayoutX(50);
        lb_mo3.setLayoutY(110);
        lb_mo3.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_mo3 = new TextField();
        txt_mo3.setLayoutX(160);
        txt_mo3.setLayoutY(106);

        Label lb_mo4 = new Label("Monthly Payment");
        lb_mo4.setLayoutX(50);
        lb_mo4.setLayoutY(140);
        lb_mo4.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_mo4 = new TextField();
        txt_mo4.setLayoutX(160);
        txt_mo4.setLayoutY(134);

        Label lb_mo5 = new Label("Down Payment");
        lb_mo5.setLayoutX(50);
        lb_mo5.setLayoutY(170);
        lb_mo5.setTextFill(javafx.scene.paint.Color.WHITE);

        TextField txt_mo5 = new TextField();
        txt_mo5.setLayoutX(160);
        txt_mo5.setLayoutY(162);






        Button btn_mo1 = new Button();
        btn_mo1.setText("Calculate");
        btn_mo1.setLayoutX(210);
        btn_mo1.setLayoutY(200);

        //Formula for Mortgage calculator
        btn_mo1.setOnAction(e ->{

            if (txt_mo3.getText().isEmpty()){
                Float Ma_1 = Float.valueOf(txt_mo1.getText());
                Float rate_mo = Float.valueOf(txt_mo2.getText());
                Float mPmt_mo = Float.valueOf(txt_mo4.getText());
                Float DPMT_Mo1 = Float.valueOf(txt_mo5.getText());
                double numofp_mo =  ((Math.log((mPmt_mo )/ (mPmt_mo - ((rate_mo/12) * (Ma_1 - DPMT_Mo1)))))) /  (12 * Math.log(1 + (rate_mo/12)));
                txt_mo3.setText(String.valueOf(numofp_mo));
            }
            if (txt_mo4.getText().isEmpty()){
                Float MA = Float.valueOf(txt_mo1.getText());
                Float rate_mo1  = Float.valueOf(txt_mo2.getText());
                Float numofp_mo1 = Float.valueOf(txt_mo3.getText());
                Float DPMT_Mo = Float.valueOf(txt_mo5.getText());
                double monthlyPayment_mo  =  ((MA - DPMT_Mo) * (rate_mo1 / 12) * Math.pow((1 + (rate_mo1 / 12)), 12 * numofp_mo1)) / (Math.pow((1 + (rate_mo1 / 12)), 12 * numofp_mo1) - 1);
                txt_mo4.setText(String.valueOf(monthlyPayment_mo));
            }


        });

        Label lb_ans4 = new Label("");
        lb_ans4.setLayoutX(150);
        lb_ans4.setLayoutY(200);

        Image image_mo = new Image("mortgage.jpg");
        ImageView image_mo1 = new ImageView();
        image_mo1.setImage(image_mo);
        image_mo1.setFitWidth(520);
        image_mo1.setFitHeight(350);

        //Help Button
        Button btn_help4 = new Button("Help");
        btn_help4.setLayoutX(450);
        btn_help4.setLayoutY(20);
        btn_help4.setOnAction(e -> AlertBox_all.display("Help", "please fill the data in the given boxes and click the 'calculator' button then you can executed the answer..."));


        //scene5 pane
        Pane pane_Mortgage = new Pane();
        pane_Mortgage.getChildren().add(image_mo1);
        pane_Mortgage.getChildren().addAll(btn_close_Mortgage, lb5, lb_mo1, txt_mo1, lb_mo2, txt_mo2, lb_mo3, txt_mo3, lb_mo4, txt_mo4, btn_mo1, btn_help4, lb_ans4,lb_mo5,txt_mo5);
        scene5 = new Scene(pane_Mortgage, 520, 350);

        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//







        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Financial Calculator");
        window.show();





        //CSS Part
        lb1.setStyle("-fx-font:normal bold 30px 'calibri light' ");
        lb2.setStyle("-fx-font:normal bold 30px 'calibri light' ");
        lb3.setStyle("-fx-font:normal bold 30px 'calibri light' ");
        lb4.setStyle("-fx-font:normal bold 30px 'calibri light' ");
        lb5.setStyle("-fx-font:normal bold 30px 'calibri light' ");
        lb_fd1.setStyle("-fx-font:normal bold 15px 'calibri light' ");
        lb_fd2.setStyle("-fx-font:normal bold 15px 'calibri light' ");
        lb_fd3.setStyle("-fx-font:normal bold 15px 'calibri light' ");
        lb_fd4.setStyle("-fx-font:normal bold 15px 'calibri light' ");
        btn1.setStyle("-fx-background-color:lightgreen; -fx-font: normal bold 15px'calibri light';-fx-textFill:black");
        btn2.setStyle("-fx-background-color:#3CF2D9;-fx-font: normal bold 15px'calibri light';-fx-textFill:black");
        btn3.setStyle("-fx-background-color:#FEA217;-fx-font: normal bold 15px'calibri light';-fx-textFill:black");
        btn4.setStyle("-fx-background-color:#E51CF3;-fx-font: normal bold 15px'calibri light';-fx-textFill:black");
        btn_fd.setStyle("-fx-background-color:Red;-fx-font: normal bold 15px'calibri light';-fx-textFill:black;");
        btn_close_saving.setStyle("-fx-background-color:Red;-fx-font: normal bold 15px'calibri light';-fx-textFill:black;");
        btn_close_loan.setStyle("-fx-background-color:Red;-fx-font: normal bold 15px'calibri light';-fx-textFill:black;");
        btn_close_Mortgage.setStyle("-fx-background-color:Red;-fx-font: normal bold 15px'calibri light';-fx-textFill:black;");


    }




}
