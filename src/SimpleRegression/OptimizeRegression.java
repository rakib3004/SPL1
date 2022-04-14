package SimpleRegression;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;
import ObjectOriented.GenericAlgo;
import MainPackage.MainClass;

public class OptimizeRegression {
    double pricePriority[] = new double[1050];
    double weight[] = new double[1050];
    int typeValue[] = new int[1050];
    int timeCount[] = new int[1050];
    int bookCount[] = new int[1050];
    int queueValue[] = new int[1050];
    int bookPrice[] = new int[1050];
    int writePriority[] = new int[1050];
    double bookPriority[] = new double[1050];
    double timePriority[] = new double[1050];
    int borrowCount[] = new int[1050];

    String string, string1, string2;
    int length;
    int integer1, integer2;
    int newYear, oldYear;

    public void newCountValue() {
    }

    public void newTypeValue() {
    }

    public void newPriceValue() {
    }

    public void newMonthValue() {
    }

    public void OptimizeRegressionMethods(BookData[] bookData, String[] writerName,
            String[] borrowCount1, String[] bookPrice1, String[] bookId, int numberOfBooks) {
        // Processing processing = new Processing();

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        for (int iterator = 0; iterator < numberOfBooks; iterator++) {
            if (writerName[iterator].equals(" Humayon Ahmed")) {
                writePriority[iterator] = 25;
            } else if (writerName[iterator].equals("Muhammad Jafar Iqbal")) {
                writePriority[iterator] = 23;
            } else {
                writePriority[iterator] = 15;
            }
        }

        for (int iterator = 0; iterator < numberOfBooks; iterator++) {
            bookPriority[iterator] = (20 - Math.sqrt(typeValue[iterator]));
            timePriority[iterator] = 16 - (timeCount[iterator] / 12);
            borrowCount[iterator] = bookCount[iterator];
            pricePriority[iterator] = Math.pow(bookPrice[iterator], (2 / 5));

            weight[iterator] = bookPriority[iterator] + timePriority[iterator] +
                    borrowCount[iterator] +
                    +writePriority[iterator] + pricePriority[iterator];
            bookData[iterator].setWeight(weight[iterator]);
        }
        MainClass mainClass = new MainClass();
        BookData bookData1 = new BookData();

        GenericAlgo genericAlgo[] = new GenericAlgo[1050];
        for (int iterator = 0; iterator < numberOfBooks; iterator++) {
            genericAlgo[iterator] = new GenericAlgo(bookData[iterator].getWeight(), iterator);
        }
        double temporary;
        int temp;
        for (int iterator = 0; iterator < numberOfBooks; iterator++) {
            for (int jterator = 0; jterator < numberOfBooks; jterator++) {
                if (genericAlgo[iterator].getWeight() > genericAlgo[jterator].getWeight()) {
                    temporary = genericAlgo[iterator].getWeight();
                    genericAlgo[iterator].setWeight(genericAlgo[jterator].getWeight());
                    genericAlgo[jterator].setWeight(temporary);
                    temp = genericAlgo[iterator].getIndex();
                    genericAlgo[iterator].setIndex(genericAlgo[jterator].getIndex());
                    genericAlgo[jterator].setIndex(temp);
                    bookData[jterator].setRank(temp, 0);
                }
            }
        }
        System.out.println("Optimized View 01 :");
        for (int i = 190; i < numberOfBooks; i++) {
            System.out.println("Book Name :" + bookData[genericAlgo[i].getIndex()].getBookName() +
                    "; Writer Name : " + bookData[genericAlgo[i].getIndex()].getWriterName()
                    + "; Weight : " + genericAlgo[i].getWeight());
        }
    }
}
