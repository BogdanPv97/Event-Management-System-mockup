import Model.Event;
import Model.User;
import Repository.AttendanceRepo;
import Repository.EventRepo;
import Repository.UserRepo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

public class AttendanceRepoTest {

    @Test
    public void insertDataTest(){
        AttendanceRepo repo=new AttendanceRepo();
        UserRepo userRepo=new UserRepo();
        EventRepo eventRepo=new EventRepo();

        User user=new User("Bogdan","Bogdan","bogdan1234","bogdan1234",24);
        Event event=new Event("name","stada2","acesta este un eveniment", LocalDateTime.of(2021,5,20,20,0),LocalDateTime.of(2021,5,21,4,0),200,true);

        userRepo.insertUser(user);
        eventRepo.insertEvent(event);

        repo.insertData(userRepo.getUserID(user.getUsername()),eventRepo.getEventID(event.getEventName(),event.getLocation()));

        //Check into database that the data was correctly inserted
    }

    @Test
    public void deleteDataTest(){
        AttendanceRepo repo=new AttendanceRepo();
        UserRepo userRepo=new UserRepo();
        EventRepo eventRepo=new EventRepo();

        User user=new User("Bogdan","Bogdan","test","bogdan1234",24);
        Event event=new Event("name","stada2","acesta este un eveniment", LocalDateTime.of(2021,5,20,20,0),LocalDateTime.of(2021,5,21,4,0),200,true);

       // userRepo.insertUser(user);
       // eventRepo.insertEvent(event);

        //repo.insertData(userRepo.getUserID(user.getUsername()),eventRepo.getEventID(event.getEventName(),event.getLocation()));
        repo.deleteData(6,2);

        //Check into database that the data was correctly deleted
    }

    @Test
    public void getAttendance(){
        AttendanceRepo repo=new AttendanceRepo();

        Assertions.assertEquals(1,repo.getEventAttendance(2));
    }
}
