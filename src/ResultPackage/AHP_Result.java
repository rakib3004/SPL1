package ResultPackage;

import Collection.*;
import FilePackage.DateTimeWriter;
import Methods.PrintInfo;
import Methods.ReverseSorting;
import Methods.Searching;
import ObjectOriented.PriorityData;

import javax.swing.*;
import java.util.Scanner;


public class AHP_Result {
    Searching searching = new Searching();
    WriterCollection writerCollection = new WriterCollection();
    TypeCollection typeCollection = new TypeCollection();
    TimeCollection timeCollection = new TimeCollection();
    BorrowCollection borrowCollection = new BorrowCollection();
    PriceCollection priceCollection = new PriceCollection();
    ReverseSorting reverseSorting = new ReverseSorting();
    PrintInfo printInfo = new PrintInfo();
    int iterator;

    public void AHP_ResultMethods(PriorityData[] priorityData, int numberOfBooks) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        int enterChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Choice : ");
        System.out.println("1. Show Result");
        System.out.println("2. ReverseSorting and show result");
        System.out.println("3. Type Based Analysis");
        System.out.println("4. Writer Based Analysis");
        System.out.println("5. Price Based Analysis");
        System.out.println("6. Time Based Analysis");
        System.out.println("7. borrow Based Analysis");

        enterChoice = scanner.nextInt();
        if(enterChoice==1){
            printInfo.showAHPProcessResult(priorityData,numberOfBooks);
        }
        else if(enterChoice==2){
            reverseSorting.sortingAHPmethods(priorityData,numberOfBooks);
        }
        else if(enterChoice==3){
            timeCollection.timeCollectionAHPMethods(priorityData,numberOfBooks);
        }
        else if(enterChoice==4){
            writerCollection.writerCollectionAHPMethods(priorityData,numberOfBooks);
        }
        else if (enterChoice==5){
            priceCollection.priceCollectionAHPMethods(priorityData,numberOfBooks);
        }
        else if (enterChoice==6){
            timeCollection.timeCollectionAHPMethods(priorityData,numberOfBooks);
        }
        else if (enterChoice==7){
            borrowCollection.borrowCollectionAHPMethods(priorityData,numberOfBooks);
        }


    }





    public void printOptionMethods(PriorityData[] priorityData, int numberOfBooks){



        double temporary;
        int temp;
        PriorityData tempData;
      /*  for (iterator = 0; iterator < numberOfBooks; iterator++) {
            for (int j = 0; j < numberOfBooks; j++) {
                if (priorityData[iterator].getAHPweight() > priorityData[j].getAHPweight()) {

                    tempData = priorityData[iterator];
                    priorityData[iterator] = priorityData[j];
                    priorityData[j] = tempData;
                }
            }
        }*/

        try {


            String aString = JOptionPane.showInputDialog("Chose OPtion :\n1.Type Base Statitics " +
                    "\n2.Writer Based Statistics \n3.Issue Date Base Statitics " +
                    "\n4.Borrow Based Statistics" + "\n5.Searching by Alphabets");
            //     optimizedResult(priorityData,numberOfBooks);

            int anInt = Integer.parseInt(aString);
            JOptionPane.showMessageDialog(null, "You Pressed " + anInt);

            if (anInt == 1) {

                typeCollection.typeCollectionAHPMethods(priorityData, numberOfBooks);

            } else if (anInt == 2) {

                writerCollection.writerCollectionAHPMethods(priorityData, numberOfBooks);

            } else if (anInt == 3) {

                timeCollection.timeCollectionAHPMethods(priorityData, numberOfBooks);

            } else if (anInt == 4) {

                borrowCollection.borrowCollectionAHPMethods(priorityData, numberOfBooks);

            } else if (anInt == 5) {

                searching.search(priorityData, numberOfBooks);

            } else {
                JOptionPane.showMessageDialog(null, "Empty Command");
            }

        } catch (NullPointerException nullPointerException) {
            System.out.println();

        }



    }

}