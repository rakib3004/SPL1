package PageRankAlgorithm;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class PageRankLink {
    int iterator1;

    public double pageRankLinkMethods(int index, PriorityData[] priorityData, int numberOfBooks) {
        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        int borrowLink, typeLink, writerLink, alphabetLink;
        double antiBorrowLink, antiTypeLink, antiWriterLink, antiAlphabetLink;
        double linkValue;
        borrowLink = findBorrowLink(index, priorityData, numberOfBooks);
        typeLink = findTypeLink(index, priorityData, numberOfBooks);
        writerLink = findWriterLink(index, priorityData, numberOfBooks);
        alphabetLink = findAlphabetLink(index, priorityData, numberOfBooks);
        int nullValueCounter = 0;
        if (borrowLink == 0) {
            antiBorrowLink = 0.0;
        } else {
            antiBorrowLink = Math.pow(Double.parseDouble(String.valueOf(borrowLink)), -1);
        }
        if (typeLink == 0) {
            antiTypeLink = 0.0;
        } else {
            antiTypeLink = Math.pow(Double.parseDouble(String.valueOf(typeLink)), -1);
        }
        if (writerLink == 0) {
            antiWriterLink = 0.0;
        } else {
            antiWriterLink = Math.pow(Double.parseDouble(String.valueOf(writerLink)), -1);
        }
        if (alphabetLink == 0) {
            antiAlphabetLink = 0.0;
        } else {
            antiAlphabetLink = Math.pow(Double.parseDouble(String.valueOf(alphabetLink)), -1);
        }
        linkValue = antiBorrowLink + antiTypeLink + antiWriterLink + antiAlphabetLink;
        return linkValue;
    }

    public int[] AHPLinkMethods(int index, PriorityData[] priorityData, int numberOfBooks) {
        int borrowLink, typeLink, writerLink, alphabetLink;
        double linkValue;
        borrowLink = findBorrowLink(index, priorityData, numberOfBooks);
        typeLink = findTypeLink(index, priorityData, numberOfBooks);
        writerLink = findWriterLink(index, priorityData, numberOfBooks);
        alphabetLink = findAlphabetLink(index, priorityData, numberOfBooks);
        linkValue = Math.pow(Double.parseDouble(String.valueOf(borrowLink)), -1) +
                Math.pow(Double.parseDouble(String.valueOf(typeLink)), -1) +
                Math.pow(Double.parseDouble(String.valueOf(writerLink)), -1) +
                Math.pow(Double.parseDouble(String.valueOf(alphabetLink)), -1);

        int[] aLink = new int[5];
        return aLink;
    }

    public int findBorrowLink(int index, PriorityData[] priorityData, int numberOfBooks) {
        int countingBorrrow = 0;
        String linkCompare = priorityData[index].bookData.borrowCount;

        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
            if (priorityData[iterator1].bookData.borrowCount.equals(linkCompare)) {
                countingBorrrow++;
            }
        }
        return countingBorrrow;
    }

    public int findTypeLink(int index, PriorityData[] priorityData, int numberOfBooks) {
        int countingType = 0;
        String linkCompare = priorityData[index].bookData.bookId.substring(0, 2);
        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
            if (priorityData[iterator1].bookData.bookId.substring(0, 2).equals(linkCompare)) {
                countingType++;
            }
        }
        return countingType;
    }

    public int findWriterLink(int index, PriorityData[] priorityData, int numberOfBooks) {
        int countingWriter = 0;
        String linkCompare = priorityData[index].bookData.writerName;
        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
            if (priorityData[iterator1].bookData.writerName.equals(linkCompare)) {
                countingWriter++;
            }
        }
        return countingWriter;
    }

    public int findAlphabetLink(int index, PriorityData[] priorityData, int numberOfBooks) {
        int countingAlphabet = 0;

        Character linkCompare = priorityData[index].bookData.bookName.charAt(0);
        for (iterator1 = 0; iterator1 < numberOfBooks; iterator1++) {
            if (priorityData[iterator1].bookData.bookName.charAt(0) == linkCompare) {
                countingAlphabet++;
            }
        }
        return countingAlphabet;
    }
}
