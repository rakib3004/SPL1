package FilePackage;

import ObjectOriented.PriorityData;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {
    int iterator;
    public void outputWriterMethods(PriorityData[] priorityData, int numberOfBooks){
        String string="";

        try {
            for (iterator = 0; iterator < numberOfBooks; iterator++) {
                System.out.println(iterator+"_____M R :"+priorityData[iterator].getMLRweight()+">>>>>>"+priorityData[iterator].bookData.bookName);
                string = string + (iterator + "_____M R :" + priorityData[iterator].getMLRweight() + ">>>>>>" + priorityData[iterator].bookData.bookName+"\n");
            }

        }
        catch (NullPointerException nullPointerException){
            System.out.println("Null Pointer Exception");
        }


        String FILENAME = "New Output5.txt";

        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(FILENAME, true));
            out.write(string);
            out.write(" --------------------------------------------------" +
                    "---------------------------------------------------------------" +
                    "------------------------------------------------");
            out.write(" ---------------------------------------------------" +
                    "-------------------------------------------------------------" +
                    "-------------------------------------------------");
            out.write(" ----------------------------------------------------" +
                    "------------------------------------------------------------------" +
                    "-------------------------------------------");

            out.close();
            JOptionPane.showMessageDialog(null,"Successful Programme Activation");
        }
        catch (IOException e) {
            System.out.println("exception occoured" + e);
        }


    }


    }
