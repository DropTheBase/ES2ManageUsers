package Api_Tests.Authenticate;

import Api.Authenticate_Api;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    @Test
    public void Register_valid(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        jsonObject.put("password","pistol");
        JSONObject object = authenticate_api.Register(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 200 OK",ss.get(0));
    }

    @Test
    public void Register_Invalid_Without_Pass(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        JSONObject object = authenticate_api.Register(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 400 Bad Request",ss.get(0));
    }

    @Test
    public void Register_Invalid_With_Data_Null(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        JSONObject object = authenticate_api.Register(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 400 Bad Request",ss.get(0));
    }

    @Test
    public void Register_Content(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        jsonObject.put("password","pistol");
        JSONObject json = authenticate_api.Register(jsonObject);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Register_Content_Invalid(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        JSONObject json = authenticate_api.Register(jsonObject);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Register_Token_Valid(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        jsonObject.put("password","pistol");
        JSONObject json = authenticate_api.Register(jsonObject);
        try{
            json.get("token");
            assertTrue(true);
        }catch (NullPointerException e){
            assertTrue(false);
        }
    }

    @Test
    public void Register_Invalid_Token(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        JSONObject json = authenticate_api.Register(jsonObject);
        try{
            if(json.get("error")==null)
                throw new Exception("erro");
            assertTrue(true);

        }catch (Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void Login_Valid(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        jsonObject.put("password","pistol");
        JSONObject object = authenticate_api.Login(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 200 OK",ss.get(0));
    }

    @Test
    public void Login_Invalid_Without_Pass(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        JSONObject object = authenticate_api.Login(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 400 Bad Request",ss.get(0));
    }

    @Test
    public void Login_Invalid_With_Data_Null(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        JSONObject object = authenticate_api.Login(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 400 Bad Request",ss.get(0));
    }

    @Test
    public void Login_Content(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        jsonObject.put("password","pistol");
        JSONObject json = authenticate_api.Login(jsonObject);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Login_Content_Invalid(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        JSONObject json = authenticate_api.Login(jsonObject);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Login_Token_Valid(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        jsonObject.put("password","pistol");
        JSONObject json = authenticate_api.Login(jsonObject);
        try{
            json.get("token");
            assertTrue(true);

        }catch (NullPointerException e){
            assertTrue(false);
        }
    }

    @Test
    public void Login_Invalid_Token(){
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        JSONObject json = authenticate_api.Login(jsonObject);
        try{
            if(json.get("error")==null)
                throw new Exception("erro");
            assertTrue(true);

        }catch (Exception e){
            assertTrue(false);
        }
    }
}
