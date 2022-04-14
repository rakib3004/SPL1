package UserInterfacePackage;

import FilePackage.DateTimeWriter;
import JavFX.Main;
import LibraryFunctionality.ReadingRoom;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.PrioritySort;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;
import TableViewPackage.Book;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeWise extends Application {
    private TableView table;
    private ObservableList data;
    private Text actionStatus;
    PriorityData[] priorityData;
    GenericAlgo[] genericAlgo;
    PrioritySort prioritySort = new PrioritySort();
    List list = new ArrayList();

    int iterator;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    String labelName = "Top Books";
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

    @Override
    public void start(Stage primaryStage) {
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

        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font(23);
        Font font5 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15);

        Button writerWise = new Button("Writer Wise");
        Button typeWise1 = new Button("Type Wise");
        Button shelfWise = new Button("Shelf Wise");
        Button timeWise = new Button("Time Wise");

        typeWise1.setPrefSize(400, 170);
        shelfWise.setPrefSize(400, 170);
        timeWise.setPrefSize(400, 170);
        writerWise.setPrefSize(400, 170);

        typeWise1.setFont(font2);
        shelfWise.setFont(font2);
        timeWise.setFont(font2);
        writerWise.setFont(font2);

        typeWise1.setTranslateX(30);
        typeWise1.setTranslateY(35);
        shelfWise.setTranslateX(30);
        shelfWise.setTranslateY(210);
        timeWise.setTranslateX(30);
        timeWise.setTranslateY(385);
        writerWise.setTranslateX(30);
        writerWise.setTranslateY(560);

        typeWise1.setContentDisplay(ContentDisplay.LEFT);
        shelfWise.setContentDisplay(ContentDisplay.LEFT);
        timeWise.setContentDisplay(ContentDisplay.LEFT);
        writerWise.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "choose.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        typeWise1.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "shelf.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        shelfWise.setGraphic(new ImageView(image2));
        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "calender.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        timeWise.setGraphic(new ImageView(image3));

        FileInputStream fileInputStream7 = null;
        try {
            fileInputStream7 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "writer.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image7 = new Image(fileInputStream7);
        writerWise.setGraphic(new ImageView(image7));
        writerWise.setOnAction(actionEvent -> {
            try {

                WriterWise writerWiseFX = new WriterWise();
                writerWiseFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        typeWise1.setOnAction(actionEvent -> {
            try {
                TypeWise typeWise = new TypeWise();
                typeWise.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        shelfWise.setOnAction(actionEvent -> {

            try {
                ShelfWiseFX shelfWiseFX = new ShelfWiseFX();
                shelfWiseFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        timeWise.setOnAction(actionEvent -> {
            try {
                TimeWise timeWiseFX = new TimeWise();
                timeWiseFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream4 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "exit.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font);
        Text text = new Text("Time Wise Book Recommendation");
        text.setTranslateX(575);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");
        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375, 30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = null;
        try {
            fileInputStream5 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "home.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375, 30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = null;
        try {
            fileInputStream6 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "back.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.automaticSystem(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Image background = new Image("Images" + File.separator + "framework.jpg");
        Canvas canvas = new Canvas(850, 425);
        canvas.setTranslateX(470);
        canvas.setTranslateY(35);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(background, 0, 0);
        Group group = new Group();
        group.getChildren().addAll(canvas, typeWise1,
                shelfWise, writerWise,
                timeWise, exit, home, text, back);

        MenuItem year1 = new MenuItem("2008-2010");
        year1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                labelName = "Top Books of " + year1.getText();
                for (iterator = 0; iterator < numberOfBooks; iterator++) {
                    if (priorityData[iterator].bookData.bookId.substring(3, 7).contains("0618") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("1208") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("1009") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("0410") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("0810") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("1210")) {
                        list.add(new Book(priorityData[iterator].bookData.bookName,
                                priorityData[iterator].bookData.writerName,
                                priorityData[iterator].bookData.bookId,
                                priorityData[iterator].bookData.typeName));
                        data = FXCollections.observableList(list);
                    }
                }
                showInfo(primaryStage, labelName, data);
            }
        });

        MenuItem year2 = new MenuItem("2011-2012");
        year2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                labelName = "Top Books of " + year2.getText();
                for (iterator = 0; iterator < numberOfBooks; iterator++) {
                    if (priorityData[iterator].bookData.bookId.substring(3, 7).contains("0311") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("1211") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("0212") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("0812")) {
                        list.add(new Book(priorityData[iterator].bookData.bookName,
                                priorityData[iterator].bookData.writerName,
                                priorityData[iterator].bookData.bookId,
                                priorityData[iterator].bookData.typeName));
                        data = FXCollections.observableList(list);
                    }
                }
                showInfo(primaryStage, labelName, data);
            }
        });
        MenuItem year3 = new MenuItem("2013-2014");
        year3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                labelName = "Top Books of " + year3.getText();
                for (iterator = 0; iterator < numberOfBooks; iterator++) {
                    if (priorityData[iterator].bookData.bookId.substring(3, 7).contains("13") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("14")) {
                        list.add(new Book(priorityData[iterator].bookData.bookName,
                                priorityData[iterator].bookData.writerName,
                                priorityData[iterator].bookData.bookId,
                                priorityData[iterator].bookData.typeName));
                        data = FXCollections.observableList(list);
                    }
                }
                showInfo(primaryStage, labelName, data);
            }
        });
        MenuItem year4 = new MenuItem("2015-2016");
        year4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                labelName = "Top Books of " + year4.getText();
                for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(3, 7).contains("15") ||
                            priorityData[iterator].bookData.bookId.substring(3, 7).contains("16")) {

                        list.add(new Book(priorityData[iterator].bookData.bookName,
                                priorityData[iterator].bookData.writerName,
                                priorityData[iterator].bookData.bookId,
                                priorityData[iterator].bookData.typeName));
                        data = FXCollections.observableList(list);
                    }
                }
                showInfo(primaryStage, labelName, data);
            }
        });
        MenuItem year5 = new MenuItem("2017-2018");
        year5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                labelName = "Top Books of " + year5.getText();
                for (iterator = 0; iterator < numberOfBooks; iterator++) {
                    if (priorityData[iterator].bookData.bookId.substring(3, 7).contains("17")) {
                        list.add(new Book(priorityData[iterator].bookData.bookName,
                                priorityData[iterator].bookData.writerName,
                                priorityData[iterator].bookData.bookId,
                                priorityData[iterator].bookData.typeName));
                        data = FXCollections.observableList(list);
                    }
                }
                showInfo(primaryStage, labelName, data);
            }
        });

        MenuButton yearSection = new MenuButton("Select Year : ");
        yearSection.getItems().addAll(year1, year2, year3, year4,
                year5);
        yearSection.setFont(font5);

        yearSection.setTranslateX(700);
        yearSection.setTranslateY(285);
        yearSection.setPrefSize(200, 50);
        Image image = new Image("Images" + File.separator + "libraryBackground14.jpg");
        // Canvas canvas = new Canvas(1500,950);
        // Group group = new Group();

        group.getChildren().addAll(yearSection);
        // GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
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
                new TimeWise.RowSelectChangeListener());

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

    public Button setStyle(Button button) {
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
        return button;
    }

    public Label setStyle(Label Label) {
        Label.setStyle("-fx-padding: 8 15 15 15;\n" +
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
        return Label;
    }
}