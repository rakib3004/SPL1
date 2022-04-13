package Collection;

import FilePackage.DateTimeWriter;
import MainPackage.BookNumber;
import MainPackage.Processing;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.PriorityData;
import MultiVariableRegression.MedianCalculation;

import java.io.IOException;
import java.time.Period;
import java.util.*;

public class WriterCollection {
    MedianCalculation medianCalculation = new MedianCalculation();

    public void writerCollectionMLRMethods(PriorityData[] priorityData, int numberOfBooks) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Set<String> writerId = new HashSet<>();
        int iterator1;

        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
            writerId.add(priorityData[iterator1].bookData.writerName);
        }
        System.out.println(writerId.size());
        System.out.println();

        int number = 0;
        int writerCount = 0;
        PriorityQueue writer = new PriorityQueue();

        Iterator<String> iterator = writerId.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            int count = 0;
            number = 1;
            writerCount++;
            List<Double> list = new ArrayList<>();
            System.out.println("##########Books of \"" + element + "\" #########(" + writerCount + ")###");
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
                if (priorityData[iterator1].bookData.writerName.equals(element)) {
                    System.out.println(number + " . " + priorityData[iterator1].bookData.bookName);
                    list.add(priorityData[iterator1].MLRweight);
                    number++;
                    count++;
                }
            }
            int sizeB = list.size();
            if (sizeB > 7) {
                medianCalculation.medianCalculationMethods(list);
            }
            if (sizeB > 7) {
                writer.add(element);
            }
            double summation = 0.0;
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.writerName.equals(element)) {
                    summation = summation + priorityData[iterator1].MLRweight;
                }
            }
            double mean = summation / number;

            double standard_deviation = 0.0;

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
                if (priorityData[iterator1].bookData.writerName.equals(element)) {

                    standard_deviation = standard_deviation + ((mean - priorityData[iterator1].MLRweight) *
                            (mean - priorityData[iterator1].MLRweight));
                }
            }
            standard_deviation = standard_deviation / (number - 1);
            standard_deviation = Math.sqrt(standard_deviation);
            System.out.println("Mean : " + mean + "    " + "Standard Deviation : " + standard_deviation);

        }
        System.out.println(writer);
    }

    public void writerCollectionAHPMethods(PriorityData[] priorityData, int numberOfBooks) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Set<String> writerId = new HashSet<>();
        int iterator1;

        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
            writerId.add(priorityData[iterator1].bookData.writerName);
        }

        System.out.println(writerId.size());
        System.out.println();

        int number = 0;
        int writerCount = 0;
        Iterator<String> iterator = writerId.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            int count = 0;
            number = 1;
            writerCount++;
            List<Double> list = new ArrayList<>();
            System.out.println("##########Books of \"" + element + "\" #########(" + writerCount + ")###");
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
                if (priorityData[iterator1].bookData.writerName.equals(element)) {
                    System.out.println(number + " . " + priorityData[iterator1].bookData.bookName);
                    list.add(priorityData[iterator1].AHPweight);
                    number++;
                    count++;
                }
            }
            int sizeB = list.size();
            if (sizeB > 7) {
                medianCalculation.medianCalculationMethods(list);
            }
            double summation = 0.0;
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.writerName.equals(element)) {
                    summation = summation + priorityData[iterator1].AHPweight;
                    // System.out.println(number+" . "+priorityData[iterator1].bookData.bookName);
                }
            }
            double mean = summation / number;
            double standard_deviation = 0.0;

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.writerName.equals(element)) {
                    standard_deviation = standard_deviation + ((mean - priorityData[iterator1].AHPweight) *
                            (mean - priorityData[iterator1].AHPweight));
                }
            }
            standard_deviation = standard_deviation / (number - 1);
            standard_deviation = Math.sqrt(standard_deviation);
            System.out.println("Mean : " + mean + "    " + "Standard Deviation : " + standard_deviation);
        }
    }

    public void writerCollectionPRAMethods(PriorityData[] priorityData, int numberOfBooks) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Set<String> writerId = new HashSet<>();
        int iterator1;
        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

            writerId.add(priorityData[iterator1].bookData.writerName);
        }
        System.out.println(writerId.size());
        System.out.println();
        System.out.println();
        System.out.println();
        int number = 0;
        int writerCount = 0;
        Iterator<String> iterator = writerId.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            int count = 0;
            number = 1;
            writerCount++;

            List<Double> list = new ArrayList<>();

            System.out.println("##########Books of \"" + element + "\" #########(" + writerCount + ")###");
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
                if (priorityData[iterator1].bookData.writerName.equals(element)) {
                    System.out.println(number + " . " + priorityData[iterator1].bookData.bookName);
                    list.add(priorityData[iterator1].PRAweight);
                    number++;
                    count++;
                }
            }
            int sizeB = list.size();
            if (sizeB > 7) {
                medianCalculation.medianCalculationMethods(list);
            }

            double summation = 0.0;
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
                if (priorityData[iterator1].bookData.writerName.equals(element)) {
                    summation = summation + priorityData[iterator1].PRAweight;
                }
            }
            double mean = summation / number;
            double standard_deviation = 0.0;

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
                if (priorityData[iterator1].bookData.writerName.equals(element)) {
                    standard_deviation = standard_deviation + ((mean - priorityData[iterator1].PRAweight) *
                            (mean - priorityData[iterator1].PRAweight));
                }
            }
            standard_deviation = standard_deviation / (number - 1);
            standard_deviation = Math.sqrt(standard_deviation);
            System.out.println("Mean : " + mean + "    " + "Standard Deviation : " + standard_deviation);

        }
    }
}

class ConsoleMain {
    public static void main(String[] args) throws IOException {

        PriorityData[] priorityData;
        int numberOfBooks;
        Processing processing = new Processing();
        BookNumber bookNumber = new BookNumber();
        MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();

        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();
        priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData, numberOfBooks);
        WriterCollection writerCollection = new WriterCollection();
        writerCollection.writerCollectionMLRMethods(priorityData, numberOfBooks);
    }
}

class Writer {
    String writerName;
    int bookNumber;

    public Writer(String writerName, int bookNumber) {
        this.writerName = writerName;
        this.bookNumber = bookNumber;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }
}