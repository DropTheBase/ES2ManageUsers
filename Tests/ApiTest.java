import com.API;
import com.MateRequest;
import com.Resource;
import com.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;

public class ApiTest {
    @Test
    public void adeus(){}
}


































































/* CODIGO ANTIGO

 public static String path = "https://reqres.in";

    @Test
    public void testListUsers(){
        ArrayList<String> result = new ArrayList<>();
        String listUsersJSON = MateRequest.executeGet(path + "/api/users?page=1");

        JSONObject json = new JSONObject(listUsersJSON);
        JSONArray data = json.getJSONArray("data");

        //System.out.println(data);

        for(int i = 0; i< data.length();i++){
            result.add(data.getJSONObject(i).toString());
        }

        JSONObject jsonExpected = new JSONObject();
        jsonExpected.put("last_name","Bluth");
        jsonExpected.put("id", 1);
        jsonExpected.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
        jsonExpected.put("first_name", "George");
        jsonExpected.put("email", "george.bluth@reqres.in");

        ArrayList<String> put = new ArrayList<>();

        JSONObject jsonExpected1 = new JSONObject();
        jsonExpected1.put("last_name","Weaver");
        jsonExpected1.put("id", 2);
        jsonExpected1.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        jsonExpected1.put("first_name", "Janet");
        jsonExpected1.put("email", "janet.weaver@reqres.in");

        JSONObject jsonExpected2 = new JSONObject();
        jsonExpected2.put("last_name","Wong");
        jsonExpected2.put("id", 3);
        jsonExpected2.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");
        jsonExpected2.put("first_name", "Emma");
        jsonExpected2.put("email", "emma.wong@reqres.in");

        JSONObject jsonExpected3 = new JSONObject();
        jsonExpected3.put("last_name","Holt");
        jsonExpected3.put("id", 4);
        jsonExpected3.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");
        jsonExpected3.put("first_name", "Eve");
        jsonExpected3.put("email", "eve.holt@reqres.in");

        JSONObject jsonExpected4 = new JSONObject();
        jsonExpected4.put("last_name","Morris");
        jsonExpected4.put("id", 5);
        jsonExpected4.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");
        jsonExpected4.put("first_name", "Charles");
        jsonExpected4.put("email", "charles.morris@reqres.in");

        JSONObject jsonExpected5 = new JSONObject();
        jsonExpected5.put("last_name","Ramos");
        jsonExpected5.put("id", 6);
        jsonExpected5.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");
        jsonExpected5.put("first_name", "Tracey");
        jsonExpected5.put("email", "tracey.ramos@reqres.in");

        put.add(jsonExpected.toString());
        put.add(jsonExpected1.toString());
        put.add(jsonExpected2.toString());
        put.add(jsonExpected3.toString());
        put.add(jsonExpected4.toString());
        put.add(jsonExpected5.toString());

        Assertions.assertEquals(result.toString(),put.toString());

    }

    @Test
    public void testCreateUser() throws IOException {
        User user = new User(2,"cmp@gmail.con","Jorge","adeus","LDH");

        assert API.createUser(user);
    }

    @Test
    public void testUserDetails(){

        String listUsersJSON = MateRequest.executeGet(path + "/api/users/2" );

        JSONObject json = new JSONObject(listUsersJSON);
         User values = new User();

         values = User.fromJSON(json.getJSONObject("data"));

        JSONObject jsonExpected = new JSONObject();
        jsonExpected.put("id",2);
        jsonExpected.put("first_name", "Janet");
        jsonExpected.put("last_name", "Weaver");
        jsonExpected.put("email", "janet.weaver@reqres.in");
        jsonExpected.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");

        Assertions.assertEquals(new JSONObject(values).toString(),jsonExpected.toString());
    }

    @Test
    public void testResourceDetails(){

        String listResourceJSON = MateRequest.executeGet(path + "/api/unknown/2");

        JSONObject json = new JSONObject(listResourceJSON);
        Resource values = new Resource();

        values = Resource.fromJSON(json.getJSONObject("data"));

        JSONObject jsonExpected = new JSONObject();
        jsonExpected.put("color","#C74375");
        jsonExpected.put("year", 2001);
        jsonExpected.put("name", "fuchsia rose");
        jsonExpected.put("id", 2);
        jsonExpected.put("pantone_value", "17-2031");

        Assertions.assertEquals(new JSONObject(values).toString(),jsonExpected.toString());
    }

    @Test

    public void testListAllResources(){
        ArrayList<String> result = new ArrayList<>();
        String listResourcesJSON = MateRequest.executeGet(path + "/api/unknown");

        JSONObject json = new JSONObject(listResourcesJSON);
        JSONArray data = json.getJSONArray("data");



        System.out.println(data);

        for(int i = 0; i< data.length();i++){
            result.add(data.getJSONObject(i).toString());
        }

        JSONObject jsonExpected = new JSONObject();
        jsonExpected.put("color","#98B2D1");
        jsonExpected.put("year", 2000);
        jsonExpected.put("name", "cerulean");
        jsonExpected.put("id", 1);
        jsonExpected.put("pantone_value", "15-4020");

        ArrayList<String> put = new ArrayList<>();

        JSONObject jsonExpected1 = new JSONObject();
        jsonExpected1.put("color","#C74375");
        jsonExpected1.put("year", 2001);
        jsonExpected1.put("name", "fuchsia rose");
        jsonExpected1.put("id", 2);
        jsonExpected1.put("pantone_value", "17-2031");

        JSONObject jsonExpected2 = new JSONObject();
        jsonExpected2.put("color","#BF1932");
        jsonExpected2.put("year", 2002);
        jsonExpected2.put("name", "true red");
        jsonExpected2.put("id", 3);
        jsonExpected2.put("pantone_value", "19-1664");

        JSONObject jsonExpected3 = new JSONObject();
        jsonExpected3.put("color","#7BC4C4");
        jsonExpected3.put("year", 2003);
        jsonExpected3.put("name", "aqua sky");
        jsonExpected3.put("id", 4);
        jsonExpected3.put("pantone_value", "14-4811");

        JSONObject jsonExpected4 = new JSONObject();
        jsonExpected4.put("color","#E2583E");
        jsonExpected4.put("year", 2004);
        jsonExpected4.put("name", "tigerlily");
        jsonExpected4.put("id", 5);
        jsonExpected4.put("pantone_value", "17-1456");

        JSONObject jsonExpected5 = new JSONObject();
        jsonExpected5.put("color","#53B0AE");
        jsonExpected5.put("year", 2005);
        jsonExpected5.put("name", "blue turquoise");
        jsonExpected5.put("id", 6);
        jsonExpected5.put("pantone_value", "15-5217");

        put.add(jsonExpected.toString());
        put.add(jsonExpected1.toString());
        put.add(jsonExpected2.toString());
        put.add(jsonExpected3.toString());
        put.add(jsonExpected4.toString());
        put.add(jsonExpected5.toString());

        Assertions.assertEquals(result.toString(),put.toString());

    }

    @Test
    public void testLoginSuccess() throws IOException {

        String email = "eve.holt@reqres.in";
        String password = "cityslicka";
        JSONObject object = new JSONObject();
        object.put("email", email);
        object.put("password", password);
        System.out.println(object.toString());


        String resultJSON = MateRequest.executePost(path + "/api/login",object.toString());
        JSONObject json = new JSONObject(resultJSON);


        JSONObject jsonExpected = new JSONObject();
        jsonExpected.put("token","QpwL5tke4Pnpja7X4");


        Assertions.assertEquals(json.toString(),jsonExpected.toString());

    }

    @Test
    public void testLoginUnsuccess() throws IOException {


        String password = "cityslicka";
        JSONObject object = new JSONObject();
        object.put("password", password);



        String resultJSON = MateRequest.executePost(path + "/api/login",object.toString());
        JSONObject json = new JSONObject(resultJSON);


        JSONObject jsonExpected = new JSONObject();
        jsonExpected.put("error","Missing email or username");




        System.out.println(json);

        Assertions.assertEquals(json.toString(),jsonExpected.toString());
    }


    @Test
    public void testRegisterSuccess() throws IOException {

        String email = "eve.holt@reqres.in";
        String password = "pistol";
        JSONObject object = new JSONObject();
        object.put("email", email);
        object.put("password", password);
        System.out.println(object.toString());


        String resultJSON = MateRequest.executePost(path + "/api/register",object.toString());
        JSONObject json = new JSONObject(resultJSON);


        JSONObject jsonExpected = new JSONObject();
        jsonExpected.put("id",4);
        jsonExpected.put("token","QpwL5tke4Pnpja7X4");


        Assertions.assertEquals(json.toString(),jsonExpected.toString());

    }

    @Test
    public void testRegisterUnsuccess() throws IOException {

        String email = "eve.holt@reqres.in";

        JSONObject object = new JSONObject();
        object.put("email", email);

        System.out.println(object.toString());


        String resultJSON = MateRequest.executePost(path + "/api/register",object.toString());
        JSONObject json = new JSONObject(resultJSON);


        JSONObject jsonExpected = new JSONObject();
        jsonExpected.put("error","Missing password");



        Assertions.assertEquals(json.toString(),jsonExpected.toString());

    }

    @Test
    public void testDelay(){

        ArrayList<String> result = new ArrayList<>();
        String listUsersJSON = MateRequest.executeGet(path + "/api/users?delay=3");

        JSONObject json = new JSONObject(listUsersJSON);
        JSONArray data = json.getJSONArray("data");

        //System.out.println(data);

        for(int i = 0; i< data.length();i++){
            result.add(data.getJSONObject(i).toString());
        }

        JSONObject jsonExpected = new JSONObject();
        jsonExpected.put("last_name","Bluth");
        jsonExpected.put("id", 1);
        jsonExpected.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
        jsonExpected.put("first_name", "George");
        jsonExpected.put("email", "george.bluth@reqres.in");

        ArrayList<String> put = new ArrayList<>();

        JSONObject jsonExpected1 = new JSONObject();
        jsonExpected1.put("last_name","Weaver");
        jsonExpected1.put("id", 2);
        jsonExpected1.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        jsonExpected1.put("first_name", "Janet");
        jsonExpected1.put("email", "janet.weaver@reqres.in");

        JSONObject jsonExpected2 = new JSONObject();
        jsonExpected2.put("last_name","Wong");
        jsonExpected2.put("id", 3);
        jsonExpected2.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");
        jsonExpected2.put("first_name", "Emma");
        jsonExpected2.put("email", "emma.wong@reqres.in");

        JSONObject jsonExpected3 = new JSONObject();
        jsonExpected3.put("last_name","Holt");
        jsonExpected3.put("id", 4);
        jsonExpected3.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");
        jsonExpected3.put("first_name", "Eve");
        jsonExpected3.put("email", "eve.holt@reqres.in");

        JSONObject jsonExpected4 = new JSONObject();
        jsonExpected4.put("last_name","Morris");
        jsonExpected4.put("id", 5);
        jsonExpected4.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");
        jsonExpected4.put("first_name", "Charles");
        jsonExpected4.put("email", "charles.morris@reqres.in");

        JSONObject jsonExpected5 = new JSONObject();
        jsonExpected5.put("last_name","Ramos");
        jsonExpected5.put("id", 6);
        jsonExpected5.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");
        jsonExpected5.put("first_name", "Tracey");
        jsonExpected5.put("email", "tracey.ramos@reqres.in");

        put.add(jsonExpected.toString());
        put.add(jsonExpected1.toString());
        put.add(jsonExpected2.toString());
        put.add(jsonExpected3.toString());
        put.add(jsonExpected4.toString());
        put.add(jsonExpected5.toString());

        Assertions.assertEquals(result.toString(),put.toString());
    }
 */