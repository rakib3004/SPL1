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

    public Library(String userID, String userName, String userInstitute, String userEducationLevel, Class<? extends LibraryUser> aClass) {

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
