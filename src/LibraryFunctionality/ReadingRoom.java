package LibraryFunctionality;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.ReverseSorting;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;
import TableViewPackage.Book;
import UserInterfacePackage.ChooseType;
import UserInterfacePackage.RemoveBookFX;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ReadingRoom extends Application {

    private TableView table;
    private ObservableList data;
    private Text actionStatus;
    GenericAlgo[] genericAlgo;
    ReverseSorting reverseSorting = new ReverseSorting();
    List list = new ArrayList();

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;
    int iterator;


    int numberOfBooks;
    int bookPoint;

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public int getBookPoint() {
        return bookPoint;
    }

    public void setBookPoint(int bookPoint) {
        this.bookPoint = bookPoint;
    }

    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    String labelName="Top Books";
    TreeMap<Object, Object> map = new TreeMap<>();
    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

    @Override
    public void start(Stage primaryStage) {


        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        if(bookPoint==0){
            try {
                priorityData = processing.fileReaderMethods();
                numberOfBooks = bookNumber.bookNumberFindingMethods();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                priorityData = processing.fileReaderMethods();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
        priorityData = reverseSorting.reverseSortingMLRmethods(priorityData,numberOfBooks);
        Button back = new Button("Back");
        Button exit = new Button("Exit");

        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        back.setOnAction(actionEvent -> {
            ChooseType chooseType = new ChooseType();

            try {
                chooseType.start(primaryStage);
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

        Button show = new Button("Show");

        show.setTranslateX(550);
        show.setTranslateY(350);

        show.setOnAction(actionEvent -> {
            showInfo(primaryStage,labelName,data);
        });

        setStyle(show);


        show.setPrefSize(200, 80);

        labelName="Top Books of "+this.getClass();

        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            list.add(new Book(priorityData[iterator].bookData.bookName,
                    priorityData[iterator].bookData.writerName,
                    priorityData[iterator].bookData.bookId,
                    priorityData[iterator].bookData.typeName));

            data = FXCollections.observableList(list);

        }




        Image image = new Image("libraryBackground5.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,show);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);


        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();


    }


    public void showInfo(Stage secondaryStage,String labelName,ObservableList data){


        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Label label = new Label();
        label.setPrefSize(800,45);
        label.setTranslateX(150);
        label.setTranslateY(0);
        label.setText(labelName);
        setStyle(label);


        Button back = new Button("Back");
        Button exit = new Button("Exit");


        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);



        back.setOnAction(actionEvent -> {
            list.clear();

            try {
                this.start(secondaryStage);
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




        TextField textField1 = new TextField();
        setStyle(textField1);
        textField1.setTranslateX(580);
        textField1.setTranslateY(650);
        textField1.setPrefSize(120,80);




        Image image = new Image("libraryBackground16.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit, back);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image, 0, 0);

        Scene scene1 = new Scene(group, 1500, 950);

        secondaryStage.setScene(scene1);
        secondaryStage.setTitle("Books Statistics");
        secondaryStage.setFullScreen(true);
        secondaryStage.show();


    }

    private class RowSelectChangeListener implements ChangeListener {

        @Override
        public void changed(ObservableValue observableValue, Object o, Object t1) {

        }
    }

    private ObservableList getInitialTableData() throws IOException {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);


        List list = new ArrayList();


        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
        priorityData = reverseSorting.reverseSortingMLRmethods(priorityData,numberOfBooks);


        int iterator;
        for(iterator=0;iterator<numberOfBooks;iterator++){

            list.add(new Book(priorityData[genericAlgo[iterator].getIndex()].bookData.bookName,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.writerName,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.bookId));
        }
        ObservableList data = FXCollections.observableList(list);
        return data;
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
    public Label setStyle(Label label)
    {
        label.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color:\n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return   label;
    }

    public Text setStyle(Text text)
    {
        text.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color:\n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  text;
    }

    public TextField setStyle(TextField textField)
    {
        textField.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color:\n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  textField;
    }
    public TextField setStylePro(TextField textField)
    {
        textField.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color:\n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: ;\n" +
                "    -fx-font-size: 0.7em;");
        return  textField;
    }
}
