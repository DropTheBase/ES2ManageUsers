package Class;

import org.json.simple.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    String Email; //Min 3 - Max 50
    String First_Name; //Min 3 - Max 20
    String Last_Name; //Min 3 - Max 20
    String Avatar; //PNG ou JPG

    public User() {
    }

    public User(String email, String first_Name, String last_Name, String avatar) throws Exception {
        if(validate(email,first_Name,last_Name,avatar)) {
            Email = email;
            First_Name = first_Name;
            Last_Name = last_Name;
            Avatar = avatar;
        }
        else
            throw new Exception("Invalid Data");
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }


    public boolean validate(String email, String first_Name, String last_Name, String avatar){
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches() == false){
            return false;
        }
        else{
            if(email.length()<3 || email.length()>50){
                return false;
            }
        }

        if(first_Name.length()<3 || first_Name.length()>20)
            return false;

        if(last_Name.length()<3 || last_Name.length()>20)
            return false;

        if(!(avatar.contains(".jpg")||avatar.contains(".png")))
            return false;

        return true;
    }

    public boolean change(JSONObject jsonObject){
        try {
            if(jsonObject.get("first").toString().length()<3 || jsonObject.get("first").toString().length()>20)
                return false;
            setFirst_Name(jsonObject.get("first").toString());
        }catch (Exception e){};

        try {
            if(jsonObject.get("last").toString().length()<3 || jsonObject.get("last").toString().length()>20)
                return false;
            setLast_Name(jsonObject.get("last").toString());
        }catch (Exception e){};

        try {
            if(!(jsonObject.get("avatar").toString().contains(".jpg")||jsonObject.get("avatar").toString().contains(".png")))
                return false;
            setAvatar(jsonObject.get("avatar").toString());
        }catch (Exception e){};

        try {
            Matcher matcher = pattern.matcher(jsonObject.get("new_email").toString());
            if(matcher.matches() == false){
                return false;
            }
            else{
                if(jsonObject.get("new_email").toString().length()<3 || jsonObject.get("new_email").toString().length()>50){
                    return false;
                }
                setEmail(jsonObject.get("new_email").toString());
            }
        }catch (Exception e){};
        return true;
    }
}
