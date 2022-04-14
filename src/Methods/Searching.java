package Methods;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

import java.util.Scanner;

public class Searching {

    int iterator, jterator, kterator;

    public void search(PriorityData[] priorityData, int numberOfBooks) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        char ch;
        String string = " ";
        int iterator, jterator;
        System.out.println("##########ReverseSorting by Book Name############");
        System.out.println();
        for (iterator = 65; iterator <= 90; iterator++) {
            ch = (char) iterator;
            string = Character.toString(ch);
            System.out.println("____________________________");
            System.out.println("_____________" + ch + "_____________");
            System.out.println("____________________________");
            for (jterator = 0; jterator < numberOfBooks; jterator++) {
                if (priorityData[jterator].bookData.bookName.charAt(0) == ch) {
                    System.out.println("Book Name : " + priorityData[jterator].bookData.bookName + "\t Book price : "
                            + priorityData[jterator].bookData.bookPrice);
                }
            }
        }
        System.out.println();
        System.out.println(
                "########################################ReverseSorting by Writer Name#########################");

        for (iterator = 65; iterator <= 90; iterator++) {
            ch = (char) iterator;
            string = Character.toString(ch);
            System.out.println("____________________________");
            System.out.println("_____________" + ch + "_____________");
            System.out.println("____________________________");
            for (jterator = 0; jterator < numberOfBooks; jterator++) {
                if (priorityData[jterator].bookData.writerName.charAt(0) == ch) {
                    System.out.println("Writer Name : " +
                            priorityData[jterator].bookData.writerName +
                            "\t Book weight : " + priorityData[jterator].MLRweight);
                }
            }
        }
    }

    public void searchingMethods(PriorityData[] priorityData, int numberOfBooks) {
        Scanner scanner = new Scanner(System.in);

        String enterSearchingString;
        enterSearchingString = scanner.nextLine();
        boolean isWriterName = false;
        boolean isBookName = false;
        boolean isTypeName = false;
        int matchingCount = 0;
        int testBookLength = 0;
        int testWriterLength = 0;
        int testTypeLength = 0;
        int terminatorPoint = 0;

        int stringLength = enterSearchingString.length();
        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            testBookLength = priorityData[iterator].bookData.bookName.length();
            terminatorPoint = Math.min(stringLength, testBookLength);
            String testingBook = priorityData[iterator].getBookData().getBookName();

            for (jterator = 0, kterator = 0; jterator < terminatorPoint; jterator++, kterator++) {
                if (testingBook.charAt(jterator) == enterSearchingString.charAt(kterator)) {
                    matchingCount++;
                }
            }
            if (matchingCount >= (terminatorPoint / 2)) {
                System.out.println("Found!!!!");
            }
            System.out.println(priorityData[iterator].getBookData().getBookName());
        }
    }
}
