package View;

import Controller.EventController;
import Controller.UserController;
import Model.User;
import Repository.AttendanceRepo;
import Repository.InterestedRepo;

import java.util.Scanner;

public class UserView {

    private Scanner keyboard;
    private EventController eventController;
    private UserController userController;
    private AttendanceRepo attendanceRepo;
    private InterestedRepo interestedRepo;

    public UserView(){
        keyboard=new Scanner(System.in);
        eventController=new EventController();
        userController=new UserController();
        attendanceRepo=new AttendanceRepo();
        interestedRepo=new InterestedRepo();
    }

    public void userMenu(){
        System.out.println("--------MENU--------");
        System.out.println("1. View Events");
        System.out.println("2. Search for Event");
        System.out.println("3. Exit");
    }

    public void searchEventMenu(){
        System.out.println("1. Search by event name");
        System.out.println("2. Search by location");
    }

    public void eventSelectedMenu(){
        System.out.println("1. Going");
        System.out.println("2. Interested");
    }

    public void play(String username){
        System.out.println("Welcome "+userController.getUserByUsername(username).getFirstName());

        userMenu();

        boolean valid=false;

        while(!valid){
            int choice=Integer.parseInt(keyboard.nextLine());
            switch(choice){
                case 1:
                    viewEvents();
                    chooseEvent(username);
                    break;
                case 2:
                    searchEvent(username);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    public void chooseEvent(String username){
        int eventID;

        System.out.println("Select event ID:");
        eventID=Integer.parseInt(keyboard.nextLine());

        eventSelected(eventID,username);
    }

    public void viewEvents(){
        eventController.display();
    }

    public void searchEvent(String username){
        searchEventMenu();

        boolean valid=false;

        while(!valid){
            int choice=Integer.parseInt(keyboard.nextLine());
            switch(choice){
                case 1:
                    searchByName(username);
                    break;
                case 2:
                    searchByLocation();
                    break;
            }
        }
    }

    public void searchByName(String username){
        String eventName;
        int eventID;

        System.out.println("Enter event name:");
        eventName=keyboard.nextLine();

        if(eventController.getEventByName(eventName)==null){
            System.out.println("Event does not exist!");
        }else{
            System.out.println(eventController.getEventByName(eventName));
        }
        System.out.println("Choose event ID:");
        eventID=Integer.parseInt(keyboard.nextLine());

        eventSelected(eventID,username);


    }

    public void searchByLocation(){}

    public void eventSelected(int eventID, String username){
        System.out.println("------------------");
        System.out.println(eventController.getEventByID(eventID));
        eventSelectedMenu();
        boolean valid=false;

        while(!valid){
            int choice=Integer.parseInt(keyboard.nextLine());
            switch(choice){
                case 1:
                    attendanceRepo.insertData(eventID,userController.getUserByUsername(username).getUser_id());
                    System.out.println("You are going to "+eventController.getEventByID(eventID).getEventName());
                    play(username);
                    break;
                case 2:
                    interestedRepo.insertData(eventID,userController.getUserByUsername(username).getUser_id());
                    System.out.println("You are interested in: "+eventController.getEventByID(eventID).getEventName());
                    play(username);
                    break;
                case 3:
                    play(username);
                    break;
            }
        }
    }
}
