package JavFX;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.PriorityData;
import Regression.newVersion.TypeCountRegression;
import javafx.application.Application;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.IOException;

public class DampFX extends Application {

    PriorityData[] priorityData;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


     Label label = new Label("\t\"Recommendation Tool for Library Management\"");

        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, 15);

        label.setFont(font);
        label.setStyle("-fx-body-color: white;");
        Label label2 = new Label("\t\t\t\t\t\"All Statistical Analysis For Library Books\"");
label2.setFont(font1);
        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(label,label2);


           vBox2.setSpacing(5);

        vBox2.setStyle("-fx-padding: 5;" +
                "-fx-border-style: inset;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 0;" +
                "-fx-border-color: white;" +
                "-fx-background-color: lime;");


        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Destination");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("No. of Train");

        BarChart barChart = new BarChart(categoryAxis,numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Train");

        series1.getData().add(new XYChart.Data("Mohanganj",3));
        series1.getData().add(new XYChart.Data("Deyanganj",5));
        series1.getData().add(new XYChart.Data("Chattragam",7));

        barChart.getData().add(series1);

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Station");

        series2.getData().add(new XYChart.Data("Mohanganj",17));
        series2.getData().add(new XYChart.Data("Deyanganj",23));
        series2.getData().add(new XYChart.Data("Chattragam",38));

        barChart.getData().add(series2);

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Passengers");

        series3.getData().add(new XYChart.Data("Mohanganj",27));
        series3.getData().add(new XYChart.Data("Deyanganj",30));
        series3.getData().add(new XYChart.Data("Chattragam",18));

        barChart.getData().add(series3);


        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Distance");

        series4.getData().add(new XYChart.Data("Mohanganj",37));
        series4.getData().add(new XYChart.Data("Deyanganj",25));
        series4.getData().add(new XYChart.Data("Chattragam",12));

        barChart.getData().add(series4);

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("Distance");

        series5.getData().add(new XYChart.Data("Mohanganj",37));
        series5.getData().add(new XYChart.Data("Deyanganj",25));
        series5.getData().add(new XYChart.Data("Chattragam",12));

        barChart.getData().add(series5);


        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("Golpo", 23);
        PieChart.Data slice2 = new PieChart.Data("Kobita"  , 17);
        PieChart.Data slice3 = new PieChart.Data("Kisore Uponnash" , 36);
        PieChart.Data slice4 = new PieChart.Data("Romantic Uponnash" , 26);
        PieChart.Data slice5 = new PieChart.Data("History" , 14);
        PieChart.Data slice6 = new PieChart.Data("General Knowledge" , 17);
        PieChart.Data slice7 = new PieChart.Data("Science Fiction" , 9);
        PieChart.Data slice8 = new PieChart.Data("Probondho" , 33);
        PieChart.Data slice9 = new PieChart.Data("Rocona Somogro" , 26);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);
        pieChart.getData().add(slice6);
        pieChart.getData().add(slice7);
        pieChart.getData().add(slice8);
        pieChart.getData().add(slice9);

        HBox hBox1 = new HBox(barChart,pieChart);
;

       TableView tableView = new TableView();

       /* TableColumn<FxDatabase,String > column0 = new TableColumn<>("index");
        column0.setCellValueFactory(new PropertyValueFactory<>("index"));*/

        TableColumn<FxDatabase,String > column1 = new TableColumn<>("bookName");
        column1.setCellValueFactory(new PropertyValueFactory<>("bookName"));


        TableColumn<FxDatabase,String > column2 = new TableColumn<>("writerName");
        column2.setCellValueFactory(new PropertyValueFactory<>("writerName"));

TableColumn<FxDatabase,String > column3 = new TableColumn<>("bookId");
        column3.setCellValueFactory(new PropertyValueFactory<>("bookId"));


        TableColumn<FxDatabase,String > column4 = new TableColumn<>("borrowCount");
        column4.setCellValueFactory(new PropertyValueFactory<>("borrowCount"));

        TableColumn<FxDatabase,String > column5 = new TableColumn<>("priceCount");
        column5.setCellValueFactory(new PropertyValueFactory<>("priceCount"));


       // tableView.getColumns().add(column0);
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);


        int i;
        String index;

        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();

for(i=0;i<numberOfBooks;i++){

    tableView.getItems().add(new FxDatabase(priorityData[i].bookData.bookName,
            priorityData[i].bookData.writerName,priorityData[i].bookData.bookId,
            priorityData[i].bookData.borrowCount,priorityData[i].bookData.bookPrice));
            }



      VBox vBox3 = new VBox();
        vBox3.getChildren().addAll(vBox2,hBox1,tableView);

        vBox3.setMaxSize(850, 650);
       // vBox3.setSpacing(5);


        Image background = new Image("libraryBackground10.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vBox3.setBackground(bg);
        Scene scene1 = new Scene(vBox3,900,700);



        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

}
