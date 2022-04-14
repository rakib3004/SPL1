package SimpleRegression;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class CalculateDoublyRegression {
    int number = 632;
    int iterator;

    public void calculateDoublyRegressionMethod(double beta1, double beta2, double beta3, PriorityData[] priorityData) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        for (iterator = 0; iterator < number; iterator++) {
            priorityData[iterator] = new PriorityData(0);
        }
        for (iterator = 0; iterator < number; iterator++) {
            priorityData[iterator].bookPriorityOne = beta1 + beta2 * priorityData[iterator].borrowPriority
                    + beta3 * priorityData[iterator].timePriority;
            System.out.println("D R :" + priorityData[iterator].bookPriorityOne + "---------");
        }
    }
}
