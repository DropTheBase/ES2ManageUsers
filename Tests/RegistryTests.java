import com.Registry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Exception.*;
public class RegistryTests {

    // Get tests------------------------------------------------
    // Registry with ID null
    @Test
    void RegistryIdNull() {
        Registry registry = new Registry(null, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertEquals(null, registry.getId());
    }

    //Registry Success
    @Test
    void RegistryValid() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertEquals(20, registry.getId());
    }

    //Registry Email null
    @Test
    void RegistryEmailNull() {
        Registry registry = new Registry(20, null, "teste", "kLjgPb8PWT");
        Assertions.assertEquals(null, registry.getEmail());
    }

    //Registry Email Valid
    @Test
    void RegistryEmailValid() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertEquals("teste@reqres.in", registry.getEmail());
    }

    //Registry Password null
    @Test
    void RegistryPasswordNull() {
        Registry registry = new Registry(20, "teste@reqres.in", null, "kLjgPb8PWT");
        Assertions.assertEquals(null, registry.getPassword());
    }

    //Registry Password Valid
    @Test
    void RegistryPasswordValid() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertEquals("teste", registry.getPassword());
    }

    //Registry Token null
    @Test
    void RegistryTokenNull() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", null);
        Assertions.assertEquals(null, registry.getToken());
    }

    //Registry Token Valid
    @Test
    void RegistryTokenValid() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT1");
        Assertions.assertEquals("kLjgPb8PWT1", registry.getToken());
    }

    //Registry Email and Password null
    @Test
    void RegistryEmailPasswordNull() {
        Registry registry = new Registry(20, null, null, "kLjgPb8PWT");
        Assertions.assertEquals(null, registry.getEmail(),registry.getPassword());
    }

    //Registry Email and Token null
    @Test
    void RegistryEmailTokenNull() {
        Registry registry = new Registry(20, null, "teste", null);
        Assertions.assertEquals(null, registry.getEmail(),registry.getToken());
    }

    //Registry Password and Token null
    @Test
    void RegistryTokenPasswordNull() {
        Registry registry = new Registry(20, "teste@reqres.in", null, null);
        Assertions.assertEquals(null, registry.getToken(), registry.getPassword());
    }

    //Registry all null
    @Test
    void RegistryAllNull() {
        Registry registry = new Registry(0, null, null, null);
        Assertions.assertEquals(null, registry.getToken(), registry.getPassword());
        Assertions.assertEquals(null, registry.getEmail());
        Assertions.assertEquals(0, registry.getId());

    }

    //SET Tests --------------------------------------------------------------

    // Registry with ID null
    @Test
    void RegistrySetIDNull() {
        Registry registry = new Registry(null, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(NoException.class,() -> {
            registry.setId(null);
        });
    }

    // Registry with ID Invalid
    @Test
    void RegistrySetIDInvalid() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(InvalidException.class,() -> {
            registry.setId(-20);
        });
    }

    // Registry with ID Valid
    @Test
    void RegistrySetIDValid() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertDoesNotThrow(() -> { registry.setId(20);});
    }

    // Registry with Email Null
    @Test
    void RegistrySetEmailNull() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(NoException.class,() -> {
            registry.setEmail(null);
        });
    }

    // Registry with num max Email
    @Test
    void RegistrySetEmailNumMax() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(InvalidException.class,() -> {
            registry.setEmail("teste1234567891234567890@reqres.in");
        });
    }

    // Registry with num min Email
    @Test
    void RegistrySetEmailNumMin() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(InvalidException.class,() -> {
            registry.setEmail("t@.i");
        });
    }

    // Registry without @ Email
    @Test
    void RegistrySetEmailNoArroba() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(InvalidException.class,() -> {
            registry.setEmail("testereqres.in");
        });
    }

    // Registry with Email Valid
    @Test
    void RegistrySetEmailValid() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertDoesNotThrow(() -> {registry.setEmail("teste@reqres.in");});
    }

    // Registry with Password Null
    @Test
    void RegistrySetPasswordNull() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(NoException.class,() -> {
            registry.setPassword(null);
        });
    }

    // Registry with Password limit Max
    @Test
    void RegistrySetPasswordNumMax() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(InvalidException.class,() -> {
            registry.setPassword("teste1234567890123456789012345678");
        });
    }

    // Registry with Password limit Min
    @Test
    void RegistrySetPasswordNumMin() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(InvalidException.class,() -> {
            registry.setPassword("te");
        });
    }

    // Registry with Password Valid
    @Test
    void testUserRegistrySetPasswordValid() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertDoesNotThrow(() -> {registry.setPassword("Test123+=");});
    }

    // Registry with Token Null
    @Test
    void RegistrySetTokenNull() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(NoException.class,() -> {
            registry.setToken(null);
        });
    }

    // Registry with Token Max
    @Test
    void RegistrySetTokenNumMax() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(InvalidException.class,() -> {
            registry.setToken("kLjgPb8PWTasdCGHVJHvjvkvjhkLjgPb8PWTasdCGHVJHvjvkvjh");
        });
    }

    // Registry with Token Min
    @Test
    void RegistrySetTokenNumMin() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");
        Assertions.assertThrows(InvalidException.class,() -> {
            registry.setToken("kLj");
        });
    }

    // Registry with Token Valid
    @Test
    void testUserRegistrySetTokenValid() {
        Registry registry = new Registry(20, "teste@reqres.in", "teste", "kLjgPb8PWT");

        Assertions.assertDoesNotThrow(() -> {registry.setToken("kLjgPb8PWTkLjgPb8PWTkLjgPb8PWT");});
    }

}
