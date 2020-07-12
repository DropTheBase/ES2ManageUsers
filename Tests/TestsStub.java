import com.Resource;
import com.Stub;
import com.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Exception.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class TestsStub {
    // BlackBox Tests --------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    // ADD USERS TESTS -----------------------------
    @Test
    void AddUser() {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );
        Stub repo = new Stub();

        Assertions.assertDoesNotThrow(() -> {repo.createUser(testUser);});
    }
    //add user with id 0 and createdAt null
    @Test
    void AddUserIDNull() {
        User user = new User(0,"teste@reqres.in","teste", "teste","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }
    //add user with first name and createdAt null
    @Test
    void AddUserFirstNameNull() {
        User user = new User(20,"teste@reqres.in",null, "teste","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }

    //add user with last name and createdAt null
    @Test
    void AddUserLastNameNull() {
        User user = new User(20,"teste@reqres.in","teste", null,"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }

    //add user with email and createdAt null
    @Test
    void AddUserEmailNull() {
        User user = new User(20,null,"teste", "teste","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }

    //add user with avatar and createdAt null
    @Test
    void AddUserAvatarNull() {
        User user = new User(20,"teste@reqres.in","teste", "teste",null,"teste",null );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }

    //add user with job and createdAt null
    //error
    @Test
    void AddUserJobNull() {
        User user = new User(20,"teste@reqres.in","teste", "teste","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg",null,null );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }

    //add user with email, name and createdAt null
    @Test
    void AddUserEmailandNameNull() {
        User user = new User(20,null,null, null,"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }

    //add user with email, name, job and createdAt null
    @Test
    void AddUserEmailandNameJobNull() {
        User user = new User(20,null,null, null,"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg",null,null );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }

    //add user with email, name, job, avatar and createdAt null
    @Test
    void AddUserEmailandNameJobAvatarNull() {
        User user = new User(20,null,null, null,null,null,null );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }
    //add user with email, job and createdAt null
    @Test
    void AddUserEmailandJobNull() {
        User user = new User(20,null,"teste", "teste","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg",null,null );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(user);
        });
    }

    // add 2 users with same id
    @Test
    void AddUserSameID() throws NoException,RepetedException {
        User testUser1 = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", "teste", null );
        User testUser2 = new User(20, "teste1@reqres.in", "teste1", "teste1", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", "teste1", null );
        Stub stub = new Stub();
        stub.createUser(testUser1);
        Assertions.assertThrows(RepetedException.class,() -> {
            stub.createUser(testUser2);
        });
    }

    // add 2 users with same email
    @Test
    void AddUserSameEmail() throws NoException,RepetedException {
        User testUser1 = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", "teste", null );
        User testUser2 = new User(21, "teste@reqres.in", "teste1", "teste1", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", "teste1", null );
        Stub stub = new Stub();
        stub.createUser(testUser1);
        Assertions.assertThrows(RepetedException.class,() -> {
            stub.createUser(testUser2);
        });
    }
    // add 2 users with same id and email
    @Test
    void AddUserSameIDEmail() throws NoException,RepetedException {
        User testUser1 = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", "teste", null );
        User testUser2 = new User(20, "teste@reqres.in", "teste1", "teste1", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", "teste1", null );
        Stub stub = new Stub();
        stub.createUser(testUser1);
        Assertions.assertThrows(RepetedException.class,() -> {
            stub.createUser(testUser2);
        });
    }

    // add user without List
    @Test
    void AddUserWithoutList() {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", "teste", null );
        Stub stub = new Stub();
        stub.users_list = null;
        Assertions.assertThrows(NoException.class,() -> {
            stub.createUser(testUser);
        });
    }

    // ADD RESOURCES TESTS-------------------

    @Test
    void AddResource() {
        Resource testResource = new Resource(20, "fuchsia rose", 2001, "#C74375", "17-2031" );
        Stub stub = new Stub();
        Assertions.assertDoesNotThrow(() -> {stub.addResource(testResource);});
    }

    // add resource without List
    @Test
    void AddResourceWithoutList() {
        Resource testResource = new Resource(20, "fuchsia rose", 2001, "#C74375", "17-2031" );
        Stub stub = new Stub();
        stub.resources_list = null;
        Assertions.assertThrows(NoException.class,() -> {
            stub.addResource(testResource);
        });
    }

    //add 2 resources with same ID
    @Test
    void AddResourceSameID() throws RepetedException, NoException {
        Resource testResource = new Resource(20, "fuchsia rose", 2001, "#C74375", "17-2031" );
        Resource testResource1 = new Resource(20, "fuchsia ", 2002, "#C74374", "17-2032" );
        Stub stub = new Stub();
        stub.addResource(testResource);
        Assertions.assertThrows(RepetedException.class,() -> {
            stub.addResource(testResource1);
        });
    }

    //add resource with ID 0
    // error
    @Test
    void AddResourceIDNull() {
        Resource testResource = new Resource(null, "fuchsia rose", 2001, "#C74375", "17-2031"  );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.addResource(testResource);
        });
    }

    //add resource with name null
    @Test
    void AddResourceNameNull() {
        Resource testResource = new Resource(20, null, 2001, "#C74375", "17-2031"  );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.addResource(testResource);
        });
    }

    //add resource with year null
    @Test
    void AddResourceYearNull() {
        Resource testResource = new Resource(20, "fuchsia rose", null, "#C74375", "17-2031"  );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.addResource(testResource);
        });
    }

    //add resource with color null
    @Test
    void AddResourceColorNull() {
        Resource testResource = new Resource(20, "fuchsia rose", 2001, null, "17-2031"  );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.addResource(testResource);
        });
    }
    //add resource with pantone null
    @Test
    void AddResourcePantoneNull() {
        Resource testResource = new Resource(20, "fuchsia rose", 2001, "#C74375", null  );
        Stub stub = new Stub();
        Assertions.assertThrows(NoException.class,() -> {
            stub.addResource(testResource);
        });
    }

    //List Users Tests -----------------------------
    @Test
    void ListUsers() throws NoException, RepetedException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);
        ArrayList<User> listuser = new ArrayList<>();
        listuser.add(testUser);
        Assertions.assertEquals( stub.listingUsers(),listuser);
    }
    // List Users with no users
    @Test
    void ListUserWithoutUsers() throws NoException {
        Stub stub = new Stub();

        Assertions.assertEquals(null, stub.listingUsers());
    }
    // List Users with no list
    @Test
    void ListUserListNull() {
        Stub stub = new Stub();
        stub.users_list = null;
        Assertions.assertThrows(NoException.class, () -> {
            stub.listingUsers();
        });
    }

    // LIst Resources Tests -------------------------
    @Test
    void ListResources() throws NoException, RepetedException {
        Resource resource = new Resource(20, "fuchsia rose", 2001, "#C74375", "17-2031" );
        Stub stub = new Stub();
        stub.addResource(resource);
        ArrayList<Resource> resourcesarr = new ArrayList<>();
        resourcesarr.add(resource);
        Assertions.assertEquals( stub.listingResources(),resourcesarr);
    }

    // List Resources with no resources
    @Test
    void ListUserWithoutResources() throws NoException {
        Stub stub = new Stub();

        Assertions.assertEquals(null, stub.listingResources());
    }
    // List Resources with no list
    @Test
    void ListResourcesListNull() {
        Stub stub = new Stub();
        stub.resources_list = null;
        Assertions.assertThrows(NoException.class, () -> {
            stub.listingResources();
        });
    }

    // User Details Tests ------------------------------------
    @Test
    void UserDetail() throws NoException, RepetedException, InvalidException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);

        Assertions.assertEquals(testUser, stub.consultingUser(20));
    }

    //User Detail with list null
    @Test
    void UserDetailNoList() {
        Stub stub = new Stub();
        stub.users_list = null;

        Assertions.assertThrows(NoException.class, () -> {
            stub.consultingUser(128);
        });
    }

    //User detail list with no users
    @Test
    void UserDetailNoUsers() throws NoException, RepetedException, InvalidException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);
        Assertions.assertEquals(null, stub.consultingUser(2));
    }

    // Resource Detail Tests ---------------------
    @Test
    void ResourceDetail() throws RepetedException, NoException, InvalidException {
        Resource testResource = new Resource(20, "fuchsia rose", 2001, "#C74375", "17-2031");
        Stub stub = new Stub();
        stub.addResource(testResource);
        Assertions.assertEquals(testResource, stub.consultingResource(20));
    }

    //Resource Detail with list null
    @Test
    void ResourceDetailNoList() {
        Stub stub = new Stub();
        stub.resources_list = null;

        Assertions.assertThrows(NoException.class, () -> {
            stub.consultingResource(128);
        });
    }

    //Resource detail list with no users
    @Test
    void ResourceDetailNoResource() throws NoException, RepetedException, InvalidException {
        Resource resource = new Resource(20, "fuchsia rose", 2001, "#C74375", "17-2031");
        Stub stub = new Stub();
        stub.addResource(resource);
        Assertions.assertEquals(null, stub.consultingResource(2));
    }

    // Registry Tests----------------------
    // Registry Valid
    //error
    @Test
    void testRegisterUserValid() throws NoException,RepetedException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);

        Assertions.assertDoesNotThrow(() -> {
            stub.registryuser("test@reqres.in", "test");
        });
    }

    // Registry with token list null
    @Test
    void RegistryNoList() {
        Stub stub = new Stub();
        stub.token_list = null;

        Assertions.assertThrows(NoException.class, () -> {
            stub.registryuser("teste@reqres.in", "teste");
        });
    }

    // Registry with registry list null
    @Test
    void testRegisterUserNoUserRegistryList() {
        Stub stub = new Stub();
        stub.registry_list = null;
        Assertions.assertThrows(NoException.class, () -> {
            stub.registryuser("teste@reqres.in", "teste");
        });
    }

    // Registry with user list null
    @Test
    void testRegisterUserNoUserList() {
        Stub repo = new Stub();
        repo.users_list = null;
        Assertions.assertThrows(NoException.class, () -> {
            repo.registryuser("teste@reqres.in", "teste");
        });
    }

    // Registry without email
    @Test
    void RegistryWithEmailNull() throws NoException, RepetedException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);

        Assertions.assertThrows(NoException.class, () -> {
            stub.registryuser(null, "test");
        });
    }

    // Registry without password
    @Test
    void RegistryWithPassNull() throws NoException, RepetedException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);
        Assertions.assertThrows(NoException.class, () -> {
            stub.registryuser("teste@reqres.in", null);
        });
    }

    // Registry with num max email
    @Test
    void RegistryMaxEmail() throws NoException, RepetedException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);

        Assertions.assertThrows(InvalidException.class, () -> {
            stub.registryuser("test123456789123456789@reqres.in", "test");
        });
    }

    // Registry with num min email
    @Test
    void ResgistryMinEmail() throws NoException, RepetedException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);

        Assertions.assertThrows(InvalidException.class, () -> {
            stub.registryuser("t@.i", "test");
        });
    }

    // Registry without @ email
    @Test
    void RegistryWithoutArrobaEmail() throws NoException, RepetedException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);

        Assertions.assertThrows(InvalidException.class, () -> {
            stub.registryuser("test.com", "test");
        });
    }

    // Registry with num max password
    @Test
    void RegistryMaxPassword() throws NoException, RepetedException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);

        Assertions.assertThrows(InvalidException.class, () -> {
            stub.registryuser("test@reqres.in", "test123456789123456789");
        });
    }

    // Registry with num min password
    @Test
    void RegistryMinPassword() throws NoException, RepetedException {
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        Stub stub = new Stub();
        stub.createUser(testUser);

        Assertions.assertThrows(InvalidException.class, () -> {
            stub.registryuser("test@reqres.in", "te");
        });
    }

    // Registry with user invalid
    @Test
    void RegistryUserInvalid() throws NoException,InvalidException,RepetedException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User testUser = new User(20, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",timestamp);
        Stub stub = new Stub();
        stub.createUser(testUser);

        Assertions.assertThrows(InvalidException.class, () -> {
            stub.registryuser("test@reqres.in", "test");
        });
    }


    // Authentication Tests----------------------

    // Authentication with no token List
    @Test
    void AuthenticationNoTokenList() {
        Stub stub = new Stub();
        stub.token_list = null;

        Assertions.assertThrows(NoException.class, () -> {
            stub.loginUser("test@reqres.in", "test");
        });
    }

    // Authentication with no registry List
    @Test
    void AuthenticationNoRegistryList() {
        Stub stub = new Stub();
        stub.registry_list = null;

        Assertions.assertThrows(NoException.class, () -> {
            stub.loginUser("test@reqres.in", "test");
        });
    }





    // WhiteBox Tests --------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    // Add Multiple Users
    @Test
    void AddMultipleUsers() throws NoException,InvalidException,RepetedException {
        Stub stub = new Stub();
        User testUser = new User(400, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        User testUser1 = new User(401, "testa@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );
        User testUser2 = new User(402, "tests@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);

        stub.createUser(testUser);
        stub.createUser(testUser1);
        stub.createUser(testUser2);

        for (int i = 0; i < stub.users_list.size(); i++) {
            Assertions.assertNotNull(stub.users_list.get(2));
        }
    }

    // Add user without User information
    @Test
    void AddUserWithoutUser() {
        Stub stub = new Stub();

        for (int i = 0; i < stub.users_list.size(); i++) {
            Assertions.assertNull(stub.users_list.get(i));

        }
    }

    //Add User no ID
    @Test
    void AddUserNoID() throws NoException,RepetedException {
        Stub stub = new Stub();
        User testUser = new User(400, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );
        stub.createUser(testUser);

        for (int i = 0; i < stub.users_list.size(); i++) {
            if (stub.users_list.get(i).getId()==(testUser.getId()) || stub.users_list.get(i).getEmail().equals(testUser.getEmail())) {
                Assertions.assertEquals(testUser, stub.users_list.get(i));
            }
        }
    }

    //Multiple Users with same ID
    @Test
    void AddTwoUsersSameID() throws NoException, RepetedException {
        Stub stub = new Stub();
        User testUser = new User(404, "test@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        stub.createUser(testUser);
        User testUser1 = new User(404, "test@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );


        Assertions.assertThrows(RepetedException.class,() -> {
            for (int i = 0; i < stub.users_list.size(); i++) {
                if (Integer.toString(stub.users_list.get(i).getId()).equals(Integer.toString(testUser1.getId()))) {

                    throw new RepetedException();
                }
            }
        });
    }

    //Multiple Users with same email
    @Test
    void AddTwoUsersSameEmail() throws NoException, RepetedException {
        Stub stub = new Stub();
        User testUser = new User(400, "test@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        stub.createUser(testUser);
        User testUser1 = new User(401, "test@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );


        Assertions.assertThrows(RepetedException.class,() -> {
            for (int i = 0; i < stub.users_list.size(); i++) {
                if (stub.users_list.get(i).getEmail().equals(testUser1.getEmail())) {
                    throw new RepetedException();
                }
            }
        });
    }



    //Multiple Users with differnte email and id
    @Test
    void AddMultipleUsersVerifyEmailandIDdiff() throws NoException, RepetedException {
        Stub stub = new Stub();
        User testUser = new User(400, "teste@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);
        User testUser1 = new User(401, "testa@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null );
        User testUser2 = new User(402, "testl@reqres.in", "teste", "teste", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg","teste",null);

        stub.createUser(testUser);
        stub.createUser(testUser1);
        stub.createUser(testUser2);

        Assertions.assertThrows(RepetedException.class,() -> {
            for (int i = 0; i < stub.users_list.size(); i++) {
                if (stub.users_list.get(i).getId()==(testUser.getId()) || stub.users_list.get(i).getEmail().equals(testUser.getEmail())) {
                    throw new RepetedException();
                }
            }
        });
    }
}