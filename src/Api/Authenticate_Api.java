package Api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Authenticate_Api {

    private HttpURLConnection connection;
    static int response;
    private InputStream inputStream;


    public JSONObject Register(JSONObject data) {
        try{
            connection = (HttpURLConnection) new URL("https://reqres.in/api/register").openConnection();
            connection.setRequestMethod( "POST" );
            connection.setRequestProperty( "Content-Type", "application/json");
            connection.setRequestProperty( "charset", "utf-8");
            connection.setDoOutput( true );
            DataOutputStream we = new DataOutputStream(connection.getOutputStream());
            we.writeBytes(data.toString());
            we.close();
            response = connection.getResponseCode();
            if (200 <= response && response <= 299)
                inputStream = connection.getInputStream();
            else
                inputStream = connection.getErrorStream();
            BufferedReader in  = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String currentline;
            while ((currentline = in.readLine())!= null)
                response.append(currentline);
            JSONParser parser = new JSONParser();
            JSONObject resultObject = (JSONObject) parser.parse(response.toString());
            resultObject.put("header",connection.getHeaderFields());
            return resultObject;
        }catch (NullPointerException e){

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public JSONObject Login(JSONObject data) {
        try{
            connection = (HttpURLConnection) new URL("https://reqres.in/api/login").openConnection();
            connection.setRequestMethod( "POST" );
            connection.setRequestProperty( "Content-Type", "application/json");
            connection.setRequestProperty( "charset", "utf-8");
            connection.setDoOutput( true );
            DataOutputStream we = new DataOutputStream(connection.getOutputStream());
            we.writeBytes(data.toString());
            we.close();
            response = connection.getResponseCode();
            if (200 <= response && response <= 299)
                inputStream = connection.getInputStream();
            else
                inputStream = connection.getErrorStream();
            BufferedReader in  = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String currentline;
            while ((currentline = in.readLine())!= null)
                response.append(currentline);
            JSONParser parser = new JSONParser();
            JSONObject resultObject = (JSONObject) parser.parse(response.toString());
            resultObject.put("header",connection.getHeaderFields());
            return resultObject;
        }catch (NullPointerException e){

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Authenticate_Api() {
    }
}
