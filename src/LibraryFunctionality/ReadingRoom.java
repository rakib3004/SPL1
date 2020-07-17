package LibraryFunctionality;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import Collection.WriterCollection;
import CrossValidationProcess.CrossValidationFX;
import CrossValidationProcess.TestingSet;
import CrossValidationProcess.TrainingSet;
import FilePackage.DateTimeWriter;
import InfoDisplay.BookApplication;
import InfoDisplay.BookInformationFX;
import JavFX.AuthorSystem;
import JavFX.FXThirdWindow;
import JavFX.FxSecondWindow;
import JavFX.SystemAnalysis;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import ProjectDescription.About;
import RankingAlgorithmFx.AnalyticHierarchyAlgorithmFx;
import RankingAlgorithmFx.PageRankAlgorithmFx;
import RankingAlgorithmFx.StatisticsFX;
import RegressionFx.FourVariableRegression;
import UserInterfacePackage.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingRoom extends Application {

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();

    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    @Override
    public void start(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Font font = new Font(26);
        Font font1 = new Font(47);
        Font font2 = new Font( 25);

        Button user = new Button("Default Book Recommendation");
        Button librarian = new Button("User Based Book Recommendation");
        Button system = new Button("Users Rules & Regulations");

        user.setPrefSize(410,230);
        librarian.setPrefSize(410,230);
        system.setPrefSize(410,230);

        user.setFont(font);
        librarian.setFont(font);
        system.setFont(font);
        user.setTranslateX(30);
        user.setTranslateY(35);
        librarian.setTranslateX(30);
        librarian.setTranslateY(270);
        system.setTranslateX(30);
        system.setTranslateY(505);

        user.setContentDisplay(ContentDisplay.TOP);
        librarian.setContentDisplay(ContentDisplay.TOP);
        system.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"user.png");
        Image image1 = new Image(fileInputStream1);
        user.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"admin.png");
        Image image2 = new Image(fileInputStream2);
        librarian.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"automation.png");
        Image image3 = new Image(fileInputStream3);
        system.setGraphic(new ImageView(image3));

        user.setOnAction(actionEvent -> {
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        librarian.setOnAction(actionEvent -> {
            LibraryDesk libraryDesk = new LibraryDesk();
            try {
                libraryDesk.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        system.setOnAction(actionEvent -> {
            AuthorSystem authorSystem = new AuthorSystem();
            try {
                authorSystem.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        Button exit = new Button("Exit");
        exit.setTranslateX(1200);
        exit.setTranslateY(700);
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        FileInputStream fileInputStream4 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"exit.png");
        Image image4 = new Image(fileInputStream4);
        exit.setGraphic(new ImageView(image4));
        exit.setPrefSize(120, 20);
        exit.setContentDisplay(ContentDisplay.LEFT);
        exit.setFont(font2);
        Text text = new Text("Library's Reading Room ");
        text.setTranslateX(575);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");

        Button back = new Button("Back");
        back.setOnAction(actionEvent -> {
            FxSecondWindow fxSecondWindow = new FxSecondWindow();
            try {
                fxSecondWindow.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        setStyle(back);
        back.setPrefSize(200, 80);
        back.setTranslateX(1100);
        back.setTranslateY(550);
        Image background = new Image("Images"+ File.separator +"framework.jpg");
        Canvas canvas = new Canvas(850, 425);
        canvas.setTranslateX(470);
        canvas.setTranslateY(35);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back);
        group.getChildren().addAll(user,librarian,system,text);
        ReadingRoom readingRoom2 = new ReadingRoom();
        LibraryDesk libraryDesk2 = new LibraryDesk();
        CrossValidationFX crossValidationFX2 = new CrossValidationFX();
        BookApplication bookApplication1 = new BookApplication();
        WriterCollection writerCollection = new WriterCollection();
        FourVariableRegression fourVariableRegression1 = new FourVariableRegression();
        AnalyticHierarchyAlgorithmFx analyticHierarchyAlgorithmFx1 = new AnalyticHierarchyAlgorithmFx();
        PageRankAlgorithmFx pageRankAlgorithmFx1 = new PageRankAlgorithmFx();
        AddBookFX addBookFX = new AddBookFX();
        RemoveBookFX removeBookFX = new RemoveBookFX();
        BookInformationFX bookInformationFX = new BookInformationFX();

        Menu menu1 = new Menu("User");
        Menu menu2 = new Menu("Librarian");
        Menu menu3 = new Menu("Analysis");
        Menu menu4 = new Menu("Process");
        Menu menu5 = new Menu("Shortcut");

        MenuItem menuItem1a = new MenuItem("Default Recommendation");
        MenuItem menuItem1b = new MenuItem("User Based Recommendation");
        menu1.getItems().addAll(menuItem1a,menuItem1b);
        menuItem1a.setOnAction(actionEvent -> {
            try {
                readingRoom2.automaticSystem(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem1b.setOnAction(actionEvent -> {
            try {
                readingRoom2.manualSystem(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        MenuItem menuItem2a = new MenuItem("Add book");
        MenuItem menuItem2b = new MenuItem("Book Info");
        MenuItem menuItem2c = new MenuItem("Remove Book");
        menuItem2a.setOnAction(actionEvent -> {
            try {
                addBookFX.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem2b.setOnAction(actionEvent -> {
            try {
                bookInformationFX.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem2c.setOnAction(actionEvent -> {
            try {
                removeBookFX.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        menu2.getItems().addAll(menuItem2a,menuItem2b,menuItem2c);

        MenuItem menuItem3a = new MenuItem("Cross Validation");
        MenuItem menuItem3b = new MenuItem("Seven Number Analysis");
        MenuItem menuItem3c = new MenuItem("Data Optimization");
        menuItem3a.setOnAction(actionEvent -> {
            try {
                crossValidationFX2.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem3b.setOnAction(actionEvent -> {
            try {
                bookApplication1.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem3c.setOnAction(actionEvent -> {
            //     writerCollection.writerCollectionMLRMethods();
        });

        menu3.getItems().addAll(menuItem3a,menuItem3b,menuItem3c);

        MenuItem menuItem4a = new MenuItem("Multi-variable Regression");
        MenuItem menuItem4b = new MenuItem("Analytic Hierarchy Process");
        MenuItem menuItem4c = new MenuItem("Page Rank Algorithm");
        menu4.getItems().addAll(menuItem4a,menuItem4b,menuItem4c);
        menuItem4a.setOnAction(actionEvent -> {
            try {
                fourVariableRegression1.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem4b.setOnAction(actionEvent -> {
            try {
                analyticHierarchyAlgorithmFx1.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menuItem4c.setOnAction(actionEvent -> {
            try {
                pageRankAlgorithmFx1.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        MenuItem readingRoom1 = new MenuItem("Reading Room");
        readingRoom1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ReadingRoom readingRoom = new ReadingRoom();
                try {
                    {
                        readingRoom.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem libraryDesk1 = new MenuItem("Library Desk");
        libraryDesk1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                LibraryDesk libraryDesk = new LibraryDesk();
                try {
                    {
                        libraryDesk.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem processVisualization = new MenuItem("Process Visualization");

        processVisualization.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                StatisticsFX statisticsFX = new StatisticsFX();
                {
                    statisticsFX.start(primaryStage);
                }
            }
        });
        MenuItem multivariableLinearRegression = new MenuItem("Multi-variable Linear Regression");
        multivariableLinearRegression.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                FourVariableRegression fourVariableRegression = new FourVariableRegression();
                try {
                    {
                        fourVariableRegression.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem analyticHierarchyProcess = new MenuItem("AnalyticHierarchy Process");
        analyticHierarchyProcess.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                AnalyticHierarchyAlgorithmFx analyticHierarchyAlgorithmFx = new AnalyticHierarchyAlgorithmFx();
                try {
                    {
                        analyticHierarchyAlgorithmFx.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem pageRankAlgorithm = new MenuItem("PageRank Algorithm");
        pageRankAlgorithm.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                PageRankAlgorithmFx pageRankAlgorithmFx = new PageRankAlgorithmFx();
                try {
                    {
                        pageRankAlgorithmFx.start(primaryStage);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        MenuItem crossValidationProcess = new MenuItem("Cross ValidationProcess");
        crossValidationProcess.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                CrossValidationFX crossValidationFX = new CrossValidationFX();
                {
                    crossValidationFX.start(primaryStage);
                }
            }
        });
        MenuItem trainingSetView = new MenuItem("Training Set View");
        trainingSetView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                TrainingSet trainingSet = new TrainingSet();
                {
                    trainingSet.start(primaryStage);
                }
            }
        });

        MenuItem testingSetView = new MenuItem("Testing Set View");
        testingSetView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                TestingSet testingSet = new TestingSet();
                {
                    testingSet.start(primaryStage);
                }
            }
        });

        MenuItem bookInformationView = new MenuItem("Book Information");

        bookInformationView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                BookInformationFX bookInformationFX = new BookInformationFX();
                {
                    bookInformationFX.start(primaryStage);
                }
            }
        });

        MenuItem systemAnalysis = new MenuItem("System Analysis");
        systemAnalysis.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                SystemAnalysis systemAnalysis = new SystemAnalysis();
                {
                    systemAnalysis.start(primaryStage);
                }
            }
        });

        menu5.getItems().addAll(readingRoom1,libraryDesk1,
                processVisualization,multivariableLinearRegression,
                analyticHierarchyProcess,pageRankAlgorithm,
                crossValidationProcess,trainingSetView,
                testingSetView,bookInformationView,systemAnalysis);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4,menu5);
        menuBar.setStyle("-fx-text-fill: #000000;");
        menuBar.setStyle("-fx-background-color: #ffffff;");
        menuBar.setStyle("-fx-padding: 1 5 1 5;");
        menuBar.setStyle(" -fx-spacing: 47;");
        menuBar.prefHeight(32);
        group.getChildren().add(menuBar);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
      graphicsContext.drawImage(background,0,0);
        Scene scene1 = new Scene(group,1500,950);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    String userChoiceList ="";
    String addFavouriteWriter="";
    String [] addFavouriteBookType = new String[12];
    int typeNumber=0;
    String userName;
    String userID;
    String stringStudyLevel="";
    String educationLevel = "";
    TextField textFieldClassNo = new TextField();
    TextField textFieldDepartment = new TextField();
    public void manualSystem(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Label label = new Label("");
        RadioButton logIn = new RadioButton("Log In");
        RadioButton signUp = new RadioButton("Sign Up");
        ToggleGroup toggleGroupMain = new ToggleGroup();
        logIn.setToggleGroup(toggleGroupMain);
        signUp.setToggleGroup(toggleGroupMain);
logIn.setOnAction(actionEvent -> {
    TextField getUserName = new TextField();
    TextField getUserID = new TextField();

    Label userNameTextField = new Label("_Name:");
    Label userIdTextField = new Label("_User ID:");
    userNameTextField.setLabelFor(getUserName);
    userNameTextField.setMnemonicParsing(true);
    userIdTextField.setLabelFor(getUserID);
    userIdTextField.setMnemonicParsing(true);
    Label label1 = new Label("Insert Your Name & ID");
    Button enter = new Button("----Enter----");

            enter.setPrefSize(160, 40);
            Stage infoStage = new Stage();
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);

    label.setText("LOG IN");
    label.setTranslateX(100);
    label.setTranslateY(20);
    label.setPrefSize(250,65);
    Label label2 = new Label();
    gridPane.setVgap(10);
    gridPane.addRow(0,label);
    gridPane.addRow(1,  label1);
    gridPane.addRow(2, userNameTextField, getUserName);
    gridPane.addRow(3, userIdTextField, getUserID);
    gridPane.addRow(4,label2,enter);
    gridPane.setMaxSize(980, 650);

            Scene S = new Scene(gridPane, 700, 400);
            infoStage.setTitle("Login");
            infoStage.setScene(S);
            infoStage.show();
    enter.setOnAction(actionEvent1 -> {
userName = getUserName.getText();
userID = getUserID.getText();
userName = userName.trim();
userID =userID.trim();

AccountManagement accountManagement = new AccountManagement();
        boolean isFound = false;
        try {
            isFound = accountManagement.accountManagementLogInMethods(userName,userID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(isFound==true){
            JOptionPane.showMessageDialog(null,"Successfully Find Your Account");
            try {
                accountManagement.accountManagementGetRecommendedBookList(userName,userID);
                UserChoiceTableData userChoiceTableData = new UserChoiceTableData();
                userChoiceTableData.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Sorry!! Your Account Does not exists");
        }
    });
        });

   signUp.setOnAction(actionEvent -> {
       TextField readerTextField = new TextField();
       Label readerName = new Label("_Name:");
       readerName.setLabelFor(readerTextField);
       readerName.setMnemonicParsing(true);
       TextField instituteTextField = new TextField();
       Label instituteName = new Label("_Institute Name:");
       instituteName.setLabelFor(instituteTextField);
       instituteName.setMnemonicParsing(true);

       ToggleGroup toggleGroup = new ToggleGroup();
RadioButton radioButtonCollege = new RadioButton("School/College");
RadioButton radioButtonUniversity = new RadioButton("University");
radioButtonCollege.setToggleGroup(toggleGroup);
radioButtonUniversity.setToggleGroup(toggleGroup);

       Label label1 = new Label("Insert Your Name & Institute");
       Button enterButton = new Button("----Enter----");
       enterButton.setPrefSize(160, 40);
       Stage infoStage = new Stage();
       GridPane gridPane = new GridPane();
       gridPane.setAlignment(Pos.CENTER);
       label.setText("SIGN UP");
       label.setTranslateX(100);
       label.setTranslateY(20);
       label.setPrefSize(250,65);

Label label2 =new Label();
Label label3 =new Label();
Label label4 =new Label();
       Button cancel = new Button("----Cancel----");
       cancel.setPrefSize(160, 40);
       cancel.setOnAction(actionEvent1 -> {
           infoStage.close();
       });
       gridPane.setVgap(10);
       gridPane.addRow(0,label2,label);
       gridPane.addRow(1,  label1);
       gridPane.addRow(2, readerName, readerTextField);
       gridPane.addRow(3, instituteName, instituteTextField);
       gridPane.addRow(4, radioButtonCollege, radioButtonUniversity);
       gridPane.addRow(12,label3,label4,cancel,enterButton);
       MenuItem humayonAhmed = new MenuItem("Humayon Ahmed");
       humayonAhmed.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent e) {
addFavouriteWriter = humayonAhmed.getText();
           } });

       MenuItem muhammadJafarIqbal = new MenuItem("Muhammad Jafar Iqbal");
       muhammadJafarIqbal.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = muhammadJafarIqbal.getText();
           }
       });
       MenuItem rokibHasan = new MenuItem("Rokib Hasan");
       rokibHasan.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = rokibHasan.getText();
           }
       });
       MenuItem emdadulHaqueMilon = new MenuItem("Emdadul Haque Milon");
       emdadulHaqueMilon.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = emdadulHaqueMilon.getText();
           }
       });
       MenuItem kaziNazrulIslam = new MenuItem("Kazi Nazrul Islam");
       kaziNazrulIslam.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = kaziNazrulIslam.getText();
           } });
       MenuItem kaziAnwarHossain = new MenuItem("Kazi Anwar Hossain");
       kaziAnwarHossain.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = kaziAnwarHossain.getText();
           }
       });
       MenuItem sharatChandraChattropadhay = new MenuItem("Sharat Chandra Chattropadhay");
       sharatChandraChattropadhay.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = sharatChandraChattropadhay.getText();
           }
       });
       MenuItem rabindranathTagore = new MenuItem("Rabindranath Tagore");
       rabindranathTagore.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = rabindranathTagore.getText();
           } });

       MenuItem sunilGangoPaddahay = new MenuItem("Sunil Gango Paddahay");
       sunilGangoPaddahay.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = sunilGangoPaddahay.getText();
           }
       });


       MenuItem samareshMajumdar = new MenuItem("Samaresh majumdar");
       samareshMajumdar.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = samareshMajumdar.getText();
           }
       });
       MenuItem emdadiyaPustokaloy = new MenuItem("Emdadiya Pustokaloy");

       emdadiyaPustokaloy.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = emdadiyaPustokaloy.getText();
           }
       });


       MenuItem others = new MenuItem("Others");
       others.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
addFavouriteWriter = others.getText();
           }
       });

       MenuButton writerMenu = new MenuButton("Choose The Writer");
       writerMenu.getItems().addAll( humayonAhmed, muhammadJafarIqbal, rokibHasan, emdadulHaqueMilon,
               kaziNazrulIslam, kaziAnwarHossain, sharatChandraChattropadhay, rabindranathTagore, sunilGangoPaddahay,
               samareshMajumdar, emdadiyaPustokaloy,others);
       Label favouriteWriter = new Label("Favourite Writer");
       favouriteWriter.setLabelFor(writerMenu);
       gridPane.addRow(9,favouriteWriter,writerMenu);

       CheckBox uponnash =new CheckBox("Uponnash");
       uponnash.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=uponnash.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox kobita =new CheckBox("Kobita");
       kobita.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=kobita.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox rochonaboli =new CheckBox("Rochonaboli");
       rochonaboli.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=rochonaboli.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox religion =new CheckBox("Religion");
       religion.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=religion.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox biggan =new CheckBox("Biggan");
       biggan.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=biggan.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox scienceFiction =new CheckBox("Science Fiction");
       scienceFiction.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=scienceFiction.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox shishuShahitto =new CheckBox("Shishu Shahitto");
       shishuShahitto.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=shishuShahitto.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox kisoreUponnash =new CheckBox("Kisore Uponnash");
       kisoreUponnash.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=kisoreUponnash.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox biography =new CheckBox("Biography");
       biography.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=biography.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox gobesona =new CheckBox("Gobesona");
       gobesona.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=gobesona.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox onubad =new CheckBox("Onubad");
       onubad.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=onubad.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox others1 =new CheckBox("Others");
       others1.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=others1.getText();
           userChoiceList = userChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });

       gridPane.addRow(6,uponnash,kobita,rochonaboli,religion);
       gridPane.addRow(7,biggan,scienceFiction,shishuShahitto,kisoreUponnash);
       gridPane.addRow(8,biography,gobesona,onubad,others1);
       var ref = new Object() {
           int gridPaneCounter = 0;
       };
       radioButtonCollege.setOnAction(actionEvent1 -> {
         //  gridPane.getChildren().remove(6);
if(ref.gridPaneCounter ==0){


    Label classNo = new Label("Class No :");
    classNo.setLabelFor(textFieldClassNo);
    classNo.setMnemonicParsing(true);
    gridPane.addRow(5, classNo, textFieldClassNo);
    ref.gridPaneCounter =1;
    educationLevel = "Secondary";
}
else{
    infoStage.close();
}
       });
       radioButtonUniversity.setOnAction(actionEvent1 -> {
if(ref.gridPaneCounter==0){
    Label departmentName = new Label("Department Name :");
    departmentName.setLabelFor(textFieldDepartment);
    departmentName.setMnemonicParsing(true);
    gridPane.addRow(5, departmentName, textFieldDepartment);
ref.gridPaneCounter=1;

    educationLevel = "Higher";}
else{
    infoStage.close();
}
       });
       gridPane.setMaxSize(980, 650);
       Scene S = new Scene(gridPane, 700, 400);
       infoStage.setTitle("Login");
       infoStage.setScene(S);
       infoStage.show();
       enterButton.setOnAction(actionEvent1 -> {
           if(addFavouriteWriter.equals("")){
JOptionPane.showMessageDialog(null,"Please Choose Your\nFavourite Writer");
           }else{
               String addReaderName;
               String addInstituteName;
               addReaderName = readerTextField.getText();
               addInstituteName = instituteTextField.getText();
               stringStudyLevel = textFieldClassNo.getText();
               if(stringStudyLevel.equals("")){
                   stringStudyLevel = textFieldDepartment.getText();
               }
               String [] infoDataArray = new String[4];

               infoDataArray[0] = addReaderName;
               infoDataArray[1]=addInstituteName;
               infoDataArray[2]=stringStudyLevel;
               infoDataArray[3]=educationLevel;
               System.out.println(addReaderName+"\t"+addInstituteName+"\t"+educationLevel+"\t"+stringStudyLevel);

               userChoiceList = userChoiceList +addFavouriteWriter;
               String textUserID = "0000";
               AccountManagement accountManagement = new AccountManagement();
               try {
                   textUserID=  accountManagement.accountManagementSignUpMethods(infoDataArray, userChoiceList);
               } catch (IOException e) {
                   e.printStackTrace();
               }
               if(textUserID=="0000"){
                   JOptionPane.showMessageDialog(null,
                           "Your Account is not Created !!!");
               }
               else{
                   JOptionPane.showMessageDialog(null,
                           "Your Account is successfully Created"+"\n"+
                                   "Name : "+addReaderName+"\n"+"User  ID : "+textUserID);
               }
               int iterator;
               for(iterator=0;iterator<12;iterator++){
                   addFavouriteBookType[iterator]=null;
               }
               typeNumber=0;
           }
           });
   });

   logIn.setTranslateX(300);
        logIn.setTranslateY(100);
          signUp.setTranslateX(510);
          signUp.setTranslateY(100);
                logIn.setPrefSize(150,50);
                signUp.setPrefSize(150,50);
                setStyle(logIn);
                setStyle(signUp);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setOnAction(actionEvent -> {
            try {
             start(primaryStage);
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
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        Image image = new Image("Images"+ File.separator +"libraryBackground23.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back);
        group.getChildren().addAll();
        group.getChildren().addAll(logIn,signUp,label);
        
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
        Scene scene1 = new Scene(group,1500,950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }
    public void automaticSystem(Stage primaryStage) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Button writerWise = new Button("Writer Wise");

        writerWise.setTranslateX(230);
        writerWise.setTranslateY(50);
        writerWise.setOnAction(actionEvent -> {
            try {

                WriterWiseFX writerWiseFX = new WriterWiseFX();
                writerWiseFX.start(primaryStage);
            }

            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        writerWise.setPrefSize(400, 80);
        setStyle(writerWise);
        Button classWise = new Button("Class Wise");

        classWise.setTranslateX(640);
        classWise.setTranslateY(50);
        classWise.setOnAction(actionEvent -> {

            try {
                TypeWiseFX typeWiseFX = new TypeWiseFX();
                typeWiseFX.start(primaryStage);
            }

            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        classWise.setPrefSize(400, 80);
        setStyle(classWise);
        Button selfWise = new Button("Self Wise");

        selfWise.setTranslateX(230);
        selfWise.setTranslateY(140);
        selfWise.setOnAction(actionEvent -> {

            try {
                RemoveBookFX.SelfWiseFX selfWiseFX = new RemoveBookFX.SelfWiseFX();
                selfWiseFX.start(primaryStage);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        selfWise.setPrefSize(400, 80);
        setStyle(selfWise);

        Button timeWise = new Button("Time Wise");

        timeWise.setTranslateX(640);
        timeWise.setTranslateY(140);
        timeWise.setOnAction(actionEvent -> {
            try {
                TimeWiseFX timeWiseFX = new TimeWiseFX();
                timeWiseFX.start(primaryStage);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        timeWise.setPrefSize(400, 80);
        setStyle(timeWise);
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setOnAction(actionEvent -> {
            try {
              start(primaryStage);
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
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

      //  Image image = new Image("Images"+ File.separator +"libraryBackground23.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,
                writerWise,classWise,selfWise,
                timeWise );
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
      //  graphicsContext.drawImage(image,0,0);

        Scene scene1 = new Scene(group,1500,950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    public Button setStyle( Button button)
    {
        button.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 1 0 2 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
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
    public RadioButton setStyle( RadioButton radioButton)
    {
        radioButton.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.4em;");
        return  radioButton;
    }
    public Label setStyle( Label label)
    {
        label.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.4em;");
        return  label;
    }
}
