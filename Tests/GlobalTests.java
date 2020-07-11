import com.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GlobalTests {

    @Test
    public void ola(){}
}




















































/* CODIGO ANTIGO


 public static String path = "https://reqres.in";

    @Test
    public void testListAllUsers(){

//STUB result
        Stub stub = new Stub();
        JSONArray jsonarray2 = new JSONArray();
        ArrayList<JSONObject> aux = stub.listAllUsers();

        for(int i = 0; i<aux.size();i++){
            jsonarray2.put(aux.get(i));
        }
//API result
        ArrayList<String> result = new ArrayList<>();
        String listUsersJSON = MateRequest.executeGet(path + "/api/users?page=1");

        JSONObject json = new JSONObject(listUsersJSON);
        JSONArray data = json.getJSONArray("data");

        //System.out.println(data);

        for(int i = 0; i< data.length();i++){
            result.add(data.getJSONObject(i).toString());
        }



        Assertions.assertNotNull(jsonarray2.toString(),result.toString());
    }


    @Test
    public void testListAllResources(){

//STUB result
        Stub stub = new Stub();
        JSONArray jsonarray2 = new JSONArray();
        ArrayList<JSONObject> aux = stub.listAllResources();

        for(int i = 0; i<aux.size();i++){
            jsonarray2.put(aux.get(i));
        }
//API result

        String listResourcesJSON = MateRequest.executeGet(path + "/api/unknown");

        JSONObject json = new JSONObject(listResourcesJSON);
        JSONArray data = json.getJSONArray("data");






        Assertions.assertEquals(jsonarray2.toString(),data.toString());
    }

    @Test
    public void testLogin(){
        boolean loginAPI = API.login("eve.holt@reqres.in","cityslicka");

        Stub stub = new Stub();
        JSONObject jsonloginlocal= stub.loginUser("eve.holt@reqres.in","cityslicka");

        Assertions.assertEquals(loginAPI,(jsonloginlocal.getInt("status")==200));
    }

    @Test
    public void testLoginWrongEmail(){
        boolean loginAPI = API.login("WrongEmail","cityslicka");

        Stub stub = new Stub();
        JSONObject jsonloginlocal= stub.loginUser("WrongEmail","cityslicka");

        Assertions.assertEquals(loginAPI,(jsonloginlocal.getInt("status")==200));
    }

    @Test
    public void testLoginWrongPassword(){
        boolean loginAPI = API.login("eve.holt@reqres.in","WrongPass");

        Stub stub = new Stub();
        JSONObject jsonloginlocal= stub.loginUser("eve.holt@reqres.in","WrongPass");

        Assertions.assertEquals(loginAPI,(jsonloginlocal.getInt("status")==400));
    }

    @Test
    public void testLoginWrongPasswordAndEmail(){
        boolean loginAPI = API.login("WrongEmail","WrongPass");

        Stub stub = new Stub();
        JSONObject jsonloginlocal= stub.loginUser("WrongEmail","WrongPass");

        Assertions.assertEquals(loginAPI,(jsonloginlocal.getInt("status")==200));
    }

    @Test
    public void testRegister(){

        Stub stub = new Stub();
        JSONObject idLocalStub = stub.registerUserToApp("eve.holt@reqres.in","pistol");

        int idAPI = API.register("eve.holt@reqres.in","pistol");


        Assertions.assertEquals(idLocalStub.getInt("id"),idAPI);
    }


    @Test
    public void testDelay() throws InterruptedException {

//STUB result
        Stub stub = new Stub();
        JSONArray jsonarray2 = new JSONArray();
        ArrayList<JSONObject> aux = stub.delayPublicUSers(10);

        for(int i = 0; i<aux.size();i++){
            jsonarray2.put(aux.get(i));
        }
//API result
        ArrayList<String> result = new ArrayList<>();
        String listUsersJSON = MateRequest.executeGet(path + "/api/users?delay=3");

        JSONObject json = new JSONObject(listUsersJSON);
        JSONArray data = json.getJSONArray("data");

        //System.out.println(data);

        for(int i = 0; i< data.length();i++){
            result.add(data.getJSONObject(i).toString());
        }



        Assertions.assertNotNull(jsonarray2.toString(),result.toString());
    }


    @Test
    public void testListSingleUser(){
        //STUB result
        Stub stub = new Stub();

        JSONObject json1 =stub.listUser(2);

        //API result

        String listUserJSON = MateRequest.executeGet(path + "/api/users/2");
        JSONObject json = new JSONObject(listUserJSON );

        JSONObject data = json.getJSONObject("data");

        Assertions.assertEquals(json1.toString(),data.toString());

    }

    @Test
    public void testListSingleResource(){
        //STUB result
        Stub stub = new Stub();

        JSONObject json1 =stub.listResource(2);

        //API result

        String listUserJSON = MateRequest.executeGet(path + "/api/unknown/2");
        JSONObject json = new JSONObject(listUserJSON );

        JSONObject data = json.getJSONObject("data");

        Assertions.assertEquals(json1.toString(),data.toString());

    }
 */