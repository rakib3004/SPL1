package LinearRegression;

import FilePackage.DateTimeWriter;
import RecommendationAlgorithm.MultiVaribleRegression;
import TableViewPackage.MLR_Chart_View;
import TableViewPackage.MLR_TableView;
import MultiVariableRegression.MultipleLinearRegression;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.PriorityData;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FourVariableRegression extends Application {
    PriorityData[] priorityData;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    @Override
    public void start(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        graphView.setOnAction(actionEvent -> {
            MLR_Chart_View mlr_chart_view = new MLR_Chart_View();
            try {
                mlr_chart_view.start(primaryStage);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        tableView.setOnAction(actionEvent -> {
            try {
                MLR_TableView MLRTableViewFX = new MLR_TableView();
                MLRTableViewFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        consoleView.setOnAction(actionEvent -> {
            try {
                priorityData = processing.fileReaderMethods();
                numberOfBooks = bookNumber.bookNumberFindingMethods();
                priorityData =     multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
                System.exit(0);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        back.setOnAction(actionEvent -> {
            MultiVaribleRegression multiVaribleRegression = new MultiVaribleRegression();
            try {
                multiVaribleRegression.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


    }

    public Button setStyle( Button button)
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
