package com.example.bhoomi.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.DOMImplementation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {


    float rate,volume,d,m,mass,raw,rpmtotal=0,rpmspindle,piece,mat,cuttingspeed,diameter,length,rpm,timetaken,sum,hour,day,machinecost,totalcost,lengthrod,selectedrpm;
int opcount;
    Button okbutton,addbutton;
   EditText editdiameter,editlength,editvolume,editpiece,editmat,editrate,editcuttingspeed,edittimetaken,dis,doc,editlengthrod,editselectedrpm;


   Spinner spinner,spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okbutton=findViewById(R.id.ok);
        addbutton=findViewById(R.id.add);
        spinner=findViewById(R.id.densityvalue);
       spinner2=findViewById(R.id.machinevalue);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        int item=adapterView.getSelectedItemPosition();

                        switch (item)
                        {
                            case 0:  d=8;
                                    cuttingspeed=60;
                                    rate=80;
                                    break;
                            case 1:  d=9;
                                    cuttingspeed=80;
                                    rate=600;
                                    break;
                            case 2:  d=9;
                                    cuttingspeed=100;
                                    rate=470;
                                    break;
                            case 3:  d=3;
                                    cuttingspeed=120;
                                    rate=300;
                                    break;
                            case 4:  d=8;
                                    cuttingspeed=40;
                                    rate=300;
                                    break;
                            case 5:  d=8;
                                    cuttingspeed=50;
                                    rate=55;
                                    break;
                        }
                        System.out.println("d:"+d);

                     editcuttingspeed=findViewById(R.id.cuttingspeed);
                    String cuttinspeeds=Float.toString(cuttingspeed);
                    editcuttingspeed.setText(cuttinspeeds);

                         editrate=findViewById(R.id.rate);
                        String rates=Float.toString(rate);
                        editrate.setText(rates);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

       spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int item=adapterView.getSelectedItemPosition();

                switch (item) {
                    case 0:
                        m = 1500;
                        break;
                    case 1:
                        m = 1200;
                        break;
                    case 2:
                        m = 1200;
                        break;
                    case 3:
                        m = 2000;
                        break;
                }
                System.out.println("M:"+m);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.density, android.R.layout.simple_spinner_dropdown_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(this, R.array.machine, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        editdiameter=(EditText) findViewById(R.id.diametervalue);


        editdiameter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.equals(""))
                {
                    String diameters=editdiameter.getText().toString();
                    diameter=Float.parseFloat(diameters);
                    rpmspindle=1000*cuttingspeed/(float) Math.PI/diameter;

                    TextView t=(TextView)findViewById(R.id.rpmspindle);
                    t.setText(String.valueOf(rpmspindle));

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        addbutton.setOnClickListener(new View.OnClickListener() {
    @Override
            public void onClick(View view) {

                dis=findViewById(R.id.dis);
                doc=findViewById(R.id.doc);

                float disvalue=Float.valueOf(dis.getText().toString());
                float docvalue=Float.valueOf(doc.getText().toString());
                float div=disvalue/docvalue;

       // System.out.println("DIV:"+div);
                sum=sum+div;
                System.out.println("sum:"+sum);

                dis.setText(" ");
                doc.setText(" ");
            opcount=opcount+1;
        Toast.makeText(getApplicationContext(),"Operation no."+opcount+ " is added",Toast.LENGTH_SHORT).show();

        }
});




        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("onclick");


                editlength=(EditText) findViewById(R.id.lengthvalue);
                String lengths=editlength.getText().toString();
                 length=Float.parseFloat(lengths);

                editlengthrod=findViewById(R.id.lengthrod);
                String lengthrods=editlengthrod.getText().toString();
                lengthrod=Float.parseFloat(lengthrods);

                editselectedrpm=findViewById(R.id.selectdrpm);
                String selectedrpms=editselectedrpm.getText().toString();
                selectedrpm=Float.parseFloat(selectedrpms);

                editpiece=findViewById(R.id.piece);
                String editpieces=editpiece.getText().toString();
                piece=Float.parseFloat(editpieces);



                volume=((float)Math.PI/4)*diameter*diameter*length;
                mass=volume*d/1000;
                raw=mass*rate/1000;
                rpmspindle=1000*cuttingspeed/(float) Math.PI/diameter;

                rpmtotal=sum;
                timetaken=rpmtotal/selectedrpm*60;
                hour=3600/timetaken;
                day=8*hour;
                machinecost=m/day;
                totalcost=machinecost+raw;
                mat=(float) (piece+piece/100*10)*mass/1000;

                float foot=(float)304.8/length;
                float rod=foot*lengthrod;
                float timetakenrod=rod*timetaken/3600;
                float rodsrequired=piece/rod;

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

//                System.out.println("mass in activity1:"+mass);

                intent.putExtra("mass",String.valueOf(mass));
                intent.putExtra("volume",String.valueOf(volume));
                intent.putExtra("raw",String.valueOf(raw));
                intent.putExtra("selectedrpm", String.valueOf(selectedrpm));
                intent.putExtra("rpmspindle",String.valueOf(rpmspindle));
                intent.putExtra("rpmtotal",String.valueOf(rpmtotal));
                intent.putExtra("timetaken",String.valueOf(timetaken));
                intent.putExtra("hour",String.valueOf(hour));
                intent.putExtra("day",String.valueOf(day));
                intent.putExtra("foot",String.valueOf(foot));
                intent.putExtra("rod",String.valueOf(rod));
                intent.putExtra("rodsrequired",String.valueOf(rodsrequired));
                intent.putExtra("timetakenrod",String.valueOf(timetakenrod));
                intent.putExtra("mat",String.valueOf(mat));
                intent.putExtra("machinecost",String.valueOf(machinecost));
                intent.putExtra("totalcost",String.valueOf(totalcost));

                startActivity(intent);

            }
        });


    }
    }




