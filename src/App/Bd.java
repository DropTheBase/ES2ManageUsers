package App;

import Class.*;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class Bd {

    HashMap<Integer,User> table_users= new HashMap<>();
    HashMap<Integer, Resource> table_resource = new HashMap<>();
    HashMap<Integer, Authenticate> table_authenticate = new HashMap<>();
    HashMap<Integer,String> table_token = new HashMap<>();
    private static Bd single_instance=null;

    public Bd() {
    }

    public static Bd Singleton()
    {
        // To ensure only one instance is created
        if (single_instance == null)
        {
            single_instance = new Bd();
        }
        return single_instance;
    }

    public void Validate_User(User user) throws Exception {
        Integer x = 0;
        for (Integer id : table_users.keySet()) {
            if(table_users.get(id).getEmail().equals(user.getEmail())==true)
                throw new Exception("Email already exists");
            x= id;
        }
        table_users.put(++x,user);
    }

    public void Delete_User(JSONObject jsonObject) throws Exception {

        try{
            Integer id = Integer.valueOf(jsonObject.get("id").toString());
            if(table_users.get(id)!=null)
                table_users.remove(id);
            else {
                throw new Exception("Invalid Id");
            }
        }
        catch (NullPointerException e){
            try{
                String email = jsonObject.get("email").toString();
                Integer x = null;
                for (Integer id : table_users.keySet()) {
                    if(table_users.get(id).getEmail().equals(email)==true){
                        x= id;
                        break;
                    }
                }
                if(x!=null)
                    table_users.remove(x);
                else {
                    throw new Exception("Invalid Email");
                }
            }
            catch (NullPointerException e2){
                throw new Exception("Missing Necessary Information");
            }
        }
    }

    public void Update_User(JSONObject jsonObject) throws Exception {
        try{
            Integer id = Integer.valueOf(jsonObject.get("id").toString());
            if(table_users.get(id)!=null){
                User user = table_users.get(id);
                boolean aux =  user.change(jsonObject);
                if(aux == false)
                    throw new Exception("Invalid Data");
            }
            else {
                throw new Exception("Invalid Id");
            }
        }
        catch (NullPointerException e){
            try{
                String email = jsonObject.get("email").toString();
                Integer x = null;
                for (Integer id : table_users.keySet()) {

                    if(table_users.get(id).getEmail().equals(email)==true){
                        x= id;
                        break;
                    }
                }
                if(x!=null){
                    User user = table_users.get(x);
                    boolean aux =  user.change(jsonObject);
                    if(aux == false)
                        throw new Exception("Invalid Data");
                }
                else {
                    throw new Exception("Invalid Email");
                }
            }
            catch (NullPointerException e2){
                throw new Exception("Missing Necessary Information");
            }
        }
    }

    public void Validate_Resource(Resource resource){
        Integer x = 0;
        for (Integer id : table_resource.keySet()) {
            x=id;
        }
        table_resource.put(++x,resource);
    }

    public void Delete_Resource(JSONObject data) throws Exception {
        try{
            Integer id = Integer.valueOf(data.get("id").toString());
            if(table_resource.get(id)!= null){
                table_resource.remove(id);
            }else {
                throw new Exception("Invalid Id");
            }
        }
        catch (NullPointerException e){
            try{
                String Nome = data.get("Name").toString();
                for (Integer id : table_resource.keySet()) {
                    if(table_resource.get(id).getName().equals(Nome))
                        table_resource.remove(id);
                }
            }
            catch (Exception e2){
                throw new Exception("Invalid Data");}
        }
    }

    public void Update_Resource(JSONObject data) throws Exception {
        try{
            Integer id = Integer.valueOf(data.get("id").toString());
            if(table_resource.get(id)!= null){
                boolean aux = table_resource.get(id).change(data);
                if(aux == false)
                    throw new Exception("Invalid Data");
            }else {
                throw new Exception("Invalid Id");
            }
        }
        catch (NullPointerException e){
            try{
                String Nome = data.get("Name").toString();
                for (Integer id : table_resource.keySet()) {
                    if(table_resource.get(id).getName().equals(Nome)){
                        boolean aux =table_resource.get(id).change(data);
                        if(aux == false)
                            throw new Exception("Invalid Data");
                    }
                }
            }
            catch (Exception e2){
                throw new Exception("Missing Necessary Information");}
        }
    }

    public void Create_Authenticate(Authenticate authenticate) throws Exception{
        Integer x = 0;
        for (Integer id : table_authenticate.keySet()) {
            x=id;
        }
        table_authenticate.put(++x, authenticate);
    }

    public boolean Validate_Authenticate(Authenticate authenticate){
        for (Integer id : table_authenticate.keySet()) {
            if(table_authenticate.get(id).getEmail().equals(authenticate.getEmail())&&table_authenticate.get(id).getPass().equals(authenticate.getPass()))
                return true;
        }
        return false;
    }
}
