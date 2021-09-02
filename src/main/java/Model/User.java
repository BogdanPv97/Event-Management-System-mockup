package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private int user_id;

    private String firstName;
    private String lastName;

    private String username;
    private String password;

    private int age;
    private boolean admin;

    public User(String firstName,String lastName,String username,String password, int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.age=age;
        this.admin=false;
    }

    @Override
    public String toString(){
        return firstName+" | "+lastName+" | "+username+" | "+age;
    }
}
