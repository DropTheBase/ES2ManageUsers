package com;

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
