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
    /*-------------------------------------------------- Login User ----------------------------------------------*/
    @Test
    public void TestLoginUserTestOK(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        assertNotNull(token);
    }

    @Test
    public void TestLoginUserTestBAD(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.in", "#1Cityslicka");
        assertEquals("Bad Request", token);
    }

    @Test
    public void TestLoginUserMissingEmailAndPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("", "");
        assertEquals("Missing Email and Password", token);
    }

    @Test
    public void TestLoginUserInvalidEmailAndPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.i", "#1City");
        assertEquals("Invalid Email and Password", token);
    }

    @Test
    public void TestLoginUserMissingEmailAndInvalidPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("", "cityslicka");
        assertEquals("Missing Email and Invalid Password", token);
    }

    @Test
    public void TestLoginUserInvalidEmailAndMissingPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.i", "");
        assertEquals("Invalid Email and Missing Password", token);
    }

    @Test
    public void TestLoginUserMissingPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "");
        assertEquals("Missing Password", token);
    }

    @Test
    public void TestLoginUserInvalidPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.in", "cityslika");
        assertEquals("Invalid Password", token);
    }

    @Test
    public void TestLoginUserMissingEmail(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("", "#1Cityslicka");
        assertEquals("Missing Email", token);
    }

    @Test
    public void TestLoginUserMinCaracterInvalidEmail(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.i", "#1Cityslicka");
        assertEquals("Invalid Email", token);
    }

    @Test
    public void TestLoginUserMaxCaracterEmailInvalid(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.invalid", "#1Cityslicka");
        assertEquals("Invalid Email", token);
    }

    @Test
    public void TestLoginUserWithoutArrobaEmailInvalid(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredoreqres.in", "#1Cityslicka");
        assertEquals("Invalid Email", token);
    }

    @Test
    public void TestLoginUserWithoutDomainEmailInvalid(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@.in", "#1Cityslicka");
        assertEquals("Invalid Email", token);
    }

    @Test
    public void TestLoginUserWithoutDotEmailInvalid(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqrescom", "#1Cityslicka");
        assertEquals("Invalid Email", token);
    }

    @Test
    public void TestLoginUserWithoutDotinEmailInvalid(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres", "#1Cityslicka");
        assertEquals("Invalid Email", token);
    }

    @Test
    public void TestLoginUserWithoutBrunoFigueiredoEmailInvalid(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("@reqres.in", "#1Cityslicka");
        assertEquals("Invalid Email", token);
    }

    @Test
    public void TestLoginUserMinCaracterInvalidPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.in", "#1City");
        assertEquals("Invalid Password", token);
    }

    @Test
    public void TestLoginUserMaxCaracterInvalidPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.in", "#1Cityslikaacimade30caracteresassimsim");
        assertEquals("Invalid Password", token);
    }

    @Test
    public void TestLoginUserWithoutUpperLetterInvalidPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.in", "#1cityslika");
        assertEquals("Invalid Password", token);
    }

    @Test
    public void TestLoginUserWithoutNumbersInvalidPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.in", "#Cityslika");
        assertEquals("Invalid Password", token);
    }

    @Test
    public void TestLoginUserWithoutCardinalInvalidPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.figueiredo@reqres.in", "1Cityslika");
        assertEquals("Invalid Password", token);
    }

    @Test
    public void TestLoginUserWithEmailAccent(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("bruno.fígueiredo@reqres.in", "#1Cityslika");
        assertEquals("Invalid Email", token);
    }


    /*-------------------------------------------------- Create User ----------------------------------------------*/
    @Test
    public void TestCreateUserOK(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertTrue(container.createUser("Teste Teste", "Teste", admin, token));
    }

    @Test
    public void TestCreateUserWithoutLogin(){
        controllerApp container= new controllerApp();
        String token = "teste";
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");

        assertFalse(container.createUser("Teste Teste", "Teste", admin, token));
    }

    //Esperado registo com sucesso, mas não funciona
    @Test
    public void TestCreateAndRegisterUser(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        container.createUser("Teste Teste", "Teste", admin, token);
        Registry user = container.registryuser("teste@reqres.in", "#1Cityslika", admin, token);
        assertNotNull(user);
    }

    @Test
    public void TestCreateUserWithoutNameAndJob(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("", "", admin, token));
    }

    @Test
    public void TestCreateUserWithInvalidNameAndJob(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("r", "l", admin, token));
    }

    @Test
    public void TestCreateUserWithoutNameAndInvalidJob(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("", "l", admin, token));
    }

    @Test
    public void TestCreateUserWithInvalidNameAndWithoutJob(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("r", "", admin, token));
    }

    @Test
    public void TestCreateUserWithoutJob(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("Bruno", "", admin, token));
    }

    @Test
    public void TestCreateUserInvalidJobMinCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("Bruno", "l", admin, token));
    }

    @Test
    public void TestCreateUserInvalidJobMaxCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("Bruno", "Leadernecessariotermaisdevintocincocaracteres", admin, token));
    }

    @Test
    public void TestCreateUserInvalidJobWithNumbers(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("Bruno", "Leader123", admin, token));
    }

    @Test
    public void TestCreateUserWithoutName(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("", "leader", admin, token));
    }

    @Test
    public void TestCreateUserWithInvalidNameMinCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("B", "leader", admin, token));
    }

    @Test
    public void TestCreateUserWithInvalidNameMaxCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("Brunofigueiredomaisdevintecincoletrascommaisvintecincoletrascom", "leader", admin, token));
    }

    @Test
    public void TestCreateUserWithInvalidNameWithNumbers(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("Bruno123", "leader", admin, token));
    }

    @Test
    public void TestCreateUserInvalidNameAndInvalidJobMaxCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("r", "Leadernecessariotermaisdevintocincocaracteres", admin, token));
    }
    @Test
    public void TestCreateUserWithoutNameAndInvalidJobMaxCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        assertFalse(container.createUser("", "Leadernecessariotermaisdevintocincocaracteres", admin, token));
    }

    @Test
    public void TestCreateUserInvalidNameAndInvalidJobWithNumbers(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);
        assertFalse(container.createUser("r", "Leader123", admin, token));
    }
    @Test
    public void TestCreateUserWithoutNameAndInvalidJobWithNumbers(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);
        assertFalse(container.createUser("", "Leader123", admin, token));
    }

    /*-------------------------------------------------- Registry User ----------------------------------------------*/
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

        Registry user = container.registryuser("bruno.figueiredo@reqres.in", "1#Pistol", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryWithoutLogin(){
        controllerApp container= new controllerApp();
        String token = "teste";
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4");

        Registry user = container.registryuser("eve.holt@reqres.in", "pistol", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserWithoutEmailAndPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("", "", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidEmailAndPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.i", "#1City", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserWithoutEmailAndInvalidPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("", "pistol", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserWithInvalidEmailAndWithoutPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.i", "", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserWithoutPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.in", "", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidPassword(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.in", "cityslika", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserWithoutEmail(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("", "1#Cityslika", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidEmailMinCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.i", "#1Cityslicka", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidEmailMaxCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.invalid", "#1Cityslicka", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidEmailWithoutHarroba(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredoreqres.in", "#1Cityslicka", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidEmailWithoutDomain(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@.in", "#1Cityslicka", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidEmailWithoutDot(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqrescom", "#1Cityslicka", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidEmailWithoutDotin(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres", "#1Cityslicka", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidEmailWithoutBrunoFigueiredo(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("@reqres.in", "#1Cityslicka", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidPasswordMinCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.in", "#1City", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidPasswordMaxCaracter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.in", "#1Cityslikaacimade30caracteresassimsim", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidPasswordWithoutUpperLetter(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.in", "#1cityslika", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidPasswordWithoutNumbers(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.in", "#Cityslika", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidPasswordWithoutCardinal(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.figueiredo@reqres.in", "1Cityslika", admin, token);
        assertNull(user);
    }

    @Test
    public void TestRegistryUserInvalidEmailAccent(){
        controllerApp container= new controllerApp();
        String token = container.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Registry user = container.registryuser("bruno.fígueiredo@reqres.in", "#1Cityslika", admin, token);
        assertNull(user);
    }


    /*-------------------------------------------------- Listing Users ----------------------------------------------*/
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


    /*-------------------------------------------------- Consulting User ----------------------------------------------*/
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


    /*-------------------------------------------------- Listing Resources ----------------------------------------------*/
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


    /*-------------------------------------------------- Consulting Resource ----------------------------------------------*/
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


    /*-------------------------------------------------- Token Validate ----------------------------------------------*/
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
