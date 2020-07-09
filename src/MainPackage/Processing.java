package MainPackage;


import FilePackage.DateTimeWriter;
import Methods.PrintInfo;
import ObjectOriented.BookData;
import ObjectOriented.PriorityData;
import TableViewPackage.Book;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;
public class Processing {
        int numOfBook;
     BookData [] bookData = new BookData[1050];

  DataParsing dataParsing = new DataParsing();
  PrintInfo printInfo = new PrintInfo();
    int charIndex ;
    int wordIndex;
PriorityData [] priorityData;
    public PriorityData [] fileReaderMethods()  throws IOException{ 
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

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
        String typeName[] = new String[1050];

        int iterator;
        int charIndex=0;
        int wordIndex=0;
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

bookName[wordIndex] = bookName[wordIndex].trim();
                writerName[wordIndex] = writerName[wordIndex].trim();

                bookId[wordIndex] = bookId[wordIndex].trim();

                bookPrice[wordIndex] = bookPrice[wordIndex].trim();

             String string = bookPrice[wordIndex];
                     string = string.replaceAll("[\\t\\n\\r]+", "");
                bookPrice[wordIndex] = string;
                MenuItem uponnash = new MenuItem("Uponnash");
                MenuItem kobita = new MenuItem("Kobita");
                MenuItem rochonaboli = new MenuItem("Rochonaboli");
                MenuItem religion = new MenuItem("Religion");
                MenuItem biggan = new MenuItem("Biggan");
                MenuItem sciFi = new MenuItem("Sci Fi");
                MenuItem shishuShahitto = new MenuItem("Shishu Shahitto");
                MenuItem kisoreUponnash = new MenuItem("Kisore Uponnash");
                MenuItem biography = new MenuItem("Biography");
                MenuItem gobesona = new MenuItem("Gobesona");
                MenuItem onubad = new MenuItem("Onubad");
                MenuItem others = new MenuItem("Others");

                            if (bookId[wordIndex].substring(0,2).equals("01"))
                            {
                           typeName[wordIndex]=uponnash.getText();
                                  }
                     else    if (bookId[wordIndex].substring(0,2).equals("02")) {
                             typeName[wordIndex]=kobita.getText();
                        }
                        else    if (bookId[wordIndex].substring(0,2).equals("05")) {
                                typeName[wordIndex]=rochonaboli.getText();
                        }
              else  if (bookId[wordIndex].substring(0,2).equals("04")) {
                                typeName[wordIndex]=religion.getText();
                            }
              
                          else  if (bookId[wordIndex].substring(0,2).equals("13")) {
                                typeName[wordIndex]=biggan.getText();
                        }
                        else   if (bookId[wordIndex].substring(0,2).equals("06")) {
                                typeName[wordIndex]=sciFi.getText();
                        }
                   else  if (bookId[wordIndex].substring(0,2).equals("11")) {

                                typeName[wordIndex]=shishuShahitto.getText();
                        }
                          else  if (bookId[wordIndex].substring(0,2).equals("10")) {
                                typeName[wordIndex]=kisoreUponnash.getText();
                        }

                         else   if (bookId[wordIndex].substring(0,2).equals("12")) {
                                typeName[wordIndex]=biography.getText();
                        }

                        else   if (bookId[wordIndex].substring(0,2).equals("08")) {
                                typeName[wordIndex]=gobesona.getText();
                            }
                     else  if (bookId[wordIndex].substring(0,2).equals("12")) {
                                typeName[wordIndex]=onubad.getText();
                        }
                     else {
                          typeName[wordIndex]=others.getText();
                        }
                bookData[wordIndex] = new BookData(  bookName[wordIndex],  writerName[wordIndex],
         bookId[wordIndex],borrowCount[wordIndex],
           bookPrice[wordIndex],typeName[wordIndex]);

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
  priorityData =      dataParsing.dataParsingMethods(bookData,writerName,borrowCount,bookPrice,bookId,numOfBook);

 return  priorityData;
    }


}