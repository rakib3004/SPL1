package LibraryFunctionality;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import Layout.ButtonDesign;
import LinearRegression.FourVariableRegression;
import MainPackage.BookNumber;
import MainPackage.DataParsing;
import MainPackage.Processing;
import Methods.PrintInfo;
import Methods.PrioritySort;
import Methods.ReverseSorting;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.BookData;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;
import TableViewPackage.AHP_TableView;
import TableViewPackage.Book;
import TableViewPackage.MLR_TableView;
import TableViewPackage.PRA_TableView;
import UserInterfacePackage.TypeWise;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryUserShowing extends Application {

    private TableView table;
    private ObservableList data;
    private Text actionStatus;
    PriorityData[] priorityData;
    GenericAlgo[] genericAlgo;
    LibraryUser[] libraryUsers;
    int numOfBook;
    BookData[] bookData = new BookData[1050];

    DataParsing dataParsing = new DataParsing();
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    ReverseSorting soring = new ReverseSorting();

    PrioritySort prioritySort = new PrioritySort();
    List list = new ArrayList();
    AHPcriteriaWeight ahPcriteriaWeight;
    int iterator;

    String labelName = "Top Books";

    public void startstartInUp(Stage primaryStage) throws IOException {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setOnAction(actionEvent -> {

        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        table = new TableView();
        data = getInitialTableData();

        TableColumn userId = new TableColumn("User Id");
        userId.setCellValueFactory(new PropertyValueFactory("userID"));

        TableColumn userName = new TableColumn("User Name");
        userName.setCellValueFactory(new PropertyValueFactory("userName"));
        TableColumn userInstitute = new TableColumn("User Institute");
        userInstitute.setCellValueFactory(new PropertyValueFactory("userInstitute"));

        TableColumn userEducationLevel = new TableColumn("User Education Level");
        userEducationLevel.setCellValueFactory(new PropertyValueFactory("userEducationLevel"));
        TableColumn userClass = new TableColumn("User Class");
        userClass.setCellValueFactory(new PropertyValueFactory("userClass"));

        table.getColumns().setAll(userId, userName, userInstitute, userEducationLevel, userClass);

        // REFORM _TABLE _STRUCTURE
        table.setTranslateX(65);
        table.setTranslateY(70);
        table.setPrefSize(1250, 560);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // set new label for table
        String labelName = "Multi Variable Results";
        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 30);
        Font font4 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 40);
        Label label2 = new Label();
        label2.setPrefSize(700, 45);
        label2.setTranslateX(454);
        label2.setTranslateY(0);
        label2.setText(labelName);
        label2.setFont(font4);

        // reset buttons position
        back.setTranslateX(35);
        back.setTranslateY(650);
        exit.setTranslateX(1135);
        exit.setTranslateY(650);
        back.setFont(font3);
        exit.setFont(font3);

        // add image as a backgroun in this table showing
        Image image = new Image("Images" + File.separator + "table2.jpg");
        Canvas canvas = new Canvas(1500, 950);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image, 0, 0);

        Group group = new Group();
        group.getChildren().addAll(canvas, table, label2, exit, back);

        Scene scene = new Scene(group, 1400, 775);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        // Select the first row
        table.getSelectionModel().select(0);
        Library library = (Library) table.getSelectionModel().getSelectedItem();
        actionStatus.setText(library.toString());
    }

    public void start(Stage primaryStage) throws IOException {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        // add button desing
        ButtonDesign buttonDesign = new ButtonDesign();

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setOnAction(actionEvent -> {

        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        back.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 30);

        // reset buttons position
        back.setTranslateX(35);
        back.setTranslateY(650);
        exit.setTranslateX(1135);
        exit.setTranslateY(650);
        back.setFont(font3);
        exit.setFont(font3);
        primaryStage.setTitle("JavaFX App");

        FileChooser fileChooser = new FileChooser();

        Button newLibraryData = new Button("Select File");
        newLibraryData.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            Processing processing = new Processing();
            try {
                priorityData = processing.fileChooserMethods(selectedFile);
                numberOfBooks = bookNumber.bookNumberFindingMethods();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
            priorityData = prioritySort.PrioritySortingMLRmethods(priorityData, numberOfBooks);

            labelName = "Library's Book Recommendation";
            for (iterator = 0; iterator < numberOfBooks; iterator++) {
                list.add(new Book(priorityData[iterator].bookData.bookName,
                        priorityData[iterator].bookData.writerName,
                        priorityData[iterator].bookData.bookId,
                        priorityData[iterator].bookData.typeName));
                data = FXCollections.observableList(list);

            }
            showInfo(primaryStage, labelName, data);

        });

        newLibraryData = buttonDesign.systemLine(newLibraryData, 150, 60, 666, 333, 25);

        Button enterButton = new Button("MLR");
        enterButton = buttonDesign.systemLine(enterButton, 150, 60, 666, 433, 25);

        // add image as a backgroun in this table showing
        Image image = new Image("Images" + File.separator + "table2.jpg");
        Canvas canvas = new Canvas(1500, 950);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image, 0, 0);

        Group group = new Group();
        group.getChildren().addAll(canvas, newLibraryData, exit, back);

        Scene scene = new Scene(group, 1400, 775);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

    /*
     * private ObservableList getInitialTableData() throws IOException {
     * List list = new ArrayList();
     * UserList userList = new UserList();
     * libraryUsers = userList.parseUser();
     * String stringMembers="";
     * char [] libraryMembers = new char[10];
     * String FILENAME_COUNT = "LibraryMemberCount.txt";
     * File fileA = new File(FILENAME_COUNT);
     * FileReader fileReader = new FileReader(fileA);
     * 
     * fileReader.read(libraryMembers);
     * int countIterator=0;
     * for(countIterator=0;libraryMembers[countIterator]!='\0';countIterator++){
     * stringMembers = stringMembers+libraryMembers[countIterator];
     * }
     * stringMembers = stringMembers.trim();
     * int intMembers = Integer.parseInt(stringMembers);
     * 
     * list.clear();
     * int iterator;
     *//*
        * System.out.println("Sizes : "+libraryUsers.length);
        *//*
           * 
           * 
           * for(iterator=0;iterator<intMembers-1;iterator++){
           * list.add(new Library(libraryUsers[iterator].getUserID(),
           * libraryUsers[iterator].getUserName(),
           * libraryUsers[iterator].getUserInstitute(),
           * libraryUsers[iterator].getUserEducationLevel(),
           * libraryUsers[iterator].getUserClass()));
           * System.out.println("okk");
           * }
           * ObservableList data = FXCollections.observableList(list);
           * return data;
           * }
           */

    public void showInfo(Stage secondaryStage, String labelName, ObservableList data) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

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
        // label top of the table
        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 30);
        Font font4 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 40);
        Label label = new Label();
        label.setPrefSize(700, 45);
        label.setTranslateX(454);
        label.setTranslateY(0);
        label.setText(labelName);
        label.setFont(font4);
        // reset buttons position
        back.setTranslateX(35);
        back.setTranslateY(650);
        exit.setTranslateX(1135);
        exit.setTranslateY(650);
        back.setFont(font3);
        exit.setFont(font3);

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
                new LibraryUserShowing.RowSelectChangeListener());

        // Status message text
        actionStatus = new Text();
        actionStatus.setFill(Color.FIREBRICK);
        table.getSelectionModel().select(0);
        Book book = (Book) table.getSelectionModel().getSelectedItem();
        actionStatus.setText(book.toString());

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
