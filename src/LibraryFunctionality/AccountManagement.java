package LibraryFunctionality;

import java.io.*;

public class AccountManagement {
    String textUserID;
    public String accountManagementMethods(String [] infoDataArray , String [] addFavouriteBookType) throws IOException {

        String FILENAME = infoDataArray[0]+".txt";
String workingDirectory = System.getProperty("user.dir");
        File file = new File("UserProfile" +File.separator+FILENAME);
        /*if(file.exists()){
            FILENAME = FILENAME +"2";
            File file1 = new File("LibraryFunctionality.UserProfile"+File.separator+(FILENAME+".txt"));
            if(file1.exists()){
                FILENAME = FILENAME+"9";
                File file2 = new File("LibraryFunctionality.UserProfile"+File.separator+(FILENAME+".txt"));
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
String FILENAME_COUNT ="LibraryMemberCount.txt";
File fileA = new File(FILENAME_COUNT);
            FileReader fileReader = new FileReader(fileA);
            char [] libraryMembers = new char[10];
            fileReader.read(libraryMembers);
            String  stringMembers="";
            int countIterator=0;
            for(countIterator=0;libraryMembers[countIterator]!='\0';countIterator++){
                stringMembers = stringMembers+libraryMembers[countIterator];

            }
            stringMembers = stringMembers.trim();
            int intMembers = Integer.parseInt(stringMembers);
            intMembers++;
            int userID = 1000+intMembers;
            textUserID = Integer.toString(userID);
String membersString = Integer.toString(intMembers);

            try {
                FileWriter fileWriter=new FileWriter(file);
                fileWriter.write(infoDataArray[0]+"\t"+textUserID);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

             try {
     FileWriter fileWriter=new FileWriter(FILENAME_COUNT);
                fileWriter.write(membersString);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        //}
        return textUserID;
    }
    public boolean accountManagementLogInMethods(String userName,String userID) throws IOException {

        boolean isFound = false;
        String FILENAME = userName+".txt";
        File file = new File("UserProfile" +File.separator+userName);
        char []getUserInfoArray = new char[100];

        if(file.exists()){
            FileReader fileReader = new FileReader(file);
            fileReader.read(getUserInfoArray);
            System.out.println("Yesssssssssssssss");
        }
        else {
            System.out.println("Noooooooooooooo");
        }
        String  findUserName, findUserID;
        findUserName="";
        findUserID="";

        int countIterator=0;
        boolean isFindTab = false;
        for(countIterator=0;getUserInfoArray[countIterator]!='\0';countIterator++){
            if(getUserInfoArray[countIterator]!='\t'){
                isFindTab = true;
                continue;
            }
            if(isFindTab==true){
                findUserID = findUserID+getUserInfoArray[countIterator];
                System.out.println(findUserID);
            }
            else{
                findUserName = findUserName+getUserInfoArray[countIterator];
                System.out.println(findUserID);

            }
        }
        findUserName = findUserName.trim();
        findUserID = findUserID.trim();
        System.out.println(userName+" ----> "+findUserName);
        System.out.println(userID+" ----> "+findUserID);

        if(findUserName.equals(userName)&&findUserID.equals(userID)){
            isFound =true;
        }

        return isFound;

    }
public void accountManagementFindRecommendedBookList(String userName,String userID){


    }

}
