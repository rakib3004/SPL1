package LibraryFunctionality;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.*;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);

        Button defaultType = new Button("Default Book Recommendation");
        Button userBased = new Button("User Based Book Recommendation");
        Button rules = new Button("Users Rules & Regulations");

        defaultType.setPrefSize(410,230);
        userBased.setPrefSize(410,230);
        rules.setPrefSize(410,230);

        defaultType.setFont(font);
        userBased.setFont(font);
        rules.setFont(font2);
        defaultType.setTranslateX(30);
        defaultType.setTranslateY(35);
        userBased.setTranslateX(30);
        userBased.setTranslateY(270);
        rules.setTranslateX(30);
        rules.setTranslateY(505);

        defaultType.setContentDisplay(ContentDisplay.TOP);
        userBased.setContentDisplay(ContentDisplay.TOP);
        rules.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"automatic.png");
        Image image1 = new Image(fileInputStream1);
        defaultType.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"manual.png");
        Image image2 = new Image(fileInputStream2);
        userBased.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"document.png");
        Image image3 = new Image(fileInputStream3);
        rules.setGraphic(new ImageView(image3));

        defaultType.setOnAction(actionEvent -> {

            try {
                automaticSystem(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        userBased.setOnAction(actionEvent -> {
            try {
                manualSystem(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        rules.setOnAction(actionEvent -> {
            ProjectDescription projectDescription = new ProjectDescription();
            try {
                projectDescription.start(primaryStage,3);
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
        exit.setFont(font);
        Text text = new Text("Library's Reading Room ");
        text.setTranslateX(600);
        text.setTranslateY(500);
        text.setFont(font1);
        text.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold;");


        Button home = new Button("Home");
        home.setTranslateX(470);
        home.setTranslateY(520);
        home.setPrefSize(375,30);
        home.setFont(font2);
        home.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream5 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"home.png");
        Image image5 = new Image(fileInputStream5);
        home.setGraphic(new ImageView(image5));
        home.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        Button back = new Button("Back");
        back.setTranslateX(950);
        back.setTranslateY(520);
        back.setPrefSize(375,30);
        back.setFont(font2);
        back.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream6 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"back.png");
        Image image6 = new Image(fileInputStream6);
        back.setGraphic(new ImageView(image6));
        back.setOnAction(actionEvent -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
        Image background = new Image("Images"+ File.separator +"framework.jpg");
        Canvas canvas = new Canvas(850, 425);
        canvas.setTranslateX(470);
        canvas.setTranslateY(35);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,home);
        group.getChildren().addAll(defaultType,userBased,rules,text);

         GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
         graphicsContext.drawImage(background,0,0);
         Scene scene1 = new Scene(group,1500,950);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    String userBookTypeChoiceList ="";
    String userWriterChoiceList ="";
    String [] addFavouriteBookType = new String[12];
    String [] addFavouriteWriterType = new String[12];
    int typeNumber=0;
    int writerNumber=0;
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

        Label signUpLabel = new Label("");
        RadioButton logInRadioButton = new RadioButton("Log In");
        RadioButton signUpRadioButton = new RadioButton("Sign Up");
        ToggleGroup toggleGroupMain = new ToggleGroup();
        logInRadioButton.setToggleGroup(toggleGroupMain);
        signUpRadioButton.setToggleGroup(toggleGroupMain);
        Font font = Font.font(Font.getFontNames().get(0), FontWeight.BOLD,18);
        Font font1 =Font.font(Font.getFontNames().get(0), FontWeight.BOLD,25);
        Font font5 =Font.font(Font.getFontNames().get(0), FontWeight.BOLD,15);
        Font font2 = new Font( 15);
        Font font4 =Font.font(Font.getFontNames().get(0), FontWeight.BOLD,33);

        //login to system
        logInRadioButton.setOnAction(actionEvent -> {
            TextField getUserName = new TextField();
            TextField getUserID = new TextField();

            Label userNameTextField = new Label("_Name:");
            Label userIdTextField = new Label("_User ID:");
            userNameTextField.setFont(font2);
            userIdTextField.setFont(font2);
            getUserName.setFont(font5);
            getUserID.setFont(font5);
            userNameTextField.setLabelFor(getUserName);
            userNameTextField.setMnemonicParsing(true);
            userIdTextField.setLabelFor(getUserID);
            userIdTextField.setMnemonicParsing(true);
            Button enterButton1 = new Button("----Enter----");

            userNameTextField.setFont(font1);
            userIdTextField.setFont(font1);

            enterButton1.setPrefSize(160, 40);
            Stage infoStage = new Stage();
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);

            signUpLabel.setText("LOG IN");
            signUpLabel.setTranslateX(230);
            signUpLabel.setTranslateY(5);
            signUpLabel.setPrefSize(250,65);
            Label label2 = new Label();

            Label spaceLabel = new Label(" ");
            Label emptyLabelOne = new Label("");
            Label emptyLabelTwo = new Label("");
            Label emptyLabelThree = new Label("");
            Label insertNameID = new Label("Insert Your Name & User ID");
            insertNameID.setFont(font1);
            gridPane.setVgap(10);
            gridPane.addRow(0,signUpLabel);
            gridPane.addRow(1, insertNameID);
            gridPane.addRow(2, userNameTextField, getUserName);
            gridPane.addRow(3, userIdTextField, getUserID);
            gridPane.addRow(14,label2,enterButton1);
            gridPane.setMaxSize(980, 650);
            Image image19 = new Image("Images"+ File.separator +"a6.jpg");
            Canvas canvas19 = new Canvas(600,400);
            Group group19 = new Group();
            group19.getChildren().addAll(canvas19);
            group19.getChildren().addAll(gridPane);


            GraphicsContext graphicsContext = canvas19.getGraphicsContext2D();
            graphicsContext.drawImage(image19,0,0);

            Scene S = new Scene(group19, 600, 400);
            infoStage.setTitle("Login");
            infoStage.setScene(S);
            infoStage.show();

            enterButton1.setOnAction(actionEvent1 -> {
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
                Stage accountInfoStage = new Stage();
                Label accountInfoLabel= new Label();
                Group accountInfoGroup = new Group();

        if(isFound==true){

            accountInfoLabel.setText("Successfully Find Your Account");
            try {
                PriorityList  priorityList =    accountManagement.accountManagementGetRecommendedBookList(userName,userID);
                UserChoiceTableData userChoiceTableData = new UserChoiceTableData();
                userChoiceTableData.start(primaryStage,userName,userID,priorityList);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else{
            accountInfoLabel.setText("Sorry!! Your Account Does not exists.\n\t\t\tTry Again!!!!!");

        }
        Image image20 = new Image("Images"+ File.separator +"iconic1.jpg");
                Canvas canvas20 = new Canvas(400,180);
                GraphicsContext graphicsContext1 = canvas20.getGraphicsContext2D();
                graphicsContext1.drawImage(image20,0,0);
                Font font7= Font.font(Font.getFontNames().get(0),FontWeight.BOLD,16);
                Button okButton = new Button("OK");
                okButton.setFont(font7);
                okButton.setTranslateX(180);
                okButton.setTranslateY(125);
                okButton.setPrefSize(75,25);
                okButton.setOnAction(actionEvent2 ->{
                    accountInfoStage.close();
                });
                accountInfoGroup.getChildren().addAll(canvas20,accountInfoLabel,okButton);
                Font font3= Font.font(Font.getFontNames().get(0),FontWeight.BOLD,26);
                accountInfoLabel.setFont(font3);
                accountInfoLabel.setTextFill(Color.WHITE);
                accountInfoLabel.setTranslateX(25);
                accountInfoLabel.setTranslateY(50);
                Scene notExitsAccountScene = new Scene(accountInfoGroup,400,180);
                accountInfoStage.setScene(notExitsAccountScene);
                accountInfoStage.show();
    });
        });

       signUpRadioButton.setOnAction(actionEvent -> {

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

       Label insertNameInstitute = new Label("Insert Your Name & Institute : ");
       Button enterButton = new Button("----Enter----");
       enterButton.setPrefSize(160, 40);
       Stage infoStage = new Stage();
       GridPane gridPane = new GridPane();
       gridPane.setAlignment(Pos.CENTER);
       signUpLabel.setText("SIGN UP");
       signUpLabel.setTranslateX(100);
       signUpLabel.setTranslateY(20);
       signUpLabel.setPrefSize(250,65);

        Label label2 =new Label();
        Label label3 =new Label();
        Label label4 =new Label();
       Button cancelButton = new Button("----Cancel----");
       cancelButton.setPrefSize(160, 40);
       signUpLabel.setFont(font4);
       signUpLabel.setTextFill(Color.WHITE);
       radioButtonCollege.setFont(font1);
       radioButtonUniversity.setFont(font1);
       readerName.setFont(font1);
       instituteName.setFont(font1);
       insertNameInstitute.setFont(font1);
       readerTextField.setFont(font);
       instituteTextField.setFont(font);
      // enterButton.setFont(font1);
     //  cancelButton.setFont(font1);
       cancelButton.setOnAction(actionEvent1 -> {
           infoStage.close();
       });
       gridPane.setVgap(10);
       gridPane.addRow(0,label2,signUpLabel);
       gridPane.addRow(1,  insertNameInstitute);
       gridPane.addRow(2, readerName, readerTextField);
       gridPane.addRow(3, instituteName, instituteTextField);
       gridPane.addRow(4, radioButtonCollege, radioButtonUniversity);
       gridPane.addRow(17,label3,cancelButton,enterButton,label4);


       CheckBox uponnash =new CheckBox("Uponnash");
       uponnash.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=uponnash.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox kobita =new CheckBox("Kobita");
       kobita.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=kobita.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox rochonaboli =new CheckBox("Rochonaboli");
       rochonaboli.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=rochonaboli.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox religion =new CheckBox("Religion");
       religion.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=religion.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox biggan =new CheckBox("Biggan");
       biggan.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=biggan.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox scienceFiction =new CheckBox("Science Fiction");
       scienceFiction.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=scienceFiction.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox shishuShahitto =new CheckBox("Shishu Shahitto");
       shishuShahitto.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=shishuShahitto.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox kisoreUponnash =new CheckBox("Kisore Uponnash");
       kisoreUponnash.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=kisoreUponnash.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox biography =new CheckBox("Biography");
       biography.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=biography.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox gobesona =new CheckBox("Gobesona");
       gobesona.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=gobesona.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox onubad =new CheckBox("Onubad");
       onubad.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=onubad.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
       CheckBox others1 =new CheckBox("Others");
       others1.setOnAction(actionEvent1 -> {
           addFavouriteBookType[typeNumber]=others1.getText();
           userBookTypeChoiceList = userBookTypeChoiceList + addFavouriteBookType[typeNumber]+"\t";
           typeNumber++;
       });
Label label = new Label("Choose Your Favourite Type : ");
label.setFont(font1);
       gridPane.addRow(6,label);
       gridPane.addRow(7,uponnash,kobita,rochonaboli,religion);
       gridPane.addRow(8,biggan,scienceFiction,shishuShahitto,kisoreUponnash);
       gridPane.addRow(9,biography,gobesona,onubad,others1);
        uponnash.setFont(font5);
        kobita.setFont(font5);
        rochonaboli.setFont(font5);
        religion.setFont(font5);
        biggan.setFont(font5);
        scienceFiction.setFont(font5);
        shishuShahitto.setFont(font5);
        kisoreUponnash.setFont(font5);
        biography.setFont(font5);
        gobesona.setFont(font5);
        onubad.setFont(font5);
        others1.setFont(font5);
           CheckBox humayonAhmed = new CheckBox("Humayon Ahmed");
           humayonAhmed.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=humayonAhmed.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
       });

           CheckBox muhammadJafarIqbal = new CheckBox("Muhammad Jafar Iqbal");
           muhammadJafarIqbal.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=muhammadJafarIqbal.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
           });
           CheckBox rokibHasan = new CheckBox("Rokib Hasan");
           rokibHasan.setOnAction(actionEvent1 -> {

               addFavouriteWriterType[writerNumber]=rokibHasan.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
           });
           CheckBox emdadulHaqueMilon = new CheckBox("Emdadul Haque Milon");
           emdadulHaqueMilon.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=emdadulHaqueMilon.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;

           });
           CheckBox kaziNazrulIslam = new CheckBox("Kazi Nazrul Islam");
           kaziNazrulIslam.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=kaziNazrulIslam.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;

           });
           CheckBox kaziAnwarHossain = new CheckBox("Kazi Anwar Hossain");
           kaziAnwarHossain.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=kaziAnwarHossain.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
           });
           CheckBox sharatChandraChattropadhay = new CheckBox("Sharat Chandra Chattropadhay");
           sharatChandraChattropadhay.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=sharatChandraChattropadhay.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
           });
           CheckBox rabindranathTagore = new CheckBox("Rabindranath Tagore");
           rabindranathTagore.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=rabindranathTagore.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
           });

           CheckBox sunilGangoPaddahay = new CheckBox("Sunil Gango Paddahay");
           sunilGangoPaddahay.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=sunilGangoPaddahay.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
           });

           CheckBox samareshMajumdar = new CheckBox("Samaresh majumdar");
           samareshMajumdar.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=samareshMajumdar.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
           });
           CheckBox emdadiyaPustokaloy = new CheckBox("Emdadiya Pustokaloy");

           emdadiyaPustokaloy.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=emdadiyaPustokaloy.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
           });
           CheckBox othersWriter = new CheckBox("Others Writer");
           othersWriter.setOnAction(actionEvent1 -> {
               addFavouriteWriterType[writerNumber]=othersWriter.getText();
               userWriterChoiceList = userWriterChoiceList + addFavouriteWriterType[writerNumber]+"\t";
               writerNumber++;
           });

           Label favouriteWriter = new Label("Choose YourFavourite Writer : ");
           favouriteWriter.setFont(font1);
           gridPane.addRow(11,favouriteWriter);
           gridPane.addRow(12,humayonAhmed, muhammadJafarIqbal, rokibHasan);
           gridPane.addRow(13,emdadulHaqueMilon, kaziNazrulIslam, kaziAnwarHossain);
           gridPane.addRow(14,sharatChandraChattropadhay, rabindranathTagore, sunilGangoPaddahay);
           gridPane.addRow(15,samareshMajumdar, emdadiyaPustokaloy,othersWriter);

        humayonAhmed.setFont(font5);
        muhammadJafarIqbal.setFont(font5);
        rokibHasan.setFont(font5);
        emdadulHaqueMilon.setFont(font5);
        kaziNazrulIslam.setFont(font5);
        kaziAnwarHossain.setFont(font5);
        sharatChandraChattropadhay.setFont(font5);
        rabindranathTagore.setFont(font5);
        sunilGangoPaddahay.setFont(font5);
        samareshMajumdar.setFont(font5);
        emdadiyaPustokaloy.setFont(font5);
        othersWriter.setFont(font5);
       final int[] gridPaneCounter = {0};
       radioButtonCollege.setOnAction(actionEvent1 -> {
         //  gridPane.getChildren().remove(6);
if(gridPaneCounter[0] ==0){
    Label classNo = new Label("Class No :");
    classNo.setFont(font1);
    textFieldClassNo.setFont(font);
    classNo.setLabelFor(textFieldClassNo);
    classNo.setMnemonicParsing(true);
    gridPane.addRow(5, classNo, textFieldClassNo);
    gridPaneCounter[0] =1;
    educationLevel = "Secondary";
}
else{
    infoStage.close();
}
       });
       radioButtonUniversity.setOnAction(actionEvent1 -> {
if(gridPaneCounter[0] ==0){
    Label departmentName = new Label("Department Name :");
    departmentName.setFont(font1);
    textFieldDepartment.setFont(font);
    departmentName.setLabelFor(textFieldDepartment);
    departmentName.setMnemonicParsing(true);
    gridPane.addRow(5, departmentName, textFieldDepartment);
gridPaneCounter[0] =1;

    educationLevel = "Higher";}
else{
    infoStage.close();
}
       });
       gridPane.setMaxSize(980, 650);

       Image image19 = new Image("Images"+ File.separator +"signUp.jpg");
       Canvas canvas19 = new Canvas(850,650);
       Group group19 = new Group();
       group19.getChildren().addAll(canvas19);
       group19.getChildren().addAll(gridPane);


       GraphicsContext graphicsContext = canvas19.getGraphicsContext2D();
       graphicsContext.drawImage(image19,0,0);

       Scene S = new Scene(group19, 850, 650,Color.DODGERBLUE);
       infoStage.setTitle("Login");
       infoStage.setScene(S);
       infoStage.show();
       enterButton.setOnAction(actionEvent1 -> {
           Stage accountInfoStage = new Stage();
           Label accountInfoLabel= new Label();
           Group accountInfoGroup = new Group();
           Button okButton = new Button("OK");
           Font font7= Font.font(Font.getFontNames().get(0),FontWeight.BOLD,16);
           okButton.setFont(font7);
           okButton.setTranslateX(180);
           okButton.setTranslateY(150);
           okButton.setPrefSize(75,25);
           if(userWriterChoiceList.equals("")|| userBookTypeChoiceList.equals("")||readerTextField.getText().equals("")||instituteTextField.getText().equals("")){
               accountInfoLabel.setText("Your Information are incomplete!!!!");
               okButton.setTranslateX(180);
               okButton.setTranslateY(120);
               okButton.setPrefSize(120,25);
               okButton.setText("Try Again");
               Image image20 = new Image("Images"+ File.separator +"iconic1.jpg");
               Canvas canvas20 = new Canvas(400,200);
               GraphicsContext graphicsContext1 = canvas20.getGraphicsContext2D();
               graphicsContext1.drawImage(image20,0,0);

               okButton.setOnAction(actionEvent2 ->{
                   accountInfoStage.close();
               });
               accountInfoGroup.getChildren().addAll(canvas20,accountInfoLabel,okButton);
               Font font3= Font.font(Font.getFontNames().get(0),FontWeight.BOLD,26);
               accountInfoLabel.setFont(font3);
               accountInfoLabel.setTextFill(Color.WHITE);
               accountInfoLabel.setTranslateX(25);
               accountInfoLabel.setTranslateY(50);
               Scene notExitsAccountScene = new Scene(accountInfoGroup,400,200);
               accountInfoStage.setScene(notExitsAccountScene);
               accountInfoStage.show();
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
/*
               System.out.println(addReaderName+"\t"+addInstituteName+"\t"+educationLevel+"\t"+stringStudyLevel);
*/

               int userChoiceListLength = userBookTypeChoiceList.length();
               int userChoiceListLength2 = userWriterChoiceList.length();

               userBookTypeChoiceList = userBookTypeChoiceList.substring(0,userChoiceListLength-1);
               userWriterChoiceList = userWriterChoiceList.substring(0,userChoiceListLength2-1);
               userBookTypeChoiceList = userBookTypeChoiceList +"\n"+ userWriterChoiceList;
               String textUserID = "0000";
               AccountManagement accountManagement = new AccountManagement();
               try {
                   textUserID=  accountManagement.accountManagementSignUpMethods(infoDataArray, userBookTypeChoiceList);
               } catch (IOException e) {
                   e.printStackTrace();
               }

               if(textUserID=="0000"){
                   accountInfoLabel.setText("Your Account is not Created !!!");
                   okButton.setTranslateX(180);
                   okButton.setTranslateY(120);
                   okButton.setPrefSize(120,25);
                   okButton.setText("Try Again");
               }
               else{
                   accountInfoLabel.setText("Your Account is successfully Created"+"\n"+
                                   "Name : "+addReaderName+"\n"+"User  ID : "+textUserID);
               }




               Image image20 = new Image("Images"+ File.separator +"iconic1.jpg");
               Canvas canvas20 = new Canvas(400,200);
               GraphicsContext graphicsContext1 = canvas20.getGraphicsContext2D();
               graphicsContext1.drawImage(image20,0,0);

               okButton.setOnAction(actionEvent2 ->{
                   accountInfoStage.close();
               });
               accountInfoGroup.getChildren().addAll(canvas20,accountInfoLabel,okButton);
               Font font3= Font.font(Font.getFontNames().get(0),FontWeight.BOLD,26);
               accountInfoLabel.setFont(font3);
               accountInfoLabel.setTextFill(Color.WHITE);
               accountInfoLabel.setTranslateX(25);
               accountInfoLabel.setTranslateY(50);
               Scene notExitsAccountScene = new Scene(accountInfoGroup,400,200);
               accountInfoStage.setScene(notExitsAccountScene);
               accountInfoStage.show();
               int iterator;
               for(iterator=0;iterator<12;iterator++){
                   addFavouriteBookType[iterator]=null;
               }
               typeNumber=0;

         infoStage.close();
           }
           });
   });
   logInRadioButton.setTranslateX(500);
        logInRadioButton.setTranslateY(400);
          signUpRadioButton.setTranslateX(700);
          signUpRadioButton.setTranslateY(400);
                logInRadioButton.setPrefSize(150,50);
                signUpRadioButton.setPrefSize(150,50);
        Font font3 =Font.font(Font.getFontNames().get(0),FontWeight.BOLD,27);
        Font font6 =Font.font(Font.getFontNames().get(0),FontWeight.BOLD,37);
logInRadioButton.setFont(font3);
signUpRadioButton.setFont(font3);
logInRadioButton.setTextFill(Color.BLACK);
signUpRadioButton.setTextFill(Color.BLACK);
Text textHeading = new Text("User Choice Based Recommendation Tool");
textHeading.setFont(font6);
textHeading.setTranslateX(400);
textHeading.setTranslateX(250);
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
        Font font10= Font.font(Font.getFontNames().get(0),FontWeight.BOLD,26);
        back.setFont(font10);
        exit.setFont(font10);

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        Image image = new Image("Images"+ File.separator +"a19.png");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back);
        group.getChildren().addAll();
        group.getChildren().addAll(logInRadioButton,signUpRadioButton,signUpLabel,textHeading);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
        Scene scene1 = new Scene(group,1500,950/*,Color.CRIMSON*/);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }
    public void automaticSystem(Stage primaryStage) throws IOException {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font(23);

        Button writerWise = new Button("Writer Wise");
        Button typeWise1 = new Button("Type Wise");
        Button selfWise = new Button("Shelf Wise");
        Button timeWise = new Button("Time Wise");

        typeWise1.setPrefSize(400, 170);
        selfWise.setPrefSize(400, 170);
        timeWise.setPrefSize(400, 170);
        writerWise.setPrefSize(400, 170);

        typeWise1.setFont(font2);
        selfWise.setFont(font2);
        timeWise.setFont(font2);
        writerWise.setFont(font2);

        typeWise1.setTranslateX(30);
        typeWise1.setTranslateY(35);
        selfWise.setTranslateX(30);
        selfWise.setTranslateY(210);
        timeWise.setTranslateX(30);
        timeWise.setTranslateY(385);
        writerWise.setTranslateX(30);
        writerWise.setTranslateY(560);

        typeWise1.setContentDisplay(ContentDisplay.LEFT);
        selfWise.setContentDisplay(ContentDisplay.LEFT);
        timeWise.setContentDisplay(ContentDisplay.LEFT);
        writerWise.setContentDisplay(ContentDisplay.LEFT);
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "types.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image1 = new Image(fileInputStream1);
        typeWise1.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream2 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "borrow.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(fileInputStream2);
        selfWise.setGraphic(new ImageView(image2));
        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream3 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "time.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image3 = new Image(fileInputStream3);
        timeWise.setGraphic(new ImageView(image3));

        FileInputStream fileInputStream7 = null;
        try {
            fileInputStream7 = new FileInputStream(
                    "src" + File.separator + "Images" + File.separator + "demand.png");
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
        selfWise.setOnAction(actionEvent -> {

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
        Text text = new Text("Default Book Recommendation");
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
                readingRoom.start(primaryStage);
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
                selfWise, writerWise,
                timeWise, exit, home, text, back);
        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
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
