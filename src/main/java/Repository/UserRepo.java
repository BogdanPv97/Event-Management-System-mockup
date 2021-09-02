package Repository;

import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    private String jdbcURL="jdbc:mysql://localhost:3306/event_management";

    private String user="root";
    private String password="root";

    private Connection connection=null;
    private Statement statement=null;

    public UserRepo(){
        try{
            connection= DriverManager.getConnection(jdbcURL,user,password);
            statement= connection.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void executeStatement(String query){
        try{
            statement.executeQuery(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int getUserID(String username){
        String query=String.format("SELECT id FROM user WHERE username='%s'",username);
        int userID=-1;
        try{
            ResultSet result=statement.executeQuery(query);
            if(result.next())
                userID=result.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return userID;
    }

    public void insertUser(User user){
        String insertQuery=String.format("INSERT INTO user (first_name,last_name,username,password,age) " +
                "values ('%s','%s','%s','%s',%d)",user.getFirstName(),user.getLastName(),user.getUsername(),user.getPassword(),user.getAge());

        executeStatement(insertQuery);
    }

    public void deleteUser(String username){
        String deleteQuery=String.format("DELETE FROM user WHERE id=%d",getUserID(username));

        executeStatement(deleteQuery);
    }

    public void updateFirstName(String username, String newFirstName){
        String updateFirstNameQuery=String.format("UPDATE user SET first_name='%s' where id=%d",newFirstName,getUserID(username));

        executeStatement(updateFirstNameQuery);
    }

    public void updateLastName(String username, String newLastName){
        String updateLastNameQuery=String.format("UPDATE user SET last_name='%s' where id=%d",newLastName,getUserID(username));

        executeStatement(updateLastNameQuery);
    }

    public void updateUsername(String username, String newUsername){
        String updateUsernameQuery=String.format("UPDATE user SET username='%s' where id=%d",newUsername,getUserID(username));

        executeStatement(updateUsernameQuery);
    }

    public void updatePassword(String username, String newPassword){
        String updatePasswordQuery=String.format("UPDATE user SET Password='%s' where id=%d",newPassword,getUserID(username));

        executeStatement(updatePasswordQuery);
    }

    public void updateAge(String username, int newAge){
        String updateAgeQuery=String.format("UPDATE user SET age=%d where id=%d",newAge,getUserID(username));

        executeStatement(updateAgeQuery);
    }

    public ResultSet allUsers(){
        String query=String.format("SELECT * FROM user");
        try{
            return statement.executeQuery(query);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAllUsers(){
        List<User> users=new ArrayList<>();
        ResultSet set=allUsers();

        try{
            while(set.next())
                users.add(new User(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getInt(6),set.getBoolean(7)));
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }
}
