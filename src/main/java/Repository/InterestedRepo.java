package Repository;

import java.sql.*;

public class InterestedRepo {

    private String jdbcURL="jdbc:mysql://localhost:3306/event_management";

    private String user="root";
    private String password="root";

    private Connection connection=null;
    private Statement statement=null;

    public InterestedRepo(){
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
        String query=String.format("INSERT INTO interested (user_id,event_id) values (%d, %d)",userID,eventID);

        executeStatement(query);
    }

    public void deleteData(int userID, int eventID){
        String query=String.format("DELETE FROM interested WHERE user_id=%d AND event_id=%d",userID, eventID);

        executeStatement(query);
    }

    public int InterestedInEvent(int eventID){
        String query=String.format("SELECT COUNT(user_id) FROM interested WHERE event_id=%d",eventID);

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
