package LibraryFunctionality;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Parameter;

public class AccountManagement {
    String textUserID;
    public String accountManagementMethods(String [] infoDataArray , String [] addFavouriteBookType) throws IOException {

        String FILENAME = infoDataArray[0]+".txt";

        File file = new File(/*"UserProfile"+File.separator+*/FILENAME);
        /*if(file.exists()){
            FILENAME = FILENAME +"2";
            File file1 = new File("UserProfile"+File.separator+(FILENAME+".txt"));
            if(file1.exists()){
                FILENAME = FILENAME+"9";
                File file2 = new File("UserProfile"+File.separator+(FILENAME+".txt"));
                file2.createNewFile();
                String FILENAME_COUNT = "LibraryMemberCount.txt";
                File fileA = new File(FILENAME_COUNT);
                FileReader fileReader = new FileReader(fileA);
                char [] libraryMembers = new char[10];
                fileReader.read(libraryMembers);
                String  stringMemebers="";
                int countIterator=0;
                for(countIterator=0;libraryMembers[countIterator]!='\0';countIterator++){
                    stringMemebers = stringMemebers+libraryMembers[countIterator];

                }
                stringMemebers = stringMemebers.trim();
                int intMembers = Integer.parseInt(stringMemebers);
                intMembers++;
                int userID = 1000+intMembers;
                textUserID = Integer.toString(userID);


                try {
                    FileWriter fileWriter=new FileWriter(FILENAME);
                    fileWriter.write(infoDataArray[0]+"\t"+textUserID);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    FileWriter fileWriter=new FileWriter(FILENAME_COUNT);
                    fileWriter.write(intMembers);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            else{
                file1.createNewFile();
                String FILENAME_COUNT = "LibraryMemberCount.txt";
                File fileA = new File(FILENAME_COUNT);
                FileReader fileReader = new FileReader(fileA);
                char [] libraryMembers = new char[10];
                fileReader.read(libraryMembers);
                String  stringMemebers="";
                int countIterator=0;
                for(countIterator=0;libraryMembers[countIterator]!='\0';countIterator++){
                    stringMemebers = stringMemebers+libraryMembers[countIterator];

                }
                stringMemebers = stringMemebers.trim();
                int intMembers = Integer.parseInt(stringMemebers);
                intMembers++;
                int userID = 1000+intMembers;
                textUserID = Integer.toString(userID);


                try {
                    FileWriter fileWriter=new FileWriter(FILENAME);
                    fileWriter.write(infoDataArray[0]+"\t"+textUserID);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    FileWriter fileWriter=new FileWriter(FILENAME_COUNT);
                    fileWriter.write(intMembers);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        else {*/
            file.createNewFile();
String FILENAME_COUNT ="LibraryFunctionality"+File.separator+"LibraryMemberCount.txt";
File fileA = new File(FILENAME_COUNT);
            FileReader fileReader = new FileReader(fileA);
            char [] libraryMembers = new char[10];
            fileReader.read(libraryMembers);
            String  stringMemebers="";
            int countIterator=0;
            for(countIterator=0;libraryMembers[countIterator]!='\0';countIterator++){
                stringMemebers = stringMemebers+libraryMembers[countIterator];

            }
            stringMemebers = stringMemebers.trim();
            int intMembers = Integer.parseInt(stringMemebers);
            intMembers++;
            int userID = 1000+intMembers;
            textUserID = Integer.toString(userID);


            try {
                FileWriter fileWriter=new FileWriter(FILENAME);
                fileWriter.write(infoDataArray[0]+"\t"+textUserID);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

             try {
     FileWriter fileWriter=new FileWriter(FILENAME_COUNT);
                fileWriter.write(intMembers);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        //}
        return textUserID;
    }
    public boolean accountManagementLogInMethods(String userName,String userID){

        boolean isFound = false;
        isFound =true;
        return isFound;

    }
public void accountManagementFindRecommendedBookList(String userName,String userID){


    }

}
