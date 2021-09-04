import Model.Event;
import Repository.EventRepo;
import org.junit.Test;

import java.time.LocalDateTime;

public class EventRepoTest {

    @Test
    public void addTest(){
        EventRepo repo=new EventRepo();

        Event event=new Event("event","stada1","descriere", LocalDateTime.of(2021,5,20,20,0),LocalDateTime.of(2021,5,21,9,0),200,false);

        repo.insertEvent(event);
    }


    @Test
    public void updateNameTest(){
        EventRepo repo=new EventRepo();

        repo.updateName("event","stada1","newEvent");
    }

    @Test
    public void updateLocationTest(){
        EventRepo repo=new EventRepo();

        repo.updateLocation("newEvent","stada1","strada1");
    }

    @Test
    public void updateDescriptionTest(){
        EventRepo repo=new EventRepo();

        repo.updateDescription("newEvent","strada1","new description about event");
    }

    @Test
    public void updateMaxNumberOfPeopleTest(){
        EventRepo repo=new EventRepo();

        repo.updateSizeLimit("newEvent","strada1",500);
    }

    @Test
    public void updateStartDate(){
        EventRepo repo=new EventRepo();

        repo.updateStartDate("newEvent","strada1",LocalDateTime.of(2021,5,19,20,0));
    }

    @Test
    public void updateEndDate(){
        EventRepo repo=new EventRepo();

        repo.updateEndDate("newEvent","strada1",LocalDateTime.of(2021,5,20,9,0));
    }

    @Test
    public void deleteTest(){
        EventRepo repo=new EventRepo();

        repo.deleteEvent("newEvent","strada1");
    }
}
