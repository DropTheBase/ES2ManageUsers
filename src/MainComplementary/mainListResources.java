package MainComplementary;

import com.Registry;
import com.Resource;
import com.controllerApp;

import java.util.ArrayList;

public class mainListResources {
    public static void main(String[] args) {

        controllerApp containerapp = new controllerApp();
        String token = containerapp.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        ArrayList<Resource> resources_list = containerapp.listingResources(admin, token);

    }
}
