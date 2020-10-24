package Layout;

import javafx.application.Application;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class ButtonDesign extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
    public Button systemLine(Button button,int w, int h, int x, int y, double fontSize){
      button.setPrefSize(w,h);
      button.setTranslateX(x);
      button.setTranslateY(y);
        Font font = Font.font(Font.getFontNames().get(0),
                FontWeight.BOLD,fontSize);
        button.setFont(font);
        return  button;
    }public Button systemLine(Button button,int w, int h, int x, int y){
      button.setPrefSize(w,h);
      button.setTranslateX(x);
      button.setTranslateY(y);
        return  button;
    }
    public Label systemLine(Label label,int w, int h, int x, int y){
      label.setPrefSize(w,h);
      label.setTranslateX(x);
      label.setTranslateY(y);
        return  label;
    } public Label systemLine(Label label,int w, int h, int x, int y, double fontSize){
      label.setPrefSize(w,h);
      label.setTranslateX(x);
      label.setTranslateY(y);
        Font font = Font.font(Font.getFontNames().get(0),
                FontWeight.BOLD,fontSize);
        label.setFont(font);
        label.setTextFill(Color.WHITE);
        return  label;
    }
    public LineChart systemLine(LineChart lineChart,int w, int h, int x, int y){
        lineChart.setPrefSize(w,h);
        lineChart.setTranslateX(x);
        lineChart.setTranslateY(y);
        return  lineChart;
    }

    public ScatterChart systemLine(ScatterChart scatterChart, int w, int h, int x, int y){
        scatterChart.setPrefSize(w,h);
        scatterChart.setTranslateX(x);
        scatterChart.setTranslateY(y);
        return  scatterChart;
    }
    public StackedAreaChart systemLine(StackedAreaChart stackedAreaChart, int w, int h, int x, int y){
        stackedAreaChart.setPrefSize(w,h);
        stackedAreaChart.setTranslateX(x);
        stackedAreaChart.setTranslateY(y);
        return  stackedAreaChart;
    }
    public Label systemLine(Label label,  int x, int y, double fontSize){
        label.setTranslateX(x);
        label.setTranslateY(y);
        Font font = Font.font(Font.getFontNames().get(0),
                FontWeight.BOLD,fontSize);
        return  label;
    }
    public Text setPosition(Text text, int x, int y){
        text.setTranslateX(x);
        text.setTranslateY(y);
        text.setFill(Color.GREENYELLOW);
        return  text;
    }
  public TextField setPosition(TextField textField, int x, int y){
      textField.setTranslateX(x);
      textField.setTranslateY(y);
      return  textField;
  }

    }
