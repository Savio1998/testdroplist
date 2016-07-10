package com.example.klinten.testdd.Models;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by klinten on 7/10/2016.
 */
public class OostHelper {
    DatabaseReference md;
    ArrayList<Locatie> locaties = new ArrayList<>();


    public OostHelper(DatabaseReference md){
        this.md = md;
    }

    private void getData(DataSnapshot dataSnapshot){
        locaties.clear();

        for(DataSnapshot mDatabase : dataSnapshot.getChildren()){
            Locatie locatie = mDatabase.getValue(Locatie.class);
            locaties.add(locatie);
        }
    }


    public ArrayList<Locatie> retrieve() {
        md.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return locaties;
    }
}
