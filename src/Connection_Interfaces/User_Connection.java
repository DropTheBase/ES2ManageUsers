package Connection_Interfaces;

import Class.User;
import org.json.simple.JSONObject;

public interface User_Connection {
    void Create_User(User user) throws Exception;
    void Delete_User(JSONObject jsonObject) throws Exception;
    void Update_User(JSONObject jsonObject) throws Exception;
}
