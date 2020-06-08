package FilePackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeWriter {
    public void dateTimeWriterMethods(String className){
        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a");

String FILENAME,string;
        FILENAME = "history.txt";

     string =  className+"\t";
        string = string+ ft.format(dNow)+"\n";

    /* BufferedWriter out = null;
            try {
                out = new BufferedWriter(
                        new FileWriter(FILENAME, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.write(string);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        try {
            FileWriter fileWriter=new FileWriter(FILENAME);
            fileWriter.write(string);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
