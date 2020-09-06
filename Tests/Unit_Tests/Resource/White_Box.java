package Unit_Tests.Resource;

import Class.Resource;
import Connection_Interfaces.Resource_Connection;
import Doubles.Mock;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class White_Box {

    @Test
    @RepeatedTest(2)
    @Order(1)
    public void WB_Resource_Create_Valid(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("Teste",2020,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void WB_Resource_Create_Name_Invalid(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("Test",2020,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_Resource_Create_Year_Invalid(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("Test",1980,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_Resource_Create_Color_Invalid(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("Test",1980,"#0000","12-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_Resource_Create_Pantone_Value_Part1_Invalid(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("Test",1980,"#0000","1-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_Resource_Create_Pantone_Value_Part2_Invalid(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("Test",1980,"#000000","12-123");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_Resource_Create_Pantone_Value_Invalid(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("Test",1980,"#000000","12.1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    /*****************Delete********************/

    @Test
    @Order(7)
    public void WB_Resource_Delete_By_Id(){
        Resource_Connection resource_connection = new Mock();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",1);
            resource_connection.Delete_Resource(jsonObject);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    @Order(7)
    public void WB_Resource_Delete_By_Name(){
        Resource_Connection resource_connection = new Mock();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Name","Teste");
            resource_connection.Delete_Resource(jsonObject);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    @Order(7)
    public void WB_Resource_Delete_By_Id_Invalid(){
        Resource_Connection resource_connection = new Mock();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",0);
            resource_connection.Delete_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Id", e.getMessage());
        }
    }

    @Test
    @Order(7)
    public void WB_Resource_Delete_By_Name_Invalid(){
        Resource_Connection resource_connection = new Mock();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Name","Test");
            resource_connection.Delete_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(7)
    public void WB_Resource_Invalid_Delete_With_Null_Data(){
        Resource_Connection resource_connection = new Mock();
        try {
            JSONObject jsonObject = new JSONObject();
            resource_connection.Delete_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    /*****************update********************/

    @Test
    @Order(2)
    public void WB_Resource_Update_By_Id_All_Data(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("name","TesteNovo");
        jsonObject.put("year",2000);
        jsonObject.put("color","#111111");
        jsonObject.put("pantone_value","23-1234");
        try {
            resource_connection.Update_Resource(jsonObject);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    @Order(2)
    public void WB_Resource_Update_By_Id_Not_Change_Data(){
        Resource_Connection resource_connection = new Mock();
        Resource resource = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_Resource_Update_By_Id_But_Name_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("name","j");
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_Resource_Update_By_Id_But_Year_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("year",1980);
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_Resource_Update_By_Id_But_Color_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("color","#0000");
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_Resource_Update_By_Id_But_Pantone_Value_Part1_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("pantone_value","1-1234");
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_Resource_Update_By_Id_But_Pantone_Value_Part2_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("pantone_value","12-123");
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_Resource_Update_By_Id_Not_Valid_Not_Change_Data(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",160);
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Id", e.getMessage());
        }
    }

    @Test
    @Order(3)
    public void WB_Resource_Update_By_Name_All_Data(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Teste");
        jsonObject.put("name","TesteNovo");
        jsonObject.put("year",2000);
        jsonObject.put("color","#111111");
        jsonObject.put("pantone_value","23-1234");
        try {
            resource_connection.Update_Resource(jsonObject);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    @Order(4)
    public void WB_Resource_Update_By_Name_But_Not_Change_Data(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Teste");
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void WB_Resource_Update_By_Name_But_Name_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Teste");
        jsonObject.put("name","Test");
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void WB_Resource_Update_By_Name_But_Year_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Teste");
        jsonObject.put("year",1980);
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void WB_Resource_Update_By_Name_But_Color_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Teste");
        jsonObject.put("color","#0000");
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void WB_Resource_Update_By_Name_But_Pantone_Value_Part1_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Teste");
        jsonObject.put("PV","1-1234");
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void WB_Resource_Update_By_Name_But_Pantone_Value_Part2_Invalid(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Teste");
        jsonObject.put("PV","12-123");
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void WB_Resource_Update_With_Null_Data(){
        Resource_Connection resource_connection = new Mock();
        JSONObject jsonObject = new JSONObject();
        try {
            resource_connection.Update_Resource(jsonObject);
        } catch (Exception e) {
            assertEquals("Missing Necessary Information", e.getMessage());
        }
    }
}
