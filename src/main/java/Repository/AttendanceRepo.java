package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AttendanceRepo {

    private String jdbcURL="jdbc:mysql://localhost:3306/event_management";

    private String user="root";
    private String password="root";

    private Connection connection=null;
    private Statement statement=null;

    public AttendanceRepo(){
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

    public void insertData(int userID, int eventID){
        String query=String.format("INSERT INTO attendance (user_id,event_id) values (%d,%d)",userID,eventID);

        executeStatement(query);
    }

    public void deleteData(int userID, int eventID){
        String query=String.format("DELETE FROM attendance WHERE user_id=%d AND event_id=%d",userID, eventID);

        executeStatement(query);
    }

    public void getEventAttendance(int eventID){
        String query=String.format("SELECT COUNT(user_id) FROM attendance WHERE event_id=%d",eventID);
    }
}
