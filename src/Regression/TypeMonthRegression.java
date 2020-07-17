package Regression;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class TypeMonthRegression {
    int iterator;
    double countMean=0;
    double timeMean=0;
    double typeValue [] = new double [1050];
    double typeValue0[] = new double [1050];

    int timeCount [] = new int[1050];

    double timeValue [] =new double[1050];
    public  double typeMonthRegressionMethods(PriorityData [] priorityData, int numberOfBooks){

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        for(iterator =0; iterator <numberOfBooks; iterator++){

            timeValue[iterator] = priorityData[iterator].timePriority;
        }
        for(iterator =0; iterator <numberOfBooks; iterator++){
            typeValue[iterator] = priorityData[iterator].bookPriority;
            typeValue0[iterator]= typeValue[iterator];
        }
        for(iterator =0; iterator <numberOfBooks; iterator++){
            timeMean = timeMean +timeValue[iterator];
            countMean = countMean+ typeValue[iterator];
        }
        timeMean = timeMean/numberOfBooks;
        countMean = countMean/numberOfBooks;
        double assumpMean1  = 0;
        double assumpMean2  = 0;
        for(iterator =0; iterator <numberOfBooks; iterator++){
            timeValue[iterator] =  timeValue[iterator]  - timeMean;
            typeValue[iterator]= typeValue[iterator]-countMean;
            assumpMean1 = assumpMean1 +( timeValue[iterator]* typeValue[iterator]);
            assumpMean2 = assumpMean2 + (timeValue[iterator]*timeValue[iterator]);
        }
        double metaValue = assumpMean1/assumpMean2;
        double betaValue = timeMean - (metaValue*countMean);
        for(iterator =0; iterator <numberOfBooks; iterator++) {

            typeValue0[iterator] = betaValue + metaValue * timeValue[iterator];
        }
        return  metaValue;
    }

}
