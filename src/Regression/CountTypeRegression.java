package Regression;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;
import ObjectOriented.GenericAlgo;

public class CountTypeRegression {

    int iterator;
    double countMean = 0;
    double typeMean = 0;
    double bookCount[] = new double[1050];
    double bookCount2[] = new double[1050];
    double typeValue[] = new double[1050];
    double typeValue1[] = new double[1050];
    double typeValue0[] = new double[1050];

    int length;
    String string;
    public  void countTypeRegressionMethods (BookData[] bookData, String[] writerName,
                            String[] borrowCount1, String[] bookPrice1, String[] bookId, int numberOfBooks) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            length = bookId[iterator].length();
            string = bookId[iterator].substring(1, 3);
            typeValue[iterator] = Integer.parseInt(string);
            typeValue0[iterator] = typeValue[iterator];
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            length = borrowCount1[iterator].length();
            string = borrowCount1[iterator].substring(1, length);
            bookCount[iterator] = Integer.parseInt(string);
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            typeMean = typeMean + typeValue[iterator];
            countMean = countMean + bookCount[iterator];
        }
        typeMean = typeMean / numberOfBooks;
        countMean = countMean / numberOfBooks;
        double assumpMean1 = 0;
        double assumpMean2 = 0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            typeValue[iterator] = typeValue[iterator] - typeMean;
            bookCount[iterator] = bookCount[iterator] - countMean;
            assumpMean1 = assumpMean1 + (typeValue[iterator] * bookCount[iterator]);
            assumpMean2 = assumpMean2 + (typeValue[iterator] * typeValue[iterator]);
        }

        double metaValue = assumpMean1 / assumpMean2;
        double betaValue = countMean - (metaValue * typeMean);
        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            bookCount2[iterator] = betaValue + metaValue * typeValue[iterator];
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {

            bookData[iterator].setWeight(bookCount2[iterator]);
        }
        GenericAlgo genericAlgo[] = new GenericAlgo[1050];
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            genericAlgo[iterator] = new GenericAlgo(bookData[iterator].getWeight(), iterator);
        }
        double temporary;
        int temp;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            for (int j = 0; j < numberOfBooks; j++) {
                if (genericAlgo[iterator].getWeight() > genericAlgo[j].getWeight()) {
                    temporary = genericAlgo[iterator].getWeight();
                    genericAlgo[iterator].setWeight(genericAlgo[j].getWeight());
                    genericAlgo[j].setWeight(temporary);
                    temp = genericAlgo[iterator].getIndex();
                    genericAlgo[iterator].setIndex(genericAlgo[j].getIndex());
                    genericAlgo[j].setIndex(temp);
                    bookData[j].setRank(temp, 8);
                }
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Optimized View 9 :");

        for (iterator = 190; iterator < numberOfBooks; iterator++) {
            System.out.println("Book Name :" + bookData[genericAlgo[iterator].getIndex()].getBookName() +
                    "; Writer Name : " + bookData[genericAlgo[iterator].getIndex()].getWriterName()
                    + "; Weight : " + genericAlgo[iterator].getWeight());
        }
    }
}