package Utility;

import Model.Event;
import Controller.EventController;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

    EventController eventController=new EventController();

    @Override
    public int compare(Event o1, Event o2) {

        if(eventController.getGoing(o1.getEvent_id())==eventController.getGoing(o2.getEvent_id()))
            return 0;
        else if(eventController.getGoing(o1.getEvent_id())<eventController.getGoing(o2.getEvent_id()))
            return -1;
        else
            return 1;
    }
}
