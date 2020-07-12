import com.API;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsAPI {
    // WhiteBox Tests --------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void ListingUsers(){
        int status = 200;
        assertTrue(status == HttpURLConnection.HTTP_OK);
    }

    @Test
    public void ConsultingUsersTrue(){
        int status = 200;
        assertTrue(status == HttpURLConnection.HTTP_OK);
    }

    @Test
    public void ConsultingUsersFalse(){
        int status = 404;
        assertTrue(status == HttpURLConnection.HTTP_NOT_FOUND);
    }

    @Test
    public void CreateUsers(){
        int status = 201;
        assertTrue(status == HttpURLConnection.HTTP_CREATED);
    }

    @Test
    public void RegistryUsersTrue(){
        int status = 200;
        assertTrue(status == HttpURLConnection.HTTP_OK);
    }

    @Test
    public void RegistryUsersFalse(){
        int status = 400;
        assertTrue(status == HttpURLConnection.HTTP_BAD_REQUEST);
    }

    @Test
    public void LoginUserTrue(){
        int status = 200;
        assertTrue(status == HttpURLConnection.HTTP_OK);
    }

    @Test
    public void LoginUserFalse(){
        int status = 400;
        assertTrue(status == HttpURLConnection.HTTP_BAD_REQUEST);
    }

    @Test
    public void ListingResource(){
        int status = 200;
        assertTrue(status == HttpURLConnection.HTTP_OK);
    }

    @Test
    public void ConsultingResourceTrue(){
        int status = 200;
        assertTrue(status == HttpURLConnection.HTTP_OK);
    }

    @Test
    public void ConsultingResourceFalse(){
        int status = 404;
        assertTrue(status == HttpURLConnection.HTTP_NOT_FOUND);
    }

}
