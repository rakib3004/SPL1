package ProjectDescription;

import FilePackage.DateTimeWriter;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class DynamicStage extends Application {
    Timeline time = new Timeline();
    int timeSec = 1;
    int bookCounter=0;
    @Override
    public void start(Stage primaryStage) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);

        Text bookNameText = new Text();

        setStyle(bookNameText);

        bookNameText.setFill(Color.GREENYELLOW);
        bookNameText.setTranslateX(200);
        bookNameText.setTranslateY(200);
        back.setOnAction(actionEvent -> {
            About about = new About();

            try {
                about.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        exit.setOnAction(actionEvent -> {
           System.exit(0);
        });
        Font font3= Font.font(Font.getFontNames().get(0), FontWeight.BOLD,30);
        back.setFont(font3);
        exit.setFont(font3);

        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.seconds(6));
        pt.setCycleCount(1);
        pt.setAutoReverse(false);
        pt.play();

        time = new Timeline();
        time.setCycleCount(4);
        time.setAutoReverse(false);
        time.getKeyFrames().add(
                new KeyFrame(Duration.seconds(2),
                        event -> {
                            timeSec++;
                            if(timeSec%4==1){


                                Image image = new Image("Images"+ File.separator +"Slide2.jpg");
                                Canvas canvas = new Canvas(1500,950);
                                Group group = new Group();
                                group.getChildren().addAll(canvas,exit,back,bookNameText);

                                GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
                                graphicsContext.drawImage(image,0,0);

                                Scene scene1 = new Scene(group,1500,950);
                                primaryStage.setScene(scene1);
                                primaryStage.setTitle("Recommendation Tool");
                                primaryStage.setFullScreen(true);
                                primaryStage.show();
                            }
                            else  if(timeSec%4==2){

                                Image image = new Image("Images"+ File.separator +"Slide3.jpg");
                                Canvas canvas = new Canvas(1500,950);
                                Group group = new Group();
                                group.getChildren().addAll(canvas,exit,back,bookNameText);

                                GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
                                graphicsContext.drawImage(image,0,0);
                                Scene scene1 = new Scene(group,1500,950);
                                primaryStage.setScene(scene1);
                                primaryStage.setTitle("Recommendation Tool");
                                primaryStage.setFullScreen(true);
                                primaryStage.show();

                            }  else  if(timeSec%4==3){
                                Image image = new Image("Images"+ File.separator +"Slide4.jpg");
                                Canvas canvas = new Canvas(1500,950);
                                Group group = new Group();
                                group.getChildren().addAll(canvas,exit,back,bookNameText);

                                GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
                                graphicsContext.drawImage(image,0,0);

                                Scene scene1 = new Scene(group,1500,950);


                                primaryStage.setScene(scene1);
                                primaryStage.setTitle("Recommendation Tool");
                                primaryStage.setFullScreen(true);
                                primaryStage.show();
                            }   else  if(timeSec%4==0){


                                Image image = new Image("Images"+ File.separator +"Slide5.jpg");
                                Canvas canvas = new Canvas(1500,950);
                                Group group = new Group();
                                group.getChildren().addAll(canvas,exit,back,bookNameText);
                                GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
                                graphicsContext.drawImage(image,0,0);
                                Scene scene1 = new Scene(group,1500,950);

                                primaryStage.setScene(scene1);
                                primaryStage.setTitle("Recommendation Tool");
                                primaryStage.setFullScreen(true);
                                primaryStage.show();
                            }
                        })
        );
        time.play();
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


}
