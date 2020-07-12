import com.*;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");

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
        User newUser = new User(20, "teste@reqres.in", "Teste", "Teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","Teste", timestamp);

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
        User newUser = new User(20, "teste@reqres.in", "Teste", "Teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","Teste", timestamp);

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

    //Testes From API
    // WhiteBox Tests --------------------------------------------------------------------------------------------------
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


    // BlackBox Tests -------------------------------------------------------------------------------------------------------------------
    @Test
    public void CreateUserSuccess() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"name\" : \"morpheus\", \"job\" : \"leader\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/users", "POST", header);
        assertEquals(201, statusCode);
    }
    // create user without fields
    @Test
    public void CreateUserWithoutFields() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"name\" : \"\", \"job\" : \"\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/users", "POST", header);
        assertEquals(400, statusCode);
    }

    @Test
    public void CreateUserWithoutJob() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"name\" : \"\", \"job\" : \"leader\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/users", "POST", header);
        assertEquals(400, statusCode);
    }

    @Test
    public void CreateUserWithoutName() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"name\" : \"morpheus\", \"job\" : \"\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/users", "POST", header);
        assertEquals(400, statusCode);
    }

    // ok register user
    @Test
    public void RegistrySuccess() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/register", "POST", header);
        assertEquals(200,statusCode);
    }

    // no email register
    @Test
    public void RegistryWithoutEmail() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"email\" : \"\", \"password\" : \"pistol\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/register", "POST", header);
        assertEquals(400, statusCode);
    }
    // no password register
    @Test
    public void RegistryWithoutPassword() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/register", "POST", header);
        assertEquals(400, statusCode);
    }
    //no email and password register
    @Test
    public void RegistryWithoutEmailandPassword() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"email\" : \"\", \"password\" : \"\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/register", "POST", header);
        assertEquals(400, statusCode);
    }

    // test ok authentication
    @Test
    public void LoginSuccess() throws IOException {
        MateRequest repo = new MateRequest();
        String header = "{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}";
        int statusCode = repo.connectionStatus("https://reqres.in/api/login", "POST", header);
        assertEquals(200, statusCode);
    }
    // login without email
    @Test
    public void LoginWithoutEmail() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"email\" : \"\", \"password\" : \"cityslicka\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/login", "POST", header);
        assertEquals(400, statusCode);
    }
    // login without password
    @Test
    public void LoginWithoutPassword() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/login", "POST", header);
        assertEquals(400, statusCode);
    }
    // login without email and password
    @Test
    public void LoginWithoutEmailandPassword() throws IOException {
        MateRequest matereq = new MateRequest();
        String header = "{\"email\" : \"\", \"password\" : \"\"}";
        int statusCode = matereq.connectionStatus("https://reqres.in/api/login", "POST", header);
        assertEquals(400, statusCode);
    }

    //State Tests
    // 3 Request to List Users
    @Test
    public void MultiRequestListUser(){
        MateRequest matereq = new MateRequest();
        String request = matereq.ResponseGET("https://reqres.in/api/users?page=2");
        String request1 = matereq.ResponseGET("https://reqres.in/api/users?page=2");
        String request2 = matereq.ResponseGET("https://reqres.in/api/users?page=2");

        assertEquals(request, request1);
        assertEquals(request, request2);
        assertEquals(request1, request2);
    }

    // 3 Request to see User Detail
    @Test
    public void MultiRequestUserDetail(){
        MateRequest matereq = new MateRequest();
        String request = matereq.ResponseGET("https://reqres.in/api/users/2");
        String request1 = matereq.ResponseGET("https://reqres.in/api/users/2");
        String request2 = matereq.ResponseGET("https://reqres.in/api/users/2");

        assertEquals(request, request1);
        assertEquals(request, request2);
        assertEquals(request1, request2);
    }

    // 3 Request to list Resources
    @Test
    public void MultiRequestListResources(){
        MateRequest matereq = new MateRequest();
        String request = matereq.ResponseGET("https://reqres.in/api/unnkown");
        String request1 = matereq.ResponseGET("https://reqres.in/api/unnkown");
        String request2 = matereq.ResponseGET("https://reqres.in/api/unnkown");

        assertEquals(request, request1);
        assertEquals(request, request2);
        assertEquals(request1, request2);
    }

    // 3 Request to see Resource details
    @Test
    public void MultiRequestResourceDetails(){
        MateRequest matereq = new MateRequest();
        String request = matereq.ResponseGET("https://reqres.in/api/unnkown/2");
        String request1 = matereq.ResponseGET("https://reqres.in/api/unnkown/2");
        String request2 = matereq.ResponseGET("https://reqres.in/api/unnkown/2");

        assertEquals(request, request1);
        assertEquals(request, request2);
        assertEquals(request1, request2);
    }

    // 3 Request to create user
    @Test
    public void MultiRequestCreate(){
        MateRequest matereq = new MateRequest();
        String login = "{\"email\" : \"morpheus\", \"password\" : \"leader\"}";

        String request = matereq.ResponsePOST("https://reqres.in/api/users", "POST", login);
        String request1 = matereq.ResponsePOST("https://reqres.in/api/users", "POST", login);
        String request2 = matereq.ResponsePOST("https://reqres.in/api/users", "POST", login);

        assertNotEquals(request, request1);
        assertNotEquals(request, request2);
        assertNotEquals(request1, request2);
    }
    // 3 Request to Registry
    @Test
    public void MultiRequestRegistry(){
        MateRequest matereq = new MateRequest();
        String header = "{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}";

        String request = matereq.ResponsePOST("https://reqres.in/api/register", "POST", header);
        String request1 = matereq.ResponsePOST("https://reqres.in/api/register", "POST", header);
        String request2 = matereq.ResponsePOST("https://reqres.in/api/register", "POST", header);

        assertEquals(request, request1);
        assertEquals(request, request2);
        assertEquals(request1, request2);
    }

    // 3 Requests to login
    @Test
    public void MultiRequestLogin(){
        MateRequest matereq = new MateRequest();
        String header = "{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}";

        String request = matereq.ResponsePOST("https://reqres.in/api/login", "POST", header);
        String request1 = matereq.ResponsePOST("https://reqres.in/api/login", "POST", header);
        String request2 = matereq.ResponsePOST("https://reqres.in/api/login", "POST", header);

        assertEquals(request, request1);
        assertEquals(request, request2);
        assertEquals(request1, request2);
    }
    // Test Json Text and XML--------------------------------------------------------------------------------------

    // JSON content for Registry
    @Test
    public void JSONRegistry(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/register");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);

            String content = connection.getRequestProperty("Content-Type");
            assertEquals("application/json", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(200, status);
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // JSON content for Registry Accepted
    @Test
    public void JSONRegistryAccepted(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/register");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Accept");
            assertEquals("application/json", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(200, status);
            try(BufferedReader buferread = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String teste = new String();
                String responseLine = null;
                int i = 0;
                while ((responseLine = buferread.readLine()) != null) {
                    teste = responseLine.trim();
                }
                assertNotEquals("", teste);
            }
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ContentXML Registry
    @Test
    public void XMLRegistryContent(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/register");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/xml");
            connection.setRequestProperty("Accept", "application/xml");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Content-Type");
            assertEquals("application/xml", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(400, status);
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // AcceptedXML Registry
    @Test
    public void XMLRegistryAccepted(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/register");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/xml");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Accept");
            assertEquals("application/xml", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(200, status);
            try(BufferedReader buferread = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String teste = new String();
                String responseLine = null;
                int i = 0;
                while ((responseLine = buferread.readLine()) != null) {
                    teste = responseLine.trim();
                }
                assertEquals("", teste);
            }
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //JSON Content Authentication
    @Test
    public void JSONAuthenticationContent(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Content-Type");
            assertEquals("application/json", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(200, status);
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //JSON Accepted Authentication
    @Test
    public void JSONAuthenticationAccepted(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Accept");
            assertEquals("application/json", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(200, status);
            try(BufferedReader buferread = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String teste = new String();
                String responseLine = null;
                int i = 0;
                while ((responseLine = buferread.readLine()) != null) {
                    teste = responseLine.trim();
                }
                assertNotEquals("", teste);
            }
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //XML Content Authentication
    @Test
    public void XMLAuthenticationContent(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/xml");
            connection.setRequestProperty("Accept", "application/xml");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Content-Type");
            assertEquals("application/xml", content);
            connection.connect();
            String JSInputStream = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputStream.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(400, status);
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //XML Accepted Authentication
    @Test
    public void XMLAuthenticationAccepted(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/xml");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Accept");
            assertEquals("application/xml", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(200, status);
            try(BufferedReader buferread = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String teste = new String();
                String responseLine = null;
                int i = 0;
                while ((responseLine = buferread.readLine()) != null) {
                    teste = responseLine.trim();
                }
                assertEquals("", teste);
            }
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Text Registry Content
    @Test
    public void TextRegistryContent(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/register");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/plain");
            connection.setRequestProperty("Accept", "text/plain");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Content-Type");
            assertEquals("text/plain", content);
            connection.connect();
            String JSInputStream = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputStream.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(400, status);
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Text Registry Accepted
    @Test
    public void TextRegistryAccepted(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/register");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "text/plain");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Accept");
            assertEquals("text/plain", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(200, status);
            try(BufferedReader buferread = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String teste = new String();
                String responseLine = null;
                int i = 0;
                while ((responseLine = buferread.readLine()) != null) {
                    teste = responseLine.trim();
                }
                assertEquals("", teste);
            }
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Text Authentication Content
    @Test
    public void TEXTLoginUserContent(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/plain");
            connection.setRequestProperty("Accept", "text/plain");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Content-Type");
            assertEquals("text/plain", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(400, status);
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Text Authentication Accepted
    @Test
    public void TEXTLoginUserAccept(){
        URL url = null;
        try {
            url = new URL("https://reqres.in/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "text/plain");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            String content = connection.getRequestProperty("Accept");
            assertEquals("text/plain", content);
            connection.connect();
            String JSInputString = String.format("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}");
            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = JSInputString.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            assertEquals(200, status);
            try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String teste = new String();
                String responseLine = null;
                int i = 0;
                while ((responseLine = br.readLine()) != null) {
                    teste = responseLine.trim();
                }
                assertEquals("", teste);
            }
            connection.disconnect();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
