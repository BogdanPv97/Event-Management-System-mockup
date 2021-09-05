package Controller;

import Model.User;
import Repository.UserRepo;
import com.mysql.cj.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private List<User> users;
    private UserRepo userRepo;

    public UserController(){
        users=new ArrayList<>();
        userRepo=new UserRepo();
        loadRepo();
    }



    //CRUD
    public void addUser(User user){
        userRepo.insertUser(user);
        loadRepo();
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

    public boolean validUsername(String username){
        for(User user:users){
            if(user.getUsername().equals(username))
                return false;
        }

        return true;
    }

    public User getUserByUsername(String username){
        for(User user:users){
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public boolean validCredential(String username, String password){
        for(User user:users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    //Check if the password is strong enough
    public boolean securityCheck(String password){
        if(password.length()<8){
            return false;
        }

        Pattern pattern=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!.$%^&-+=()])(?=\\S+$).{8,20}$");
        Matcher matcher=pattern.matcher(password);

        if(!matcher.find()){
            return false;
        }
        return true;
    }

    public void loadRepo(){
        users.clear();
        users.addAll(userRepo.getAllUsers());
    }

}
