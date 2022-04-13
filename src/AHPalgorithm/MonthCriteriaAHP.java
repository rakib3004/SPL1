package AHPalgorithm;

import FilePackage.DateTimeWriter;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;

public class MonthCriteriaAHP {
    AHPcriteriaWeight ahPcriteriaWeight;
    AHPSubCriteriaProcess ahpSubCriteriaProcess = new AHPSubCriteriaProcess();
    double[] monthCounter = new double[5];

    public AHPcriteriaWeight monthCriteriaAHPMethods(double criteria, PriorityData[] priorityData, int numberOfBooks) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        double[][] monthCriterAHPMatrix = new double[5][5];

        monthCounter = ahpSubCriteriaProcess.monthCriteriaCalculationMethods(priorityData, numberOfBooks);
        int iterator, jterator;

        int priority = 1;

        for (iterator = 0; iterator < 5; iterator++) {
            for (jterator = iterator + 1; jterator < 5; jterator++) {
                monthCriterAHPMatrix[iterator][jterator] = (monthCounter[iterator] / monthCounter[jterator]);
            }
        }
        // new methodology for analytical hierarchy process to calculate sub criteria by
        // issuing book by category
        // add new methodology for analytical hierarchy process
        monthCriterAHPMatrix[0][1] = 1.35;
        monthCriterAHPMatrix[0][2] = 2.6;
        monthCriterAHPMatrix[0][3] = 4.7;
        monthCriterAHPMatrix[0][4] = 7.8;
        monthCriterAHPMatrix[1][2] = 1.35;
        monthCriterAHPMatrix[1][3] = 3.4;
        monthCriterAHPMatrix[1][4] = 5.6;
        monthCriterAHPMatrix[2][3] = 2.1;
        monthCriterAHPMatrix[2][4] = 3.9;
        monthCriterAHPMatrix[3][4] = 1.47;

        for (iterator = 0; iterator < 5; iterator++) {
            for (jterator = iterator + 1; jterator < 5; jterator++) {
                monthCriterAHPMatrix[jterator][iterator] = Math.pow(monthCriterAHPMatrix[iterator][jterator], -1);

            }
        }
        for (iterator = 0; iterator < 5; iterator++) {

            monthCriterAHPMatrix[iterator][iterator] = (1);
        }
        double[] summationMatrix = new double[5];

        for (iterator = 0; iterator < 5; iterator++) {
            for (jterator = 0; jterator < 5; jterator++) {

                summationMatrix[iterator] = summationMatrix[iterator] + monthCriterAHPMatrix[iterator][jterator];
            }
        }
        for (iterator = 0; iterator < 5; iterator++) {
            for (jterator = 0; jterator < 5; jterator++) {

                monthCriterAHPMatrix[iterator][jterator] = monthCriterAHPMatrix[iterator][jterator]
                        / summationMatrix[iterator];
            }
        }
        double[] monthWeightMatrix = new double[5];

        for (iterator = 0; iterator < 5; iterator++) {
            for (jterator = 0; jterator < 5; jterator++) {
                monthWeightMatrix[iterator] = monthWeightMatrix[iterator] + monthCriterAHPMatrix[jterator][iterator];

            }
            monthWeightMatrix[iterator] = monthWeightMatrix[iterator] / 5;
        }
        for (iterator = 0; iterator < 5; iterator++) {

            monthWeightMatrix[iterator] = monthWeightMatrix[iterator] * criteria;
            ;
        }

        ahPcriteriaWeight = new AHPcriteriaWeight(monthWeightMatrix[0], monthWeightMatrix[1],
                monthWeightMatrix[2], monthWeightMatrix[3], monthWeightMatrix[4]);
        // print all criteria value to show the evaluation

        System.out.println(ahPcriteriaWeight.latestBook + "---------->  ahPcriteriaWeight.latestBook");
        System.out.println(ahPcriteriaWeight.newlyBook + "---------->  ahPcriteriaWeight.newlyBook");
        System.out.println(ahPcriteriaWeight.recentlyOldBook + "---------->  ahPcriteriaWeight.recentlyOldBook");
        System.out.println(ahPcriteriaWeight.oldBook + "---------->  ahPcriteriaWeight.oldBook");
        System.out.println(ahPcriteriaWeight.oldestBook + "---------->  ahPcriteriaWeight.oldestBook");
        System.out.println();
        return ahPcriteriaWeight;
    }
}