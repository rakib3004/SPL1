package AHPalgorithm;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;

public class AopyAsteClass {
    public void menubar(){

    }
    public void buttonLayout(){
      /*  Font font = new Font(19);
        Font font1 = new Font(47);
        Font font2 = new Font( 26);
        Button processValueAreaChart = new Button("ProcessValue AreaChart");
        Button processValueLineArt = new Button("ProcessValue LineArt");
        Button processValuePlotting = new Button("ProcessValue Plotting");

        processValueAreaChart.setPrefSize(410,230);
        processValueLineArt.setPrefSize(410,230);
        processValuePlotting.setPrefSize(410,230);

        processValueAreaChart.setFont(font);
        processValueLineArt.setFont(font);
        processValuePlotting.setFont(font2);
        processValueAreaChart.setTranslateX(30);
        processValueAreaChart.setTranslateY(35);
        processValueLineArt.setTranslateX(30);
        processValueLineArt.setTranslateY(270);
        processValuePlotting.setTranslateX(30);
        processValuePlotting.setTranslateY(505);

        processValueAreaChart.setContentDisplay(ContentDisplay.TOP);
        processValueLineArt.setContentDisplay(ContentDisplay.TOP);
        processValuePlotting.setContentDisplay(ContentDisplay.TOP);
        FileInputStream fileInputStream1 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"automatic.png");
        Image image1 = new Image(fileInputStream1);
        processValueAreaChart.setGraphic(new ImageView(image1));

        FileInputStream fileInputStream2 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"manual.png");
        Image image2 = new Image(fileInputStream2);
        processValueLineArt.setGraphic(new ImageView(image2));

        FileInputStream fileInputStream3 = new FileInputStream(
                "src"+ File.separator +"Images"+ File.separator +"document.png");
        Image image3 = new Image(fileInputStream3);
        processValuePlotting.setGraphic(new ImageView(image3));

        processValueAreaChart.setOnAction(actionEvent -> {
            try {
                AddBookFX addBookFX = new AddBookFX();
                addBookFX.start(primaryStage);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        processValueLineArt.setOnAction(actionEvent -> {
            BookInformationFX bookInformationFX = new BookInformationFX();
            try {
                bookInformationFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        processValuePlotting.setOnAction(actionEvent -> {
            try {
                RemoveBookFX removeBookFX = new RemoveBookFX();
                removeBookFX.start(primaryStage);
            }
            catch (Exception exception) {
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
        Text text = new Text("Librarian Desk");
        text.setTranslateX(575);
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
        });*/
    }
    public void grapicsCard(){
        Image background = new Image("Images"+ File.separator +"framework.jpg");
        Canvas canvas = new Canvas(850, 425);
        canvas.setTranslateX(470);
        canvas.setTranslateY(35);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(background,0,0);
        Group group = new Group();
    }
    public void swapPosition(){
        /*twoVariableRegression.setTranslateX(50);
        twoVariableRegression.setTranslateY(20);
        threeVariableRegression.setTranslateX(50);
        threeVariableRegression.setTranslateY(380);
        fourVariableRegression.setTranslateX(50);
        fourVariableRegression.setTranslateY(740);

        double temp;
        temp= twoVariableRegression.getTranslateX();
        twoVariableRegression.setTranslateX(twoVariableRegression.getTranslateY());
        twoVariableRegression.setTranslateY(temp);

        temp=      threeVariableRegression.getTranslateX();
        threeVariableRegression.setTranslateX(threeVariableRegression.getTranslateY());
        threeVariableRegression.setTranslateY(temp);
        temp=     fourVariableRegression.getTranslateX();
        fourVariableRegression.setTranslateX(fourVariableRegression.getTranslateY());
        fourVariableRegression.setTranslateY(temp);*/
    }
}
