package LibraryFunctionality;
import javafx.beans.property.SimpleStringProperty;

public class Library {
    private SimpleStringProperty userID;
    private SimpleStringProperty userName;
    private SimpleStringProperty userInstitute;
    private SimpleStringProperty userEducationLevel;
    private SimpleStringProperty userClass;

    public Library(SimpleStringProperty userID,
                   SimpleStringProperty userName,
                   SimpleStringProperty userInstitute,
                   SimpleStringProperty userEducationLevel,
                   SimpleStringProperty userClass) {
        this.userID = userID;
        this.userName = userName;
        this.userInstitute = userInstitute;
        this.userEducationLevel = userEducationLevel;
        this.userClass = userClass;
    }

    public Library(String userID1, String userName1, String userInstitute1, String userEducationLevel1, String userClass1) {
        this.userID1 = userID1;
        this.userName1 = userName1;
        this.userInstitute1 = userInstitute1;
        this.userEducationLevel1 = userEducationLevel1;
        this.userClass1 = userClass1;
    }



    private String userID1;
    private String userName1;
    private String userInstitute1;
    private String userEducationLevel1;
    private String userClass1;

    public String getUserID1() {
        return userID1;
    }

    public void setUserID1(String userID1) {
        this.userID1 = userID1;
    }

    public String getUserName1() {
        return userName1;
    }

    public void setUserName1(String userName1) {
        this.userName1 = userName1;
    }

    public String getUserInstitute1() {
        return userInstitute1;
    }

    public void setUserInstitute1(String userInstitute1) {
        this.userInstitute1 = userInstitute1;
    }

    public String getUserEducationLevel1() {
        return userEducationLevel1;
    }

    public void setUserEducationLevel1(String userEducationLevel1) {
        this.userEducationLevel1 = userEducationLevel1;
    }

    public String getUserClass1() {
        return userClass1;
    }

    public void setUserClass1(String userClass1) {
        this.userClass1 = userClass1;
    }

    public String getUserID() {
        return userID.get();
    }

    public SimpleStringProperty userIDProperty() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID.set(userID);
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getUserInstitute() {
        return userInstitute.get();
    }

    public SimpleStringProperty userInstituteProperty() {
        return userInstitute;
    }

    public void setUserInstitute(String userInstitute) {
        this.userInstitute.set(userInstitute);
    }

    public String getUserEducationLevel() {
        return userEducationLevel.get();
    }

    public SimpleStringProperty userEducationLevelProperty() {
        return userEducationLevel;
    }

    public void setUserEducationLevel(String userEducationLevel) {
        this.userEducationLevel.set(userEducationLevel);
    }

    public String getUserClass() {
        return userClass.get();
    }

    public SimpleStringProperty userClassProperty() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass.set(userClass);
    }
}
