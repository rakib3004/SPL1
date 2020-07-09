package AHPalgorithm;

import FilePackage.DateTimeWriter;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;

public class TypeCriteriaAHP {
    AHPcriteriaWeight ahPcriteriaWeight;
    AHPSubCriteriaProcess ahpSubCriteriaProcess = new AHPSubCriteriaProcess();
    double [] typeCounter = new double[6];

    public AHPcriteriaWeight typeCriteriaAHPMethods(double criteria,PriorityData[] priorityData, int numberOfBooks) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        double[][] typeCriteriaAHPMatrix = new double[6][6];

typeCounter  = ahpSubCriteriaProcess.typeCriteriaCalculationMethods(priorityData,numberOfBooks);
        int iterator, jterator;

        for (iterator = 0; iterator < 6; iterator++) {
            for (jterator = iterator + 1; jterator < 6; jterator++) {
                typeCriteriaAHPMatrix[iterator][jterator] = typeCounter[iterator]/typeCounter[jterator];
            }
        }
        // new methodology for analytical hierarchy process to calculate sub criteria by issuing book by category
        // add new methodology for analytical hierarchy process
        typeCriteriaAHPMatrix[0][1] = 4.1;
        typeCriteriaAHPMatrix[0][2] = 1.32;
        typeCriteriaAHPMatrix[0][3] = 1.56;
        typeCriteriaAHPMatrix[0][4] = 4.9;
        typeCriteriaAHPMatrix[0][5] = 5.8;
        typeCriteriaAHPMatrix[1][2] = 1.0/3.66;
        typeCriteriaAHPMatrix[1][3] = 1.0/3.95;
        typeCriteriaAHPMatrix[1][4] = 1.0/1.82;
        typeCriteriaAHPMatrix[1][5] = 1.5;
        typeCriteriaAHPMatrix[2][3] = 1.55;
        typeCriteriaAHPMatrix[2][4] = 4.5;
        typeCriteriaAHPMatrix[2][5] = 5.77;
        typeCriteriaAHPMatrix[3][4] = 4.4;
        typeCriteriaAHPMatrix[3][5] = 5.1;
        typeCriteriaAHPMatrix[4][5] = 2.36;

        for (iterator = 0; iterator < 6; iterator++) {
            for (jterator = iterator + 1; jterator < 6; jterator++) {
                                typeCriteriaAHPMatrix[jterator][iterator] = Math.pow(typeCriteriaAHPMatrix[iterator][jterator], -1);
            }
        }
        for (iterator = 0; iterator < 6; iterator++) {
            typeCriteriaAHPMatrix[iterator][iterator] = (1);

        }
        double[] summationMatrix = new double[6];

        for (iterator = 0; iterator < 6; iterator++) {
            for (jterator = 0; jterator < 6; jterator++) {
                summationMatrix[iterator] = summationMatrix[iterator] + typeCriteriaAHPMatrix[iterator][jterator];
            }
        }
        for (iterator = 0; iterator < 6; iterator++) {
            for (jterator = 0; jterator < 6; jterator++) {

                typeCriteriaAHPMatrix[iterator][jterator] = typeCriteriaAHPMatrix[iterator][jterator] / summationMatrix[iterator];
            }
        }
        double[] typeWeightMatrix = new double[6];

        for (iterator = 0; iterator < 6; iterator++) {
            for (jterator = 0; jterator < 6; jterator++) {

                typeWeightMatrix[iterator] = typeWeightMatrix[iterator] + typeCriteriaAHPMatrix[jterator][iterator];
            }
            typeWeightMatrix[iterator] = typeWeightMatrix[iterator] / 6;
        }
        for (iterator = 0; iterator < 6; iterator++) {

   typeWeightMatrix[iterator]  =    typeWeightMatrix[iterator]*criteria;
        }
         ahPcriteriaWeight = new AHPcriteriaWeight(typeWeightMatrix[0],
                typeWeightMatrix[1],typeWeightMatrix[2],typeWeightMatrix[3],typeWeightMatrix[4],typeWeightMatrix[5]);

        // show all calculated value of sub criteria
        System.out.println(ahPcriteriaWeight.uponnashType+"---------->  ahPcriteriaWeight.uponnashType");
        System.out.println(ahPcriteriaWeight.kobitaType+"---------->  ahPcriteriaWeight.kobitaType");
        System.out.println(ahPcriteriaWeight.scienceFictionType+"---------->  ahPcriteriaWeight.scienceFictionType");
        System.out.println(ahPcriteriaWeight.kisorUponnashType+"---------->  ahPcriteriaWeight.kisorUponnashType");
        System.out.println(ahPcriteriaWeight.religionType+"---------->  ahPcriteriaWeight.religionType");
        System.out.println(ahPcriteriaWeight.othersType+"---------->  ahPcriteriaWeight.othersType");
        System.out.println();

        return ahPcriteriaWeight;

    }
}
