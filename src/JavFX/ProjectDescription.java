package JavFX;

import CrossValidationProcess.CrossValidation;
import FilePackage.DateTimeWriter;
import LibraryFunctionality.ReadingRoom;
import LinearRegression.FourVariableRegression;
import RecommendationAlgorithm.AnalyticHierarchyAlgorithm;
import RecommendationAlgorithm.PageRankAlgorithm;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class ProjectDescription extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage, int index) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(50);
        back.setTranslateY(670);
        exit.setTranslateX(1100);
        exit.setTranslateY(670);
        back.setOnAction(actionEvent -> {
            AuthorSystem authorSystem = new AuthorSystem();
            try {
                authorSystem.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        exit.setOnAction(actionEvent -> {
            System.exit(1129);
        });
        Font font3 = Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 30);
        back.setFont(font3);
        exit.setFont(font3);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);
        String imageString = "v1.png";

        if (index == 1) {
            imageString = "v1.png";
            back.setOnAction(actionEvent -> {
                AuthorSystem authorSystem = new AuthorSystem();
                try {
                    authorSystem.start(primaryStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });
        } else if (index == 2) {
            imageString = "v2.png";
            back.setOnAction(actionEvent -> {
                CrossValidation crossValidation = new CrossValidation();
                try {
                    crossValidation.start(primaryStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });
        } else if (index == 3) {
            imageString = "v3.png";
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }else if (index == 4) {
            imageString = "v4.png";
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }else if (index == 5) {
            imageString = "v5.png";
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }else if (index == 6) {
            imageString = "v6.png";
            ReadingRoom readingRoom = new ReadingRoom();
            try {
                readingRoom.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }

        if(methodIndex==1){
            FourVariableRegression fourVariableRegression1 = new FourVariableRegression();
            try {
                fourVariableRegression1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        else if(methodIndex==2){
            AnalyticHierarchyAlgorithm analyticHierarchyAlgorithm = new AnalyticHierarchyAlgorithm();
            try {
                analyticHierarchyAlgorithm.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        else if(methodIndex==3){
            PageRankAlgorithm pageRankAlgorithmFx = new PageRankAlgorithm();
            try {
                pageRankAlgorithmFx.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        Image image = new Image("Images" + File.separator + imageString);

        Canvas canvas = new Canvas(1500, 950);
        Group group = new Group();
        group.getChildren().addAll(canvas, exit, back);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image, 0, 0);

        Scene scene1 = new Scene(group, 1500, 950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Recommendation Tool");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}

 /*

   Class tree/ Diagram ache naki kono
        Coding difficulties ki ki
        Function name readable
        Comment ache naki kono ( important jaygay comment rakhte hobe)
        Library r use ache naki

        */