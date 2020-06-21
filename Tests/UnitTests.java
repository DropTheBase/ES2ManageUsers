import com.Resource;
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

        json = stub.listUser(2);

        JSONObject jsonExpected = new JSONObject();

        jsonExpected.put("last_name","Weaver");
        jsonExpected.put("id",2);
        jsonExpected.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        jsonExpected.put("first_name","Janet");
        jsonExpected.put("email","janet.weaver@reqres.in");



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

        JSONArray jsonArrays = new JSONArray();


        User user= new User(1,"george.bluth@reqres.in","George","Bluth","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");


        User user2= new User(2,"janet.weaver@reqres.in","Janet","Weaver","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");


        User user3= new User(3,"emma.wong@reqres.in","Emma","Wong","https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");

        User user4= new User(4,"eve.holt@reqres.in","Eve","Holt","https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");

        User user5= new User(5,"charles.morris@reqres.in","Charles","Morris","https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");

        User user6= new User(6,"tracey.ramos@reqres.in","Tracey","Ramos","https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");


        jsonArrays.put(user.toJson());
        jsonArrays.put(user2.toJson());
        jsonArrays.put(user3.toJson());
        jsonArrays.put(user4.toJson());
        jsonArrays.put(user5.toJson());
        jsonArrays.put(user6.toJson());

        JSONArray jsonarray2 = new JSONArray();
        ArrayList<JSONObject> aux = stub.listAllUsers();

        for(int i = 0; i<aux.size();i++){
            jsonarray2.put(aux.get(i));
        }

        Assertions.assertNotNull(jsonarray2.toString(),jsonArrays.toString());


    }


    @Test
    public void testAccessUserToAppSuccess(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.registerUserToApp("eve.holt@reqres.in","pistol");

        JSONObject jsonStatus = new JSONObject();

        jsonStatus.put("email", "eve.holt@reqres.in");
        jsonStatus.put("id", 4);
        jsonStatus.put("password", "pistol");

        Assertions.assertEquals(json.toString(),jsonStatus.toString());


    }

    //whitebox
    @Test
    public void testAccessUserToAppFailEmail(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.registerUserToApp(null,"pistol");

        JSONObject jsonStatus = new JSONObject();

        jsonStatus.put("id", -1);
        jsonStatus.put("error", "Missing password or Email");
        jsonStatus.put("status", 400);


        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }

    //whitebox

    @Test
    public void testAccessUserToAppFailPass(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.registerUserToApp("eve.holt@reqres.in",null);

        JSONObject jsonStatus = new JSONObject();

        jsonStatus.put("id", -1);
        jsonStatus.put("error", "Missing password or Email");
        jsonStatus.put("status", 400);


        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }


    //whitebox
    @Test
    public void testAccessUserToAppFailPassAndEmail(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.registerUserToApp(null,null);

        JSONObject jsonStatus = new JSONObject();

        jsonStatus.put("id", -1);
        jsonStatus.put("error", "Missing password or Email");
        jsonStatus.put("status", 400);


        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }


    @Test
    public void testLoginSuccess(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.loginUser("eve.holt@reqres.in","cityslicka");

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

        json = stub.loginUser("mailerrado@gmail.com","cityslicka");

        JSONObject jsonStatus = new JSONObject();


        jsonStatus.put("status", 400);




        Assertions.assertEquals(json.toString(),jsonStatus.toString());

    }

    //whitebox
    @Test
    public void testLoginUnsuccessWrongPassword(){
        Stub stub = new Stub();

        JSONObject json = new JSONObject();

        json = stub.loginUser("eve.holt@reqres.in","passworderrada");

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

        json = stub.listResource(2);

        JSONObject jsonExpected = new JSONObject();

        jsonExpected.put("id",2);
        jsonExpected.put("name","fuchsia rose");
        jsonExpected.put("year",2001);
        jsonExpected.put("color","#C74375");
        jsonExpected.put("pantone_value","17-2031");


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

        JSONArray jsonArrays = new JSONArray();


        Resource resource1 = new Resource(1,"cerulean",2000,"#98B2D1","15-4020");

        Resource resource2 = new Resource(2,"fuchsia rose",2001,"#C74375","17-2031");

        Resource resource3 = new Resource(3,"true red",2002,"#BF1932","19-1664");

        Resource resource4 = new Resource(4,"aqua sky",2003,"#7BC4C4","14-4811");

        Resource resource5 = new Resource(5,"tigerlily",2004,"#E2583E","17-1456");

        Resource resource6 = new Resource(6,"blue turquoise",2005,"#53B0AE","15-5217");

        jsonArrays.put(resource1.toJson());
        jsonArrays.put(resource2.toJson());
        jsonArrays.put(resource3.toJson());
        jsonArrays.put(resource4.toJson());
        jsonArrays.put(resource5.toJson());
        jsonArrays.put(resource6.toJson());

        JSONArray jsonarray2 = new JSONArray();
        ArrayList<JSONObject> aux = stub.listAllResources();

        for(int i = 0; i<aux.size();i++){
            jsonarray2.put(aux.get(i));
        }

        Assertions.assertEquals(jsonarray2.toString(),jsonArrays.toString());


    }

    @Test

    public void testDelayUsers() throws InterruptedException {
        Stub stub = new Stub();

        ArrayList<JSONObject> jsonArrays = new ArrayList<JSONObject>();

        jsonArrays = stub.delayPublicUSers(10);


        ArrayList<JSONObject> jsonArrays2 = stub.listAllUsers();


        Assertions.assertEquals(jsonArrays.toString(),jsonArrays2.toString());

    }



    //blackbox




}
