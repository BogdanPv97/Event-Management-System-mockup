package View;

import Controller.UserController;
import Model.User;

import java.util.Scanner;

public class LoginView {

    private Scanner keyboard;
    private UserController userController;
    private UserView userView;

    public LoginView(){
        keyboard=new Scanner(System.in);
        userController=new UserController();
        userView=new UserView();
    }

    public void loginMenu(){
        System.out.println("--------MENU--------");
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. Exit");
    }

    public void play(){

        loginMenu();
        boolean validChoice=false;

        while(!validChoice){
            int choice=Integer.parseInt(keyboard.nextLine());

            switch(choice){
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    public void login(){
        String username;
        String password;
        boolean validCredential=false;

        while(!validCredential) {
            System.out.println("Username:");
            username = keyboard.nextLine();
            System.out.println("Password:");
            password = keyboard.nextLine();

            if(userController.validCredential(username,password)){
                validCredential=true;
                userView.play(username);
            }else{
                System.out.println("Invalid credentials!");
                play();
            }
        }
    }

    public void createAccount() {
        boolean validUsername = false;
        boolean validPassword = false;

        String firstName;
        String lastName;
        String username;
        String password;
        int age;

        System.out.println("Enter first name:");
        firstName = keyboard.nextLine();
        System.out.println("Enter last name:");
        lastName = keyboard.nextLine();
        System.out.println("Enter age:");
        age = Integer.parseInt(keyboard.nextLine());

        while (!validUsername || !validPassword) {
            System.out.println("Enter username:");
            username = keyboard.nextLine();
            if (userController.validUsername(username)) {
                validUsername = true;
            }
        System.out.println("Enter password:");
        System.out.println("Password should include:" + "\n" +
                "Numeric value [1-9]" + "\n" +
                "Uppercase and Lowercase letters[a-z][A-Z]" + "\n" +
                "At least one special character (@ # $ % ^ & *)" + "\n" +
                "The password length should be at lest 8 characters!");
        password = keyboard.nextLine();

        if (userController.securityCheck(password)) {
            validPassword = true;
        }else{
            System.out.println("Weak password! Try again");
        }

        if(validUsername && validPassword) {
            User user = new User(firstName, lastName, username, password, age);
            userController.addUser(user);
            System.out.println("Account created successfully");
            play();
            }else{
            System.out.println("Invalid user or password!");
        }
        }
    }
}
