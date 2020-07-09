package AHPalgorithm;

import FilePackage.DateTimeWriter;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;

public class PriceCriteriaAHP {
    AHPcriteriaWeight ahPcriteriaWeight;
    AHPSubCriteriaProcess ahpSubCriteriaProcess = new AHPSubCriteriaProcess();
    double [] priceCounter = new double[3];
    public AHPcriteriaWeight priceCriteriaAHPMethods(double criteria,PriorityData[] priorityData, int numberOfBooks) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        double[][] priceCriteriaAHPMatrix = new double[3][3];

        int iterator, jterator;
        priceCounter  = ahpSubCriteriaProcess.priceCriteriaCalculationMethods(priorityData,numberOfBooks);
        for (iterator = 0; iterator < 3; iterator++) {
            for (jterator = iterator + 1; jterator < 3; jterator++) {

                priceCriteriaAHPMatrix[iterator][jterator] = priceCounter[iterator]/priceCounter[jterator];
            }
        }
// new methodology for analytical hierarchy process to calculate sub criteria by issuing book by category
        // add new methodology for analytical hierarchy process
        priceCriteriaAHPMatrix[0][1]=3.0;
        priceCriteriaAHPMatrix[0][2]=5.0;
        priceCriteriaAHPMatrix[1][2]=5.0/3.0;

         for (iterator = 0; iterator < 3; iterator++) {
            for (jterator = iterator + 1; jterator < 3; jterator++) {
                priceCriteriaAHPMatrix[jterator][iterator] = Math.pow(priceCriteriaAHPMatrix[iterator][jterator], -1);
            }
        }
        for (iterator = 0; iterator < 3; iterator++) {

            priceCriteriaAHPMatrix[iterator][iterator] = 1.00;
        }

        double[] summationMatrix = new double[3];

        for (iterator = 0; iterator < 3; iterator++) {
            for (jterator = 0; jterator < 3; jterator++) {

                summationMatrix[iterator] = summationMatrix[iterator] + priceCriteriaAHPMatrix[iterator][jterator];
            }
        }
        for (iterator = 0; iterator < 3; iterator++) {
            for (jterator = 0; jterator < 3; jterator++) {

                priceCriteriaAHPMatrix[iterator][jterator] = priceCriteriaAHPMatrix[iterator][jterator] / summationMatrix[iterator];
            }
        }
        double[] priceWeightMatrix = new double[3];

        for (iterator = 0; iterator < 3; iterator++) {
            for (jterator = 0; jterator < 3; jterator++) {

                priceWeightMatrix[iterator] = priceWeightMatrix[iterator] + priceCriteriaAHPMatrix[jterator][iterator];

            }
            priceWeightMatrix[iterator] = priceWeightMatrix[iterator] / 3;
        }

        for (iterator = 0; iterator < 3; iterator++) {

        priceWeightMatrix[iterator]  =  priceWeightMatrix[iterator]*criteria;

        }
        //print all criteria value to show the evaluation

        ahPcriteriaWeight = new AHPcriteriaWeight(priceWeightMatrix[0],
                priceWeightMatrix[1],priceWeightMatrix[2]);
        System.out.println(ahPcriteriaWeight.highPrice+"---------->  ahPcriteriaWeight.highPrice");
        System.out.println(ahPcriteriaWeight.mediumPrice+"---------->  ahPcriteriaWeight.mediumPrice");
        System.out.println(ahPcriteriaWeight.lowPrice+"---------->  ahPcriteriaWeight.lowPrice");
        System.out.println();
       return ahPcriteriaWeight;
    }
}
