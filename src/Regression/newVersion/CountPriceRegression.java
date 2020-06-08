package Regression.newVersion;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;

public class CountPriceRegression {
    int iterator;
    double countMean=0;
    double priceMean=0;
    double bookCount [] = new double [1050];
    double bookPrice [] =new double[1050];
    double bookPrice1 [] =new double[1050];

    int length;
    String string;
    public  double countPriceRegressionMethods(PriorityData [] priorityData, int numberOfBooks){

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        for(iterator =0; iterator <numberOfBooks; iterator++){

            bookCount[iterator] = priorityData[iterator].borrowPriority;
        }
        for(iterator =0; iterator <numberOfBooks; iterator++){

            bookPrice[iterator] = priorityData[iterator].pricePriority;
        }

        for(iterator =0; iterator <numberOfBooks; iterator++){
            priceMean = priceMean +bookPrice[iterator];
            countMean = countMean+bookCount[iterator];
        }

        priceMean = priceMean/numberOfBooks;
        countMean = countMean/numberOfBooks;

        double assumpMean1  = 0;
        double assumpMean2  = 0;
        for(iterator =0; iterator <numberOfBooks; iterator++){
            bookPrice[iterator] =  bookPrice[iterator]  - priceMean;
            bookCount[iterator]=bookCount[iterator]-countMean;
            assumpMean1 = assumpMean1 +( bookPrice[iterator]*bookCount[iterator]);
            assumpMean2 = assumpMean2 + (bookCount[iterator]*bookCount[iterator]);

        }

        double metaValue = assumpMean1/assumpMean2;
        double betaValue = countMean - (metaValue*priceMean);
        for(iterator =0; iterator <numberOfBooks; iterator++) {

            bookPrice1[iterator] = betaValue + metaValue * bookCount[iterator];
            //     System.out.println(bookPrice0[i]+"\t"+bookPrice1[i]);
        }

        return  metaValue;

    }

}
