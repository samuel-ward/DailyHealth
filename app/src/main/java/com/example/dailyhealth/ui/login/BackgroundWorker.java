package com.example.dailyhealth.ui.login;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.widget.Toast;

import com.example.dailyhealth.Record;
import com.example.dailyhealth.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class BackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    private AlertDialog alertDialog;
    private User user;

    public BackgroundWorker(Context ctx){
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        //IP: Home:: 192.168.1.64
        //IP: Massey:: 10.1.227.240
        String login_url = "http://192.168.1.64/login.php";
        //String login_url = "https://projectpaper.000webhostapp.com/login.php";
        String register_url = "http://192.168.1.64/register.php";
        String update_url = "http://192.168.1.64/update.php";
        String get_user_url = "http://192.168.1.64/get_user.php";

        if(type.equals("login")){
            //Login
            try{
                String username = params[1];
                String password = params[2];

                //Connection to Database
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //Output Stream
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String postData = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                writer.write(postData);
                writer.flush();
                writer.close();
                outputStream.close();

                //Input Stream
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                String result = "";
                String line = "";
                while ((line = reader.readLine()) != null){
                    result += line;
                }
                reader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e){
                return e.getMessage();
            } catch (IOException e){
                return e.getMessage();
            } catch (Exception e){
                return e.getMessage();
            }
        } else if(type.equals("register")){
            //Register
            try{
                String username = params[1];
                String email = params[2];
                String password = params[3];
                String sex = params[4];
                String age = params[5];
                String weight = params[6];
                String height = params[7];

                //Connection to Database
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //Output Stream
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String postData = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        +URLEncoder.encode("sex","UTF-8")+"="+URLEncoder.encode(sex,"UTF-8")+"&"
                        +URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"
                        +URLEncoder.encode("weight","UTF-8")+"="+URLEncoder.encode(weight,"UTF-8")+"&"
                        +URLEncoder.encode("height","UTF-8")+"="+URLEncoder.encode(height,"UTF-8");
                writer.write(postData);
                writer.flush();
                writer.close();
                outputStream.close();

                //Input Stream
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                String result = "";
                String line = "";
                while ((line = reader.readLine()) != null){
                    result += line;
                }
                reader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e){
                return e.getMessage();
            } catch (IOException e){
                return e.getMessage();
            } catch (Exception e){
                return e.getMessage();
            }
        } else if(type.equals("update")){
            //Update
            try{
                String username = params[1];
                String password = params[2];
                String records = params[3];

                //Connection to Database
                URL url = new URL(update_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //Output Stream
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String postData = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        +URLEncoder.encode("records","UTF-8")+"="+URLEncoder.encode(records,"UTF-8");
                writer.write(postData);
                writer.flush();
                writer.close();
                outputStream.close();

                //Input Stream
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                String result = "";
                String line = "";
                while ((line = reader.readLine()) != null){
                    result += line;
                }
                reader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e){
                return e.getMessage();
            } catch (IOException e){
                return e.getMessage();
            } catch (Exception e){
                return e.getMessage();
            }
        } else if(type.equals("login2")){
            //Java Connection -- Didin't Work
            try{
                String user_name = params[1];
                String password = params[2];
                user = user.getInstance();
                ArrayList<Record> list;
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myURL = "jdbc:mysql://http://10.101.227.247:80/daily_health_login";
                Class.forName(myDriver);
                Connection connection = DriverManager.getConnection(myURL,"root","");

                //Query
                String query = "SELECT username, email, password, sex, age, weight, height, records FROM user_data WHERE username='"+
                        user_name+"' AND password='"+password+"'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                String name = resultSet.getString("username");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("password");
                int sex = resultSet.getInt("sex");
                int age = resultSet.getInt("age");
                int weight = resultSet.getInt("weight");
                int height = resultSet.getInt("height");
                String records = resultSet.getString("records");
                statement.close();

                //Populate User
                user.setUsername(name);
                user.setEmail(email);
                user.setPassword(pass);
                if(sex == 0){
                    user.setSex(false);
                } else {
                    user.setSex(true);
                }
                user.setAge(age);
                user.setWeight(weight);
                user.setHeight(height);
                Gson gson = new Gson();
                list = gson.fromJson(records, new TypeToken<List<Record>>(){}.getType());
                user.setRecordList(list);
                user.setRegistered(true);

            }catch (Exception e){
                return e.getMessage();
            }

        } else if(type.equals("get_user")){
            //Get User Data
            try{
                String username = params[1];
                String password = params[2];

                //Connection to Database
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //Output Stream
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String postData = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                writer.write(postData);
                writer.flush();
                writer.close();
                outputStream.close();

                //Input Stream
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                String result = "";
                String line = "";
                while ((line = reader.readLine()) != null){
                    result += line;
                }
                reader.close();
                inputStream.close();
                httpURLConnection.disconnect();
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
        //Get rid of alert
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        //super.onPostExecute(result);
        //alertDialog.setMessage(result);
        //alertDialog.show();
        Toast.makeText(context,"Login Status: "+result,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
