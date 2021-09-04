package Controller;

import Model.Event;
import Repository.AttendanceRepo;
import Repository.EventRepo;
import Repository.InterestedRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventController {

    private List<Event> events;
    private EventRepo eventRepo;
    private AttendanceRepo attendanceRepo;
    private InterestedRepo interestedRepo;

    public EventController(){
        events=new ArrayList<>();
        eventRepo=new EventRepo();
        attendanceRepo=new AttendanceRepo();
        interestedRepo=new InterestedRepo();
        loadRepo();
    }

    //CRUD
    public void addEvent(Event event){
        eventRepo.insertEvent(event);
        loadRepo();
    }

    public void deleteEvent(String name, String location){
        eventRepo.deleteEvent(name,location);
    }

    public void updateName(String name, String location, String newName){
        eventRepo.updateName(name,location,newName);
    }

    public void updateLocation(String name, String location, String newLocation){
        eventRepo.updateLocation(name,location,newLocation);
    }

    public void updateDescription(String name, String location, String newDescription){
        eventRepo.updateDescription(name,location,newDescription);
    }

    public void updateDateStart(String name, String location, LocalDateTime newDateStart){
        eventRepo.updateStartDate(name,location,newDateStart);
    }

    public void updateDateEnd(String name, String location, LocalDateTime newDateEnd){
        eventRepo.updateEndDate(name,location,newDateEnd);
    }

    public void updateSizeLimit(String name, String location, int newSizeLimit){
        eventRepo.updateSizeLimit(name,location,newSizeLimit);
    }

    public void updateAgeRestriction(String name, String location, boolean restriction){
        eventRepo.updateAgeRestriction(name,location,restriction);
    }

    public void display(){
        for(Event event:events){
            System.out.println(event);
        }
    }

    public int getInterested(int eventID){
        return interestedRepo.InterestedInEvent(eventID);
    }

    public int getGoing(int eventID){
        return attendanceRepo.getEventAttendance(eventID);
    }

    public void loadRepo(){
        events.clear();
        events.addAll(eventRepo.getAllEvents());
    }
}
