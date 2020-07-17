package Regression;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class MonthPriceRegression {


    int iterator;
    double timeMean =0;
    double priceMean=0;
    double timeCount[] = new double [1050];
    double bookPrice [] =new double[1050];
    double bookPrice1 [] =new double[1050];
    double bookPrice0 [] =new double[1050];

    int length;
    String string;
    public  double monthPriceRegressionMethods(PriorityData[] priorityData, int numberOfBooks){

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        for(iterator =0; iterator <numberOfBooks; iterator++){
            timeCount[iterator] = priorityData[iterator].timePriority;
        }
        for(iterator =0; iterator <numberOfBooks; iterator++){

            bookPrice[iterator] = priorityData[iterator].pricePriority;
        }

        for(iterator =0; iterator <numberOfBooks; iterator++){
            priceMean = priceMean +bookPrice[iterator];
            timeMean = timeMean + timeCount[iterator];
        }

        priceMean = priceMean/numberOfBooks;
        timeMean = timeMean /numberOfBooks;

        double assumpMean1  = 0;
        double assumpMean2  = 0;
        for(iterator =0; iterator <numberOfBooks; iterator++){
            bookPrice[iterator] =  bookPrice[iterator]  - priceMean;
            timeCount[iterator]= timeCount[iterator]- timeMean;
            assumpMean1 = assumpMean1 +( bookPrice[iterator]* timeCount[iterator]);
            assumpMean2 = assumpMean2 + (timeCount[iterator]* timeCount[iterator]);
        }

        double metaValue = assumpMean1/assumpMean2;
        double betaValue = timeMean - (metaValue*priceMean);
        for(iterator =0; iterator <numberOfBooks; iterator++) {

            bookPrice1[iterator] = betaValue + metaValue * timeCount[iterator];
        }
        return  metaValue;
    }
}
