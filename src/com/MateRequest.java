package com;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MateRequest {
    public int connectionStatus(String link, String method, String header) throws IOException {
        int statusCode = 0;

        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.connect();

        String jsinput = String.format(header);

        try(OutputStream outstream = connection.getOutputStream()) {
            byte[] input = jsinput.getBytes("utf-8");
            outstream.write(input, 0, input.length);
        }

        statusCode = connection.getResponseCode();

        connection.disconnect();

        return statusCode;
    }

    public String ResponseGET(String link){
        URL url = null;
        String inline = "";
        try {
            url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            int status = connection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader buferreader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                StringBuffer content = new StringBuffer();

                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext())
                {
                    inline+=scanner.nextLine();
                }

                buferreader.close();
            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inline;
    }

    public String ResponsePOST(String link, String method, String header){
        URL url = null;
        String teste = "";
        try {
            url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            try(OutputStream outstream = connection.getOutputStream()) {
                byte[] input = header.getBytes("utf-8");
                outstream.write(input, 0, input.length);
            }

            int status = connection.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK || status == HttpURLConnection.HTTP_CREATED){
                try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    String responseLine = null;
                    int i = 0;

                    while ((responseLine = br.readLine()) != null) {
                        teste = responseLine.trim();
                        i++;
                    }
                }
            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teste;
    }


}












































































/*CODIGO ANTIGO



    public static String executeGet(String targetURL){
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("User-Agent", "Mozilla/4.0"); //serve para fingir o meu codigo de browser
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static String executePost(String targetURL, String urlParameters) throws IOException {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.addRequestProperty("User-Agent", "Mozilla/4.0"); //serve para fingir o meu codigo de browser
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            InputStream is;
            //Get Response
            if(connection.getResponseCode()>= 200 && connection.getResponseCode()<=299){

                is = connection.getInputStream();
            }else{
                is = connection.getErrorStream();

            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            //e.printStackTrace(); //comentar futuramente
            JSONObject json = new JSONObject();

            int status = connection.getResponseCode();
            json.put("status",status);
            return json.toString();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
 */