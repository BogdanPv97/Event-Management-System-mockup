import Controller.UserController;
import Model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class UserControllerTest {



    @Test
    public void SecurityCheckTest(){
        UserController controller= new UserController();

        String pass1="asd3#ljg";
        String pass2="Asd1#.";
        String pass3="Asdffg32#";

        Assertions.assertEquals(false,controller.securityCheck(pass1));
        System.out.println(1);
        Assertions.assertEquals(false,controller.securityCheck(pass2));
        System.out.println(2);
        Assertions.assertEquals(true,controller.securityCheck(pass3));
        System.out.println(3);

    }

    @Test
    public void validUsernameTest(){
        UserController controller=new UserController();

        User user=new User("Bogdan","Paval","bogdan123","bogdan123",24);
        User user2=new User("bgd","bgd","bogdan123","bogdan321",20);

        controller.addUser(user);
        Assertions.assertEquals(false,controller.validUsername(user2.getUsername()));
    }
}
