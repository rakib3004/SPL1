package UserInterfacePackage;

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

import java.io.IOException;
import java.util.*;

public class TypeWiseFX extends Application {


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




        MenuItem uponnash = new MenuItem("Uponnash");
        uponnash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
             public void handle(ActionEvent e) {

                    labelName="Top Books of  "+uponnash.getText();


              

             for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0,2).equals("01")) 
                    {
                        //   uponnashTypeNO++;
                        list.add(new Book(priorityData[iterator].bookData.bookName,
                                priorityData[iterator].bookData.writerName,
                                priorityData[iterator].bookData.bookId,
                                priorityData[iterator].bookData.typeName));

                  data = FXCollections.observableList(list);

                    }
                }
             
            
              //  System.out.println(map);
                showInfo(primaryStage,labelName,data);

            } });


        MenuItem kobita = new MenuItem("Kobita");

        kobita.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+kobita.getText();

                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("02")) {
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

        MenuItem rochonaboli = new MenuItem("Rochonaboli");
        rochonaboli.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+rochonaboli.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("05")) {
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
        MenuItem religion = new MenuItem("Religion");
        religion.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+religion.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("04")) {
                        //   uponnashTypeNO++;
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


        MenuItem biggan = new MenuItem("Biggan");
        biggan.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+biggan.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("13")) {
                        //   uponnashTypeNO++;
                        list.add(new Book(priorityData[iterator].bookData.bookName,
                                priorityData[iterator].bookData.writerName,
                                priorityData[iterator].bookData.bookId,
                                priorityData[iterator].bookData.typeName));
                        data = FXCollections.observableList(list);

                    }
                 }


                showInfo(primaryStage,labelName,data);
          } });

        MenuItem sciFi = new MenuItem("Sci Fi");
        sciFi.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+sciFi.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("06")) {
                        //   uponnashTypeNO++;
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

        MenuItem shishuShahitto = new MenuItem("Shishu Shahitto");
        shishuShahitto.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+shishuShahitto.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("11")) {



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
        


        MenuItem kisoreUponnash = new MenuItem("Kisore Uponnash");
        kisoreUponnash.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+kisoreUponnash.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("10")) {

                        list.add(new Book(priorityData[iterator].bookData.bookName,
                                priorityData[iterator].bookData.writerName,
                                priorityData[iterator].bookData.bookId,
                                priorityData[iterator].bookData.typeName));

                        data = FXCollections.observableList(list);

                    }
                 }


                showInfo(primaryStage,labelName,data);
          } });
        MenuItem biography = new MenuItem("Biography");
        biography.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+biography.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("12")) {

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

        MenuItem gobesona = new MenuItem("Gobesona");
        gobesona.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+gobesona.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0,2).equals("08")) {

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
        MenuItem onubad = new MenuItem("Onubad");

        onubad.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+onubad.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("12")) {

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
        MenuItem others = new MenuItem("Others");
        others.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                    labelName="Top Books of  "+others.getText();
                 for (iterator = 0; iterator < numberOfBooks; iterator++) {

                    if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("07")||
                            priorityData[iterator].bookData.bookId.substring(0, 2).equals("22")) {


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

        MenuButton bookType = new MenuButton("Choose Your Type");
        bookType.getItems().addAll( uponnash, kobita, rochonaboli, religion,
                biggan, sciFi, shishuShahitto, kisoreUponnash,biography,
                gobesona, onubad,others);


bookType.setTranslateX(500);
bookType.setTranslateY(350);
bookType.setPrefSize(200, 50);


        Image image = new Image("libraryBackground6.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,bookType);

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
                new TypeWiseFX.RowSelectChangeListener());
        
        
        
                // Status message text
        actionStatus = new Text();
        actionStatus.setFill(Color.FIREBRICK);


        table.getSelectionModel().select(0);
        Book book = (Book) table.getSelectionModel().getSelectedItem();
        actionStatus.setText(book.toString());




        Image image = new Image("libraryBackground1.jpg");
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