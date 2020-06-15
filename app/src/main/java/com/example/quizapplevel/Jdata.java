package com.example.quizapplevel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Jdata extends AppCompatActivity {
        private TextView showTemp;
        private TextView showP;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jdata);

        showTemp = findViewById(R.id.r_button1);
        showP = findViewById(R.id.r_button2);
        showTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!getWeather()){
                    
                }
            }

        });

        showP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!getWeather())
            }
        });


    }

    public boolean getWeather() {
        try {
            DownloadTask task = new DownloadTask();


            task.execute("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Could not find ",Toast.LENGTH_SHORT).show();
        }
        return false;
    }



    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;

            } catch (Exception e) {
                e.printStackTrace();

                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);

                String weatherInfo = jsonObject.getString("weather");


                    JSONObject mainData = jsonObject.getJSONObject("main");
                    JSONArray arr = new JSONArray(weatherInfo);

                String message = "";

                for (int i=0; i < arr.length(); i++) {
                    JSONObject jsonPart = arr.getJSONObject(i);

                    String main = jsonPart.getString("main");
                    String description = jsonPart.getString("description");


                        message += main + ": " + description +  "\r\n";
                }
                    showTemp.setText(mainData.getString("temp"));
                    showP.setText(mainData.getString("pressure"));
                    //shows.setText(message);

            } catch (Exception e) {

                Toast.makeText(getApplicationContext(),"Could not find  :(",Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }

        }
    }
}





