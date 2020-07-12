package MainComplementary;

import com.Registry;
import com.User;
import com.controllerApp;

import java.util.Scanner;

public class mainUserDetail {
    public static void main(String[] args) {

        controllerApp containerapp = new controllerApp();
        String token = containerapp.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Scanner myObj = new Scanner(System.in);

        System.out.println("\nEnter ID from user:");
        int id = myObj.nextInt();

        User searchUser = containerapp.consultingUser(id, admin, token);

    }


}
