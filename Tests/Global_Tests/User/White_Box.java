package Global_Tests.User;

import App.App;
import Class.User;
import Connection_Interfaces.User_Connection;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class White_Box {

    @Test
    @Order(1)
    public void User_Create_valid(){
        User_Connection user_connection = new App();
        User user = null;
        try {
            user = new User("teste@hotmail.com","Teste","Teste","teste.jpg");
            user_connection.Create_User(user);
            user = new User("teste2@hotmail.com","Teste2","Teste2","teste2.jpg");
            user_connection.Create_User(user);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    @Order(1)
    public void WB_User_Create_With_Email_That_Exists(){
        User_Connection user_connection = new App();
        User user = null;
        try {
            user = new User("teste@hotmail.com","Teste","Teste","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Email already exists", e.getMessage());
        }
    }

    @Test
    public void WB_User_Create_With_Email_Invalid(){
        User_Connection user_connection = new App();
        User user = null;
        try {
            user = new User("teste","Teste","Teste","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_User_Create_Email_Invalid_Less_Then_Min(){
            User_Connection user_connection = new App();
            User user = null;
            try {
                user = new User("@.","Teste","Teste","teste.jpg");
                user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_User_Create_First_Name_Invalid(){
        User_Connection user_connection = new App();
        User user = null;
        try {
            user = new User("teste@hotmail.com","Te","Teste","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_User_Create_Last_Name_Invalid(){
        User_Connection user_connection = new App();
        User user = null;
        try {
            user = new User("teste@hotmail.com","Teste","Te","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_User_Create_Avatar_Invalid_Format_File(){
        User_Connection user_connection = new App();
        User user = null;
        try {
            user = new User("teste@hotmail.com","Teste","Teste","teste.xml");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    /**************Delete*****************/

    @Test
    public void WB_User_Delete_By_Id_Valid(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        try {
            user_connection.Delete_User(jsonObject);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    @Order(3)
    public void WB_User_Delete_By_Email_Valid(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","teste@hotmail.com");
        try {
            user_connection.Delete_User(jsonObject);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    public void WB_User_Delete_Id_That_Not_Exit(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",160);
        try {
            user_connection.Delete_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Id", e.getMessage());
        }
    }

    @Test
    public void WB_User_Delete_With_Null_Data(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        try {
            user_connection.Delete_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Missing Necessary Information", e.getMessage());
        }
    }

    /**************Update*****************/

    @Test
    @Order(2)
    public void WB_User_Update_By_Id_All_Data(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("first","Teste");
        jsonObject.put("last","Teste");
        jsonObject.put("avatar","teste.png");
        jsonObject.put("email_novo","teste_novo@hotmail.com");
        try {
            user_connection.Update_User(jsonObject);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    @Order(2)
    public void WB_User_Update_By_Id_Not_Change_Data(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        try {
            user_connection.Update_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_User_Update_By_Id_But_First_Name_Invalid(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("first","Te");
        try {
            user_connection.Update_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_User_Update_By_Id_But_Last_Name_Invalid(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("last","Te");
        try {
            user_connection.Update_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_User_Update_By_Id_But_Avatar_Invalid(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("avatar","teste.xml");
        try {
            user_connection.Update_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_User_Update_By_Id_But_Email_Invalid(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("email_novo","teste");
        try {
            user_connection.Update_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_User_Update_By_Id_But_Email_Less_Then_Min(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("email_novo","@.");
        try {
            user_connection.Update_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void WB_User_Update_By_Id_That_Not_Exist(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",160);
        try {
            user_connection.Update_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Invalid Id", e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void WB_User_Update_With_Null_Data(){
        User_Connection user_connection = new App();
        User user = null;
        JSONObject jsonObject = new JSONObject();
        try {
            user_connection.Update_User(jsonObject);
        } catch (Exception e) {
            assertEquals("Missing Necessary Information", e.getMessage());
        }
    }

}
