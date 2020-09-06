package Api_Tests.Resource;

import Class.Resource;
import Api.Resource_Api;
import Connection_Interfaces.Method_Connection;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    @Test
    public void Resource_Status_Get_All(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject json = method_connection.Get(null);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 200 OK",ss.get(0));
    }

    @Test
    public void Resource_Content_Get_All(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject json = method_connection.Get(null);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Resource_Schema_Get_All(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject json = method_connection.Get(null);
        List<JSONObject> ss = (List<JSONObject>) json.get("data");
        for (int i = 0;i<ss.size();i++){
            assertEquals(true, method_connection.Validate_Schema(ss.get(i)));
        }
    }

    @Test
    public void Resource_Status_Get_One(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject object = new JSONObject();
        object.put("id",1);
        JSONObject json = method_connection.Get(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 200 OK",ss.get(0));
    }

    @Test
    public void Resource_Content_Get_One(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject object = new JSONObject();
        object.put("id",1);
        JSONObject json = method_connection.Get(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Resource_Schema_Get_One(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject object = new JSONObject();
        object.put("id",1);
        JSONObject json = method_connection.Get(object);
        assertEquals(true,method_connection.Validate_Schema((JSONObject) json.get("data")));
    }

    @Test
    public void Resource_Status_Get_One_With_Id_Invalid(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject object = new JSONObject();
        object.put("id",-1);
        JSONObject json = method_connection.Get(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 404 Not Found",ss.get(0));
    }

    @Test
    public void Resource_Content_Get_One_With_Id_Invalid(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject object = new JSONObject();
        object.put("id",-1);
        JSONObject json = method_connection.Get(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Resource_Schema_Get_One_With_Id_Invalid(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject object = new JSONObject();
        object.put("id",-1);
        JSONObject json = method_connection.Get(object);
        try{
            method_connection.Validate_Schema((JSONObject) json.get("data"));
        }catch (NullPointerException e){
            assertTrue(true);
        }
    }

    /*****************Post********************/

    @Test
    public void Resource_Status_Post() throws Exception{
        Method_Connection method_connection = new Resource_Api();
        Resource resource = new Resource("Teste1",2010,"#000000","12-1234");
        JSONObject object = new JSONObject();
        object.put("name", resource.getName());
        object.put("year", resource.getYear());
        object.put("color", resource.getColor());
        object.put("pantone_value", resource.getPantone_value());
        JSONObject json = method_connection.Post(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 201 Created",ss.get(0));
    }

    @Test
    public void Resource_Content_Post() throws Exception {
        Method_Connection method_connection = new Resource_Api();
        Resource resource = new Resource("Teste1",2010,"#000000","12-1234");
        JSONObject object = new JSONObject();
        object.put("name", resource.getName());
        object.put("year", resource.getYear());
        object.put("color", resource.getColor());
        object.put("pantone_value", resource.getPantone_value());
        JSONObject json = method_connection.Post(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Resource_Schema_Post(){
        Method_Connection method_connection = new Resource_Api();
        try {
            Resource resource = new Resource("Teste1",2010,"#000000","12-1234");
            JSONObject object = new JSONObject();
            object.put("name", resource.getName());
            object.put("year", resource.getYear());
            object.put("color", resource.getColor());
            object.put("pantone_value", resource.getPantone_value());
            JSONObject json = method_connection.Post(object);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void Resource_Status_Post_With_Null_Data() {
        Method_Connection method_connection = new Resource_Api();
        try{
            JSONObject json = method_connection.Post(null);

        }catch (NullPointerException e){
            assertTrue(true);}

    }

    /*****************Delete********************/

    @Test
    public void Resource_Status_Delete(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject object = new JSONObject();
        object.put("id",1);
        JSONObject json = method_connection.Delete(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 204 No Content",ss.get(0));
    }

    @Test
    public void Resource_Status_Delete_With_Id_Invalid(){
        Method_Connection method_connection = new Resource_Api();
        JSONObject object = new JSONObject();
        object.put("id",-1);
        JSONObject json = method_connection.Delete(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 404 Not Found",ss.get(0));
    }

    @Test
    public void Resource_Status_Delete_With_Null_Data() {
        Method_Connection method_connection = new Resource_Api();
        try{
            JSONObject json = method_connection.Delete(null);

        }catch (NullPointerException e){
            assertTrue(true);}

    }

    /*****************Update********************/

    @Test
    public void Resource_Status_Update() throws Exception {
        Method_Connection method_connection = new Resource_Api();
        Resource resource = new Resource("Teste1",2010,"#000000","12-1234");
        JSONObject object = new JSONObject();
        object.put("id",1);
        object.put("name", resource.getName());
        object.put("year", resource.getYear());
        object.put("color", resource.getColor());
        object.put("pantone_value", resource.getPantone_value());
        JSONObject json = method_connection.Update(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 200 OK",ss.get(0));
    }

    @Test
    public void Resource_Status_Update_With_Id_Invalid() throws Exception {
        Method_Connection method_connection = new Resource_Api();
        Resource resource = new Resource("Teste1",2010,"#000000","12-1234");
        JSONObject object = new JSONObject();
        object.put("id",-1);
        object.put("name", resource.getName());
        object.put("year", resource.getYear());
        object.put("color", resource.getColor());
        object.put("pantone_value", resource.getPantone_value());
        JSONObject json = method_connection.Update(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get(null);
        assertEquals("HTTP/1.1 404 Not Found",ss.get(0));
    }

    @Test
    public void Resource_Content_Update() throws Exception {
        Method_Connection method_connection = new Resource_Api();
        Resource resource = new Resource("Teste1",2010,"#000000","12-1234");
        JSONObject object = new JSONObject();
        object.put("id",1);
        object.put("name", resource.getName());
        object.put("year", resource.getYear());
        object.put("color", resource.getColor());
        object.put("pantone_value", resource.getPantone_value());
        JSONObject json = method_connection.Post(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Resource_Content_Update_With_Id_Invalid() throws Exception {
        Method_Connection method_connection = new Resource_Api();
        Resource resource = new Resource("Teste1",2010,"#000000","12-1234");
        JSONObject object = new JSONObject();
        object.put("id",-1);
        object.put("name", resource.getName());
        object.put("year", resource.getYear());
        object.put("color", resource.getColor());
        object.put("pantone_value", resource.getPantone_value());
        JSONObject json = method_connection.Post(object);
        JSONObject s = new JSONObject((Map) json.get("header"));
        List<String> ss = (List<String>) s.get("Content-Type");
        assertEquals("application/json; charset=utf-8",ss.get(0));
    }

    @Test
    public void Resource_Status_Update_With_Null_Data() {
        Method_Connection method_connection = new Resource_Api();
        try{
            JSONObject json = method_connection.Update(null);

        }catch (NullPointerException e){
            assertTrue(true);}


    }
}
