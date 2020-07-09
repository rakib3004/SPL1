package LibraryFunctionality;

import FilePackage.DateTimeWriter;

import java.io.*;

public class AccountManagement {
    String textUserID;
    String  stringMembers="";
    char [] libraryMembers = new char[10];
    public String accountManagementSignUpMethods(String [] infoDataArray ,
                                                 String userChoiceList) throws IOException {

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
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
                
                fileReader.read(libraryMembers);
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
                    fileWriter.write(infoDataArray[0]+"\t"+textUserID+"\t"+infoDataArray[1]+"\t"+infoDataArray[2]+"\t"+infoDataArray[3]);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String membersString = Integer.toString(intMembers);
                try {
                    FileWriter fileWriter=new FileWriter(FILENAME_COUNT);
                    fileWriter.write(membersString);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FILENAME = userNameTemplate+"3ChoiceList.txt";
                File fileA3 = new File("src"+File.separator+"UserChoiceList" +File.separator+(FILENAME+".txt"));
                fileA3.createNewFile();
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
                fileReader.read(libraryMembers);
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
                    fileWriter.write(infoDataArray[0]+"\t"+textUserID+"\t"+infoDataArray[1]+"\t"+infoDataArray[2]+"\t"+infoDataArray[3]);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String membersString = Integer.toString(intMembers);
                try {
                    FileWriter fileWriter=new FileWriter(FILENAME_COUNT);
                    fileWriter.write(membersString);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FILENAME = userNameTemplate+"2ChoiceList.txt";
                File fileA2 = new File("src"+File.separator+"UserChoiceList" +File.separator+(FILENAME+".txt"));
                fileA2.createNewFile();
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
            
            fileReader.read(libraryMembers);
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
                FileWriter fileWriter=new FileWriter(file);
                fileWriter.write(infoDataArray[0]+"\t"+textUserID+"\t"+infoDataArray[1]+"\t"+infoDataArray[2]+"\t"+infoDataArray[3]);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String membersString = Integer.toString(intMembers);
            try {
     FileWriter fileWriter=new FileWriter(FILENAME_COUNT);
                fileWriter.write(membersString);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
FILENAME = userNameTemplate+"ChoiceList.txt";
            File fileA1 = new File("src"+File.separator+"UserChoiceList" +File.separator+(FILENAME+".txt"));
            fileA1.createNewFile();
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

        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

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
            boolean getID=false;
            for(countIterator=0;getUserInfoArray[countIterator]!='\0';countIterator++){
                if(getUserInfoArray[countIterator]=='\t'&&isFindTab==false){
                    isFindTab = true;
                    continue;
                }
                else if(getUserInfoArray[countIterator]=='\t'&&isFindTab==true){
                   break;
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
    public File[] accountManagementGetFileName(String userName, String userID) throws IOException {
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        boolean isFound = false;
        userName = userName.trim();
        String FILENAME = userName+".txt";
        String FILENAME2 = userName+"ChoiceList.txt";
        File [] fileObject = new File[2];

        File file = new File("src"+File.separator+"UserProfile" +File.separator+FILENAME);
        File fileA = new File("src"+File.separator+"UserChoiceList" +File.separator+FILENAME2);
        char []getUserInfoArray = new char[100];
        if(file.exists()){
            FileReader fileReader = new FileReader(file);
            fileReader.read(getUserInfoArray);
            String  findUserName, findUserID;
            findUserName="";
            findUserID="";
            int countIterator=0;
            boolean isFindTab = false;
            boolean getID=false;
            for(countIterator=0;getUserInfoArray[countIterator]!='\0';countIterator++){
                if(getUserInfoArray[countIterator]=='\t'&&isFindTab==false){
                    isFindTab = true;
                    continue;
                }
                else if(getUserInfoArray[countIterator]=='\t'&&isFindTab==true){
                    break;
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
            System.out.println(userName+"--2-->"+findUserName);
            System.out.println(userID+"--2-->"+findUserID);

            if(findUserName.contains(userName)&&findUserID.equals(userID)){
                isFound =true;
                fileObject[0] = file;
                fileObject[1] = fileA;
            }
            else {
                FILENAME = userName+"2.txt";
                FILENAME2 = userName+"2ChoiceList.txt";
                File file2 = new File("src"+File.separator+"UserProfile" +File.separator+FILENAME);
                File fileA2 = new File("src"+File.separator+"UserChoiceList" +File.separator+FILENAME2);

                fileReader = new FileReader(file2);
                fileReader.read(getUserInfoArray);
                findUserName="";
                findUserID="";

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
                System.out.println(userName+"--2-->"+findUserName);
                System.out.println(userID+"--2-->"+findUserID);

                if(findUserName.contains(userName)&&findUserID.equals(userID)){
                    isFound =true;
                    fileObject[0] = file2;
                    fileObject[1] = fileA2;
                }
                else{
                    FILENAME = userName+"3.txt";
                    FILENAME2 = userName+"3ChoiceList.txt";
                    File file3 = new File("src"+File.separator+"UserProfile" +File.separator+FILENAME);
                    File fileA3 = new File("src"+File.separator+"UserChoiceList" +File.separator+FILENAME2);

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
                    System.out.println(userName+"--2-->"+findUserName);
                    System.out.println(userID+"--2-->"+findUserID);

                    if(findUserName.contains(userName)&&findUserID.equals(userID)){
                        isFound =true;
                        fileObject[0] = file3;
                        fileObject[1] = fileA3;
                    }
                    else{
                        isFound =false;
                        fileObject[0] = null;
                        fileObject[1] = null;
                    }
                }
            }

        }
        return fileObject;
    }
public void accountManagementGetRecommendedBookList(String userName, String userID) throws IOException {
    String  className = this.getClass().getSimpleName();
    DateTimeWriter dateTimeWriter =  new DateTimeWriter();
    dateTimeWriter.dateTimeWriterMethods(className);
 File[] file=  accountManagementGetFileName(userName,userID);
UserChoiceTableData userChoiceTableData = new UserChoiceTableData();

    }

}
