package TableViewPackage;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.ReverseSorting;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;
import RecommendationAlgorithm.AnalyticHierarchyAlgorithm;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AHP_TableView extends Application {

    private TableView table;
    private ObservableList data;
    private Text actionStatus;
    PriorityData[] priorityData;
    GenericAlgo[] genericAlgo;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    ReverseSorting reverseSorting = new ReverseSorting();
    AHPcriteriaWeight ahPcriteriaWeight;
    AHPcalculation ahPcalculation = new AHPcalculation();
AHPprocessImplementation  ahPprocessImplementation = new AHPprocessImplementation();
    @Override
    public void start(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        primaryStage.setTitle("Analytic Hierarchy Process Table");
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setOnAction(actionEvent -> {
            AnalyticHierarchyAlgorithm analyticHierarchyAlgorithm = new AnalyticHierarchyAlgorithm();
            try {
                analyticHierarchyAlgorithm.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
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
        Label label = new Label("Analytic Hierarchy Process Results");
        label.setTextFill(Color.DARKBLUE);
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
        TableColumn bookId = new TableColumn("Book ID");
        bookId.setCellValueFactory(new PropertyValueFactory("bookId"));
        TableColumn borrowCount = new TableColumn("Borrow Count");
        borrowCount.setCellValueFactory(new PropertyValueFactory("borrowCount"));


        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn bookWeight = new TableColumn("Book Weight");
        bookWeight.setCellValueFactory(new PropertyValueFactory("bookWeight"));
        TableColumn typeName = new TableColumn("Type Name");
        typeName.setCellValueFactory(new PropertyValueFactory("typeName"));
        table.getColumns().setAll(bookName,writerName,bookId,typeName,borrowCount,price, bookWeight);

       // REFORM _TABLE _STRUCTURE
        table.setTranslateX(65);
        table.setTranslateY(70);
        table.setPrefSize(1250,560);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // set new label for table
        String labelName = "Analytical Hierarchy Results";
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

        table.getSelectionModel().selectedIndexProperty().addListener(
                new AHP_TableView.RowSelectChangeListener());
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
        table.getSelectionModel().select(0);
        Book book = (Book) table.getSelectionModel().getSelectedItem();
        actionStatus.setText(book.toString());
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
        DecimalFormat df = new DecimalFormat("###.##");
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        ahPcriteriaWeight =  ahPcalculation.AHPcalculationMethods(priorityData,numberOfBooks);
        priorityData=     ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight,priorityData,numberOfBooks);
        genericAlgo = reverseSorting.sortingAHPmethods(priorityData,numberOfBooks);
        int iterator;
        for(iterator=0;iterator<numberOfBooks;iterator++){
            list.add(new Book(priorityData[genericAlgo[iterator].getIndex()].bookData.bookName,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.writerName,priorityData[genericAlgo[iterator].getIndex()].bookData.bookId,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.typeName,
                    priorityData[genericAlgo[iterator].getIndex()].bookData.borrowCount,priorityData[genericAlgo[iterator].getIndex()].bookData.bookPrice,
                    Double.toString(Double.parseDouble(df.format(priorityData[genericAlgo[iterator].getIndex()].getRankValue())))));
        }
        ObservableList data = FXCollections.observableList(list);
        return data;
    }
    public Button setStyle(Button button)
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
