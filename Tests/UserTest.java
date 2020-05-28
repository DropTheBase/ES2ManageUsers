import com.User;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    public JSONObject userAddJson(){
        JSONObject json = new JSONObject();
        json.put("id", 1);
        json.put("email", "t");
        json.put("first_name", "t");
        json.put("last_name", "t");
        json.put("avatar", "t");

        return json;
    }

    @Test
    public void testToJson(){

        User user = new User(1,"t","t","t","t");

        Assertions.assertEquals(user.toJson().toString(),userAddJson().toString());

    }

}
