package FilePackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeWriter {

    int classCounter = 0;

    public void dateTimeWriterInitialMethods(String className) {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a");

        String FILENAME, string, COUNTER_FILE;
        FILENAME = "history.txt";
        COUNTER_FILE = "ClassCounter.txt";

        string = className + "\t";
        string = string + ft.format(dNow) + "\n";

        /*
         * BufferedWriter out = null;
         * try {
         * out = new BufferedWriter(
         * new FileWriter(FILENAME, true));
         * } catch (IOException e) {
         * e.printStackTrace();
         * }
         * try {
         * out.write(string);
         * out.close();
         * } catch (IOException e) {
         * e.printStackTrace();
         * }
         */
        try {
            FileWriter fileWriter = new FileWriter(FILENAME);
            fileWriter.write(string);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        classCounter++;
        String noAccessClass = Integer.toString(classCounter);

        FileWriter fileWriter1 = null;
        try {
            fileWriter1 = new FileWriter(COUNTER_FILE);
            fileWriter1.write(noAccessClass);
            fileWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dateTimeWriterMethods(String className) {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a");

        String FILENAME, string;
        FILENAME = "history.txt";
        string = className + "\t";
        string = string + ft.format(dNow) + "\n";

        BufferedWriter out = null;
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
        }
        /*
         * try {
         * FileWriter fileWriter=new FileWriter(FILENAME);
         * fileWriter.write(string);
         * fileWriter.close();
         * } catch (IOException e) {
         * e.printStackTrace();
         * }
         */

        String COUNTER_FILE = "ClassCounter.txt";
        classCounter++;
        String noAccessClass = Integer.toString(classCounter);

        FileWriter fileWriter1 = null;
        try {
            fileWriter1 = new FileWriter(COUNTER_FILE);
            fileWriter1.write(noAccessClass);
            fileWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
