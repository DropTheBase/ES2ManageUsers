package MainComplementary;

import com.Registry;
import com.Resource;
import com.controllerApp;

import java.util.Scanner;

public class mainResourceDetail {
    public static void main(String[] args) {

        controllerApp containerapp = new controllerApp();
        String token = containerapp.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Scanner myObj = new Scanner(System.in);

        System.out.println("\n  Enter ID from Resource  ");
        int id = myObj.nextInt();

        Resource searchResource = containerapp.consultingResource(id, admin, token);
    }
}
