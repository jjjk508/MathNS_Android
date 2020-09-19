package com.example.mathns.task;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckTask extends AsyncTask<String, Void, String> {
    public static String ip = "49.50.167.225:8080";
    String sendMsg,receiveMsg;
    String serverip = "http://"+ip+"/MathNS/app/joinCheck.jsp";

    @Override
    protected String doInBackground(String... strings) {
       try{
           String str;
           URL url = new URL(serverip);
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
           conn.setRequestMethod("POST");
           OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

           sendMsg = "userID="+strings[0];

           osw.write((sendMsg));
           osw.flush();

           if(conn.getResponseCode()==conn.HTTP_OK){
               InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
               BufferedReader reader = new BufferedReader(tmp);
               StringBuffer buffer = new StringBuffer();
               while ((str = reader.readLine()) != null) {
                   buffer.append(str);
               }
               receiveMsg = buffer.toString();
           }else {
               Log.i("통신 결과", conn.getResponseCode()+"에러");
           }
       }catch (MalformedURLException e){
           e.printStackTrace();
       } catch ( IOException e ){
           e.printStackTrace();
       }

        return receiveMsg;
    }
}
