package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class Event implements Comparable<Event>{

    private int event_id;

    private String eventName;
    private String location;
    private String description;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private int sizeLimit;
    private boolean ageRestriction;

    public Event(int event_id,String eventName,String location,String description, String dateStart, String dateEnd,int sizeLimit, boolean ageRestriction){
        this.event_id=event_id;
        this.eventName=eventName;
        this.location=location;
        this.description=description;
        this.dateStart=stringToDate(dateStart);
        this.dateEnd=stringToDate(dateEnd);
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
        return "ID:"+event_id+"\n"+
                "Event: "+eventName+"\n"+
                "Location: "+location+"\n"+
                "Details: "+description+"\n"+
                "Max number of people: "+sizeLimit+"\n"+
                "Event starts on "+dateStart+" until "+dateEnd+"\n";
    }

    public LocalDateTime stringToDate(String date){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime formatted=LocalDateTime.parse(date,formatter);

        return formatted;
    }

    @Override
    public int compareTo(Event o) {
       return this.eventName.compareTo(o.getEventName());
    }
}
