package LibraryFunctionality;

import FilePackage.DateTimeWriter;
import LinearRegression.FourVariableRegression;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.ReverseSorting;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;
import TableViewPackage.AHP_TableView;
import TableViewPackage.Book;
import TableViewPackage.MLR_TableView;
import TableViewPackage.PRA_TableView;
import javafx.application.Application;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryUserShowing extends Application {

    private TableView table;
    private ObservableList data;
    private Text actionStatus;
    PriorityData[] priorityData;
    GenericAlgo[] genericAlgo;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    ReverseSorting soring = new ReverseSorting();
    @Override
    public void start(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setOnAction(actionEvent -> {
           /* FourVariableRegression fourVariableRegression = new FourVariableRegression();
            try {
                fourVariableRegression.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }*/

        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        back.setTranslateX(0);
        back.setTranslateY(685);
        exit.setTranslateX(1100);
        exit.setTranslateY(685);

        // Table view, data, columns and properties
        table = new TableView();
        data = getInitialTableData();
        table.setItems(data);
        /*    private SimpleStringProperty userID;
    private SimpleStringProperty userName;
    private SimpleStringProperty userInstitute;
    private SimpleStringProperty userEducationLevel;
    private SimpleStringProperty userClass;*/

        TableColumn bookName = new TableColumn("User Id");
        bookName.setCellValueFactory(new PropertyValueFactory("userID"));

        TableColumn writerName = new TableColumn("User Name");
        writerName.setCellValueFactory(new PropertyValueFactory("userName"));
        TableColumn bookId = new TableColumn("User Institute");
        bookId.setCellValueFactory(new PropertyValueFactory("userInstitute"));

        TableColumn borrowCount = new TableColumn("User Education Level");
        borrowCount.setCellValueFactory(new PropertyValueFactory("userEducationLevel"));
        TableColumn price = new TableColumn("User Class");
        price.setCellValueFactory(new PropertyValueFactory("userClass"));


        table.getColumns().setAll(bookName,writerName,bookId,borrowCount,price);

        // REFORM _TABLE _STRUCTURE
        table.setTranslateX(65);
        table.setTranslateY(70);
        table.setPrefSize(1250,560);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // set new label for table
        String labelName = "Multi Variable Results";
        Font font3= Font.font(Font.getFontNames().get(0), FontWeight.BOLD,30);
        Font font4= Font.font(Font.getFontNames().get(0), FontWeight.BOLD,40);
        Label label2 = new Label();
        label2.setPrefSize(700,45);
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
        Image image = new Image("Images"+ File.separator +"table2.jpg");
        Canvas canvas = new Canvas(1500, 950);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image, 0, 0);




        // Status message text
        actionStatus = new Text();
        actionStatus.setFill(Color.FIREBRICK);
        ContextMenu contextMenu = new ContextMenu();
        MenuItem mlr_table_view = new MenuItem("MLR Table View");
        MenuItem ahp_table_view = new MenuItem("AHP Table View");
        MenuItem pra_table_view = new MenuItem("PRA Table View");

        ahp_table_view.setOnAction((event) -> {
            AHP_TableView ahpTableViewFX = new AHP_TableView();
            try {
                ahpTableViewFX.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pra_table_view.setOnAction((event) -> {
            PRA_TableView praTableViewFX = new PRA_TableView();
            try {
                praTableViewFX.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        mlr_table_view.setOnAction((event) -> {
            MLR_TableView mlrTableViewFX = new MLR_TableView();
            try {
                mlrTableViewFX.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        contextMenu.getItems().addAll(mlr_table_view,ahp_table_view,pra_table_view);

        table.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(table, event.getScreenX(), event.getScreenY());
            }
        });

        Group group = new Group();
        group.getChildren().addAll(canvas,table,label2,exit,back);

        Scene scene = new Scene(group, 1400, 775);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        // Select the first row
        table.getSelectionModel().select(0);
        Book book = (Book) table.getSelectionModel().getSelectedItem();
        actionStatus.setText(book.toString());
    }
    private ObservableList getInitialTableData() throws IOException {
        List list = new ArrayList();
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
        genericAlgo =soring.sortingMLRmethods(priorityData,numberOfBooks);
        int iterator;
        for(iterator=0;iterator<numberOfBooks;iterator++){

            list.add(new Book(priorityData[genericAlgo[iterator].getIndex()].bookData.bookName,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.writerName,priorityData[genericAlgo[iterator].getIndex()].bookData.bookId,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.typeName,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.borrowCount,priorityData[genericAlgo[iterator].getIndex()].bookData.bookPrice,
                    Double.toString(priorityData[genericAlgo[iterator].getIndex()].getRankValue())));
        }
        ObservableList data = FXCollections.observableList(list);
        return data;
    }

}
