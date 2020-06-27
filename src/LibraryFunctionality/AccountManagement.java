package LibraryFunctionality;

import java.io.*;

public class AccountManagement {
    String textUserID;
    public String accountManagementMethods(String [] infoDataArray ,
                                           String [] addFavouriteBookType,
                                           String userChoiceList) throws IOException {
String userNameTemplate = infoDataArray[0];
        String FILENAME = userNameTemplate;

        File file = new File("src"+File.separator+"UserProfile" +File.separator+(FILENAME+".txt"));
        if(file.exists()){
            FILENAME = userNameTemplate +"2";
            File file1 = new File("src"+File.separator+"UserProfile" +File.separator+(FILENAME+".txt"));
            if(file1.exists()){
                FILENAME = userNameTemplate+"3";
                File file2 = new File("src"+File.separator+"UserProfile" +File.separator+(FILENAME+".txt"));
                file2.createNewFile();
                String FILENAME_COUNT = "LibraryMemberCount.txt";
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
                FILENAME = userNameTemplate+"3ChoiceList.txt";
                File fileA3 = new File("src"+File.separator+"UserProfile" +File.separator+(FILENAME+".txt"));
                fileA3.createNewFile();
                int iterator;
                String choiceListDescription;
                choiceListDescription = infoDataArray[2];
               /* for(iterator=0;addFavouriteBookType[iterator]!=null;iterator++){
                    choiceListDescription = choiceListDescription+"\t"+addFavouriteBookType[iterator];
                }*/

                try{
                    FileWriter fileWriter = new FileWriter(fileA3);
                    fileWriter.write(userChoiceList);
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
                FILENAME = userNameTemplate+"2ChoiceList.txt";
                File fileA2 = new File("src"+File.separator+"UserProfile" +File.separator+(FILENAME+".txt"));
                fileA2.createNewFile();
                int iterator;
                String choiceListDescription;
                choiceListDescription = infoDataArray[2];
               /* for(iterator=0;addFavouriteBookType[iterator]!=null;iterator++){
                    choiceListDescription = choiceListDescription+"\t"+addFavouriteBookType[iterator];
                }
*/
                try{
                    FileWriter fileWriter = new FileWriter(fileA2);
                    fileWriter.write(userChoiceList);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
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
FILENAME = userNameTemplate+"ChoiceList.txt";
            File fileA1 = new File("src"+File.separator+"UserProfile" +File.separator+(FILENAME+".txt"));
            fileA1.createNewFile();
            int iterator;
            String choiceListDescription;
            choiceListDescription = infoDataArray[2];
         /*   for(iterator=0;addFavouriteBookType[iterator]!=null;iterator++){
                choiceListDescription = choiceListDescription+"\t"+addFavouriteBookType[iterator];
            }*/
iterator=0;
            try{
                FileWriter fileWriter = new FileWriter(fileA1);
                fileWriter.write(userChoiceList);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return textUserID;
    }
    public boolean accountManagementLogInMethods(String userName,String userID) throws IOException {

        boolean isFound = false;
        userName = userName.trim();
        String FILENAME = userName+".txt";

        File file = new File("src"+File.separator+"UserProfile" +File.separator+FILENAME);
        char []getUserInfoArray = new char[100];
        if(file.exists()){
            FileReader fileReader = new FileReader(file);
            fileReader.read(getUserInfoArray);
            String  findUserName, findUserID;
            findUserName="";
            findUserID="";

            int countIterator=0;
            boolean isFindTab = false;
            for(countIterator=0;getUserInfoArray[countIterator]!='\0';countIterator++){
                if(getUserInfoArray[countIterator]=='\t'){
                    isFindTab = true;
                    continue;
                }
                if(isFindTab==true){

                    findUserID = findUserID+getUserInfoArray[countIterator];
                }
                else{
                    findUserName = findUserName+getUserInfoArray[countIterator];
                }
            }

            findUserName = findUserName.trim();
            findUserID = findUserID.trim();
            System.out.println(userName+"---->"+findUserName);
            System.out.println(userID+"---->"+findUserID);

            if(findUserName.contains(userName)&&findUserID.equals(userID)){
                isFound =true;
            }
            else {
                FILENAME = userName+"2.txt";
                File file2 = new File("src"+File.separator+"UserProfile" +File.separator+FILENAME);
                 fileReader = new FileReader(file2);
                fileReader.read(getUserInfoArray);
                findUserName="";
                findUserID="";

                 countIterator=0;
                 isFindTab = false;
                for(countIterator=0;getUserInfoArray[countIterator]!='\0';countIterator++){
                    if(getUserInfoArray[countIterator]=='\t'){
                        isFindTab = true;
                        continue;
                    }
                    if(isFindTab==true){

                        findUserID = findUserID+getUserInfoArray[countIterator];
                    }
                    else{
                        findUserName = findUserName+getUserInfoArray[countIterator];
                    }
                }

                findUserName = findUserName.trim();
                findUserID = findUserID.trim();
                System.out.println(userName+"---->"+findUserName);
                System.out.println(userID+"---->"+findUserID);

                if(findUserName.contains(userName)&&findUserID.equals(userID)){
                    isFound =true;
                }
                else{
                    FILENAME = userName+"3.txt";
                    File file3 = new File("src"+File.separator+"UserProfile" +File.separator+FILENAME);
                    fileReader = new FileReader(file3);
                    fileReader.read(getUserInfoArray);
                    findUserName="";
                    findUserID="";

                    countIterator=0;
                    isFindTab = false;
                    for(countIterator=0;getUserInfoArray[countIterator]!='\0';countIterator++){
                        if(getUserInfoArray[countIterator]=='\t'){
                            isFindTab = true;
                            continue;
                        }
                        if(isFindTab==true){

                            findUserID = findUserID+getUserInfoArray[countIterator];
                        }
                        else{
                            findUserName = findUserName+getUserInfoArray[countIterator];
                        }
                    }

                    findUserName = findUserName.trim();
                    findUserID = findUserID.trim();
                    System.out.println(userName+"---->"+findUserName);
                    System.out.println(userID+"---->"+findUserID);

                    if(findUserName.contains(userName)&&findUserID.equals(userID)){
                        isFound =true;
                    }
                    else{
                        isFound =false;

                    }
                }
            }

        }

        return isFound;

    }
public void accountManagementFindRecommendedBookList(String userName,String userID){
    }

}
