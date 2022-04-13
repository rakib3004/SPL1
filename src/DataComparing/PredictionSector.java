package DataComparing;

import FilePackage.DateTimeWriter;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;

public class PredictionSector {
    PriorityData[] priorityData, priorityDataCV;
    TestingSector testingSector = new TestingSector();
    AHPcriteriaWeight ahPcriteriaWeight;

    public PriorityData[] predictionSectorMethods(double[] priceGroupWeight, double[] timeGroupWeight,
            double[] countGroupWeight, double[] typeGroupWeight, int processIndex) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        ahPcriteriaWeight = new AHPcriteriaWeight(priceGroupWeight[0],
                priceGroupWeight[1], priceGroupWeight[2], countGroupWeight[0], countGroupWeight[1],
                countGroupWeight[2], countGroupWeight[3], timeGroupWeight[0], timeGroupWeight[1],
                timeGroupWeight[2], timeGroupWeight[3], timeGroupWeight[4], typeGroupWeight[0],
                typeGroupWeight[1], typeGroupWeight[2], typeGroupWeight[3], typeGroupWeight[4], typeGroupWeight[5]);
        priorityDataCV = testingSector.testingSectorMethods(ahPcriteriaWeight, processIndex);
        return priorityDataCV;
    }
}
