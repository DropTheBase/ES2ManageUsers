package Class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authenticate {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    private String Email; //Min 3 - Max 50
    private String Pass; //Uma Maiúscula Min 8 - Max 20

    public Authenticate(String email, String pass) throws Exception {

        if(validate(email,pass)==true){
            Email = email;
            Pass = pass;
        }
        else throw new Exception("Invalid Data");
    }

    public boolean validate (String email,String pass){
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches() == false){
            return false;
        }
        else{
            if(email.length()<3 || email.length()>50){
                return false;
            }
        }

        if(!pass.matches("^(?=.{8,20}$)(?=.*[A-Z])(?=.*[0-9]).*$"))
            return false;

        return true;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
