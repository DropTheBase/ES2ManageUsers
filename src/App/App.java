package App;

import Api.Authenticate_Api;
import Api.Resource_Api;
import Api.User_Api;
import Class.Authenticate;
import Class.Resource;
import Class.User;
import Connection_Interfaces.Authenticate_connection;
import Connection_Interfaces.Method_Connection;
import Connection_Interfaces.Resource_Connection;
import Connection_Interfaces.User_Connection;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public class App implements User_Connection, Authenticate_connection, Resource_Connection {

    Bd bd = Bd.Singleton();

    @Override
    public void Create_User(User user) throws Exception {
        Method_Connection method_connection = new User_Api();
        JSONObject object = new JSONObject();
        object.put("first_Name", user.getFirst_Name());
        object.put("last_Name", user.getLast_Name());
        object.put("avatar", user.getAvatar());
        object.put("email", user.getEmail());
        JSONObject jsonObject = method_connection.Post(object);
        JSONObject s = new JSONObject((Map) jsonObject.get("header"));
        List<String> ss = (List<String>) s.get(null);
        if(ss.get(0).equals("HTTP/1.1 201 Created"))
            bd.Validate_User(user);
        else
            throw new Exception("Invalid Data");
    }

    @Override
    public void Delete_User(JSONObject jsonObject) throws Exception {
        Method_Connection method_connection = new User_Api();
        Integer id = null;
        try{
            id = Integer.valueOf(jsonObject.get("id").toString());
        }catch (NullPointerException e){
            throw new Exception("Missing Necessary Information");
        }
        JSONObject object = method_connection.Delete(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        if(ss.get(0).equals("HTTP/1.1 204 No Content"))
            bd.Delete_User(jsonObject);
        else
            throw new Exception("Invalid Data");
    }

    @Override
    public void Update_User(JSONObject jsonObject) throws Exception {
        Method_Connection method_connection = new User_Api();
        Integer id = null;
        try{
            id = Integer.valueOf(jsonObject.get("id").toString());
        }catch (NullPointerException e){
            throw new Exception("Missing Necessary Information");
        }
        JSONObject object = method_connection.Update(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        if(ss.get(0).equals("HTTP/1.1 200 OK")){
            if(id != null)
                jsonObject.put("id",id);
            bd.Update_User(jsonObject);}
        else
            throw new Exception("Invalid Data");
    }


    @Override
    public void Create_Resource(Resource resource) throws Exception {
        Method_Connection method_connection = new Resource_Api();
        JSONObject object = new JSONObject();
        object.put("name", resource.getName());
        object.put("year", resource.getYear());
        object.put("color", resource.getColor());
        object.put("pantone_value", resource.getPantone_value());
        JSONObject json = method_connection.Post(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get(null);
        if(ss.get(0).equals("HTTP/1.1 201 Created")){
            bd.Validate_Resource(resource);}
        else
            throw new Exception("Invalid Data");
    }

    @Override
    public void Delete_Resource(JSONObject jsonObject) throws Exception {
        Method_Connection method_connection = new Resource_Api();
        Integer id = null;
        try{
            id = Integer.valueOf(jsonObject.get("id").toString());
        }catch (NullPointerException e){
            throw new Exception("Missing Necessary Information");
        }
        JSONObject object = method_connection.Delete(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        if(ss.get(0).equals("HTTP/1.1 204 No Content"))
            bd.Delete_Resource(jsonObject);
        else
            throw new Exception("Invalid Data");
    }

    @Override
    public void Update_Resource(JSONObject jsonObject) throws Exception {
        Method_Connection method = new Resource_Api();
        Integer id = null;
        try{
            id = Integer.valueOf(jsonObject.get("id").toString());
        }catch (NullPointerException e){
            throw new Exception("Missing Necessary Information");
        }
        JSONObject object = method.Update(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        if(ss.get(0).equals("HTTP/1.1 200 OK")){
            if(id != null)
                jsonObject.put("id",id);
            bd.Update_Resource(jsonObject);}
        else
            throw new Exception("Invalid Data");
    }

    @Override
    public void Register(Authenticate authenticate) throws Exception {
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email",authenticate.getEmail());
        jsonObject.put("password",authenticate.getPass());
        JSONObject object = authenticate_api.Register(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        if(ss.get(0).equals("HTTP/1.1 200 OK")){
            bd.Create_Authenticate(authenticate);
            bd.table_token.put(Integer.valueOf(object.get("id").toString()),object.get("token").toString());
        }
        else
            throw new Exception("Invalid Data");
    }

    @Override
    public void Login(Authenticate authenticate) throws Exception {
        Authenticate_Api authenticate_api = new Authenticate_Api();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", authenticate.getEmail());
        jsonObject.put("password", authenticate.getPass());
        JSONObject object = authenticate_api.Login(jsonObject);
        JSONObject s = new JSONObject((Map) object.get("header"));
        List<String> ss = (List<String>) s.get(null);
        if(ss.get(0).equals("HTTP/1.1 200 OK")){
            bd.Create_Authenticate(authenticate);
            bd.table_token.put(Integer.valueOf(object.get("id").toString()),object.get("token").toString());
        }
        else
            throw new Exception("Invalid Data");
    }
}
