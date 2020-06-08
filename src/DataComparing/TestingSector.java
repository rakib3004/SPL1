package DataComparing;

import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.PrioritySort;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestingSector {

    PriorityData[] priorityData,priorityDataCV,priorityData2;
    GenericAlgo[] genericAlgo;
    PrioritySort prioritySort = new PrioritySort();
    List list = new ArrayList(); 

    int iterator;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();

    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

    public PriorityData [] testingSectorMethods(AHPcriteriaWeight ahPcriteriaWeight) {


        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        try {
            priorityData = processing.fileReaderMethods();
            priorityDataCV = processing.fileReaderMethods();
            priorityData2 = processing.fileReaderMethods();
            numberOfBooks = bookNumber.bookNumberFindingMethods();
        } catch (IOException e) {
            e.printStackTrace();
        }

        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
        priorityData2 = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                System.out.println(priorityData[iterator].getMLRweight());

                if (Integer.parseInt(priorityData[iterator].bookData.bookPrice) <= 180) {
                    //System.out.println(iterator + ":::: 180 er niche dam");
                    priorityData[iterator].pricePriority = ahPcriteriaWeight.lowPrice;
                } else if (Integer.parseInt(priorityData[iterator].bookData.bookPrice) <= 250) {
                    //System.out.println(iterator + ":::: 250 er niche dam");
                    priorityData[iterator].pricePriority = ahPcriteriaWeight.mediumPrice;
                } else {
                    //System.out.println(iterator + ":::: Besi dam");
                    priorityData[iterator].pricePriority = ahPcriteriaWeight.highPrice;
                }

            }
        }


        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                if (priorityData[iterator].timePriority <= 4.00) {
                    //System.out.println(iterator + "::::latest book");
                    priorityData[iterator].timePriority = ahPcriteriaWeight.latestBook;
                } else if (priorityData[iterator].timePriority <= 6.00) {
                    //System.out.println(iterator + "::::newly book");
                    priorityData[iterator].timePriority = ahPcriteriaWeight.newlyBook;
                } else if (priorityData[iterator].timePriority <= 8.00) {
                    //System.out.println(iterator + "::::recently old book");
                    priorityData[iterator].timePriority = ahPcriteriaWeight.recentlyOldBook;
                } else if (priorityData[iterator].timePriority <= 10.00) {
                    //System.out.println(iterator + "::::old book");
                    priorityData[iterator].timePriority = ahPcriteriaWeight.oldBook;
                } else if (priorityData[iterator].timePriority <= 12.00) {
                    //System.out.println(iterator + "::::oldest book");
                    priorityData[iterator].timePriority = ahPcriteriaWeight.oldestBook;
                }


            }
        }


        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {

                if (priorityData[iterator].borrowPriority <= 10) {
                    //System.out.println(iterator + ":::: 10 er niche");

                    priorityData[iterator].borrowPriority = ahPcriteriaWeight.lowlyDemand;
                } else if (priorityData[iterator].borrowPriority <= 20) {
                    //System.out.println(iterator + ":::: 20 er niche");

                    priorityData[iterator].borrowPriority = ahPcriteriaWeight.lowMediumDemand;
                } else if (priorityData[iterator].borrowPriority <= 30) {
                    //System.out.println(iterator + ":::: 30 er niche");

                    priorityData[iterator].borrowPriority = ahPcriteriaWeight.highMediumDemand;
                } else if (priorityData[iterator].borrowPriority <= 40) {
                    //System.out.println(iterator + ":::: 40 er niche");

                    priorityData[iterator].borrowPriority = ahPcriteriaWeight.highlyDemand;
                }

            }
        }


        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {

                if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("01")) {
                    //System.out.println(iterator + ":::: Uponnash");
                    priorityData[iterator].bookPriority = ahPcriteriaWeight.uponnashType;
                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("05")) {
                    //System.out.println(iterator + ":::: Rochonaboli");

                    priorityData[iterator].bookPriority = ahPcriteriaWeight.uponnashType;
                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("02")) {
                    //System.out.println(iterator + ":::: Kobita");

                    priorityData[iterator].bookPriority = ahPcriteriaWeight.kobitaType;
                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("13")) {
                    //System.out.println(iterator + ":::: Biggan");

                    priorityData[iterator].bookPriority = ahPcriteriaWeight.scienceFictionType;
                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("14")) {
                    //System.out.println(iterator + ":::: Gobeshona");

                    priorityData[iterator].bookPriority = ahPcriteriaWeight.scienceFictionType;
                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("06")) {
                    //System.out.println(iterator + ":::: Science Fiction");

                    priorityData[iterator].bookPriority = ahPcriteriaWeight.scienceFictionType;
                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("10")) {
                    //System.out.println(iterator + ":::: Kisore Uponnash");

                    priorityData[iterator].bookPriority = ahPcriteriaWeight.kisorUponnashType;
                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("11")) {
                    //System.out.println(iterator + ":::: Shishu Shahitto");

                    priorityData[iterator].bookPriority = ahPcriteriaWeight.kisorUponnashType;
                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("04")) {
                    //System.out.println(iterator + ":::: Religion");

                    priorityData[iterator].bookPriority = ahPcriteriaWeight.religionType;
                } else {
                    //System.out.println(iterator + ":::: Othres");

                    priorityData[iterator].bookPriority = ahPcriteriaWeight.othersType;
                }

            }

        }

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {

                priorityData[iterator].setMLRweight(.25*(priorityData[iterator].pricePriority +
                        priorityData[iterator].timePriority + priorityData[iterator].borrowPriority +
                        priorityData[iterator].timePriority)); ;

        }
        }



        return priorityData;

    }

}
