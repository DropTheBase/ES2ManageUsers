package Connection_Interfaces;

import Class.Resource;
import org.json.simple.JSONObject;

public interface Resource_Connection {
    void Create_Resource(Resource resource) throws Exception;
    void Delete_Resource(JSONObject jsonObject) throws Exception;
    void Update_Resource(JSONObject jsonObject) throws Exception;
}
