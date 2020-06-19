package UserInterfacePackage;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.FXThirdWindow;
import LibraryFunctionality.ReadingRoom;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.PrioritySort;
import Methods.ReverseSorting;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;
import ProjectDescription.About;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RemoveBookFX extends Application {


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
    public void start(Stage primaryStage){
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
            LibraryDesk libraryDesk = new LibraryDesk();

            try {
                libraryDesk.start(primaryStage);
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




        Image image = new Image("Images"+ File.separator +"libraryBackground5.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,show);


        Button administrationMood = new Button("Administration Mood");
        Button readersMood = new Button("Readers Mood");
        Button about = new Button("About");

        readersMood.setTranslateX(20);
        readersMood.setTranslateY(260);
        administrationMood.setTranslateX(20);
        administrationMood.setTranslateY(320);
        about.setTranslateX(20);
        about.setTranslateY(380);


        administrationMood.setPrefSize(160, 30);
        readersMood.setPrefSize(160, 30);
        about.setPrefSize(160,30);

        administrationMood.setOnAction(actionEvent -> {

            FXThirdWindow fxThirdWindow = new FXThirdWindow();
            try {
                fxThirdWindow.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        readersMood.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        about.setOnAction(actionEvent -> {
            About about1 = new About();
            try {
                about1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        group.getChildren().addAll(readersMood,administrationMood,about);



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


        textField1.setOnAction(actionEvent -> {
            list.clear();
            setNumberOfBooks(Integer.parseInt(textField1.getText()));
            setBookPoint(1);

            try {
                this.start(secondaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });


        TextField textField2 = new TextField("No of Books, You want to remove :");
        setStylePro(textField2);
        textField2.setTranslateX(360);
        textField2.setTranslateY(650);
        textField2.setPrefSize(215,80);

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


        table.getColumns().setAll(bookName,writerName,typeName,bookId);
        table.setPrefWidth(1240);
        table.setPrefHeight(560);
        table.setTranslateX(60);
        table.setTranslateY(70);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.getSelectionModel().selectedIndexProperty().addListener(
                new RemoveBookFX.RowSelectChangeListener());



        // Status message text
        actionStatus = new Text();
        actionStatus.setFill(Color.FIREBRICK);


        table.getSelectionModel().select(0);
        Book book = (Book) table.getSelectionModel().getSelectedItem();
        actionStatus.setText(book.toString());



        Image image = new Image("Images"+ File.separator +"libraryBackground16.jpg");
        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit, back,textField1,
                textField2,label,table);

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

    private ObservableList getInitialTableData() throws IOException { String  className = this.getClass().getSimpleName();
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

    public static class SelfWiseFX extends Application {


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
        String labelName="Top Books";
        TreeMap<Object, Object> map = new TreeMap<>();
        AHPcalculation ahPcalculation = new AHPcalculation();
        AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
        MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

        @Override
        public void start(Stage primaryStage){
            String  className = this.getClass().getSimpleName();
            DateTimeWriter dateTimeWriter =  new DateTimeWriter();
            dateTimeWriter.dateTimeWriterMethods(className);
            try {
                priorityData = processing.fileReaderMethods();
                numberOfBooks = bookNumber.bookNumberFindingMethods();
            } catch (IOException e) {
                e.printStackTrace();
            }
            priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
            priorityData = prioritySort.PrioritySortingMLRmethods(priorityData,numberOfBooks);
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

        setStyle(exit);
        setStyle(back);
            back.setPrefSize(200, 80);
            exit.setPrefSize(200, 80);

            MenuItem self1 = new MenuItem("Book No : 1-100");

            self1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                        labelName="Top Books from "+self1.getText();
                    for (iterator = 0; iterator < numberOfBooks; iterator++) {

                        if (priorityData[iterator].bookData.bookId.substring(11,12).contains("0")) {


                            list.add(new Book(priorityData[iterator].bookData.bookName,
                                    priorityData[iterator].bookData.writerName,
                                    priorityData[iterator].bookData.bookId,
                                    priorityData[iterator].bookData.typeName));

                            data = FXCollections.observableList(list);
                        }
                    }
               showInfo(primaryStage,labelName,data);
                }
            });


            MenuItem self2 = new MenuItem("Book No : 101-200");
            self2.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                        labelName="Top Books from "+self2.getText();

                    for (iterator = 0; iterator < numberOfBooks; iterator++) {

                        if (priorityData[iterator].bookData.bookId.substring(11,12).contains("1")) {


                            list.add(new Book(priorityData[iterator].bookData.bookName,
                                    priorityData[iterator].bookData.writerName,
                                    priorityData[iterator].bookData.bookId,
                                    priorityData[iterator].bookData.typeName));

                            data = FXCollections.observableList(list);

                        }
                    }
                   showInfo(primaryStage,labelName,data);
                }
            });


            MenuItem self3 = new MenuItem("Book No : 201-300");
            self3.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                        labelName="Top Books from "+self3.getText();

                    for (iterator = 0; iterator < numberOfBooks; iterator++) {

                        if (priorityData[iterator].bookData.bookId.substring(11,12).contains("2")) {

                            list.add(new Book(priorityData[iterator].bookData.bookName,
                                    priorityData[iterator].bookData.writerName,
                                    priorityData[iterator].bookData.bookId,
                                    priorityData[iterator].bookData.typeName));

                            data = FXCollections.observableList(list);

                        }
                    }
                   showInfo(primaryStage,labelName,data);
                }
            });




            MenuItem self4 = new MenuItem("Book No : 301-400");
            self4.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                        labelName="Top Books from "+self4.getText();


                    for (iterator = 0; iterator < numberOfBooks; iterator++) {

                        if (priorityData[iterator].bookData.bookId.substring(11,12).contains("3")) {


                            list.add(new Book(priorityData[iterator].bookData.bookName,
                                    priorityData[iterator].bookData.writerName,
                                    priorityData[iterator].bookData.bookId,
                                    priorityData[iterator].bookData.typeName));

                            data = FXCollections.observableList(list);

                        }
                    }
                   showInfo(primaryStage,labelName,data);
                } });



            MenuItem self5 = new MenuItem("Book No : 401-500");
            self5.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                        labelName="Top Books from "+self5.getText();



                    for (iterator = 0; iterator < numberOfBooks; iterator++) {

                        if (priorityData[iterator].bookData.bookId.substring(11,12).contains("4")) {

                            list.add(new Book(priorityData[iterator].bookData.bookName,
                                    priorityData[iterator].bookData.writerName,
                                    priorityData[iterator].bookData.bookId,
                                    priorityData[iterator].bookData.typeName));

                            data = FXCollections.observableList(list);

                        }
                    }

                   showInfo(primaryStage,labelName,data);
                } });



            MenuItem self6 = new MenuItem("Book No : 501-600");
            self6.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                        labelName="Top Books from "+self6.getText();

                    for (iterator = 0; iterator < numberOfBooks; iterator++) {

                        if (priorityData[iterator].bookData.bookId.substring(11,12).contains("5")) {


                            list.add(new Book(priorityData[iterator].bookData.bookName,
                                    priorityData[iterator].bookData.writerName,
                                    priorityData[iterator].bookData.bookId,
                                    priorityData[iterator].bookData.typeName));

                            data = FXCollections.observableList(list);

                        }
                    }

                   showInfo(primaryStage,labelName,data);
                } });


           MenuItem self7 = new MenuItem("Book No : 601-700");
            self7.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                        labelName="Top Books from "+self7.getText();

                    for (iterator = 0; iterator < numberOfBooks; iterator++) {

                        if (priorityData[iterator].bookData.bookId.substring(11,12).contains("6")) {

                            list.add(new Book(priorityData[iterator].bookData.bookName,
                                    priorityData[iterator].bookData.writerName,
                                    priorityData[iterator].bookData.bookId,
                                    priorityData[iterator].bookData.typeName));

                            data = FXCollections.observableList(list);

                        }
                    }

                   showInfo(primaryStage,labelName,data);
                } });





            MenuButton selfSection = new MenuButton("Choose Self ");
            selfSection.getItems().addAll(self1, self2, self3,
                    self4,self5,self6,self7);


            selfSection.setTranslateX(500);
            selfSection.setTranslateY(350);
            selfSection.setPrefSize(200, 50);


            Image image = new Image("Images"+ File.separator +"libraryBackground5.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
            group.getChildren().addAll(canvas,exit,back,selfSection);

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
            label.setPrefSize(500,45);
            label.setTranslateX(450);
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


            table.getColumns().setAll(bookName,writerName,typeName,bookId);
            table.setPrefWidth(1240);
            table.setPrefHeight(560);
            table.setTranslateX(60);
            table.setTranslateY(70);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            table.getSelectionModel().selectedIndexProperty().addListener(
                    new RowSelectChangeListener());



            // Status message text
            actionStatus = new Text();
            actionStatus.setFill(Color.FIREBRICK);


            table.getSelectionModel().select(0);
            Book book = (Book) table.getSelectionModel().getSelectedItem();
            actionStatus.setText(book.toString());



            Image image = new Image("libraryBackground16.jpg");
            Canvas canvas = new Canvas(1500, 950);
            Group group = new Group();
            group.getChildren().addAll(canvas,exit, back,label,table);

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
            priorityData = prioritySort.PrioritySortingMLRmethods(priorityData,numberOfBooks);
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
        public Label setStyle(Label Label)
        {
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
            return  Label;
        }
    }
}
