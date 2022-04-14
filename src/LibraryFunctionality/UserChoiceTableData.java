package LibraryFunctionality;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.PrioritySort;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;
import TableViewPackage.Book;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserChoiceTableData {
    private TableView table;
    private ObservableList data;
    private Text actionStatus;
    GenericAlgo[] genericAlgo;
    PrioritySort prioritySort = new PrioritySort();
    List list = new ArrayList();

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;
    int iterator;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    String labelName;
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    PriorityList priorityList1 = new PriorityList();

    public void start(Stage primaryStage, String userName, String userID, PriorityList priorityList) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        try {
            priorityData = processing.fileReaderMethods();
            numberOfBooks = bookNumber.bookNumberFindingMethods();
        } catch (IOException e) {
            e.printStackTrace();
        }
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
        priorityData = prioritySort.PrioritySortingMLRmethods(priorityData, numberOfBooks);
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        labelName = "  " + userName + "'s Choice List";
        int jterator = 0;
        for (jterator = 0; jterator < priorityList.typeCounter; jterator++) {
            for (iterator = 0; iterator < numberOfBooks; iterator++) {
                if (priorityData[iterator].bookData.typeName.equals(priorityList.favTypeList[jterator])) {
                    list.add(new Book(priorityData[iterator].bookData.bookName,
                            priorityData[iterator].bookData.writerName,
                            priorityData[iterator].bookData.bookId,
                            priorityData[iterator].bookData.typeName));
                    data = FXCollections.observableList(list);
                    // Kisore Uponnash
                }
                if (priorityData[iterator].bookData.typeName.equals("Uponnash")
                        || priorityData[iterator].bookData.typeName.equals("Sci Fi")
                        || priorityData[iterator].bookData.typeName.equals("Kisore Uponnash")) {
                    list.add(new Book(priorityData[iterator].bookData.bookName,
                            priorityData[iterator].bookData.writerName,
                            priorityData[iterator].bookData.bookId,
                            priorityData[iterator].bookData.typeName));
                    data = FXCollections.observableList(list);
                }
            }

        }
        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 30);
        back.setFont(font3);
        exit.setFont(font3);
        Button show = new Button("Show");
        show.setTranslateX(550);
        show.setTranslateY(350);
        show.setPrefSize(200, 100);
        show.setFont(font3);

        show.setOnAction(actionEvent -> {
            showInfo(primaryStage, labelName, data);
        });

        Image image = new Image("Images" + File.separator + "Form2.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, exit, back, show/* ,bookType */);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image, 0, 0);
        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

    public void showInfo(Stage secondaryStage, String labelName, ObservableList data) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Label label = new Label();
        label.setPrefSize(350, 45);
        label.setTranslateX(460);
        label.setTranslateY(15);
        label.setText(labelName);
        label.setTextAlignment(TextAlignment.CENTER);
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(25);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 30);
        Font font4 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 40);
        back.setFont(font3);
        exit.setFont(font3);
        label.setFont(font4);
        String userName = "", userID = "";
        back.setOnAction(actionEvent -> {
            list.clear();
            try {
                this.start(secondaryStage, userName, userID, priorityList1);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        table = new TableView();
        table.setItems(data);

        TableColumn bookName = new TableColumn("Book Name");
        bookName.setCellValueFactory(new PropertyValueFactory("bookName"));

        TableColumn writerName = new TableColumn("Writer Name");
        writerName.setCellValueFactory(new PropertyValueFactory("writerName"));

        TableColumn bookId = new TableColumn("Book ID");
        bookId.setCellValueFactory(new PropertyValueFactory("bookId"));

        TableColumn typeName = new TableColumn("Type Name");
        typeName.setCellValueFactory(new PropertyValueFactory("typeName"));

        table.getColumns().setAll(bookName, writerName, typeName, bookId);
        table.setPrefWidth(1240);
        table.setPrefHeight(560);
        table.setTranslateX(60);
        table.setTranslateY(70);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getSelectionModel().selectedIndexProperty().addListener(
                new UserChoiceTableData.RowSelectChangeListener());
        table.getSelectionModel().select(0);
        Book book = (Book) table.getSelectionModel().getSelectedItem();

        Image image = new Image("Images" + File.separator + "libraryBackground1.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, exit, back, label, table);
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
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        List list = new ArrayList();

        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
        priorityData = prioritySort.PrioritySortingMLRmethods(priorityData, numberOfBooks);
        int iterator;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            list.add(new Book(priorityData[genericAlgo[iterator].getIndex()].bookData.bookName,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.writerName,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.bookId));
        }
        ObservableList data = FXCollections.observableList(list);
        return data;
    }

}