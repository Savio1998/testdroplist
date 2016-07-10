package com.example.klinten.testdd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.klinten.testdd.Models.CustomAdapterOost;
import com.example.klinten.testdd.Models.Locatie;
import com.example.klinten.testdd.Models.OostHelper;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class OostActivity extends AppCompatActivity {
    TextView  textView1, textView2, textView3 , textView4, textView5, textView6, textView7, textView8, textView9, textView10;
    LinearLayout glll, gl, vr;
    ListView listgl;
    CustomAdapterOost adapterOost;
    OostHelper helper;
    private DatabaseReference mDatabase;
    ArrayList<Locatie> locatielist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oost);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        glll = (LinearLayout) findViewById(R.id.glll);
        gl = (LinearLayout) findViewById(R.id.llgl);
        vr = (LinearLayout) findViewById(R.id.llvr);
        listgl = (ListView) findViewById(R.id.listViewgl);
        helper = new OostHelper(mDatabase);

        adapterOost = new CustomAdapterOost(this, locatielist);
        listgl.setAdapter(adapterOost);
        mDatabase.addValueEventListener(new ValueEventListener() {
            final String TAG = "";

//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
//                    String attractie = (String) messageSnapshot.child("Amsterdam-Oost").child("Gezonde Levensstijl").getValue();
//                    String adres = (String) messageSnapshot.child("Attractie").child("adres").getValue();
//                    Log.d(TAG, "Value is: " + attractie);
//            }    }
//
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    getData(dataSnapshot);
                }

                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    getData(dataSnapshot);
                }

                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



//        textView1 = (TextView) findViewById(R.id.textView1);
////        textView1.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView1. setMovementMethod(LinkMovementMethod.getInstance());
//
//        textView2 = (TextView) findViewById(R.id.textView2);
////        textView2.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView2. setMovementMethod(LinkMovementMethod.getInstance());
//
//        textView3 = (TextView) findViewById(R.id.textView3);
////        textView3.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView3. setMovementMethod(LinkMovementMethod.getInstance());
//
//        textView4 = (TextView) findViewById(R.id.textView4);
////        textView4.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView4. setMovementMethod(LinkMovementMethod.getInstance());
//
//        textView5 = (TextView) findViewById(R.id.textView5);
////        textView5.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView5. setMovementMethod(LinkMovementMethod.getInstance());
//
//        textView6 = (TextView) findViewById(R.id.textView6);
////        textView6.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView6. setMovementMethod(LinkMovementMethod.getInstance());
//
//        textView7 = (TextView) findViewById(R.id.textView7);
////        textView7.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView7. setMovementMethod(LinkMovementMethod.getInstance());
//
//        textView8 = (TextView) findViewById(R.id.textView8);
////        textView8.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView8. setMovementMethod(LinkMovementMethod.getInstance());
//
//        textView9 = (TextView) findViewById(R.id.textView9);
////        textView9.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView9. setMovementMethod(LinkMovementMethod.getInstance());
//
//        textView10 = (TextView) findViewById(R.id.textView10);
////        textView10.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
////        textView10. setMovementMethod(LinkMovementMethod.getInstance());


        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Gezonde Levensstijl");
        spinnerArray.add("Vriendschappen en relaties");
        spinnerArray.add("Blik op de toekomst");
        spinnerArray.add("Cultuur en ik");
        spinnerArray.add("Talentontwikkeling");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.themadd);
        sItems.setAdapter(adapter);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position == 0){
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    private void getData(DataSnapshot dataSnapshot){
        locatielist.clear();

        for(DataSnapshot mDatabase : dataSnapshot.getChildren()){
            Locatie locatie = mDatabase.getValue(Locatie.class);
            locatielist.add(locatie);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_oost, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(item.getItemId()) {
            case R.id.action_list:
                Intent intent = new Intent(this, OostActivity.class);
                this.startActivity(intent);
                break;
            case R.id.action_voegtoe:
                Intent intent2 = new Intent(this, OostAddActivity.class);
                this.startActivity(intent2);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
