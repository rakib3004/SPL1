package Regression.newVersion;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;

//Complete
public class TypeCountRegression {
    int iterator;
    double countMean=0;
    double typeMean=0;
    double bookCount [] = new double [1050];
    double typeValue [] =new double[1050];
    double typeValue1 [] =new double[1050];
    double typeValue0 [] =new double[1050];

    int length;
    String string;
    double assumpMean1  = 0;
    double assumpMean2  = 0;
    public  double typeCountRegressionMethods(PriorityData [] priorityData, int numberOfBooks){

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        for(iterator =0; iterator <numberOfBooks; iterator++){

            typeValue[iterator] = priorityData[iterator].bookPriority;
            typeValue0[iterator]=typeValue[iterator];
        }
    for(iterator =0; iterator <numberOfBooks; iterator++){

        bookCount[iterator] = priorityData[iterator].borrowPriority;
    }

        for(iterator =0; iterator <numberOfBooks; iterator++){
typeMean = typeMean +typeValue[iterator];
countMean = countMean+bookCount[iterator];
        }

        typeMean = typeMean/numberOfBooks;
        countMean = countMean/numberOfBooks;


    for(iterator =0; iterator <numberOfBooks; iterator++){
typeValue[iterator] =  typeValue[iterator]  - typeMean;
bookCount[iterator]=bookCount[iterator]-countMean;
assumpMean1 = assumpMean1 +( typeValue[iterator]*bookCount[iterator]);
assumpMean2 = assumpMean2 + (bookCount[iterator]*bookCount[iterator]);

    }

    double metaValue = assumpMean1/assumpMean2;
    double betaValue = countMean - (metaValue*typeMean);
        for(iterator =0; iterator <numberOfBooks; iterator++) {

            typeValue1[iterator] = betaValue + metaValue * bookCount[iterator];
       //     System.out.println(typeValue0[i]+"\t"+typeValue1[i]);
        }
        return  metaValue;


    }

    }