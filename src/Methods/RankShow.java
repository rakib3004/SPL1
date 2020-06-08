package Methods;

import FilePackage.DateTimeWriter;
import ObjectOriented.BookData;

public class RankShow {
    BookData bookData = new BookData();

    public void showCase(BookData [] bookData,int numberOfBooks) {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        System.out.println("Book Name \t\t t1 \t t2 \t t3 \t t4 \t t5 \t t6 \t t7 \t t8 \t t9 ");
        for (int iterator = 0; iterator < numberOfBooks; iterator++) {
            System.out.println(bookData[iterator].bookName+"\t"+bookData[iterator].rank[0]+
                    "\t"+bookData[iterator].rank[1]+"\t"+bookData[iterator].rank[2]+
                    "\t"+bookData[iterator].rank[3]+"\t"+bookData[iterator].rank[4]+"" +
                    "\t"+bookData[iterator].rank[5]+
                    "\t"+bookData[iterator].rank[6]+"\t"+bookData[iterator].rank[7]+"" +
                    "\t"+bookData[iterator].rank[8]);
        }
    }
}