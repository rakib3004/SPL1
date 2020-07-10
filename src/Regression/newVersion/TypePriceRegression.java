package Regression.newVersion;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;

public class TypePriceRegression {
    int iterator;
    double priceMean=0;
    double typeMean=0;
    double bookPrice [] = new double [1050];
    double typeValue [] =new double[1050];
    double typeValue1 [] =new double[1050];
    double typeValue0 [] =new double[1050];
    double assumpMean1  = 0;
    double assumpMean2  = 0;

    public  double typePriceRegressionMethods(PriorityData[] priorityData, int numberOfBooks){
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        for(iterator =0; iterator <numberOfBooks; iterator++){
            typeValue[iterator] = priorityData[iterator].bookPriority;
            typeValue0[iterator]=typeValue[iterator];
        }
        for(iterator =0; iterator <numberOfBooks; iterator++){

            bookPrice[iterator] = priorityData[iterator].pricePriority;
        }
        for(iterator =0; iterator <numberOfBooks; iterator++){
            typeMean = typeMean +typeValue[iterator];
            priceMean = priceMean+bookPrice[iterator];
        }
        typeMean = typeMean/numberOfBooks;
        priceMean = priceMean/numberOfBooks;
        for(iterator =0; iterator <numberOfBooks; iterator++){
            typeValue[iterator] =  typeValue[iterator]  - typeMean;
            bookPrice[iterator]=bookPrice[iterator]-priceMean;
            assumpMean1 = assumpMean1 +( typeValue[iterator]*bookPrice[iterator]);
            assumpMean2 = assumpMean2 + (bookPrice[iterator]*bookPrice[iterator]);
        }
        double metaValue = assumpMean1/assumpMean2;
        double betaValue = priceMean - (metaValue*typeMean);
        for(iterator =0; iterator <numberOfBooks; iterator++) {

            typeValue1[iterator] = betaValue + metaValue * bookPrice[iterator];
        }
        return  metaValue;
    }
}