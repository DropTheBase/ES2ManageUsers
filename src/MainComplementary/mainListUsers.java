package MainComplementary;

import com.Registry;
import com.User;
import com.controllerApp;

import java.util.ArrayList;

public class mainListUsers {
    public static void main(String[] args) {

        controllerApp containerapp = new controllerApp();
        String token = containerapp.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

       ArrayList<User> users_list = containerapp.listingUsers(admin, token);

    }
}
