package LibraryFunctionality;

import FilePackage.DateTimeWriter;
import Layout.ButtonDesign;
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
    LibraryUser [] libraryUsers;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    ReverseSorting soring = new ReverseSorting();
    public void startstartInUp(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
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


        table.getColumns().setAll(userId,userName,userInstitute,userEducationLevel,userClass);

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

        Group group = new Group();
        group.getChildren().addAll(canvas,table,label2,exit,back);

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
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
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



        Font font3= Font.font(Font.getFontNames().get(0), FontWeight.BOLD,30);



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
        });

        buttonDesign.systemLine(newLibraryData,150,60,666,333,25);





// add image as a backgroun in this table showing
        Image image = new Image("Images"+ File.separator +"table2.jpg");
        Canvas canvas = new Canvas(1500, 950);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image, 0, 0);

        Group group = new Group();
        group.getChildren().addAll(canvas,newLibraryData,exit,back);

        Scene scene = new Scene(group, 1400, 775);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }




    private ObservableList getInitialTableData() throws IOException {
        List list = new ArrayList();
        UserList userList = new UserList();
        libraryUsers = userList.parseUser();
        String  stringMembers="";
        char [] libraryMembers = new char[10];
        String FILENAME_COUNT = "LibraryMemberCount.txt";
        File fileA = new File(FILENAME_COUNT);
        FileReader fileReader = new FileReader(fileA);

        fileReader.read(libraryMembers);
        int countIterator=0;
        for(countIterator=0;libraryMembers[countIterator]!='\0';countIterator++){
            stringMembers = stringMembers+libraryMembers[countIterator];
        }
        stringMembers = stringMembers.trim();
        int intMembers = Integer.parseInt(stringMembers);

        list.clear();
        int iterator;
/*
        System.out.println("Sizes : "+libraryUsers.length);
*/


        for(iterator=0;iterator<intMembers-1;iterator++){
            list.add(new Library(libraryUsers[iterator].getUserID(),
                    libraryUsers[iterator].getUserName(),
                    libraryUsers[iterator].getUserInstitute(),
                    libraryUsers[iterator].getUserEducationLevel(),
                    libraryUsers[iterator].getUserClass()));
            System.out.println("okk");
        }
        ObservableList data = FXCollections.observableList(list);
        return data;
    }

}
