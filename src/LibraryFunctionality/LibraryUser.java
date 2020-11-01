package LibraryFunctionality;

public class LibraryUser {
    private String userID;
    private String userName;
    private String userInstitute;
    private String userEducationLevel;
    private String userClass;

    public LibraryUser() {
    }

    public LibraryUser(String userID, String userName, String userInstitute, String userEducationLevel, String userClass) {
        this.userID = userID;
        this.userName = userName;
        this.userInstitute = userInstitute;
        this.userEducationLevel = userEducationLevel;
        this.userClass = userClass;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserInstitute() {
        return userInstitute;
    }

    public void setUserInstitute(String userInstitute) {
        this.userInstitute = userInstitute;
    }

    public String getUserEducationLevel() {
        return userEducationLevel;
    }

    public void setUserEducationLevel(String userEducationLevel) {
        this.userEducationLevel = userEducationLevel;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }
}
