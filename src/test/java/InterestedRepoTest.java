import Repository.InterestedRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class InterestedRepoTest {

    @Test
    public void insertDataTest(){
        InterestedRepo repo=new InterestedRepo();

        repo.addData(6,4);
    }

    @Test
    public void getInterestedTest(){
        InterestedRepo repo=new InterestedRepo();

        Assertions.assertEquals(1,repo.InterestedInEvent(4));
    }

    @Test
    public void deleteDataTest(){
        InterestedRepo repo=new InterestedRepo();

        repo.deleteData(6,4);
    }
}
