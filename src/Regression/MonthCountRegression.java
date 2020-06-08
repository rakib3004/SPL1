package Regression;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;
import ObjectOriented.GenericAlgo;

public class MonthCountRegression {

    int iterator;
    double countMean=0;
    double timeMean=0;
    double bookCount [] = new double [1050];
    double bookCount0 [] = new double [1050];
    double bookCount1 [] = new double [1050];

    int timeCount [] = new int[1050];

    double timeValue [] =new double[1050];


    int length;
    String string;
    String string1,string2;

    int newYear,oldYear,integer1,integer2;
    public  void monthCountRegressionMethods(BookData[] bookData, String[] writerName,
                            String[] borrowCount1, String[] bookPrice1, String[] bookId, int numberOfBooks){

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        for(iterator =0; iterator <numberOfBooks; iterator++){
            newYear = 2 + (20) * 12;
            string1 = bookId[iterator].substring(4,6);
            integer1 = Integer.parseInt(string1);
            string2=bookId[iterator].substring(6,8);

            integer2 = Integer.parseInt(string2);
            oldYear = integer1+(integer2*12);
            timeValue[iterator] = newYear - oldYear;

        }

        for(iterator =0; iterator <numberOfBooks; iterator++){
            length = borrowCount1[iterator].length();
            string =borrowCount1[iterator].substring(1,length);
            bookCount[iterator] = Integer.parseInt(string);
        }

        for(iterator =0; iterator <numberOfBooks; iterator++){
            timeMean = timeMean +timeValue[iterator];
            countMean = countMean+bookCount[iterator];
        }

        timeMean = timeMean/numberOfBooks;
        countMean = countMean/numberOfBooks;

        double assumpMean1  = 0;
        double assumpMean2  = 0;
        for(iterator =0; iterator <numberOfBooks; iterator++){
            timeValue[iterator] =  timeValue[iterator]  - timeMean;
            bookCount[iterator]=bookCount[iterator]-countMean;
            assumpMean1 = assumpMean1 +( timeValue[iterator]*bookCount[iterator]);
            assumpMean2 = assumpMean2 + (timeValue[iterator]*timeValue[iterator]);

        }

        double metaValue = assumpMean1/assumpMean2;
        double betaValue = timeMean - (metaValue*countMean);
        for(iterator =0; iterator <numberOfBooks; iterator++) {

            bookCount1[iterator] = betaValue + metaValue * timeValue[iterator];
        }
        for(iterator =0; iterator <numberOfBooks; iterator++){

            bookData[iterator].setWeight(bookCount1[iterator]);
        }
       // SortingMonthCount sortingMonthCount = new SortingMonthCount();
      //  sortingMonthCount.algorithm(bookData,numberOfBooks);
        GenericAlgo genericAlgo[] = new GenericAlgo[1050];
        for(iterator = 0; iterator <numberOfBooks; iterator++){
            genericAlgo[iterator] = new GenericAlgo(bookData[iterator].getWeight(), iterator);
        }
        double temporary;
        int temp;
        for(iterator =0; iterator <numberOfBooks; iterator++){
            for(int j=0;j<numberOfBooks;j++){
                if(genericAlgo[iterator].getWeight()>genericAlgo[j].getWeight()){
                    temporary= genericAlgo[iterator].getWeight();
                    genericAlgo[iterator].setWeight(genericAlgo[j].getWeight());
                    genericAlgo[j].setWeight(temporary);
                    temp = genericAlgo[iterator].getIndex();
                    genericAlgo[iterator].setIndex(genericAlgo[j].getIndex());
                    genericAlgo[j].setIndex(temp);
                    bookData[j].setRank(temp,2);

                }
            }
        }
        System.out.println( );
        System.out.println( );
        System.out.println( );
        System.out.println( );
        System.out.println("Optimized View 3 :" );

        for(iterator =190; iterator <numberOfBooks; iterator++){
            System.out.println("Book Name :"+bookData[genericAlgo[iterator].getIndex()].getBookName()+
                    "; Writer Name : "+bookData[genericAlgo[iterator].getIndex()].getWriterName()
                    + "; Weight : "+genericAlgo[iterator].getWeight());
        }

    }

}
