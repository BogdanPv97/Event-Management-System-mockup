package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Event {

    private int event_id;

    private String eventName;
    private String location;
    private String description;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private int sizeLimit;
    private boolean ageRestriction;
    private int going;
    private int interested;

    public Event(int event_id,String eventName,String location,String description, String dateStart, String dateEnd,int sizeLimit, boolean ageRestriction){
        this.event_id=event_id;
        this.eventName=eventName;
        this.location=location;
        this.description=description;
        this.dateStart=LocalDateTime.of(Integer.parseInt(dateStart.split("-")[0]),Integer.parseInt(dateStart.split("-")[1]),Integer.parseInt(dateStart.split("-")[2]),Integer.parseInt(dateStart.split("-")[3]),Integer.parseInt(dateStart.split("-")[4]));
        this.dateEnd=LocalDateTime.of(Integer.parseInt(dateEnd.split("-")[0]),Integer.parseInt(dateEnd.split("-")[1]),Integer.parseInt(dateEnd.split("-")[2]),Integer.parseInt(dateEnd.split("-")[3]),Integer.parseInt(dateEnd.split("-")[4]));
        this.sizeLimit=sizeLimit;
        this.ageRestriction=ageRestriction;
    }

    public Event(String eventName,String location,String description, LocalDateTime dateStart, LocalDateTime dateEnd,int sizeLimit, boolean ageRestriction){
        this.eventName=eventName;
        this.location=location;
        this.description=description;
        this.dateStart=dateStart;
        this.dateEnd=dateEnd;
        this.sizeLimit=sizeLimit;
        this.ageRestriction=ageRestriction;
    }

    @Override
    public String toString(){
        return "Event: "+eventName+"\n"+
                "Location: "+location+"\n"+
                "Details: "+description+"\n"+
                "Max number of people: "+sizeLimit;
    }
}
