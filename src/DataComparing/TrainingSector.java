package DataComparing;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.PrioritySort;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.CrossValidationData;
import ObjectOriented.GenericAlgo;
import ObjectOriented.PriorityData;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TrainingSector {
    PriorityData[] priorityData,priorityDataCV;
    GenericAlgo[] genericAlgo;
    PrioritySort prioritySort = new PrioritySort();
    List list = new ArrayList();
    int iterator;
    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    PredictionSector predictionSector = new PredictionSector();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

    public  CrossValidationData []  trainingSectorMethods(int processIndex) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        int[] priceCounter = new int[3];
        double[] priceGroupWeight;
        priceGroupWeight = new double[3];

        int[] timeCounter = new int[5];
        double[] timeGroupWeight;
        timeGroupWeight = new double[5];

        int[] countCounter = new int[4];
        double[] countGroupWeight;
        countGroupWeight = new double[4];

        int[] typeCounter = new int[6];
        double[] typeGroupWeight;
        typeGroupWeight = new double[6];
        //double [] priceGroupWeight,double [] timeGroupWeight, double [] countGroupWeight,double [] typeGroupWeight;
        try {
            priorityData = processing.fileReaderMethods();
            numberOfBooks = bookNumber.bookNumberFindingMethods();
        } catch (IOException e) {
            e.printStackTrace();
        }
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                continue;
            } else {
                if (Integer.parseInt(priorityData[iterator].bookData.bookPrice) <= 180) {
                    priceCounter[0]++;
                    priceGroupWeight[0] = priceGroupWeight[0] + priorityData[iterator].getRankValue();

                } else if (Integer.parseInt(priorityData[iterator].bookData.bookPrice) <= 250) {
                    priceCounter[1]++;
                    priceGroupWeight[1] = priceGroupWeight[1] + priorityData[iterator].getRankValue();
                } else {
                    priceCounter[2]++;
                    priceGroupWeight[2] = priceGroupWeight[2] + priorityData[iterator].getRankValue();
                }
            }
        }
        for (iterator = 0; iterator < 3; iterator++) {

            priceGroupWeight[iterator] = priceGroupWeight[iterator] / priceCounter[iterator];
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                continue;
            } else {
                if (priorityData[iterator].timePriority <= 5.60) {
                    timeCounter[4]++;
                    timeGroupWeight[4] = timeGroupWeight[4] + priorityData[iterator].getRankValue();


                } else if (priorityData[iterator].timePriority <= 7.20) {
                    timeCounter[3]++;
                    timeGroupWeight[3] = timeGroupWeight[3] + priorityData[iterator].getRankValue();
                } else if (priorityData[iterator].timePriority <= 9.50) {
                    timeCounter[2]++;
                    timeGroupWeight[2] = timeGroupWeight[2] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].timePriority <= 12.00) {
                    timeCounter[1]++;
                    timeGroupWeight[1] = timeGroupWeight[1] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].timePriority <= 14.00) {
                    timeCounter[0]++;
                    timeGroupWeight[0] = timeGroupWeight[0] + priorityData[iterator].getRankValue();
                }
            }
        }
        for (iterator = 0; iterator < 5; iterator++) {
            timeGroupWeight[iterator] = timeGroupWeight[iterator] / timeCounter[iterator];
        }
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                continue;
            } else {
                if (priorityData[iterator].borrowPriority <= 10) {
                    countCounter[3]++;
                    countGroupWeight[3] = countGroupWeight[3] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].borrowPriority <= 20) {
                    countCounter[2]++;
                    countGroupWeight[2] = countGroupWeight[2] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].borrowPriority <= 30) {
                    countCounter[1]++;
                    countGroupWeight[1] = countGroupWeight[1] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].borrowPriority <= 40) {
                    countCounter[0]++;
                    countGroupWeight[0] = countGroupWeight[0] + priorityData[iterator].getRankValue();

                }
            }
        }
        for (iterator = 0; iterator < 4; iterator++) {

            countGroupWeight[iterator] = countGroupWeight[iterator] / countCounter[iterator];
        }

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                continue;
            } else {
                if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("01")) {
                    typeCounter[0]++;
                    typeGroupWeight[0] = typeGroupWeight[0] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("05")) {

                    typeCounter[0]++;
                    typeGroupWeight[0] = typeGroupWeight[0] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("02")) {

                    typeCounter[1]++;
                    typeGroupWeight[1] = typeGroupWeight[1] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("13")) {

                    typeCounter[2]++;
                    typeGroupWeight[2] = typeGroupWeight[2] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("08")) {
                    typeCounter[2]++;
                    typeGroupWeight[2] = typeGroupWeight[2] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("06")) {
                    typeCounter[2]++;
                    typeGroupWeight[2] = typeGroupWeight[2] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("10")) {
                    typeCounter[3]++;
                    typeGroupWeight[3] = typeGroupWeight[3] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("11")) {
                    typeCounter[3]++;
                    typeGroupWeight[3] = typeGroupWeight[3] + priorityData[iterator].getRankValue();

                } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("04")) {
                    typeCounter[4]++;
                    typeGroupWeight[4] = typeGroupWeight[4] + priorityData[iterator].getRankValue();

                } else {
                    typeCounter[5]++;
                    typeGroupWeight[5] = typeGroupWeight[5] + priorityData[iterator].getRankValue();
                }

            }
        }
        for (iterator = 0; iterator < 6; iterator++) {

            typeGroupWeight[iterator] = typeGroupWeight[iterator] / typeCounter[iterator];
        }
        priorityDataCV = predictionSector.predictionSectorMethods(priceGroupWeight, timeGroupWeight, countGroupWeight, typeGroupWeight);
        double[] codeValidationList = new double[1000];
        CrossValidationData[] crossValidationData = new CrossValidationData[1000];
        int jterator = 0;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityDataCV[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityDataCV[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                codeValidationList[jterator] = priorityDataCV[iterator].getRankValue();
                jterator++;
            }
        }
        try {
            priorityData = processing.fileReaderMethods();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jterator = 0;
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(13, 14).contains("5") ||
                    priorityData[iterator].bookData.bookId.substring(13, 14).contains("0")) {
                crossValidationData[jterator] = new CrossValidationData(priorityData[iterator].getRankValue(), codeValidationList[jterator]);
                jterator++;
            }
        }
        return crossValidationData;
    }
}
