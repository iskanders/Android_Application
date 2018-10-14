package terrain.foot.com.foot;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Welcom extends AppCompatActivity {
    String id,Email;
    static  StadeModel stade;
    TextView verfcnx;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vide);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Email = getvalue("Email", getValue("Email"));
        verfcnx=findViewById(R.id.verfcnx);
        final ProgressBar progressBar = findViewById(R.id.determinateBar);
        progressBar.setProgress(0);
        progressBar.showContextMenu();
        progressBar.setProgress(30);

        progressBar.setProgress(35);

            task:
            {

                if (isNetworkAvailable()) {

                    progressBar.setProgress(20);

                    if (getValue("id") == -1) {

                        Intent intent = new Intent(Welcom.this, Login.class);
                        intent.putExtra("Email", Email);
                        startActivity(intent);
                        finish();
                    } else {


                        id = getvalue("id", getValue("id"));
                        final Intent intent = new Intent(Welcom.this, Profile.class);
                        intent.putExtra("id", id);
                        intent.putExtra("Email", Email);
                        progressBar.setProgress(45);
                        progressBar.setProgress(60);
                        progressBar.setProgress(65);
                        progressBar.setProgress(70);


                        myRef.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                progressBar.setProgress(80);
                                stade = new StadeModel(0, dataSnapshot.child("firstName").getValue().toString(), dataSnapshot.child("localisation").getValue().toString(), id, dataSnapshot.child("profilePic").getValue().toString(), Integer.parseInt(dataSnapshot.child("phoneNumber").getValue().toString()), Integer.parseInt(dataSnapshot.child("bottelnumb").getValue().toString()), Integer.parseInt(dataSnapshot.child("ballnumb").getValue().toString()),Integer.parseInt(dataSnapshot.child("douchenumb").getValue().toString()));

                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                progressBar.setProgress(99);
                                startActivity(intent);
                                finish();

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


                    }
                }else {
                    RelativeLayout no = findViewById(R.id.no_connexion);
                    no.setVisibility(View.VISIBLE);
                    verfcnx.setVisibility(View.VISIBLE);
                    verfcnx.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final Intent intent = new Intent(Welcom.this, Welcom.class);

                            startActivity(intent);
                            finish();
                        }
                    });

                }


            }

    }
    public int getValue(String name) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        return prefs.getInt(name, -1);
    }

    private boolean isNetworkAvailable() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
public String getvalue(String file,int len){
    try{
        FileInputStream fIn = openFileInput(file);
        InputStreamReader isr = new InputStreamReader(fIn);
        char[] inputBuffer = new char[len];
        //len is the length of that saved string in the file

        isr.read(inputBuffer);

        String readString = new String(inputBuffer);
        return readString;
    }catch(IOException e){

    }
return null;
}
    }
