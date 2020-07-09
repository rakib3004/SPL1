
package MainPackage;

        import AHPalgorithm.AHPcalculation;
        import AHPalgorithm.AHPprocessImplementation;
        import FilePackage.DateTimeWriter;
        import SimpleRegression.DoublyLinearRegression;
        import MultiVariableRegression.MultipleLinearRegression;
        import ObjectOriented.AHPcriteriaWeight;
        import ObjectOriented.PriorityData;
        import PageRankAlgorithm.PageRankCalculation;
        import Regression.newVersion.TypeCountRegression;
        import ResultPackage.AHP_Result;
        import ResultPackage.MLR_Result;
        import ResultPackage.PRA_Result;

        import javax.swing.*;

        import java.io.IOException;
        import java.util.Scanner;

public class MainClass extends JFrame {


    public static void main(String[] args)throws IOException {


        PriorityData[] priorityData;
        AHPcriteriaWeight ahPcriteriaWeight;
        TypeCountRegression typeCountRegression = new TypeCountRegression();
        MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
        DoublyLinearRegression doublyLinearRegression = new DoublyLinearRegression();
        int numberOfBooks;
        Processing processing = new Processing();
        BookNumber bookNumber = new BookNumber();
        MLR_Result mlrResult = new MLR_Result();
        AHP_Result ahpResult = new AHP_Result();
        PRA_Result praResult = new PRA_Result();
        AHPcalculation ahPcalculation = new AHPcalculation();
        AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
        Scanner scanner = new Scanner(System.in);
        int input1,input2;

        System.out.println("What do you want???\n1.Multivariable Linear Regression \n" +
                "2.Analytic Heirarcy Process\n3.Page Rank Algorithm");
        input1 = scanner.nextInt();
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        if(input1==1){

            System.out.println("What do you want???\n1.Two Variable Linear Regression \n" +
                    "2.Three Variable Linear Regression \n3.Four Variable Linear Regression ");
            input2 = scanner.nextInt();

            if(input2==1){
                typeCountRegression.typeCountRegressionMethods(priorityData,numberOfBooks);
            }
            else if(input2==2){
                doublyLinearRegression.doublyLinearRegressionMethods(priorityData,numberOfBooks);

            }
            else if(input2==3){
                priorityData =    multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
                mlrResult.MLR_ResultMethods(priorityData,numberOfBooks);
            }
        }
        else if(input1==2){
            ahPcriteriaWeight =  ahPcalculation.AHPcalculationMethods(priorityData,numberOfBooks);
       priorityData=     ahPprocessImplementation.ahpProcessImplementationMethods(ahPcriteriaWeight,priorityData,numberOfBooks);
             ahpResult.AHP_ResultMethods(priorityData,numberOfBooks);
        }
        else if(input1==6){
            int i;
            for(i=0;i<numberOfBooks;i++){
                System.out.println(priorityData[i].timePriority);
            }
        }
        else{
            PageRankCalculation pageRankCalculation = new PageRankCalculation();
            try {

           priorityData=   pageRankCalculation.pageRankCalculationMethods(priorityData,numberOfBooks);
praResult.PRA_ResultMethods(priorityData,numberOfBooks);
                System.exit(0);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }
}