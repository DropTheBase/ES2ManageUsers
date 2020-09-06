package Connection_Interfaces;

import org.json.simple.JSONObject;

public interface Method_Connection {
    JSONObject Post(JSONObject data);
    JSONObject Get(JSONObject data);
    JSONObject Delete(JSONObject data);
    JSONObject Update(JSONObject data);
    boolean Validate_Schema(JSONObject jsonObject);
}
