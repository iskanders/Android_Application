package terrain.foot.com.foot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class SignUpActivity extends AppCompatActivity {
    private EditText log;
    private EditText passwd ;
    private EditText passwd2 ;
    private EditText nom;
    private EditText douche;
    private EditText boteille;
    private EditText ballon;
    private Button signup ;

    FirebaseDatabase database = FirebaseDatabase.getInstance();



    EditText g,m;

    String name;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        View decorView = this.getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);
        g=(EditText)findViewById(R.id.gouvernorat1);
        m=(EditText)findViewById(R.id.Mobile1);
        douche = (EditText)findViewById(R.id.douche1);
        boteille=(EditText)findViewById(R.id.boteille1);
        ballon=(EditText)findViewById(R.id.ballon1);

       back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.setColorFilter(R.color.colorPrimaryDark);
                Intent intent = new Intent(SignUpActivity.this,Login.class);

                startActivity(intent);
                finish();
            }
        });



                  log=(EditText)findViewById(R.id.login);
                  passwd=(EditText)findViewById(R.id.passwd);
                  signup=(Button) findViewById(R.id.valider);
                  nom=  (EditText)findViewById(R.id.nom);
                  passwd2=(EditText)findViewById(R.id.passwd2);




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String login = log.getText().toString();
                final String password = passwd.getText().toString();

                if (TextUtils.isEmpty(login)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 1) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!(passwd.getText().toString().equals((passwd2.getText().toString()))))
                {
                    Toast.makeText(getApplicationContext(), "Passwords entered do not match!", Toast.LENGTH_SHORT).show();
                    return;
                }
                final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
                progressDialog.setTitle("Enregistrement...");
                progressDialog.show();

                String Nom=nom.getText().toString();
                String gouvernorat = g.getText().toString();
                String Mobile= m.getText().toString();
                String Douche = douche.getText().toString();
                String Boteille=boteille.getText().toString();
                String Ballon = ballon.getText().toString();
                UserInfos userinfos=new UserInfos(Douche,Nom,Boteille,Mobile,gouvernorat,Ballon);
                database.getReference().child("newuser").push().setValue(userinfos).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Votre demande est bien enregistrée", Toast.LENGTH_SHORT).show();
                        final Intent intent = new Intent(SignUpActivity.this, SignUpActivity.class);

                        startActivity(intent);
                        finish();
                    }
                });
              //database.getReference().child("Mobile").setValue(Mobile);
               // database.child(user.getUid()).child("Localisation").setValue(gouvernorat)    ;


              /*  auth.createUserWithEmailAndPassword(login, password)
                        .addOnCompleteListener(SignUpActivity.this,  new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                               Toast.makeText(SignUpActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();

                                } else {

                                }
                            }
                        });*/



    }
});
    }

}