package VisualRepresentation;

import BookDataBaseFX.BorrowCountOfBook;
import FilePackage.DateTimeWriter;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AnalyticChart extends Application {

    @Override
    public void start(Stage primaryStage) {
    }

    public void startTypeBook(Stage primaryStage){

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
            BorrowCountOfBook borrowCountOfBook = new BorrowCountOfBook();
            try {
                borrowCountOfBook.start(primaryStage);
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
        categoryAxis.setLabel("Generics of Book Bar Chart");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Generics of Book");
        BarChart barChart = new BarChart(categoryAxis,numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Number of Books");
        String year2008,year2009,year2010,year2011,year2012,year2013,year2014,year2015,year2016,year2017;
        int  year2008Books,year2009Books,year2010Books,year2011Books,year2012Books,
                year2013Books,year2014Books,year2015Books,year2016Books,year2017Books;
        year2008Books=0;year2009Books=0;year2010Books=0;year2011Books=0;
        year2012Books=0;year2013Books=0;year2014Books=0;year2015Books=0;
        year2016Books=0;year2017Books=0;
        int iterator;
        year2008 =  "year2008" ;
        year2009 =  "year2009" ; year2010 =  "year2010" ; year2011 =  "year2011" ;
        year2012=   "year2012" ;year2013 =  "year2013" ; year2014 =  "year2014" ;
        year2015 =  "year2015" ;year2016 =  "year2016" ; year2017 =  "year2017" ;
        series1.getData().add(new XYChart.Data(year2008,year2008Books));
        series1.getData().add(new XYChart.Data(year2009,year2009Books));
        series1.getData().add(new XYChart.Data(year2010,year2010Books));
        series1.getData().add(new XYChart.Data(year2011,year2011Books));
        series1.getData().add(new XYChart.Data(year2012,year2012Books));
        series1.getData().add(new XYChart.Data(year2013,year2013Books));
        series1.getData().add(new XYChart.Data(year2014,year2014Books));
        series1.getData().add(new XYChart.Data(year2015,year2015Books));
        series1.getData().add(new XYChart.Data(year2016,year2016Books));
        series1.getData().add(new XYChart.Data(year2017,year2017Books));

        barChart.getData().add(series1);
        barChart.setTranslateX(65);
        barChart.setTranslateY(55);
        barChart.setPrefSize(500,500);
        barChart.getData().add(series1);
        barChart.setTranslateX(65);
        barChart.setTranslateY(55);
        barChart.setPrefSize(500,500);


        Image background = new Image("Images"+ File.separator +"libraryBackground4.jpg");
        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        Group group = new Group(exit,back);
        Scene scene = new Scene(group ,1400, 770);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }public void startDemandBook(Stage primaryStage){

    }public void startGenericBook(Stage primaryStage){

    }public void startCLassBook(Stage primaryStage){

    }public void startBorrowCount(Stage primaryStage){

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
