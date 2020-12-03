package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

import com.rabelas.weathercurrentday.models.WebpageData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Eq_D extends AppCompatActivity {
    ConstraintLayout cl;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eq_d);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("DURING Earthquake");
        setSupportActionBar(toolbar);

        final TextView bodyText= findViewById(R.id.webBody);
        //final TextView titleText= findViewById(R.id.webTitle);

        new Thread(new Runnable() {

            WebpageData data = new WebpageData();
            @Override
            public void run() {


                try {
                    Document Edoc =  Jsoup.connect("https://www.cofh.org/173/Before-During-and-After-an-Earthquake").get();
                    //Document Vdoc =  Jsoup.connect("https://coins.ph/blog/what-to-do-volcanic-eruption-tips/").get();
                    //Document Fdoc =  Jsoup.connect("http://people360.com.ph/what-to-do-before-during-and-after-a-typhoon").get();

                    Elements EText = Edoc.select("#divEditor69697407-c5dd-435d-8184-85e3d7c18d9e");
                    //Element VText = Vdoc.body();
                    //Elements VText = Vdoc.select("div.mk-single-content.clearfix");
                    //Elements FText = Fdoc.select("#content");

                    // Element bodyText = Edoc.body();
                    data.setPageBody(EText.text());



                    data.extractText("During","After");//this is dependent on the line above
                    // before.extractText("After:","https");//this is dependent on the line above
                    //before.extractText("During:","After:");//this is dependent on the line above
                    // before.extractText("Before:","During");//this is dependent on the line above




                    //before.extractText("THE ERUPTION","Stay safe");//this is dependent on the line above
                    //before.extractText("ERUPTION","AFTER");//this is dependent on the line above,
                    //before.extractText("EXPLOSION","DURING");//this is dependent on the line above,
                    //before.setPageTitle(EBdoc.title());


                } catch (IOException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {//Set to textview thru WebpageData object
                        // titleText.setText(before.getPageTitle());
                        bodyText.setText(data.getPageBody());
                    }
                });
            }
        }).start();
    }
}