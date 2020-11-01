package LibraryFunctionality;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserList {

    public void addUser(String textUserID,String [] infoDataArray) throws IOException {

File file =new File("UserTable.txt");
        FileWriter fileWriter = new FileWriter(file);
        //user id------user name------user institute -------  higher/secondary---- class no/dept name
        fileWriter.write(textUserID+"\t"+infoDataArray[0]+"\t"+infoDataArray[1]+"\t"+infoDataArray[3]+"\t"+infoDataArray[2]+"\n");
   fileWriter.close();
    }

    public void parseUser(){

    }


}
