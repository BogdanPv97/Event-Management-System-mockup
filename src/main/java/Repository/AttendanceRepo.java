package Repository;

import java.sql.*;

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
            statement.execute(query);
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

    public int getEventAttendance(int eventID){
        String query=String.format("SELECT COUNT(user_id) FROM attendance WHERE event_id=%d",eventID);

        try {
            ResultSet result = statement.executeQuery(query);
            if(result.next())
                return result.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
