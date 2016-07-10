package com.example.klinten.testdd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.List;

public class WestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oost);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Blik op de toekomst");
        spinnerArray.add("Vriendschap en relaties");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.themadd);
        sItems.setAdapter(adapter);

        LinearLayout gl = (LinearLayout) findViewById(R.id.llgl);
        LinearLayout vr = (LinearLayout) findViewById(R.id.llvr);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
//    private void populateUserInfoList() {
//        ArrayList<UserInfo> locatieInfoList = new ArrayList<UserInfo>();
//        Firebase gezond = new Firebase("https://elancedb.firebaseio.com/Locaties/Amsterdam-Oost/Gezonde%20Levensstijl");
//        gezond.child("Gezonde Levensstijl").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                HashMap<String, Object> gezondelevensstijl = (HashMap<String, Object>) snapshot.getValue();
//                for (Object user : gezondelevensstijl.values()) {
//                    HashMap<String, Object> userMap = (HashMap<String, Object>) user;
//                    String userNumber = (String) userMap.remove("number");
//                    if (!locatieInfoList.contains(userNumber)) {
//                        String name = (String) userMap.remove("username");
//                        String pic = (String) userMap.remove("profile_picture");
//                        UserInfo info = new UserInfo(locatienaam, straatnaam);
//                        locatieInfoList.add(info);
//                    }
//                }
//                // thread executing here can get info from database and make subsequent call
//                Collections.addAll(userInfoList);
//                populateFriendsListView();
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                String message = "Server error. Refresh page";
//                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void populateFriendsListView() {
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
