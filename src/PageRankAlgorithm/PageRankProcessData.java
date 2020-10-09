package PageRankAlgorithm;

import ObjectOriented.PriorityData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class PageRankProcessData {
    String [] stringArray = new String[632];
    public PriorityData[]  PageRankProcessDataMethods(PriorityData[] priorityData, int numberOfBooks) throws IOException {
int iterator;
 double [] pageRankArray  = new double[632];
        for(iterator=0;iterator<numberOfBooks;iterator++){
stringArray[iterator]="";
        }
        pageRankArray = pageRankDataFromText(pageRankArray);
for(iterator=0;iterator<numberOfBooks;iterator++){
    priorityData[iterator].setPRAweight(pageRankArray[iterator]);
    priorityData[iterator].setRankValue(pageRankArray[iterator]);
}
        return  priorityData;
    }
    public double [] pageRankDataFromText(double[] pageRankArray) throws IOException {
        int iterator;

        String FILENAME = "PageRankAlgo.txt";
        File file = new File(FILENAME);
        FileReader fileReader = new FileReader(file);
        char[] arrayOfCharacter = new char[900000];
        fileReader.read(arrayOfCharacter);
        int iCount;
        int charIndex=0;
        int wordIndex=0;
int iterator1=0;
        for (iCount = 0; arrayOfCharacter[iCount] != '\0'; iCount++) {
            if (arrayOfCharacter[iCount] == '\n') {
                // iCount++;
                stringArray[iterator1] = stringArray[iterator1].trim();
                pageRankArray[iterator1] = Double.parseDouble(stringArray[iterator1]);
                iterator1++;
            }
            else{
                stringArray[iterator1] = stringArray[iterator1]+arrayOfCharacter[iCount];
            }
        }
        fileReader.close();
        return pageRankArray;
    }
    public void printPageRankAlgorithmDataView(PriorityData [] priorityData, int numberOfBooks){
        int iterator;
        for(iterator=0;iterator<numberOfBooks;iterator++){
            System.out.println(priorityData[iterator].getPRAweight());
        }
    }
    }

