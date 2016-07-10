package com.example.klinten.testdd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class NoordActivity extends AppCompatActivity {
    LinearLayout gl;
    TextView  textView1, textView2, textView3 , textView4, textView5, textView6, textView7, textView8, textView9, textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noord);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView1 = (TextView) findViewById(R.id.textView1);
//        textView1.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView1. setMovementMethod(LinkMovementMethod.getInstance());

        textView2 = (TextView) findViewById(R.id.textView2);
//        textView2.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView2. setMovementMethod(LinkMovementMethod.getInstance());

        textView3 = (TextView) findViewById(R.id.textView3);
//        textView3.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView3. setMovementMethod(LinkMovementMethod.getInstance());

        textView4 = (TextView) findViewById(R.id.textView4);
//        textView4.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView4. setMovementMethod(LinkMovementMethod.getInstance());

        textView5 = (TextView) findViewById(R.id.textView5);
//        textView5.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView5. setMovementMethod(LinkMovementMethod.getInstance());

        textView6 = (TextView) findViewById(R.id.textView6);
//        textView6.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView6. setMovementMethod(LinkMovementMethod.getInstance());

        textView7 = (TextView) findViewById(R.id.textView7);
//        textView7.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView7. setMovementMethod(LinkMovementMethod.getInstance());

        textView8 = (TextView) findViewById(R.id.textView8);
//        textView8.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView8. setMovementMethod(LinkMovementMethod.getInstance());

        textView9 = (TextView) findViewById(R.id.textView9);
//        textView9.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView9. setMovementMethod(LinkMovementMethod.getInstance());

        textView10 = (TextView) findViewById(R.id.textView10);
//        textView10.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
//        textView10. setMovementMethod(LinkMovementMethod.getInstance());

        setSupportActionBar(toolbar);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Blik op de toekomst");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.themadd);
        sItems.setAdapter(adapter);

        gl = (LinearLayout) findViewById(R.id.llto);

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
