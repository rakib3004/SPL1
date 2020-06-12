package VisualRepresentation;

import FilePackage.DateTimeWriter;
import InfoDisplay.UIDisplayFX;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EX_FX extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            UIDisplayFX uiDisplayFX = new UIDisplayFX();
            try {
                uiDisplayFX.priceStatistics(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });

        setStyle(exit);
        setStyle(back);


        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);



        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");


        ScatterChart ScatterChart  = new ScatterChart (categoryAxis,numberAxis);


        String over100,over140;



        over100 =  "Sin_Data" ;
        over140 =  "Cos_Data" ;



        double [] over100Count= new double[7];
        double[] over140Count= new double[7];



        int iterator;
for(iterator=0;iterator<7;iterator++){
    over100Count[iterator] = Math.sin((((iterator+1))*(iterator+1)));
}
for(iterator=0;iterator<7;iterator++){
    over140Count[iterator] = Math.cos((((iterator+1))*(iterator+1)));
}

        XYChart.Series series1 = new XYChart.Series();
        series1.setName(over100);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(over140);



        series1.getData().add(new XYChart.Data(over100,over100Count[0]));
        series1.getData().add(new XYChart.Data(over100,over100Count[1]));
        series1.getData().add(new XYChart.Data(over100,over100Count[2]));
        series1.getData().add(new XYChart.Data(over100,over100Count[3]));
        series1.getData().add(new XYChart.Data(over100,over100Count[4]));
        series1.getData().add(new XYChart.Data(over100,over100Count[5]));
        series1.getData().add(new XYChart.Data(over100,over100Count[6]));


        series2.getData().add(new XYChart.Data(over140,over140Count[0]));
        series2.getData().add(new XYChart.Data(over140,over140Count[1]));
        series2.getData().add(new XYChart.Data(over140,over140Count[2]));
        series2.getData().add(new XYChart.Data(over140,over140Count[3]));
        series2.getData().add(new XYChart.Data(over140,over140Count[4]));
        series2.getData().add(new XYChart.Data(over140,over140Count[5]));
        series2.getData().add(new XYChart.Data(over140,over140Count[6]));


        ScatterChart .getData().add(series1);
        ScatterChart .getData().add(series2);



        ScatterChart .setTranslateX(65);
        ScatterChart .setTranslateY(55);
        ScatterChart .setPrefSize(1000,700);





        LineChart LineChart  = new LineChart (categoryAxis,numberAxis);


        XYChart.Series seriesA = new XYChart.Series();
        seriesA.setName(over100);
        XYChart.Series seriesB = new XYChart.Series();
        seriesB.setName(over140);


int counterMath;

        for(iterator=0;iterator<7;iterator++){
            counterMath = iterator+1;
            over100Count[iterator] = (counterMath*counterMath*counterMath)-(counterMath*counterMath);
        }
        for(iterator=0;iterator<7;iterator++){
            counterMath = iterator+1;

            over140Count[iterator] = (counterMath*counterMath*counterMath*counterMath)-(counterMath*counterMath*counterMath);
        }
        over100 =  "Qubic_Data" ;
        over140 =  "Square_Data" ;


        seriesA.getData().add(new XYChart.Data(over100,over100Count[0]));
        seriesA.getData().add(new XYChart.Data(over100,over100Count[1]));
        seriesA.getData().add(new XYChart.Data(over100,over100Count[2]));
        seriesA.getData().add(new XYChart.Data(over100,over100Count[3]));
        seriesA.getData().add(new XYChart.Data(over100,over100Count[4]));
        seriesA.getData().add(new XYChart.Data(over100,over100Count[5]));
        seriesA.getData().add(new XYChart.Data(over100,over100Count[6]));


        seriesB.getData().add(new XYChart.Data(over140,over140Count[0]));
        seriesB.getData().add(new XYChart.Data(over140,over140Count[1]));
        seriesB.getData().add(new XYChart.Data(over140,over140Count[2]));
        seriesB.getData().add(new XYChart.Data(over140,over140Count[3]));
        seriesB.getData().add(new XYChart.Data(over140,over140Count[4]));
        seriesB.getData().add(new XYChart.Data(over140,over140Count[5]));
        seriesB.getData().add(new XYChart.Data(over140,over140Count[6]));





        LineChart .getData().add(seriesA);
        LineChart .getData().add(seriesB);




        LineChart .setTranslateX(65);
        LineChart .setTranslateY(55);
        LineChart .setPrefSize(1000,700);



        HBox hBox1 = new HBox(ScatterChart ,exit,back);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(1400,750);
        // vBox3.setSpacing(5);


        Image background = new Image("Images"+ File.separator +"libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();


    }

    public Button setStyle(Button button)
    {
        button.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  button;
    }
}
