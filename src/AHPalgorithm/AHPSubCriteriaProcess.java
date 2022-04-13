package AHPalgorithm;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class AHPSubCriteriaProcess {

    int iterator;

    public double[] priceCriteriaCalculationMethods(PriorityData[] priorityData, int numberOfBooks) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        int[] priceCounter = new int[3];
        double[] parsingPriceCounter = new double[3];

        // count number of books on each type of price category in AHP Calculation
        priceCounter[0] = 1;
        priceCounter[1] = 1;
        priceCounter[2] = 1;
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (Integer.parseInt(priorityData[iterator].bookData.bookPrice) <= 180) {
                priceCounter[0]++;
            } else if (Integer.parseInt(priorityData[iterator].bookData.bookPrice) <= 250) {
                priceCounter[1]++;
            } else {
                priceCounter[2]++;
            }
        }

        for (iterator = 0; iterator < 3; iterator++) {
            parsingPriceCounter[iterator] = Double.parseDouble(String.valueOf(priceCounter[iterator]));
        }
        return parsingPriceCounter;
    }

    public double[] countCriteriaCalculationMethods(PriorityData[] priorityData, int numberOfBooks) {
        int[] countCounter = new int[4];
        double[] parsingCountCounter = new double[4];

        // count number of books on each type of purchase category in AHP Calculation

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].borrowPriority <= 10) {
                countCounter[3]++;
            } else if (priorityData[iterator].borrowPriority <= 20) {
                countCounter[2]++;
            } else if (priorityData[iterator].borrowPriority <= 30) {
                countCounter[1]++;
            } else if (priorityData[iterator].borrowPriority <= 40) {
                countCounter[0]++;
            }
        }

        for (iterator = 0; iterator < 4; iterator++) {
            parsingCountCounter[iterator] = Double.parseDouble(String.valueOf(countCounter[iterator]));
        }

        return parsingCountCounter;
    }

    public double[] monthCriteriaCalculationMethods(PriorityData[] priorityData, int numberOfBooks) {
        int[] monthCounter = new int[5];
        double[] parsingMonthCounter = new double[5];

        // count number of books on each type of date of issue category in AHP
        // Calculation

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].timePriority <= 5.60) {
                monthCounter[4]++;

            } else if (priorityData[iterator].timePriority <= 7.20) {
                monthCounter[3]++;

            } else if (priorityData[iterator].timePriority <= 9.50) {
                monthCounter[2]++;

            } else if (priorityData[iterator].timePriority <= 12.00) {
                monthCounter[1]++;

            } else if (priorityData[iterator].timePriority <= 14.00) {
                monthCounter[0]++;
            }
        }

        for (iterator = 0; iterator < 5; iterator++) {
            parsingMonthCounter[iterator] = Double.parseDouble(String.valueOf(monthCounter[iterator]));
        }
        return parsingMonthCounter;
    }

    public double[] typeCriteriaCalculationMethods(PriorityData[] priorityData, int numberOfBooks) {
        int[] typeCounter = new int[6];
        double[] parsingTypeCounter = new double[6];
        // count number of books on each type of literature field category in AHP
        // Calculation

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("01")) {
                typeCounter[0]++;
            } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("05")) {

                typeCounter[0]++;
            } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("02")) {

                typeCounter[1]++;
            } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("13")) {

                typeCounter[2]++;
            } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("08")) {
                typeCounter[2]++;
            } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("06")) {
                typeCounter[2]++;
            } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("10")) {
                typeCounter[3]++;

            } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("11")) {
                typeCounter[3]++;

            } else if (priorityData[iterator].bookData.bookId.substring(0, 2).equals("04")) {
                typeCounter[4]++;

            } else {
                typeCounter[5]++;
            }
        }
        // parsing integer to double value through string
        for (iterator = 0; iterator < 6; iterator++) {
            parsingTypeCounter[iterator] = Double.parseDouble(String.valueOf(typeCounter[iterator]));
        }
        return parsingTypeCounter;
    }
}
