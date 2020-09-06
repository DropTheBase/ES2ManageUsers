package Global_Tests.Authenticate;

import Class.Authenticate;
import App.App;
import Connection_Interfaces.Authenticate_connection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class White_Box {

    @Test
    public void WB_Register_valid(){
        Authenticate_connection authenticate_connection = new App();
        try {
            Authenticate authenticate= new Authenticate("teste@hotmail.com","P1234567");
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
        }
    }

    @Test
    public void  WB_Register_With_Invalid_Email(){
        Authenticate_connection authenticate_connection = new App();
        try {
            Authenticate authenticate= new Authenticate("teste","P1234567");
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void  WB_Register_With_Invalid_Pass(){
        Authenticate_connection authenticate_connection = new App();
        try {
            Authenticate authenticate= new Authenticate("teste@hotmail.com","p1234567");
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_Login_valid(){
        Authenticate_connection authenticate_connection = new App();
        try {
            Authenticate authenticate = new Authenticate("teste@hotmail.com","P1234567");
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
        }
    }

    @Test
    public void WB_Login_With_Email_Not_Exist(){
        Authenticate_connection authenticate_connection = new App();
        try {
            Authenticate authenticate= new Authenticate("testeinvalido@hotmail.com","P1234567");
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void WB_Login_With_Pass_Invalid(){
        Authenticate_connection authenticate_connection = new App();
        try {
            Authenticate authenticate= new Authenticate("teste@hotmail.com","891234567");
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

}
