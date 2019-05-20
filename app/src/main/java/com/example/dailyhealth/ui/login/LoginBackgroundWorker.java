package com.example.dailyhealth.ui.login;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

public class LoginBackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    private AlertDialog alertDialog;

    LoginBackgroundWorker (Context ctx){
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String username = params[1];
        String password = params[2];
        String login_url = "https://192.168.1.64/login.php";
        //String login_url = "https://projectpaper.000webhostapp.com/login.php";

        if(type.equals("login")){
            try{
                //Connection to Database
                URL url = new URL(login_url);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);

                //Output Stream
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String postData = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                writer.write(postData);
                writer.flush();
                writer.close();
                outputStream.close();

                //Input Stream
                InputStream inputStream = httpsURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                String result = "";
                String line = "";
                while ((line = reader.readLine()) != null){
                    result += line;
                }
                reader.close();
                inputStream.close();
                httpsURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e){
                return e.getMessage();
            } catch (IOException e){
                return e.getMessage();
            } catch (Exception e){
                return e.getMessage();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        //super.onPreExecute();
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        //super.onPostExecute(result);
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
