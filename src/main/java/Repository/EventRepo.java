package Repository;

import Model.Event;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventRepo {

    private String jdbcURL="jdbc:mysql://localhost:3306/event_management";

    private String user="root";
    private String password="root";

    private Connection connection=null;
    private Statement statement=null;

    public EventRepo(){
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

    public int getEventID(String name, String location){
        String query=String.format("SELECT id FROM event WHERE name='%s' AND location='%s'",name,location);
        int eventID=-1;
        try {
            ResultSet result = statement.executeQuery(query);
            if(result.next()){
                eventID=result.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return eventID;
    }

    public void insertEvent(Event event){
        String insertQuery=String.format("INSERT INTO event (name,location,description,dateStart,dateEnd,size_limit,ageRestriction) " +
                "values ('%s','%s','%s','%s','%s',%d,%b)",event.getEventName(),event.getLocation(),event.getDescription(),event.getDateStart(),event.getDateEnd(),
                event.getSizeLimit(),event.isAgeRestriction());

        executeStatement(insertQuery);
    }

    public void deleteEvent(String name, String location){
        String deleteQuery=String.format("DELETE FROM event WHERE id=%d",getEventID(name,location));

        executeStatement(deleteQuery);
    }

    public void updateName(String name, String location, String newName){
        String updateNameQuery=String.format("UPDATE event SET name='%s' WHERE id=%d",newName,getEventID(name,location));

        executeStatement(updateNameQuery);
    }

    public void updateDescription(String name, String location, String newDescription){
        String updateDescriptionQuery=String.format("UPDATE event SET description='%s' WHERE id=%d", newDescription,getEventID(name,location));

        executeStatement(updateDescriptionQuery);
    }

    public void updateLocation(String name, String location, String newLocation){
        String updateLocationQuery=String.format("UPDATE event SET location='%s' WHERE id=%d",newLocation,getEventID(name,location));

        executeStatement(updateLocationQuery);
    }

    public void updateStartDate(String name, String location, LocalDateTime newDateStart){
        String updateDateStartQuery=String.format("UPDATE event SET dateStart='%s' WHERE id=%d",newDateStart,getEventID(name,location));

        executeStatement(updateDateStartQuery);
    }

    public void updateEndDate(String name, String location, LocalDateTime newDateEnd){
        String updateDateEndQuery=String.format("UPDATE event SET dateEnd='%s' WHERE id=%d",newDateEnd,getEventID(name,location));

        executeStatement(updateDateEndQuery);
    }

    public void updateSizeLimit(String name, String location, int newSizeLimit){
        String updateSizeLimitQuery=String.format("UPDATE event SET size_limit=%d WHERE id=%d",newSizeLimit,getEventID(name,location));

        executeStatement(updateSizeLimitQuery);
    }

    public void updateAgeRestriction(String name, String location, boolean newRestriction){
        String updateAgeRestrictionQuery=String.format("UPDATE event SET ageRestriction='%b' WHERE id=%d",newRestriction,getEventID(name, location));

        executeStatement(updateAgeRestrictionQuery);
    }

    public ResultSet allEvents(){
        String query="SELECT * FROM event";
        try{
            return statement.executeQuery(query);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Event> getAllEvents(){
        ResultSet set=allEvents();
        List<Event> events=new ArrayList<>();
        try {
            while (set.next()) {
                events.add(new Event(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getInt(7),set.getBoolean(8)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return events;
    }
}
