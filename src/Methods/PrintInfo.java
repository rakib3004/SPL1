package Methods;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;
import ObjectOriented.PriorityData;

public class PrintInfo {
int iterator;
int jterator;
    public void printInfoMethods(BookData[] bookData, int numberOfBooks) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        for (jterator = 0; jterator < numberOfBooks; jterator++) {
            System.out.println(bookData[jterator].bookName);
        }
        for (jterator = 0; jterator < numberOfBooks; jterator++) {
            System.out.println(bookData[jterator].writerName);
        }
        for (jterator = 0; jterator < numberOfBooks; jterator++) {
            System.out.println(bookData[jterator].bookId);
        }
        for (jterator = 0; jterator < numberOfBooks; jterator++) {
            System.out.println(bookData[jterator].borrowCount);
        }
        for (jterator = 0; jterator < numberOfBooks; jterator++) {
            System.out.println(bookData[jterator].bookPrice);
        }
    }
    public void showMLRProcessResult(PriorityData[] priorityData, int numberOfBooks) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        System.out.println("Book Name :\t Writer Name : \t Weight ");
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            System.out.println(priorityData[iterator].bookData.bookName + "\t"
                    + priorityData[iterator].bookData.writerName + "\t" + priorityData[iterator].getMLRweight());
        }
    }
    public void showAHPProcessResult(PriorityData[] priorityData, int numberOfBooks) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        System.out.println("Book Name :\t Writer Name : \t Weight ");
        for(iterator=0;iterator<numberOfBooks;iterator++){

            System.out.println(priorityData[iterator].bookData.bookName+"\t"
                    +priorityData[iterator].bookData.writerName+"\t"+priorityData[iterator].getAHPweight());
        }
    }

    public void showPRAProcessResult(PriorityData[] priorityData, int numberOfBooks) {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        System.out.println("Book Name :\t Writer Name : \t Weight ");
        for(iterator=0;iterator<numberOfBooks;iterator++){

            System.out.println(priorityData[iterator].bookData.bookName+"\t"
                    +priorityData[iterator].bookData.writerName+"\t"+priorityData[iterator].getPRAweight());
        }
    }
}