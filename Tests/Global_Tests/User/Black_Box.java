package Global_Tests.User;

import Class.User;
import App.App;
import Connection_Interfaces.User_Connection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Black_Box {

    //first name lengt < 3
    @Test
    public void BB_User_First_Name_Less_Then_Min(){
        User_Connection user_connection = new App();
        try {
            User user = new User("teste@hotmail.com","Te","Teste","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //first name lengt = 3
    @Test
    public void BB_User_First_Name_Equal_To_Min(){
        User_Connection user_connection = new App();
        try {
            User user = new User("teste@hotmail.com","Tes","Teste","teste.jpg");
            user_connection.Create_User(user);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //first name lengt = 20
    @Test
    public void BB_User_First_Name_Equal_To_Max(){
        User_Connection user_connection = new App();
        try {
            User user = new User("teste@hotmail.com","Testetestetesteteste","Teste","teste.jpg");
            user_connection.Create_User(user);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //first name lengt > 20
    @Test
    public void BB_User_First_Name_More_Then_Max(){
        User_Connection user_connection = new App();
        try {
            User user = new User("teste@hotmail.com","Testetestetesteteste1","Teste","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //last name lengt < 3
    @Test
    public void BB_User_Last_Name_Less_Then_Min(){
        User_Connection user_connection = new App();
        try {
            User user = new User("teste@hotmail.com","Teste","Te","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //last name lengt = 3
    @Test
    public void BB_User_Last_Name_Equal_To_Min(){
        User_Connection user_connection = new App();
        try {
            User user = new User("teste@hotmail.com","Teste","Tes","teste.jpg");
            user_connection.Create_User(user);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //last name lengt = 20
    @Test
    public void BB_User_Last_Name_Equal_To_Max(){
        User_Connection user_connection = new App();
        try {
            User user = new User("teste@hotmail.com","Teste","Testetestetesteteste","teste.jpg");
            user_connection.Create_User(user);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //last name lengt > 20
    @Test
    public void BB_User_Last_Name_More_Then_Max(){
        User_Connection user_connection = new App();
        try {
            User user = new User("teste@hotmail.com","Teste","Testetestetesteteste1","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //email lengt < 3
    @Test
    public void BB_User_Email_Less_Then_Min(){
        User_Connection user_connection = new App();
        try {
            User user = new User("@.","Teste","Teste","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //email lengt = 3
    @Test
    public void BB_User_Email_Equal_To_Min(){
        User_Connection user_connection = new App();
        try {
            User user = new User("b@.","Teste","Teste","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
        }
    }

    //email lengt = 50
    @Test
    public void BB_User_Email_Equal_To_Max(){
        User_Connection user_connection = new App();
        try {
            User user = new User("123456789123456789123456789123456789123@hotmail.pt","Teste","Teste","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
        }
    }

    //email lengt > 50
    @Test
    public void BB_User_Email_More_Then_Max(){
        User_Connection user_connection = new App();
        try {
            User user = new User("1234567891234567891234567891234567891234@hotmail.pt","Teste","Teste","teste.jpg");
            user_connection.Create_User(user);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

}
