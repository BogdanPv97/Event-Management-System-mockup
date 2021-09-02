package Controller;

import Model.User;
import Repository.UserRepo;
import com.mysql.cj.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<User> users;
    private UserRepo userRepo;

    public UserController(){
        users=new ArrayList<>();
        userRepo=new UserRepo();
        loadRepo();
    }

    public boolean validUsername(String username){
        for(User user:users){
            if(user.getUsername().equals(username))
                return false;
        }

        return true;
    }

    //CRUD
    public void addUser(User user){
        userRepo.insertUser(user);
    }

    public void deleteUser(String username){
        userRepo.deleteUser(username);
    }

    public void updateFirstName(String username, String newFirstName){
        userRepo.updateFirstName(username,newFirstName);
    }

    public void updateLastName(String username, String newLastName){
        userRepo.updateLastName(username,newLastName);
    }

    public void updateUsername(String username, String newUsername){
        userRepo.updateUsername(username, newUsername);
    }

    public void updatePassword(String username, String newPassword){
        userRepo.updatePassword(username, newPassword);
    }

    public void updateAge(String username, int newAge){
        userRepo.updateAge(username, newAge);
    }

    public void displayUsers(){
        for(User user:users){
            System.out.println(user);
        }
    }

    //Check if the password is strong enough
    public boolean securityCheck(String password){

        boolean lowercase=false;
        boolean uppercase=false;
        boolean digit=false;

        if(password.length()<8){
            return false;
        }
        if(!password.contains("@") || !password.contains("#") || !password.contains("$") || !password.contains("%") || !password.contains("^") || !password.contains("&")){
            return false;
        }
        for(int i=0;i<password.length();i++){
            if(Character.isDigit(i))
                digit=true;
            if(Character.isUpperCase(i))
                uppercase=true;
            if(Character.isLowerCase(i))
                lowercase=true;
        }

        if(!digit==true || !uppercase==true || !lowercase==true){
            return false;
        }

        return true;
    }

    public void loadRepo(){
        users.addAll(userRepo.getAllUsers());
    }
}
