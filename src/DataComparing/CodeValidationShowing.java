package DataComparing;

import CrossValidationProcess.CrossValidation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.PrioritySort;
import Methods.ReverseSorting;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.CrossValidationData;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.DARKBLUE;

public class CodeValidationShowing extends Application {
    private TableView table;
    private ObservableList data;
    private Text actionStatus;
    PriorityData[] priorityData,priorityDataCV;
    GenericAlgo[] genericAlgo;
int iterator;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    ReverseSorting soring = new ReverseSorting();
    PrioritySort prioritySort = new PrioritySort();
    @Override
    public void start(Stage primaryStage) throws IOException {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        primaryStage.setTitle("Table View Example 1");
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setOnAction(actionEvent -> {
            CrossValidation crossValidation = new CrossValidation();
            try {
                crossValidation.start(primaryStage);
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
        back.setTranslateX(0);
        back.setTranslateY(685);
        exit.setTranslateX(1100);
        exit.setTranslateY(685);
        Label outputLabel = new Label();
        outputLabel.setTranslateX(540);
        outputLabel.setTranslateY(725);
        Button CV_Output = new Button("Result");
        Font font = Font.font(Font.getFontNames().get(0),FontWeight.BOLD,20);
        CV_Output.setFont(font);
        outputLabel.setFont(font);
        CV_Output.setTranslateX(540);
        CV_Output.setTranslateY(670);
        CV_Output.setPrefSize(200, 50);
        CV_Output.setOnAction(actionEvent -> {
            TrainingSector trainingSector = new TrainingSector();
            try {
                priorityDataCV = processing.fileReaderMethods();
            } catch (IOException e) {
                e.printStackTrace();
            }
            CrossValidationData[] crossValidationData;
            crossValidationData = trainingSector.trainingSectorMethods();
            System.out.println("Thank You");
            double accuracyOfCV = calculateCVResults(crossValidationData, priorityData);
            System.out.println(accuracyOfCV);
            /*JOptionPane.showMessageDialog(null, accuracyOfCV + "%");*/
            outputLabel.setText("Accuracy : "+accuracyOfCV+" %");
        });
        Label label = new Label("Cross Validation Results");
        label.setTextFill(DARKBLUE);
        label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(label);
        table = new TableView();
        data = getInitialTableData();
        table.setItems(data);

        TableColumn bookName = new TableColumn("Book Name");
        bookName.setCellValueFactory(new PropertyValueFactory("bookName"));

        TableColumn writerName = new TableColumn("Writer Name");
        writerName.setCellValueFactory(new PropertyValueFactory("writerName"));

        TableColumn typeName = new TableColumn("Calculated Value");
        typeName.setCellValueFactory(new PropertyValueFactory("typeName"));

        TableColumn bookId = new TableColumn("Book ID");
        bookId.setCellValueFactory(new PropertyValueFactory("bookId"));

        TableColumn bookWeight = new TableColumn("Estimated Value");
        bookWeight.setCellValueFactory(new PropertyValueFactory("bookWeight"));

        table.getColumns().setAll(bookName, writerName, typeName, bookWeight/*,bookWeightCV*/);
        table.setPrefWidth(1400);
        table.setPrefHeight(600);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.getSelectionModel().selectedIndexProperty().addListener(
                new CodeValidationShowing.RowSelectChangeListener());
        actionStatus = new Text();
        actionStatus.setFill(Color.FIREBRICK);

        HBox hBox = new HBox();
        hBox.getChildren().add(table);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hb, hBox);
        Group group = new Group();
        group.getChildren().addAll(vBox, exit, back, CV_Output,outputLabel);

        Scene scene = new Scene(group, 1400, 775);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        table.getSelectionModel().select(0);
        TableData tableData = (TableData) table.getSelectionModel().getSelectedItem();
        actionStatus.setText(tableData.toString());
    }

    private class RowSelectChangeListener implements ChangeListener {
        @Override
        public void changed(ObservableValue observableValue, Object o, Object t1) {
        }
    }

    private ObservableList getInitialTableData( ) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        List list = new ArrayList();
        TrainingSector trainingSector = new TrainingSector();
        priorityDataCV = processing.fileReaderMethods();
        CrossValidationData[] crossValidationData;
        crossValidationData= trainingSector.trainingSectorMethods();
 //       calculateCVResults(crossValidationData,priorityData);
        int jterator=0;
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = processing.fileReaderMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
 jterator=0;
        for(iterator=0;iterator<numberOfBooks;iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                String string = Double.toString(crossValidationData[jterator].estimatedData);
            list.add(new TableData(priorityData[iterator].bookData.bookName,
                    priorityData[iterator].bookData.writerName,
                    Double.toString(crossValidationData[jterator].calculatedValue),
                    Double.toString(crossValidationData[jterator].estimatedData)));
             jterator++;
        }
        }
        ObservableList data = FXCollections.observableList(list);

        return data;
    }
    public double calculateCVResults(CrossValidationData[] crossValidationData,PriorityData [] priorityData){
        int jterator=0;
        double rmsValue=0.0;
        double rmsSquareDifference=0.0;
        double rmsSquareValue=0.0;
        for(iterator=0;iterator<numberOfBooks;iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
             rmsSquareValue= (crossValidationData[jterator].calculatedValue-crossValidationData[jterator].estimatedData);
                rmsSquareDifference = rmsSquareDifference+(rmsSquareValue*rmsSquareValue);
                jterator++;
            }
        }
        rmsValue = Math.sqrt(rmsSquareDifference/jterator);
double accuracyOfCV = 100.00-rmsValue;
return accuracyOfCV;
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
    public  class TableData {
        public SimpleStringProperty bookName;
        public SimpleStringProperty writerName;
        public SimpleStringProperty typeName;
        public SimpleStringProperty bookWeight;
        public SimpleStringProperty estimate;
        public TableData(String s1, String s2, String s4, String  s5/*, String s6*/) {

            bookName = new SimpleStringProperty(s1);
            writerName = new SimpleStringProperty(s2);
            typeName = new SimpleStringProperty(s4);
            bookWeight = new SimpleStringProperty(s5);
        }
        public TableData(SimpleStringProperty bookName,
                    SimpleStringProperty writerName,
                    SimpleStringProperty typeName,
                    SimpleStringProperty bookWeight,
                    SimpleStringProperty estimate) {
            this.bookName = bookName;
            this.writerName = writerName;
            this.typeName = typeName;
            this.bookWeight = bookWeight;
        }

       public String getEstimate() {
            return estimate.get();
        }

        public SimpleStringProperty estimateProperty() {
            return estimate;
        }

        public void setEstimate(String s) {
            this.estimate.set(s);
        }

        public String getTypeName() {
            return typeName.get();
        }

        public SimpleStringProperty typeNameProperty() {
            return typeName;
        }

        public void setTypeName(String s) {
            this.typeName.set(s);
        }

        public String getBookWeight() {
            return bookWeight.get();
        }

        public SimpleStringProperty bookWeightProperty() {
            return bookWeight;
        }

        public void setBookWeight(String s) {
            this.bookWeight.set(s);
        }

        public String getBookName() {

            return bookName.get();
        }
        public void setBookName(String s) {

            bookName.set(s);
        }

        public String getWriterName() {

            return writerName.get();
        }
        public void setWriterName(String s) {

            writerName.set(s);
        }

        @Override
        public String toString() {
            return (bookName.get() + ", by " + writerName.get());
        }
    }
}
