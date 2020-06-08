package Regression.newVersion;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class CountMonthRegression {
    int iterator;
    double countMean = 0;
    double timeMean = 0;
    double bookCount[] = new double[1050];

    double timeValue[] = new double[1050];
    double timeValue1[] = new double[1050];
    public double countMonthRegressionMethods(PriorityData [] priorityData, int numberOfBooks) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            timeValue[iterator] = priorityData[iterator].timePriority;
        }

        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            bookCount[iterator] = priorityData[iterator].borrowPriority;
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            timeMean = timeMean + timeValue[iterator];
            countMean = countMean + bookCount[iterator];
        }
        countMean = countMean / numberOfBooks;

        double assumpMean1 = 0;
        double assumpMean2 = 0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            timeValue[iterator] = timeValue[iterator] - timeMean;
            bookCount[iterator] = bookCount[iterator] - countMean;
            assumpMean1 = assumpMean1 + (timeValue[iterator] * bookCount[iterator]);
            assumpMean2 = assumpMean2 + (bookCount[iterator] * bookCount[iterator]);
        }
        double metaValue = assumpMean1 / assumpMean2;
        double betaValue = timeMean - (metaValue * countMean);
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            timeValue1[iterator] = betaValue + metaValue * bookCount[iterator];
            //     System.out.println(typeValue0[i]+"\t"+timeValue1[i]);
        }
return  metaValue;
    }
}