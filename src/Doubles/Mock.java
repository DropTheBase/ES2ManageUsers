package Doubles;

import Class.*;
import App.Bd;
import Connection_Interfaces.Authenticate_connection;
import Connection_Interfaces.Resource_Connection;
import Connection_Interfaces.User_Connection;
import org.json.simple.JSONObject;

public class Mock implements Authenticate_connection, User_Connection, Resource_Connection {
    Bd bd = Bd.Singleton();

    @Override
    public void Create_User(User user) throws Exception {
        bd.Validate_User(user);
    }

    @Override
    public void Delete_User(JSONObject jsonObject) throws Exception {
        bd.Delete_User(jsonObject);
    }

    @Override
    public void Update_User(JSONObject jsonObject) throws Exception {
        bd.Update_User(jsonObject);
    }


    @Override
    public void Create_Resource(Resource resource) throws Exception {
        bd.Validate_Resource(resource);
    }

    @Override
    public void Delete_Resource(JSONObject jsonObject) throws Exception {
        bd.Delete_Resource(jsonObject);
    }

    @Override
    public void Update_Resource(JSONObject jsonObject) throws Exception {
        bd.Update_Resource(jsonObject);
    }

    @Override
    public void Register(Authenticate authenticate) throws Exception {
        bd.Create_Authenticate(authenticate);
    }

    @Override
    public void Login(Authenticate authenticate) throws Exception {
        if(bd.Validate_Authenticate(authenticate)==false)
            throw new Exception("Invalid Data");
    }
}
