import com.Stub;
import com.User;
import com.sun.org.apache.bcel.internal.generic.JsrInstruction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class UnitTests {

    @Test
    public void testCreateUser(){

        Stub stub = new Stub();
        JSONObject json = new JSONObject();

        json = stub.createUser("andre","arquiteto");

        JSONObject jsonExpected= new JSONObject();

        jsonExpected.put("name", "andre");
        jsonExpected.put("job", "arquiteto");



        Assertions.assertEquals(json.get("name"),jsonExpected.get("name"));
        Assertions.assertEquals(json.get("job"),jsonExpected.get("job"));

        Assertions.assertNotNull(json.get("createdAt"));
    }

    @Test
    public void testListSingleUserSuccess(){

        Stub stub = new Stub();
        JSONObject json = new JSONObject();

        json = stub.listUser(200);

        JSONObject jsonExpected = new JSONObject();

        jsonExpected.put("last_name","alberto");
        jsonExpected.put("id",200);
        jsonExpected.put("avatar","image.png");
        jsonExpected.put("first_name","jorge");
        jsonExpected.put("email","jorge@gmail.com");



        Assertions.assertEquals(json.toString(),jsonExpected.toString());

    }

    @Test
    public void testListSingleUserUnsuccess(){

        Stub stub = new Stub();
        JSONObject json = new JSONObject();

        json = stub.listUser(404);

        JSONObject jsonExpected = new JSONObject();

        jsonExpected.put("error",404);




        Assertions.assertEquals(json.toString(),jsonExpected.toString());

    }

    @Test
    public void testListAllUsersSuccess(){
        Stub stub = new Stub();

        ArrayList<JSONObject> jsonArrays = new ArrayList<JSONObject>();

        Assertions.assertNotNull(jsonArrays);


    }


    @Test
    public void testAccessUserToAppSuccess(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.accessUserToApp("quaresma@gmail.com","cr7");

        JSONObject jsonStatus = new JSONObject();

        jsonStatus.put("token", "ATK123");
        jsonStatus.put("id", 301);
        jsonStatus.put("status", 200);

        Assertions.assertEquals(json.toString(),jsonStatus.toString());


    }

    //whitebox
    @Test
    public void testAccessUserToAppFailEmail(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.accessUserToApp(null,"cr7");

        JSONObject jsonStatus = new JSONObject();

        jsonStatus.put("error", "Missing password or Email");
        jsonStatus.put("status", 400);


        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }

    //whitebox

    @Test
    public void testAccessUserToAppFailPass(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.accessUserToApp("quaresma@gmail.com",null);

        JSONObject jsonStatus = new JSONObject();

        jsonStatus.put("error", "Missing password or Email");
        jsonStatus.put("status", 400);


        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }


    //whitebox
    @Test
    public void testAccessUserToAppFailPassAndEmail(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.accessUserToApp(null,null);

        JSONObject jsonStatus = new JSONObject();

        jsonStatus.put("error", "Missing password or Email");
        jsonStatus.put("status", 400);


        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }


    @Test
    public void testLoginSuccess(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.loginUser("andre@gmail.com","user3");

        JSONObject jsonStatus = new JSONObject();

        jsonStatus.put("token", "ATK321");
        jsonStatus.put("status", 200);




        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }

    //whitebox
    @Test
    public void testLoginUnsuccessWrongEmail(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.loginUser("mailerrado@gmail.com","user3");

        JSONObject jsonStatus = new JSONObject();


        jsonStatus.put("status", 400);




        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }

    //whitebox
    @Test
    public void testLoginUnsuccessWrongPassword(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.loginUser("andre@gmail.com","passworderrada");

        JSONObject jsonStatus = new JSONObject();


        jsonStatus.put("status", 400);




        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }

    //whitebox
    @Test
    public void testLoginUnsuccessWrongPasswordAndEmail(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.loginUser("emailerrado@gmail.com","passworderrada");

        JSONObject jsonStatus = new JSONObject();


        jsonStatus.put("status", 400);




        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }


    //whitebox
    @Test
    public void testSingleResourceSuccess(){

        Stub stub = new Stub();
        JSONObject json = new JSONObject();

        json = stub.listResource(200);

        JSONObject jsonExpected = new JSONObject();

        jsonExpected.put("id",200);
        jsonExpected.put("name","nasa");
        jsonExpected.put("year","1997");
        jsonExpected.put("color","blue");
        jsonExpected.put("pantone_value","17-03");


        Assertions.assertEquals(json.toString(),jsonExpected.toString());

    }

//whitebox
    @Test
    public void testSingleResourceUnsuccess(){

        Stub stub = new Stub();
        JSONObject json = new JSONObject();

        json = stub.listResource(201);

        JSONObject jsonExpected = new JSONObject();

        jsonExpected.put("error",404);



        Assertions.assertEquals(json.toString(),jsonExpected.toString());

    }

    @Test
    public void testListAllResourcesSuccess(){
        Stub stub = new Stub();

        ArrayList<JSONObject> jsonArrays = new ArrayList<JSONObject>();

        Assertions.assertNotNull(jsonArrays);


    }

}
