package com.andaratech.movieapp.config;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Asus on 12/08/2017.
 */

public class unbook extends AsyncTask<String, Void, String> {
    private Context context;
    private String link = Server.link;
    public unbook (Context context) {
        this.context = context;
    }

    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... arg0) {
        String android_id   = arg0[0];
        String book_id      = arg0[1];

        String data;
        BufferedReader bufferedReader;
        String result;
        try {
            data = "?android_id=" + URLEncoder.encode(android_id, "UTF-8");
            data += "&bookmark_id=" + URLEncoder.encode(book_id, "UTF-8");

            link = link + "unbook.php" + data;
            Log.d("Log link", link);

            URL url = new URL(link);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String jsonStr = result;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String response = jsonObj.getString("response");
                if (response.equals("success")) {
                    Toast.makeText(context, "Romoved from bookmark", Toast.LENGTH_SHORT).show();
                } else if (response.equals("failed")) {
                    Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("Log error", "Couldn't connect to remote database.");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.d("Log error", "Couldn't get any JSON data.");
        }
    }
}
