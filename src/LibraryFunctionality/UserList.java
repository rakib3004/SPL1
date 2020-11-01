package LibraryFunctionality;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserList {

    public void addUser(String textUserID,String [] infoDataArray) throws IOException {

File file =new File("src"+File.separator+"LibraryFunctionality" +File.separator+"UserTable.txt");
        FileWriter fileWriter = new FileWriter(file);
        //user id------user name------user institute -------  higher/secondary---- class no/dept name
        fileWriter.write(textUserID+"\t"+infoDataArray[0]+"\t"+infoDataArray[1]+"\t"+infoDataArray[3]+"\t"+infoDataArray[2]+"\n");
   fileWriter.close();
    }


char [] userInfoData = new char[5000];

    LibraryUser [] libraryUser = new LibraryUser[1000];
    public  LibraryUser [] parseUser()throws IOException {
        File file =new File("src"+File.separator+"LibraryFunctionality" +File.separator+"UserTable.txt");
        FileReader fileReader = new FileReader(file);
        fileReader.read(userInfoData);
        fileReader.close();
        int userIterator=0;
         String userID;
         String userName;
         String userInstitute;
         String userEducationLevel;
         String userClass;
        String [] dataArray = new String[5];
        String dataCollector="";
        int dataIterator=0;
        int arrayIterator=0;
        for(dataIterator=0;userInfoData[dataIterator]!='\0';dataIterator++){

            if(userInfoData[dataIterator]=='\t'){
                dataCollector = dataCollector.trim();
                dataArray[arrayIterator]=dataCollector;
                arrayIterator++;
                dataCollector="";
            }
            else if(userInfoData[dataIterator]=='\n'){
                dataCollector = dataCollector.trim();
                dataArray[arrayIterator]=dataCollector;
                dataCollector="";
                userID = dataArray[0];
                userName = dataArray[1];
                userInstitute = dataArray[2];
                userEducationLevel = dataArray[3];
                userClass = dataArray[4];
                libraryUser[userIterator] = new LibraryUser(userID,userName,userInstitute,userEducationLevel,userClass);
                System.out.println(userID+"\t"+userName+"\t"+userInstitute+"\t"+userEducationLevel+"\t"+userClass);
                dataArray[0]="";
                dataArray[1]="";
                dataArray[2]="";
                dataArray[3]="";
                dataArray[4]="";
                arrayIterator=0;

            }
            else {
               dataCollector = dataCollector+userInfoData[dataIterator];
            }
        }
return  libraryUser;
    }


}
