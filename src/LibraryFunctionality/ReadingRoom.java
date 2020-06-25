package LibraryFunctionality;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.FXThirdWindow;
import JavFX.FxSecondWindow;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import ProjectDescription.About;
import TableViewPackage.Book;
import UserInterfacePackage.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
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


        Button automaticSystem = new Button("Automatic System");
        automaticSystem.setOnAction(actionEvent -> {
            try {
                automaticSystem(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        setStyle(automaticSystem);
        automaticSystem.setPrefSize(400,80);
        automaticSystem.setTranslateX(240);
        automaticSystem.setTranslateY(50);

        Button manualSystem = new Button("Manual System");
        manualSystem.setOnAction(actionEvent -> {
            try {
                manualSystem(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        setStyle(manualSystem);
        manualSystem.setPrefSize(400,80);
        manualSystem.setTranslateX(650);
        manualSystem.setTranslateY(50);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setOnAction(actionEvent -> {
            FxSecondWindow fxSecondWindow = new FxSecondWindow();

            try {
                fxSecondWindow.start(primaryStage);
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


        Image image = new Image("Images"+ File.separator +"libraryBackground23.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,
          readersMood,administrationMood,about);
        group.getChildren().addAll(automaticSystem,manualSystem);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);

        Scene scene1 = new Scene(group,1500,950);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    String addFavouriteWriter;
    String [] addFavouriteBookType = new String[12];
    int typeNumber=0;
    String userName;
    String userID;
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

    TextField firstNameFld = new TextField();
    TextField lastNameFld = new TextField();

    Label userNameTextField = new Label("_Name:");
    Label userIdTextField = new Label("_User ID:");
    userNameTextField.setLabelFor(firstNameFld);
    userNameTextField.setMnemonicParsing(true);
    userIdTextField.setLabelFor(lastNameFld);
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

    gridPane.setVgap(10);
    gridPane.addRow(0,label);
    gridPane.addRow(1,  label1);
    gridPane.addRow(2, userNameTextField, firstNameFld);
    gridPane.addRow(3, userIdTextField, lastNameFld);
    gridPane.addRow(4,enter);

    gridPane.setMaxSize(980, 650);


            Scene S = new Scene(gridPane, 700, 400);
            infoStage.setTitle("Login");
            infoStage.setScene(S);
            infoStage.show();


    enter.setOnAction(actionEvent1 -> {
userName = userNameTextField.getText();
userID = userIdTextField.getText();
AccountManagement accountManagement = new AccountManagement();

boolean isFound = accountManagement.accountManagementLogInMethods(userName,userID);
if(isFound==true){
    accountManagement.accountManagementFindRecommendedBookList(userName,userID);
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
       gridPane.setVgap(10);
       gridPane.addRow(0,label);
       gridPane.addRow(1,  label1);
       gridPane.addRow(2, readerName, readerTextField);
       gridPane.addRow(3, instituteName, instituteTextField);
       gridPane.addRow(4, radioButtonCollege, radioButtonUniversity);
       gridPane.addRow(12,label2,enterButton);

       Button cancel = new Button("Cancel");
       cancel.setPrefSize(160, 40);
       cancel.setOnAction(actionEvent1 -> {
           infoStage.close();
       });

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
           typeNumber++;
       });
       CheckBox kobita =new CheckBox("Kobita");
       kobita.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=kobita.getText();
           typeNumber++;
           
       });
       CheckBox rochonaboli =new CheckBox("Rochonaboli");
       rochonaboli.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=rochonaboli.getText();
           typeNumber++;
           
       });
       CheckBox religion =new CheckBox("Religion");
       religion.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=religion.getText();
           typeNumber++;
           
       });
       CheckBox biggan =new CheckBox("Biggan");
       biggan.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=biggan.getText();
           typeNumber++;
           
       });
       CheckBox scienceFiction =new CheckBox("Science Fiction");
       scienceFiction.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=scienceFiction.getText();
           typeNumber++;
           
       });
       CheckBox shishuShahitto =new CheckBox("Shishu Shahitto");
       shishuShahitto.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=shishuShahitto.getText();
           typeNumber++;
           
       });
       CheckBox kisoreUponnash =new CheckBox("Kisore Uponnash");
       kisoreUponnash.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=kisoreUponnash.getText();
           typeNumber++;
           
       });
       CheckBox biography =new CheckBox("Biography");
       biography.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=biography.getText();
           typeNumber++;
           
       });
       CheckBox gobesona =new CheckBox("Gobesona");
       gobesona.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=gobesona.getText();
           typeNumber++;
           
       });
       CheckBox onubad =new CheckBox("Onubad");
       onubad.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=onubad.getText();
           typeNumber++;
           
       });
       CheckBox others1 =new CheckBox("Others");
       others1.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=others1.getText();
           typeNumber++;

       });

       gridPane.addRow(6,uponnash,kobita,rochonaboli,religion);
       gridPane.addRow(7,biggan,scienceFiction,shishuShahitto,kisoreUponnash);
       gridPane.addRow(8,biography,gobesona,onubad,others1);

       var ref = new Object() {
           int gridPaneCounter = 0;
       };
       radioButtonCollege.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=uponnash.getText();
           typeNumber++;
         //  gridPane.getChildren().remove(6);
if(ref.gridPaneCounter ==0){

    TextField textFieldClassNo = new TextField();
    Label classNo = new Label("Class No :");
    classNo.setLabelFor(textFieldClassNo);
    classNo.setMnemonicParsing(true);
    gridPane.addRow(5, classNo, textFieldClassNo);
    ref.gridPaneCounter =1;

}
else{
    infoStage.close();
}
       });
       radioButtonUniversity.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=uponnash.getText();
           typeNumber++;
if(ref.gridPaneCounter==0){
    TextField textFieldDepartment = new TextField();
    Label departmentName = new Label("Department Name :");
    departmentName.setLabelFor(textFieldDepartment);
    departmentName.setMnemonicParsing(true);
    gridPane.addRow(5, departmentName, textFieldDepartment);
ref.gridPaneCounter=1;
}
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
           addFavouriteBookType[typeNumber]=uponnash.getText();
           typeNumber++;
           String addReaderName;
           String addInstituteName;
           addReaderName = readerTextField.getText();
           addInstituteName = instituteTextField.getText();
           System.out.println(addReaderName+"\t"+addInstituteName+"\t"+addFavouriteWriter);

           String [] infoDataArray = new String[3];

           infoDataArray[0] = addReaderName;
           infoDataArray[1]=addInstituteName;
           infoDataArray[2]=addFavouriteWriter;
           String textUserID = "0000";
           AccountManagement accountManagement = new AccountManagement();
           try {
             textUserID=  accountManagement.accountManagementMethods(infoDataArray,addFavouriteBookType);
           } catch (IOException e) {
               e.printStackTrace();
           }
           JOptionPane.showMessageDialog(null,
                   "Your Account is successfully Created"+"\n"+
                   "Name : "+addReaderName+"\n"+"User ID : "+textUserID);
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

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Image image = new Image("Images"+ File.separator +"libraryBackground23.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back);
        group.getChildren().addAll(readersMood,
                administrationMood,about);
        group.getChildren().addAll(logIn,signUp,label);
        
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);

        Scene scene1 = new Scene(group,1500,950);
        
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }    public void automaticSystem(Stage primaryStage) throws IOException {
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




        Image image = new Image("Images"+ File.separator +"libraryBackground23.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,
                writerWise,classWise,selfWise,
                timeWise ,readersMood,
                administrationMood,about);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);

        Scene scene1 = new Scene(group,1500,950);


        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();
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
