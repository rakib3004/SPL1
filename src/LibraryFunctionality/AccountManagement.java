package LibraryFunctionality;

import java.io.File;
import java.io.IOException;

public class AccountManagement {
    public void accountManagementMethods(String [] infoDataArray , String [] addFavouriteBookType) throws IOException {

        String FILENAME = infoDataArray[0];

        File file = new File("UserProfile"+File.separator+FILENAME);
        if(file.exists()){
            FILENAME = FILENAME +"2";
            File file1 = new File("UserProfile"+File.separator+FILENAME);
            if(file1.exists()){
                FILENAME = FILENAME+"9";
                File file2 = new File("UserProfile"+File.separator+FILENAME);
                file2.createNewFile();
            }
            file1.createNewFile();
        }
        else {
            file.createNewFile();

        }
    }

}
