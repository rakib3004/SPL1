package PageRankAlgorithm;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class CheckPageLink {
    String  compareDataOne;
    String  compareDataTwo;
    Character compareCharacterOne,compareCharacterTwo;
    public boolean checkPageLinkMethods(int index, int jIndex,PriorityData[] priorityData, int numberOfBooks){
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        boolean linkPageBool;
        boolean borrowLinkBool,typeLinkBool,writerLinkBool,alphabetLinkBool;
        borrowLinkBool = checkBorrowLinkBool(index,jIndex,priorityData,numberOfBooks);
        typeLinkBool = checkTypeLinkBool(index,jIndex,priorityData,numberOfBooks);
        writerLinkBool = checkWriterLinkBool(index,jIndex,priorityData,numberOfBooks);
        alphabetLinkBool = checkAlphabetLinkBool(index,jIndex,priorityData,numberOfBooks);

        linkPageBool = (borrowLinkBool||typeLinkBool||writerLinkBool||alphabetLinkBool);
        return linkPageBool;
    }

    public boolean checkBorrowLinkBool(int index,int jIndex,PriorityData[] priorityData, int numberOfBooks){
       compareDataOne = priorityData[index].bookData.borrowCount;
       compareDataTwo = priorityData[jIndex].bookData.borrowCount;

        if(compareDataOne.equals(0.0)){
            return  false;
        }
        else if(compareDataTwo.equals(0.0)){
            return  false;
        }
    else  if(compareDataOne.equals(compareDataTwo)){
           return  true;
       }
        else{
           return  false;

       }

    }
     public boolean checkTypeLinkBool(int index,int jIndex,PriorityData[] priorityData, int numberOfBooks){
         compareDataOne = priorityData[index].bookData.bookId.substring(0,2);
         compareDataTwo = priorityData[jIndex].bookData.bookId.substring(0,2);

         if(compareDataOne.equals(compareDataTwo)){
             return  true;
         }
         else{
             return  false;

         }
     }
     public boolean checkWriterLinkBool(int index,int jIndex,PriorityData[] priorityData, int numberOfBooks){
         compareDataOne = priorityData[index].bookData.writerName;
         compareDataTwo = priorityData[jIndex].bookData.writerName;

         if(compareDataOne.equals(compareDataTwo)){
             return  true;
         }
         else{
             return  false;

         }
     }
     public boolean checkAlphabetLinkBool(int index,int jIndex,PriorityData[] priorityData, int numberOfBooks){
         compareCharacterOne = priorityData[index].bookData.bookName.charAt(0);
         compareCharacterTwo = priorityData[jIndex].bookData.bookName.charAt(0);

         if(compareDataOne.equals(compareDataTwo)){
             return  true;
         }
         else{
             return  false;

         }
     }

}
