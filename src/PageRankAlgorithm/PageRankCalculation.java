package PageRankAlgorithm;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class PageRankCalculation {
double linkValue;
boolean checkLink;
PageRankLink pageRankLink = new PageRankLink();
CheckPageLink checkPageLink = new CheckPageLink();
    int iterator,jterator;
    double  [] temporaryBorrowCount = new double[2000];

PageRankMatrixCalculation pageRankMatrixCalculation = new PageRankMatrixCalculation();
    public PriorityData[]  pageRankCalculationMethods(PriorityData[] priorityData, int numberOfBooks) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        double initialProbability = Math.pow(numberOfBooks, -1);
        double[] pageWeight = new double[numberOfBooks];
        double[][] pageRankMatrix = new double[numberOfBooks][numberOfBooks];
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            pageWeight[iterator] = initialProbability * 4;
        }


        for (iterator = 0; iterator < numberOfBooks; iterator++) {
temporaryBorrowCount[iterator] = priorityData[iterator].getBorrowPriority();
            if (priorityData[iterator].borrowPriority < 6.0) {
                priorityData[iterator].setBorrowPriority(0.0);
            } else if (priorityData[iterator].borrowPriority <= 10.0) {
                priorityData[iterator].setBorrowPriority(10);
            }else if (priorityData[iterator].borrowPriority <= 15.0) {
                priorityData[iterator].setBorrowPriority(15);
            }else if (priorityData[iterator].borrowPriority <= 20.0) {
                priorityData[iterator].setBorrowPriority(20);
            }else if (priorityData[iterator].borrowPriority <= 25.0) {
                priorityData[iterator].setBorrowPriority(25);
            }else if (priorityData[iterator].borrowPriority <= 30.0) {
                priorityData[iterator].setBorrowPriority(30);
            }else if (priorityData[iterator].borrowPriority <= 35.0) {
                priorityData[iterator].setBorrowPriority(35);
            }else if (priorityData[iterator].borrowPriority <= 40.0) {
                priorityData[iterator].setBorrowPriority(40);
            }

        }

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            linkValue = pageRankLink.pageRankLinkMethods(iterator, priorityData, numberOfBooks);

            //    System.out.println(linkValue);
           if (priorityData[iterator].getBorrowPriority() == 0) {
                for (jterator = 0; jterator < numberOfBooks; jterator++) {
                    pageRankMatrix[jterator][iterator] = 0.0;

                }

            }

else{
            for (jterator = 0; jterator < numberOfBooks; jterator++) {


                checkLink = checkPageLink.checkPageLinkMethods(iterator, jterator, priorityData, numberOfBooks);
                //   System.out.println(checkLink);
                if (checkLink == true) {
                    pageRankMatrix[jterator][iterator] = linkValue;

                } else if (checkLink == false) {
                    pageRankMatrix[jterator][iterator] = 0.0;

                }


            }

       }

        }


        for (jterator = 0; jterator < numberOfBooks; jterator++) {

            pageRankMatrix[jterator][jterator] = 0.0;

        }


        int processingCounter = 0;
        for (processingCounter = 1; processingCounter <=1; processingCounter++) {


        pageWeight = pageRankMatrixCalculation.pageRankMatrixCalculationMethods(pageWeight, pageRankMatrix, numberOfBooks);


        }

        for(iterator=0;iterator<numberOfBooks;iterator++){

            priorityData[iterator].setPRAweight(pageWeight[iterator]);
            priorityData[iterator].setBorrowPriority(temporaryBorrowCount[iterator]);

        }

        return priorityData;
    }
}
