import Model.User;
import Repository.UserRepo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UserRepoTest {

    @Test
    public void insertTest(){
        UserRepo repo=new UserRepo();

        User user=new User("Mike","Johnson","mike123","password",20);

        repo.insertUser(user);
    }

    @Test
    public void updateFirstNameTest(){
        UserRepo repo=new UserRepo();

        repo.updateFirstName("mike123","Michael");
    }

    @Test
    public void updateLastNameTest(){
        UserRepo repo=new UserRepo();

        repo.updateLastName("mike123","John");
    }

    @Test
    public void updateUsernameTest(){
        UserRepo repo=new UserRepo();

        repo.updateUsername("mike123","mike1234");
    }

    @Test
    public void updatePasswordTest(){
        UserRepo repo=new UserRepo();

        repo.updatePassword("mike1234","newPassword");
    }

    @Test
    public void updateAgeTest(){
        UserRepo repo=new UserRepo();

        repo.updateAge("mike1234",30);
    }

    @Test
    public void deleteTest(){
        UserRepo repo=new UserRepo();

        repo.deleteUser("mike1234");
    }

    @Test
    public void getUserIdTest(){
        UserRepo repo=new UserRepo();

       Assertions.assertEquals(9,repo.getUserID("mike123"));
    }
}
