package com.example.klinten.testdd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.klinten.testdd.Models.Locatie;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by klinten on 7/8/2016.
 */
public class OostAddActivity extends AppCompatActivity{
        Button button;
        LinearLayout glll, gl, vr;
        EditText attractie, categorie, adres, postcode, tel;
        private DatabaseReference mDatabase;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addoost);
        mDatabase = FirebaseDatabase.getInstance().getReference();;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        mDatabase.addValueEventListener(new ValueEventListener() {
//            final String TAG = "";
//
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
//                    String attractie = (String) messageSnapshot.child("Amsterdam-Oost").getValue();
//                    String adres = (String) messageSnapshot.child("Attractie").getValue();
//                    Log.d(TAG, "Value is: " + attractie);
//                }
//            }
//
//
//            public void onChildRemoved(DataSnapshot dataSnapshot, Collection adapter) {
//                adapter.remove((String) dataSnapshot.child("text").getValue());
//            }
//
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//            }
//
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
        // Add items via the Button and EditText at the bottom of the window.
        button = (Button) findViewById(R.id.buttongl);
        attractie = (EditText) findViewById(R.id.field_attractie);
        categorie = (EditText) findViewById(R.id.field_categorie);
        adres = (EditText) findViewById(R.id.field_adres);
        postcode = (EditText) findViewById(R.id.field_postcode);
        tel = (EditText) findViewById(R.id.field_tel);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                populateGLList();
            }
        });

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
        }

    private void populateGLList() {
        final String attracties = attractie.getText().toString();
        final String categorien = categorie.getText().toString();
        final String adressen = adres.getText().toString();
        final String postcodes = postcode.getText().toString();
        final String telefoon = tel.getText().toString();


        if (TextUtils.isEmpty(attracties)) {
            attractie.setError("Verplicht");
            return;
        }
        if (TextUtils.isEmpty(categorien)) {
            categorie.setError("Verplicht");
            return;
        }

        if (TextUtils.isEmpty(adressen)) {
            adres.setError("Verplicht");
            return;
        }

        if (TextUtils.isEmpty(postcodes)) {
            postcode.setError("Verplicht");
            return;
        }

        Locatie location = new Locatie(attracties, categorien, adressen, postcodes, telefoon);
        DatabaseReference bestemming = mDatabase.child("Locaties").child("Amsterdam")
                .child("Amsterdam-Oost").child("Gezonde Levensstijl").push();
        bestemming.setValue(location);
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
