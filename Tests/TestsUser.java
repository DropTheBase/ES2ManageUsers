import com.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Exception.*;

public class TestsUser {

    /************EXECUÇÂO DOS TESTES DE GETS***************************/



    //TEST FIRST NAME GET

    @Test
    void testFirstNameNullForGet() {
        User testUser = new User(240, "user1@user.pt", null, "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals(null, testUser.getFirst_name());
    }

    @Test
    void testMaxLenghtFirstNameForGet() {
        User testUser = new User(240, "user1@user.pt", "thislastnameistoolongforthisphrasesowewrotethis", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals("thislastnameistoolongforthisphrasesowewrotethis", testUser.getFirst_name());
    }

    @Test
    void testMinLenghtFirstNameForGet() {
        User testUser = new User(240, "user1@user.pt", "es", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals("es", testUser.getFirst_name());
    }

    @Test
    void testFirstNameSuccessForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals("Utilizador", testUser.getFirst_name());
    }

    //TEST LAST NAME GET

    @Test
    void testLastNameNullForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", null, "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals(null, testUser.getLast_name());
    }

    @Test
    void testMaxLenghtLastNameForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "es", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals("es", testUser.getLast_name());
    }

    @Test
    void testMinLenghtLastNameForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "thislastnameistoolongforthisphrasesowewrotethis", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals("thislastnameistoolongforthisphrasesowewrotethis", testUser.getLast_name());
    }


    @Test
    void testLastNameSuccessForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals("User", testUser.getLast_name());
    }

    //TEST ID GET

    @Test
    void testNullIdForGet() {
        User testUser = new User(null, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg", "user",null);

        Assertions.assertEquals(null, testUser.getId());
    }

    @Test
    void testIdSuccessForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals(240, testUser.getId());
    }

    //TEST EMAIL GET

    @Test
    void testNullEmailForGet() {
        User testUser = new User(240, null, "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals(null, testUser.getEmail());
    }



    @Test
    void testEmailSuccessForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals("user1@user.pt", testUser.getEmail());
    }

    //TEST AVATAR GET

    @Test
    void testNullAvatarForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", null,"user",null );

        Assertions.assertEquals(null, testUser.getAvatar());
    }


    @Test
    void testMaxLenghtAvatarForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/imageslongggggggggggggggggggggggg/User1/user1.jpg","user",null );

        Assertions.assertEquals("https://s3.amazonaws.com/assets/imageslongggggggggggggggggggggggg/User1/user1.jpg", testUser.getAvatar());
    }

    @Test
    void testMinLenghtAvatarForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s.jpg","user",null );

        Assertions.assertEquals("https://s.jpg", testUser.getAvatar());
    }


    @Test
    void testAvatarSuccessForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals("https://s3.amazonaws.com/assets/images/User1/user1.jpg", testUser.getAvatar());
    }

    //TEST JOB

    @Test
    void testNullJobForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg",null,null );

        Assertions.assertEquals(null, testUser.getJob());
    }

    @Test
    void testMaxLenghtJobForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","us",null );

        Assertions.assertEquals("us", testUser.getJob());
    }

    @Test
    void testMinLenghtJobForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","userjobistoolongtobecorrectisthisphrase",null );

        Assertions.assertEquals("userjobistoolongtobecorrectisthisphrase", testUser.getJob());
    }

    @Test
    void testJobSuccessForGet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertEquals("user", testUser.getJob());
    }


    /*********************EXECUÇÂO DOS TESTES DE SETS********************/


    //TEST FIRST NAME

    @Test
    void testNullFirstName() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(NoException.class,() -> {
            testUser.setFirst_name(null);
        });
    }

    @Test
    void testMaxLenghtFisrtName() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setFirst_name("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        });
    }

    @Test
    void testMinLenghtFisrtName() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setFirst_name("u");
        });
    }

    @Test
    void testNameNumber() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setFirst_name("user1");
        });
    }

    @Test
    void testFirstNameSuccessForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertDoesNotThrow(() -> {testUser.setFirst_name("userAlberto");});
    }

    //TEST LAST NAME

    @Test
    void testLastNameNullForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(NoException.class,() -> {
            testUser.setLast_name(null);
        });
    }

    @Test
    void testMaxLenghtLastName() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setLast_name("uuuuuuuuuuuuuuuuuuuuuuuuu");
        });
    }

    @Test
    void testMinLenghtLastName() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setLast_name("u");
        });
    }

    @Test
    void testCantHaveNumber() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setLast_name("user1");
        });
    }

    @Test
    void testLastNameSuccessForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertDoesNotThrow(() -> {testUser.setLast_name("useralberto");});
    }

    //TEST AVATAR

    @Test
    void testNullAvatarForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(NoException.class,() -> {
            testUser.setAvatar(null);
        });
    }

    @Test
    void testMaxLenghtAvatarForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setAvatar("https://s3.amazonaws.com/assets/longtermmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm/User1/user1.png");
        });
    }

    @Test
    void testMinLenghtAvatarForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setAvatar("https:short.com");
        });
    }

    @Test
    void testAvatarInvalidValues() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setAvatar("https:´~+-+*/");
        });
    }

    @Test
    void testAvatarSuccessForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertDoesNotThrow(() -> {testUser.setAvatar("https://s3.amazonaws.com/joaquimalberto/joaquim/alberto/joaquim.png");});
    }

//TEST JOB

    @Test
    void testNullJobForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(NoException.class,() -> {
            testUser.setJob(null);
        });
    }

    @Test
    void testMaxLenghtJobForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setJob("jobistoolongtobecorrectinthisphrase");
        });
    }

    @Test
    void testMinLenghtJobForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setJob("sj");
        });
    }

    @Test
    void testJobSuccessForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertDoesNotThrow(() -> {testUser.setJob("EngenheiroInformatico");});
    }

    //TEST ID

    @Test
    void testUserNullIdOnSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(NoException.class,() -> {
            testUser.setId(null);
        });
    }

    @Test
    void testUserIdErrorOnSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setId(-240);
        });
    }

    @Test
    void testIdSuccessOnSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertDoesNotThrow(() -> { testUser.setId(13);});
    }

    //TEST EMAIL

    @Test
    void testNullEmailForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(NoException.class,() -> {
            testUser.setEmail(null);
        });
    }

    @Test
    void testEmailMaxLenght() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setEmail("maxlenghtemailtestforuseremailahahahahfunnycode@user.pt");
        });
    }

    @Test
    void testEmailMinLenght() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setEmail("u@.p");
        });
    }

    @Test
    void testEmailFailSymbol() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertThrows(InvalidException.class,() -> {
            testUser.setEmail("user.com");
        });
    }

    @Test
    void testEmailSuccessForSet() {
        User testUser = new User(240, "user1@user.pt", "Utilizador", "User", "https://s3.amazonaws.com/assets/images/User1/user1.jpg","user",null );

        Assertions.assertDoesNotThrow(() -> {testUser.setEmail("user1@user.pt");});
    }


}
