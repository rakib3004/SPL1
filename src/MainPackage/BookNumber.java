package MainPackage;

import FilePackage.DateTimeWriter;
import Methods.PrintInfo;
import ObjectOriented.BookData;
import ObjectOriented.PriorityData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BookNumber {
    public  int bookNumberFindingMethods() throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        int numOfBook;
        int iterator;
        int charIndex = 0;
        int wordIndex = 0;
        PriorityData[] priorityData;

            File file = new File("IIT_SPL.txt");
            FileReader fr = new FileReader(file);
            char[] arrayOfCharacter = new char[120500];
            fr.read(arrayOfCharacter);


            // reads the content to the array
            String  bookName[] = new String[1050];
            String writerName[] = new String[1050];
            String bookId[] = new String[1050];


            String borrowCount[] = new String[1050];

            String bookPrice[] = new String[1050];



            bookName[wordIndex] = "\0";
            writerName[wordIndex] = "\0";
            bookId[wordIndex] = "\0";
            borrowCount[wordIndex] = "\0";
            bookPrice[wordIndex] = "\0";

            for (iterator = 0; arrayOfCharacter[iterator] != '\0'; iterator++) {
                if (arrayOfCharacter[iterator] == '\t') {
                    iterator++;
                    charIndex++;
                    charIndex = charIndex % 5;
                }
                if (arrayOfCharacter[iterator] == '\n') {
                    iterator++;
                    charIndex++;

                    charIndex = charIndex % 5;




                    wordIndex++;
                    bookName[wordIndex] = "\0";
                    writerName[wordIndex] = "\0";
                    bookId[wordIndex] = "\0";

                    borrowCount[wordIndex] = "\0";
                    bookPrice[wordIndex] = "\0";

                }
                if (charIndex == 0) {

                    bookName[wordIndex] = bookName[wordIndex] + arrayOfCharacter[iterator];
                } else if (charIndex == 1) {

                    writerName[wordIndex] = writerName[wordIndex] + arrayOfCharacter[iterator];

                } else if (charIndex == 2) {
                    bookId[wordIndex] = bookId[wordIndex] + arrayOfCharacter[iterator];


                } else if (charIndex == 3) {
                    borrowCount[wordIndex] = borrowCount[wordIndex] + arrayOfCharacter[iterator];

                }
                else if(charIndex ==4){
                    bookPrice[wordIndex]=bookPrice[wordIndex]+arrayOfCharacter[iterator];
                }
            }
            fr.close();

            numOfBook= wordIndex;

return numOfBook;
        }
}
