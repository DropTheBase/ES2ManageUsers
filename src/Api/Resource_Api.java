package Api;

import Class.Resource;
import Connection_Interfaces.Method_Connection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Resource_Api implements Method_Connection {

    private HttpURLConnection connection;
    static int response;
    private InputStream inputStream;

    @Override
    public JSONObject Post(JSONObject data) {
        try{
            connection = (HttpURLConnection) new URL("https://reqres.in/api/now").openConnection();
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

    @Override
    public JSONObject Get(JSONObject data){
        if(data != null){
            try{
                Integer id = Integer.valueOf(data.get("id").toString());
                connection = (HttpURLConnection) new URL("https://reqres.in/api/now/"+id).openConnection();
                connection.setRequestMethod( "GET" );
                connection.setRequestProperty( "Content-Type", "application/json");
                connection.setRequestProperty( "charset", "utf-8");
                connection.setDoOutput( true );
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
        }
        else{

            try{

                connection = (HttpURLConnection) new URL("https://reqres.in/api/now").openConnection();
                connection.setRequestMethod( "GET" );
                connection.setRequestProperty( "Content-Type", "application/json");
                connection.setRequestProperty( "charset", "utf-8");
                connection.setDoOutput( true );
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
                ArrayList<String> header = new ArrayList<>();
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
        }
        return null;
    }

    @Override
    public JSONObject Delete(JSONObject data) {
        try{
            Integer id = Integer.valueOf(data.get("id").toString());
            connection = (HttpURLConnection) new URL("https://reqres.in/api/now/"+id).openConnection();
            connection.setRequestMethod( "DELETE" );
            connection.setRequestProperty( "Content-Type", "application/json");
            connection.setRequestProperty( "charset", "utf-8");
            connection.setDoOutput( true );
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
            JSONObject resultObject = new JSONObject();
            resultObject.put("header",connection.getHeaderFields());
            return resultObject;
        }catch (NullPointerException e){

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject Update(JSONObject data) {
        try{
            Integer id = Integer.valueOf(data.get("id").toString());
            data.remove("id");
            connection = (HttpURLConnection) new URL("https://reqres.in/api/now/"+id).openConnection();
            connection.setRequestMethod( "PUT" );
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

    @Override
    public boolean Validate_Schema(JSONObject jsonObject) {
        Resource resource = new Resource();
        boolean x = resource.validate(jsonObject.get("name").toString(),Integer.valueOf(jsonObject.get("year").toString()),jsonObject.get("color").toString()
                ,jsonObject.get("pantone_value").toString());
        return x;
    }
}
