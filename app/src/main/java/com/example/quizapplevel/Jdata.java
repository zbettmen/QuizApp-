package com.example.quizapplevel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;

public class Jdata extends AppCompatActivity {
        private Button test;
        private TextView country;
        private TextView locations;
        private TextView showTemp;
        private TextView dates;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jdata);
        dates = findViewById(R.id.date_text);
            country = findViewById(R.id.country);
            locations = findViewById(R.id.location);
           showTemp = findViewById(R.id.temp_text);

        test = findViewById(R.id.button_test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeather();
                getDate();

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

                    String locat = jsonObject.getString("name");


                    JSONObject maData = jsonObject.getJSONObject("main");
                    JSONObject mainData = jsonObject.getJSONObject("sys");

                    country.setText(mainData.getString("country"));

                    locations.setText(locat);
                    showTemp.setText(maData.getString("temp"));






            } catch (Exception e) {

                Toast.makeText(getApplicationContext(),"Could not find  :(",Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }

        }
    }

    public void getDate(){
        Calendar calendar = Calendar.getInstance();
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        dates.setText(date);


    }
}





