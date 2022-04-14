package MultiVariableRegression;

import FilePackage.DateTimeWriter;
import ResultPackage.MLR_Result;
import ObjectOriented.PriorityData;

public class CalculateWeight {
    double optimizeValue;
    double isolatedValue = 0.0;
    MLR_Result MLRResult = new MLR_Result();

    public PriorityData[] calculateWeightMethods(double betaZero, double betaOne, double betaTwo, double betaThree,
            PriorityData[] priorityData, int numberOfBooks) {
        betaZero = isolatedValue;
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        int iterator;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            optimizeValue = betaZero + (betaOne * priorityData[iterator].borrowPriority) +
                    (betaTwo * priorityData[iterator].timePriority) +
                    (betaThree * priorityData[iterator].pricePriority);

            priorityData[iterator].setMLRweight(optimizeValue);
            priorityData[iterator].setRankValue(optimizeValue);
            System.out.println(priorityData[iterator].borrowPriority);

        }
        return priorityData;
    }
}
