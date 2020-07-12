import com.MateRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MateRequestTests {
    // BlackBox Tests -------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

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


}
