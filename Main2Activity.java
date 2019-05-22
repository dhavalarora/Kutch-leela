package com.example.bhoomi.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView masstext, volumetext, rawtext, timehour, textselected, mattext, rodsrequiredtext, rpmspindletext, rpmtotaltext, timetakentext, hourtext, daytext, machinecosttext, totalcosttext, textrod, textfoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        masstext =  findViewById(R.id.mass);
        rawtext = findViewById(R.id.raw);
        rpmspindletext = findViewById(R.id.rpmspindle);
        rpmtotaltext = findViewById(R.id.totalrpm);
        timetakentext = findViewById(R.id.timetaken);
        hourtext = findViewById(R.id.hour);
        daytext = findViewById(R.id.day);
        textrod = findViewById(R.id.rod);
        textfoot = findViewById(R.id.foot);
        mattext = findViewById(R.id.mat);
        machinecosttext = findViewById(R.id.machine);
        totalcosttext = findViewById(R.id.totalcost);
        volumetext = findViewById(R.id.volume);
        timehour = findViewById(R.id.timehour);
        textselected = findViewById(R.id.selectedrpm);
        rodsrequiredtext = findViewById(R.id.rodrequired);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            /*diatext.setText(extras.getString("diameter"));
            lentext.setText(extras.getString("length"));
*/


            masstext.setText(String.format("%.3f", Float.valueOf(extras.getString("mass"))).concat(" Gram"));
            volumetext.setText(String.format("%.3f", Float.valueOf(extras.getString("volume"))).concat(" mm^3"));
            rawtext.setText(String.format("%.2f", Float.valueOf(extras.getString("raw"))).concat(" Rs"));
            rpmspindletext.setText(String.format("%.2f", Float.valueOf(extras.getString("rpmspindle"))).concat(" Rpm"));
            textselected.setText(String.format("%.2f", Float.valueOf(extras.getString("selectedrpm"))).concat(" Rpm"));
            rpmtotaltext.setText(String.format("%.2f", Float.valueOf(extras.getString("rpmtotal"))).concat(" Rpm"));
            timetakentext.setText(String.format("%.2f", Float.valueOf(extras.getString("timetaken"))).concat(" Sec"));
            hourtext.setText(String.format("%.2f", Float.valueOf(extras.getString("hour"))).concat(" Pieces"));
            daytext.setText(String.format("%.2f", Float.valueOf(extras.getString("day"))).concat(" Pieces"));
            textrod.setText(String.format("%.2f", Float.valueOf(extras.getString("rod"))).concat(" Pieces"));
            rodsrequiredtext.setText(String.format("%.2f", Float.valueOf(extras.getString("rodsrequired"))).concat(" Rods"));
            textfoot.setText(String.format("%.2f", Float.valueOf(extras.getString("foot"))).concat(" Pieces"));

            mattext.setText(String.format("%.2f", Float.valueOf(extras.getString("mat"))).concat(" Kg"));
            Float t = Float.valueOf(extras.getString("timetakenrod"));
            float sec = t * 3600;

            int h = (int) sec / 3600;
            int m = (int) (sec % 3600) / 60;
            int s = (int) sec % 60;

            timehour.setText(String.format("%02d" + "h" + ":%02d" + "m" + ":%02d" + "s", h, m, s));
            machinecosttext.setText(String.format("%.2f", Float.valueOf(extras.getString("machinecost"))).concat(" Rs"));
            totalcosttext.setText(String.format("%.2f", Float.valueOf(extras.getString("totalcost"))).concat(" Rs"));
        }

    }


}
