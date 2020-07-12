import com.Registry;
import com.Resource;
import com.User;
import com.controllerApp;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

public class TestsApp {

    //---------------------BLACK-BOX---------------------------
    @Test
    public void TestLoginUserTestOK(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        assertNotNull(token);
    }

    @Test
    public void TestLoginUserTestBAD(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.in", "cityslicka");
        assertEquals("Bad Request", token);
    }

    @Test
    public void TestRegistryUserOK(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("eve.holt@reqres.in", "pistol", admin, token);
        assertNotNull(user);
    }

    @Test
    public void TestRegistryUserBAD(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.in", "pistol", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryWhithoutLogin(){
        controllerApp container= new controllerApp();
        String token = "teste";
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");

        Registry user = container.registryuser("eve.holt@reqres.in", "pistol", admin, token);
        assertNull(user);
    }

    @Test
    public void TestListingUsersOK(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);


        ArrayList<User> list_users = container.listingUsers(admin, token);
        assertNotEquals(0, list_users.size());
    }

    @Test
    public void TestListingUsersWithoutLogin(){
        controllerApp container= new controllerApp();
        String token = "teste";
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");

        ArrayList<User> list_users = container.listingUsers(admin, token);
        assertEquals(0, list_users.size());
    }

    @Test
    public void TestConsultingUserOK(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        User user = container.consultingUser(2, admin, token);
        assertNotNull(user);
    }

    @Test
    public void TestConsultingUserNotFound(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        User user = container.consultingUser(15, admin, token);
        assertNull(user);
    }

    @Test
    public void TestConsultingUserWithoutLogin(){
        controllerApp container= new controllerApp();
        String token = "teste";
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        User user = container.consultingUser(2, admin, token);
        assertNull(user);
    }

    @Test
    public void TestListingResourcesOK(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        ArrayList<Resource> list_resources = container.listingResources(admin, token);
        assertNotEquals(0, list_resources.size());
    }

    @Test
    public void TestListingResourcesWithoutLogin(){
        controllerApp container= new controllerApp();
        String token = "teste";
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");

        ArrayList<Resource> list_resources = container.listingResources(admin, token);
        assertEquals(0, list_resources.size());
    }

    @Test
    public void TestConsultingResourceOK(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Resource resource = container.consultingResource(2, admin, token);
        assertNotNull(resource);
    }

    @Test
    public void TestConsultingResourceNotFound(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Resource resource = container.consultingResource(15, admin, token);
        assertNull(resource);
    }

    @Test
    public void TestConsultingResourceWithoutLogin(){
        controllerApp container= new controllerApp();
        String token = "teste";
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");

        Resource resource = container.consultingResource(2, admin, token);
        assertNull(resource);
    }

    @Test
    public void TestCreateUserOK(){
        controllerApp container= new controllerApp();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);
        User newUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste", timestamp);

        assertTrue(container.createUser(newUser, admin, token));
    }

    @Test
    public void TestCreateUserWithoutLogin(){
        controllerApp container= new controllerApp();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String token = "teste";
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");
        User newUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste", timestamp);

        assertFalse(container.createUser(newUser, admin, token));
    }

    //Esperado registo com sucesso, mas não funciona
    @Test
    public void TestCreateAndRegisterUser(){
        controllerApp container= new controllerApp();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);
        User newUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste", timestamp);

        container.createUser(newUser, admin, token);
        Registry user = container.registryuser(newUser.getEmail(), "teste", admin, token);
        assertNotNull(user);
    }

    //Utilizador não é criado na Api (testado anteriormente), mas é adicionado na app
    @Test
    public void CreateAndListUsers(){
        controllerApp container= new controllerApp();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);
        User newUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste", timestamp);

        container.createUser(newUser, admin, token);
        ArrayList<User> list_users = container.listingUsers(admin, token);
        boolean exists = false;

        for(int i = 0; i < list_users.size(); i++){
            if(newUser == list_users.get(i)) exists = true;
        }

        assertTrue(exists);
    }

    //O utilizador não é criado na Api
    @Test
    public void CreateAndListSingleUser(){
        controllerApp container= new controllerApp();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);
        User newUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste", timestamp);

        container.createUser(newUser, admin, token);
        User user = container.consultingUser(20, admin, token);

        assertNull(user);
    }

    //-------------WHITE-BOX----------------
    @Test
    public void TestTokenValidated(){
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");
        String token = "QpwL5tke4Pnpja7X4";

        assertEquals(admin.getToken(), token);
    }

    @Test
    public void TestTokenNotValidated(){
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");
        String token = "teste";

        assertNotEquals(admin.getToken(), token);
    }
}
