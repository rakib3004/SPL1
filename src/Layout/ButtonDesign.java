package Layout;

import javafx.application.Application;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;

public class ButtonDesign extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
    public Button systemDesign(Button button,int w, int h, int x, int y, double fontSize){
      button.setPrefSize(w,h);
      button.setTranslateX(x);
      button.setTranslateY(y);
        Font font = Font.font(Font.getFontNames().get(0),
                FontWeight.BOLD,fontSize);
        return  button;
    }
    public LineChart systemLine(LineChart lineChart,int w, int h, int x, int y){
        lineChart.setPrefSize(w,h);
        lineChart.setTranslateX(x);
        lineChart.setTranslateX(y);
        return  lineChart;
    }  public ScatterChart systemLine(ScatterChart scatterChart, int w, int h, int x, int y){
        scatterChart.setPrefSize(w,h);
        scatterChart.setTranslateX(x);
        scatterChart.setTranslateX(y);
        return  scatterChart;
    }

    }
