package com.example.mathns.vo;

public class User {

    private String userID;
    private String userPassword;
    private String userName;
    private String userEmail;
    private String userNickname;
    private Integer userLevel;

    public User(String userID, String userPassword, String userName, String userEmail, String userNickname, Integer userLevel){
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        this.userLevel = userLevel;
    }
    public User(){

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return "user{" +
                "userID='" + userID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userLevel=" + userLevel +
                '}';
    }
}
