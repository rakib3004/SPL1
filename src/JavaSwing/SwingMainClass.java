package JavaSwing;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import SimpleRegression.DoublyLinearRegression;
import MultiVariableRegression.MultipleLinearRegression;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import PageRankAlgorithm.PageRankCalculation;
import Regression.newVersion.TypeCountRegression;

import javax.swing.*;
import java.io.IOException;

public class SwingMainClass {

    public static void main(String[] args) throws IOException {
        PriorityData[] priorityData;
        AHPcriteriaWeight ahPcriteriaWeight;
        TypeCountRegression typeCountRegression = new TypeCountRegression();
        MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
        DoublyLinearRegression doublyLinearRegression = new DoublyLinearRegression();

        int numberOfBooks;
        Processing processing = new Processing();
        BookNumber bookNumber = new BookNumber();

        AHPcalculation ahPcalculation = new AHPcalculation();
        AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
        int input1,input2;
        String stringInput,stringInput2;


      stringInput =  JOptionPane.showInputDialog("What do you want???\n1.Multivariable Linear Regression \n" +
                "2.Analytic Heirarcy Process\n3.Page Rank Algorithm");

      input1 = Integer.parseInt(stringInput);


        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();



      if(input1==1){

          stringInput2 =  JOptionPane.showInputDialog("What do you want???\n1.Two Variable Linear Regression \n" +
                  "2.Three Variable Linear Regression \n3.Four Variable Linear Regression ");

          input2 = Integer.parseInt(stringInput2);

          if(input2==1){
              typeCountRegression.typeCountRegressionMethods(priorityData,numberOfBooks);

          }
          else if(input2==2){
              doublyLinearRegression.doublyLinearRegressionMethods(priorityData,numberOfBooks);

          }
          else if(input2==3){
              priorityData =      multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
          }



      }
      else if(input1==2){

          ahPcriteriaWeight =  ahPcalculation.AHPcalculationMethods(priorityData,numberOfBooks);
          ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight,priorityData,numberOfBooks);

      }
      else{
          PageRankCalculation pageRankCalculation = new PageRankCalculation();

          try {

              pageRankCalculation.pageRankCalculationMethods(priorityData,numberOfBooks);
              System.exit(0);
          }

          catch (Exception exception) {
              exception.printStackTrace();
          }
      }

    }
}
