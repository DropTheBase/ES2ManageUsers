package Unit_Tests.Authenticate;

import Class.Authenticate;
import Connection_Interfaces.Authenticate_connection;
import Doubles.Mock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Black_Box {

    //email lengt < 3
    @Test
    public void BB_Register_Email_Less_Then_Min(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("@.","P12345678");
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //email lengt = 3
    @Test
    public void BB_Register_Email_Equal_To_Min(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("b@.","P12345678");
            authenticate_connection.Register(authenticate);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //email lengt = 50
    @Test
    public void BB_Register_Email_Equal_To_Max(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("123456789123456789123456789123456789123456789@h.pt","P12345678");
            authenticate_connection.Register(authenticate);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //email length > 50
    @Test
    public void BB_Register_Email_More_Then_Max(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("123456789123456789123456789123456789123456789123456@hot.com","P12345678");
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }


    //pass lengt > 20
    @Test
    public void BB_Register_Pass_More_Then_Max(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","P12345678912345678972");
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //pass lengt = 20
    @Test
    public void BB_Register_Pass_Equal_To_Max(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","P1234567891234567891");
            authenticate_connection.Register(authenticate);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //pass lengt = 8
    @Test
    public void BB_Register_Pass_Equal_To_Min(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","P1234567");
            authenticate_connection.Register(authenticate);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //pass lengt < 8
    @Test
    public void BB_Register_Pass_Less_Then_Min(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","P1234");
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void BB_Register_Pass_Without_Upper_Case(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","p1234567");
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void BB_Register_Pass_Null(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com",null);
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals(null, e.getMessage());
        }
    }

    @Test
    public void BB_Register_Email_Null(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate(null,"P1234567");
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals(null, e.getMessage());
        }
    }

    @Test
    public void BB_Register_null_Email_And_Pass_Null(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate(null,null);
            authenticate_connection.Register(authenticate);
        } catch (Exception e) {
            assertEquals(null, e.getMessage());
        }
    }

    //*******************************Login**************************************//

    //email lengt < 3
    @Test
    public void BB_Login_Email_Less_Then_Min(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("@.","P12345678");
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //email lengt = 3
    @Test
    public void BB_Login_Email_Equal_To_Min(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("b@.","P12345678");
            authenticate_connection.Login(authenticate);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //email lengt = 50
    @Test
    public void BB_Login_Email_Equal_To_Max(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("123456789123456789123456789123456789123456789@h.pt","P12345678");
            authenticate_connection.Login(authenticate);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //email length > 50
    @Test
    public void BB_Login_Email_More_Then_Max(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("123456789123456789123456789123456789123456789123456@hot.com","P12345678");
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //pass lengt > 20
    @Test
    public void BB_Login_Pass_More_Then_Max(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","P12345678912345678972");
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //pass lengt = 20
    @Test
    public void BB_Login_Pass_Equal_To_Max(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","P1234567891234567891");
            authenticate_connection.Login(authenticate);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //pass lengt = 8
    @Test
    public void BB_Login_Pass_Equal_To_Min(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","P1234567");
            authenticate_connection.Login(authenticate);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //pass lengt < 8
    @Test
    public void BB_Login_Pass_Less_Then_Min(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","P1234");
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void BB_Login_Pass_Without_Upper_Case(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com","p1234567");
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    @Test
    public void BB_Login_Pass_Null(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate("bruno@hotmail.com",null);
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals(null, e.getMessage());
        }
    }

    @Test
    public void BB_Login_Email_Null(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate(null,"P1234567");
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals(null, e.getMessage());
        }
    }

    @Test
    public void BB_Login_null_Email_And_Pass_Null(){
        Authenticate_connection authenticate_connection = new Mock();
        try {
            Authenticate authenticate= new Authenticate(null,null);
            authenticate_connection.Login(authenticate);
        } catch (Exception e) {
            assertEquals(null, e.getMessage());
        }
    }

}
