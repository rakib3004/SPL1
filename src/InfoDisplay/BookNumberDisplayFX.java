package InfoDisplay;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.MenuFX;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class BookNumberDisplayFX extends Application {

    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;

    int numberOfBooks;
    int typeCounter=6,writerCounter=350, yearCounter =12;
    int typePalse,writerPalse,yearPalse;
    int timeSec = 1;
    int bookCounter=0;
    Timeline time = new Timeline();

    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();

    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    @Override
    public void start(Stage primaryStage) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");

        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, 8);
        Font font1 = Font.font("Times New Roman", FontPosture.ITALIC, 8);

        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);


        back.setOnAction(actionEvent -> {
            MenuFX menuFX = new MenuFX();

            try {
                menuFX.start(primaryStage);
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

        try {
            numberOfBooks = bookNumber.bookNumberFindingMethods();
        } catch (IOException e) {
            e.printStackTrace();
        }



        Label BookNumbers = new Label((numberOfBooks/6)+" Books" );
        BookNumbers.setAlignment(Pos.CENTER);
        setStyle1(BookNumbers);
        BookNumbers.setFont(font1);
        BookNumbers.setPrefSize(110, 80);
        BookNumbers.setTextAlignment(TextAlignment.CENTER);
        BookNumbers.setTranslateX(250);
        BookNumbers.setTranslateY(130);
        Paint svColor = Color.rgb(102,111,200);
        BookNumbers.setBackground(new Background(new BackgroundFill(svColor, CornerRadii.EMPTY, Insets.EMPTY)));
        BookNumbers.setTextFill(Color.BLACK);
        BookNumbers.setScaleX(6);
        BookNumbers.setScaleY(3.4);




        Label WriterNumbers = new Label((writerCounter/6)+" Writers " );
        WriterNumbers.setAlignment(Pos.CENTER);
        setStyle2(WriterNumbers);
        WriterNumbers.setPrefSize(110, 80);
        WriterNumbers.setTextAlignment(TextAlignment.CENTER);
        WriterNumbers.setFont(font1);
        WriterNumbers.setTranslateX(1000);
        WriterNumbers.setTranslateY(130);
        Paint sttColor = Color.rgb(0,96,11);
        BookNumbers.setBackground(new Background(new BackgroundFill(sttColor, CornerRadii.EMPTY, Insets.EMPTY)));
        Paint stColor = Color.rgb(100,150,50);
        WriterNumbers.setBackground(new Background(new BackgroundFill(stColor, CornerRadii.EMPTY, Insets.EMPTY)));
        WriterNumbers.setTextFill(Color.BLACK);
        WriterNumbers.setScaleX(6);
        WriterNumbers.setScaleY(3.4);



        Label YearsNumbers = new Label( (yearCounter /6)+" Years " );
        YearsNumbers.setAlignment(Pos.CENTER);
        setStyle3(YearsNumbers);
        YearsNumbers.setPrefSize(110, 80);
        YearsNumbers.setTextAlignment(TextAlignment.CENTER);
        YearsNumbers.setFont(font1);
        YearsNumbers.setTranslateX(250);
        YearsNumbers.setTranslateY(465);
        Paint shColor = Color.rgb(200,20,30);
        YearsNumbers.setBackground(new Background(new BackgroundFill(shColor, CornerRadii.EMPTY, Insets.EMPTY)));
        YearsNumbers.setTextFill(Color.BLACK);
        YearsNumbers.setScaleX(6);
        YearsNumbers.setScaleY(3.4);



        Label TypeNumbers = new Label((typeCounter/6)+" types");
        TypeNumbers.setAlignment(Pos.CENTER);
        setStyle4(TypeNumbers);
        TypeNumbers.setFont(font1);
        TypeNumbers.setTextAlignment(TextAlignment.CENTER);
        TypeNumbers.setPrefSize(110, 80);
        TypeNumbers.setTranslateX(1000);
        TypeNumbers.setTranslateY(465);
        Paint srColor = Color.rgb(214,158,33);
        TypeNumbers.setBackground(new Background(new BackgroundFill(srColor, CornerRadii.EMPTY, Insets.EMPTY)));
        TypeNumbers.setTextFill(Color.BLACK);
        TypeNumbers.setScaleX(6);
        TypeNumbers.setScaleY(3.4);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.seconds(6));
        // pt.setNode(ball);
//        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(1);
        pt.setAutoReverse(false);
        pt.play();



        time = new Timeline();
        time.setCycleCount(6);
        time.setAutoReverse(false);
        time.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1.13),
                        event -> {
                            timeSec++;
                            bookCounter = (numberOfBooks/6)*timeSec;
                            writerPalse =  (writerCounter/6)*timeSec;
                            typePalse = (typeCounter/6)*timeSec;
                            yearPalse =  (yearCounter/6)*timeSec;
                            BookNumbers.setText(bookCounter+" Books" );
                            WriterNumbers.setText(writerPalse+" Writers" );
                            TypeNumbers.setText(typePalse+" types" );
                            YearsNumbers.setText(yearPalse+" Years" );

                            if (timeSec == 6) {

                                time.stop();
                            }
                        })
        );

        time.play();


        Group semiGroup = new Group();;
        semiGroup.getChildren().addAll(BookNumbers,WriterNumbers,YearsNumbers,TypeNumbers);
        String string = "libraryBackground9.jpg";

        Image image = new Image(string);
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,semiGroup,exit,back);



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
                "    -fx-background-color: #33FF66 \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  button;
    }

    public Label setStyle1(Label label)
    {
        label.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: #00FFFF \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 0.6em;");
        return  label;
    }

    public Label setStyle2(Label label)
    {
        label.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: #00FFFF \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 0.6em;");
        return  label;
    }

    public Label setStyle3(Label label)
    {
        label.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: #00FFFF \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 0.6em;");
        return  label;
    }

    public Label setStyle4(Label label)
    {
        label.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: #00FFFF \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 0.6em;");
        return  label;
    }
}
