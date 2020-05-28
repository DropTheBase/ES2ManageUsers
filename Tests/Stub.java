import com.API;
import com.User;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

public class Stub {

    @Test
    public void textListUsers(){
        List<User> result = API.listUsers();


    assertNotNull(result);
    }

    @Test
    public void testCreateUser(){
        User user = new User(2,"Martinho","Joao","adeus","ola");

        assert API.createUser(user);
    }
}
