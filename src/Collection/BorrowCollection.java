package Collection;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;
import MultiVariableRegression.MedianCalculation;

import java.util.*;

public class BorrowCollection {
    MedianCalculation medianCalculation = new MedianCalculation();

    public void borrowCollectionMLRMethods(PriorityData[] priorityData, int numberOfBooks) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Set<String> borrowID = new HashSet<>();
        int iterator1;

        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

            borrowID.add(priorityData[iterator1].bookData.borrowCount);
        }
        System.out.println(borrowID.size());
        System.out.println();
        System.out.println();
        System.out.println();
        int number = 0;
        int writerCount = 0;
        Iterator<String> iterator = borrowID.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();

            int count = 0;

            number = 1;
            writerCount++;

            List<Double> list = new ArrayList<>();

            System.out.println("##########Books of \"" + element + "\" #########(" + writerCount + ")###");
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
                if (priorityData[iterator1].bookData.borrowCount.equals(element)) {
                    System.out.println(number + " . " + priorityData[iterator1].bookData.bookName);
                    list.add(priorityData[iterator1].MLRweight);
                    number++;
                    count++;
                }
            }

            double summation = 0.0;

            int sizeB = list.size();
            if (sizeB > 7) {

                medianCalculation.medianCalculationMethods(list);
            }

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.borrowCount.equals(element)) {
                    summation = summation + priorityData[iterator1].MLRweight;

                    // System.out.println(number+" . "+priorityData[iterator1].bookData.bookName);
                }

            }
            double mean = summation / number;

            double standard_deviation = 0.0;

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.borrowCount.equals(element)) {

                    standard_deviation = standard_deviation + ((mean - priorityData[iterator1].MLRweight) *
                            (mean - priorityData[iterator1].MLRweight));

                }

            }
            standard_deviation = standard_deviation / (number - 1);
            standard_deviation = Math.sqrt(standard_deviation);
            System.out.println("Mean : " + mean + "    " + "Standard Deviation : " + standard_deviation);

        }
    }

    public void borrowCollectionAHPMethods(PriorityData[] priorityData, int numberOfBooks) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Set<String> borrowID = new HashSet<>();
        int iterator1;

        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
            borrowID.add(priorityData[iterator1].bookData.borrowCount);
        }

        System.out.println(borrowID.size());
        System.out.println();
        System.out.println();
        System.out.println();
        int number = 0;
        int writerCount = 0;
        Iterator<String> iterator = borrowID.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();

            int count = 0;

            number = 1;
            writerCount++;

            List<Double> list = new ArrayList<>();
            System.out.println("##########Books of \"" + element + "\" #########(" + writerCount + ")###");
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
                if (priorityData[iterator1].bookData.borrowCount.equals(element)) {
                    System.out.println(number + " . " + priorityData[iterator1].bookData.bookName);
                    list.add(priorityData[iterator1].AHPweight);
                    number++;
                    count++;
                }
            }
            double summation = 0.0;

            int sizeB = list.size();
            if (sizeB > 7) {
                medianCalculation.medianCalculationMethods(list);
            }

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.borrowCount.equals(element)) {
                    summation = summation + priorityData[iterator1].AHPweight;

                    // System.out.println(number+" . "+priorityData[iterator1].bookData.bookName);
                }
            }
            double mean = summation / number;
            double standard_deviation = 0.0;

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.borrowCount.equals(element)) {

                    standard_deviation = standard_deviation + ((mean - priorityData[iterator1].AHPweight) *
                            (mean - priorityData[iterator1].AHPweight));
                }
            }
            standard_deviation = standard_deviation / (number - 1);
            standard_deviation = Math.sqrt(standard_deviation);
            System.out.println("Mean : " + mean + "    " + "Standard Deviation : " + standard_deviation);

        }
    }

    public void borrowCollectionPRAMethods(PriorityData[] priorityData, int numberOfBooks) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Set<String> borrowID = new HashSet<>();
        int iterator1;

        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

            borrowID.add(priorityData[iterator1].bookData.borrowCount);

        }
        System.out.println(borrowID.size());
        System.out.println();
        System.out.println();
        System.out.println();
        int number = 0;
        int writerCount = 0;
        Iterator<String> iterator = borrowID.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            int count = 0;

            number = 1;
            writerCount++;
            List<Double> list = new ArrayList<>();
            System.out.println("##########Books of \"" + element + "\" #########(" + writerCount + ")###");
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
                if (priorityData[iterator1].bookData.borrowCount.equals(element)) {
                    System.out.println(number + " . " + priorityData[iterator1].bookData.bookName);
                    list.add(priorityData[iterator1].PRAweight);
                    number++;
                    count++;
                }
            }
            double summation = 0.0;

            int sizeB = list.size();
            if (sizeB > 7) {
                medianCalculation.medianCalculationMethods(list);
            }

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.borrowCount.equals(element)) {
                    summation = summation + priorityData[iterator1].PRAweight;

                    // System.out.println(number+" . "+priorityData[iterator1].bookData.bookName);
                }

            }
            double mean = summation / number;
            double standard_deviation = 0.0;

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.borrowCount.equals(element)) {

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
