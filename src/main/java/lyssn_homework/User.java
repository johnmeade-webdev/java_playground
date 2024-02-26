package lyssn_homework;

public class User {
    int userID;
    String fname, lname, signupdate;

    public User(int id, String fn, String ln, String signupdate) {
        this.userID = id;
        this.fname = fn;
        this.lname = ln;
        this.signupdate = signupdate;
    }
}
