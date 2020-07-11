package MainComplementary;

import com.Registry;
import com.User;
import com.controllerApp;

import java.sql.Timestamp;
import java.util.Scanner;


public class mainCreateUser {
    public static void main(String[] args) {

        controllerApp containerapp = new controllerApp();
        String token = containerapp.loginUser("eve.holt@reqres.in", "cityslicka");
        Registry admin = new Registry(4, "eve.holt@reqres.in", "cityslicka", token);

        Scanner myObj = new Scanner(System.in);

        int idCounter = 1;
        int id = idCounter++;
        String first_name;
        String job;
        String last_name;
        String avatar;
        String email;
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());

        System.out.println("\nEnter Email:");
        email = myObj.nextLine();
        System.out.println("Enter first name:");
        first_name = myObj.nextLine();
        System.out.println("Enter last name:");
        last_name = myObj.nextLine();
        System.out.println("Enter job:");
        job = myObj.nextLine();
        System.out.println("Enter Avatar:");
        avatar = myObj.nextLine();
        System.out.println("\n");

        User newUser = new User(id, email, first_name, last_name, avatar, job, createdAt);
        containerapp.createUser(newUser, admin, token);

    }

}
