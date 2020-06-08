package InfoDisplay;

import FilePackage.DateTimeWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.Parent;

import java.io.IOException;

public class BookAnalysisFX extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Parent parent = FXMLLoader.load(getClass().getResource("database.fxml"));
primaryStage.setScene(new Scene(parent,1000,500));
primaryStage.show();


    }


}