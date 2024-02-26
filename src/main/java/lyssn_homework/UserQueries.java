package lyssn_homework;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserQueries {

    public static void main(String[] args) {
//        // Query all users and return a collection
//        // The collection is then printed to output;
//        ArrayList<User> allUsers = getAllUsers();
//        printUserArrayList(allUsers);

//        // Create a function that updates a user
//        User updatedUser = new User(12345, "michelle", "Von-Davis", "1999-01-08 04:05:06");
//        updateUserByID(12345, updatedUser);
//
//        // Query the db for a user by their userID
        User userById = getUserById(14893);
        System.out.println(userById);

    }

    public static ArrayList<User> getAllUsers() {
        String sqlString = "SELECT * FROM users";

        var users = new ArrayList<User>();

        try (var conn = DB.connect()) {
            assert conn != null;
            try (PreparedStatement getUsers = conn.prepareStatement(sqlString)) {
                var res = getUsers.executeQuery();
                while (res.next()) {
                    User user = new User(
                            res.getInt("userid"),
                            res.getString("fname"),
                            res.getString("lname"),
                            res.getString("signupdate")
                    );
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static void updateUserByID(int userID, User newUser) {
        String sqlString = "UPDATE users SET fname = ?, lname = ? WHERE userid = ?";

        try (var conn = DB.connect()) {
            assert conn != null;
            try (PreparedStatement updateUser = conn.prepareStatement(sqlString)) {
                updateUser.setString(1, newUser.fname);
                updateUser.setString(2, newUser.lname);
                updateUser.setInt(3, userID);
                updateUser.executeUpdate();
                System.out.println("User Updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getUserById(int userID) {
        String sqlString = "SELECT * FROM users WHERE userid = ?";

        try (var conn = DB.connect()) {
            assert conn != null;
            try (PreparedStatement getUser = conn.prepareStatement(sqlString)) {
                getUser.setInt(1, userID);
                var res = getUser.executeQuery();
                if (res.next()) {
                    return new User(
                            res.getInt("userid"),
                            res.getString("fname"),
                            res.getString("lname"),
                            res.getString("signupdate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new User(-99, null, null, null);
    }

    public static void printUserArrayList(ArrayList<User> userList) {
        for (User user : userList) {
            System.out.printf("First: %s, Last: %s, ID: %s, SignedUpOn: %s", user.fname, user.lname, user.userID, user.signupdate);
            System.out.println();
        }
    }
}
