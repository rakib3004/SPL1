package Collection;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;
import MultiVariableRegression.MedianCalculation;

import java.util.*;

public class TypeCollection {
    MedianCalculation medianCalculation = new MedianCalculation();

    public void typeCollectionMLRMethods(PriorityData[] priorityData, int numberOfBooks) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Set<String> typeId = new HashSet<>();
        int iterator1;

        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

            typeId.add(priorityData[iterator1].bookData.bookId.substring(0, 2));
        }
        int size = typeId.size();
        int number;
        Iterator<String> iterator = typeId.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            int count = 0;
            List<Double> list = new ArrayList<>();
            number = 0;
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(element)) {
                    System.out.println(count + " . " + priorityData[iterator1].bookData.bookName);
                    list.add(priorityData[iterator1].MLRweight);
                    number++;
                    count++;
                }
            }
            double summation = 0;
            int sizeB = list.size();
            if (sizeB > 7) {
                medianCalculation.medianCalculationMethods(list);
            }

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(element)) {
                    summation = summation + priorityData[iterator1].MLRweight;
                }
            }
            double mean = summation / number;
            double standard_deviation = 0.0;

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(element)) {

                    standard_deviation = standard_deviation + ((mean - priorityData[iterator1].MLRweight) *
                            (mean - priorityData[iterator1].MLRweight));
                }
            }
            standard_deviation = standard_deviation / (number);
            standard_deviation = Math.sqrt(standard_deviation);
            System.out.println("Mean : " + mean + "    " + "Standard Deviation : " + standard_deviation);
        }

    }

    public void typeCollectionAHPMethods(PriorityData[] priorityData, int numberOfBooks) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Set<String> typeId = new HashSet<>();
        int iterator1;
        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

            typeId.add(priorityData[iterator1].bookData.bookId.substring(0, 2));

        }
        int size = typeId.size();
        int number;
        Iterator<String> iterator = typeId.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            int count = 0;
            List<Double> list = new ArrayList<>();

            number = 0;
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(element)) {
                    System.out.println(count + " . " + priorityData[iterator1].bookData.bookName);
                    list.add(priorityData[iterator1].AHPweight);

                    number++;
                    count++;
                }
            }
            double summation = 0;

            int sizeB = list.size();
            if (sizeB > 7) {

                medianCalculation.medianCalculationMethods(list);
            }

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(element)) {
                    summation = summation + priorityData[iterator1].AHPweight;

                }

            }
            double mean = summation / number;

            double standard_deviation = 0.0;

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(element)) {

                    standard_deviation = standard_deviation + ((mean - priorityData[iterator1].AHPweight) *
                            (mean - priorityData[iterator1].AHPweight));
                }

            }
            standard_deviation = standard_deviation / (number);
            standard_deviation = Math.sqrt(standard_deviation);
            System.out.println("Mean : " + mean + "    " + "Standard Deviation : " + standard_deviation);
        }
    }

    public void typeCollectionPRAMethods(PriorityData[] priorityData, int numberOfBooks) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        Set<String> typeId = new HashSet<>();
        int iterator1;

        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

            typeId.add(priorityData[iterator1].bookData.bookId.substring(0, 2));

        }
        int size = typeId.size();

        int number;
        Iterator<String> iterator = typeId.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            int count = 0;
            List<Double> list = new ArrayList<>();
            number = 0;
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(element)) {
                    System.out.println(count + " . " + priorityData[iterator1].bookData.bookName);
                    list.add(priorityData[iterator1].PRAweight);
                    number++;
                    count++;
                }
            }
            double summation = 0;
            int sizeB = list.size();
            if (sizeB > 7) {
                medianCalculation.medianCalculationMethods(list);
            }
            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(element)) {
                    summation = summation + priorityData[iterator1].PRAweight;

                }
            }
            double mean = summation / number;

            double standard_deviation = 0.0;

            for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {

                if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(element)) {

                    standard_deviation = standard_deviation + ((mean - priorityData[iterator1].PRAweight) *
                            (mean - priorityData[iterator1].PRAweight));

                }
            }
            standard_deviation = standard_deviation / (number);
            standard_deviation = Math.sqrt(standard_deviation);
            System.out.println("Mean : " + mean + "    " + "Standard Deviation : " + standard_deviation);
        }
    }
}
