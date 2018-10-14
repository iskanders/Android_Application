package terrain.foot.com.foot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import static terrain.foot.com.foot.Welcom.stade;

public class InfoEdit extends AppCompatActivity {
    ImageView back;
    EditText name, localisation, numero,editbtl,editball,editdouche;
    Button modifName, modifnum, modifloc, enregistrer, annuler,modifbttl,modifball,modifdouche;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");
    Boolean changement=false;
    Boolean one=false;
    Boolean two=false;
    Boolean three=false;
    boolean zero=false;
    boolean four=false;
    boolean five=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile3);
        back = (ImageView) findViewById(R.id.back);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        View decorView = this.getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);        Intent intent= getIntent();
        final String  id = intent.getStringExtra("id");
        final String  Email = intent.getStringExtra("Email");
        name=(EditText)findViewById(R.id.editname);
        localisation=(EditText)findViewById(R.id.editloc);
        editbtl=(EditText)findViewById(R.id.editbtl);
        editdouche=(EditText)findViewById(R.id.editdouche);
        editball=(EditText)findViewById(R.id.editball);
        numero=(EditText)findViewById(R.id.editnum);
        modifName= findViewById(R.id.namebutton);
        modifloc=findViewById(R.id.locbutton);
        modifnum=findViewById(R.id.numbutton);
        modifdouche=findViewById(R.id.douchebutton);
        modifbttl=findViewById(R.id.btlbutton);
        modifball=findViewById(R.id.ballbutton);
        enregistrer=findViewById(R.id.enregitrer);
        annuler=findViewById(R.id.annuler);
        enregistrer.setVisibility(View.INVISIBLE);
        annuler.setVisibility(View.INVISIBLE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //back.setColorFilter(R.color.colorPrimary);
                Intent intent = new Intent(InfoEdit.this,Parametree.class);
                intent.putExtra("id", id);
                intent.putExtra("Email", Email);
                startActivity(intent);
                finish();
            }
        });

        localisation.setText(stade.getLocalisation());
        name.setText(stade.getFirstName());
        numero.setText(""+stade.getMobile());
        editbtl.setText(""+stade.getBottelnumb());
        editball.setText(""+stade.getBallnumb());
        editdouche.setText(""+stade.getDouchenumb());
//localisation.setKeyListener(null);
//name.setKeyListener(null);
//numero.setKeyListener(null);
localisation.setEnabled(false);
name.setEnabled(false);
numero.setEnabled(false);
        editbtl.setEnabled(false);
        modifbttl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zero=true;

                editbtl.setEnabled(true);
                enregistrer.setVisibility(View.VISIBLE);
                annuler.setVisibility(View.VISIBLE);
                editball.setEnabled(false);
                editdouche.setEnabled(false);
                name.setEnabled(false);
                numero.setEnabled(false);
                localisation.setEnabled(false);
                enregistrer.setEnabled(true);
                modifloc.setEnabled(false);
                modifdouche.setEnabled(false);
                modifball.setEnabled(false);
                modifnum.setEnabled(false);
modifName.setEnabled(false);
                modifball.setTextColor(getResources().getColor(R.color.gris1));
                modifbttl.setTextColor(getResources().getColor(R.color.vert2));
                modifName.setTextColor(getResources().getColor(R.color.gris1));
                modifloc.setTextColor(getResources().getColor(R.color.gris1));
                modifnum.setTextColor(getResources().getColor(R.color.gris1));
                modifdouche.setTextColor(getResources().getColor(R.color.gris1));


            }
        });
modifName.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        one=true;


        enregistrer.setVisibility(View.VISIBLE);
        annuler.setVisibility(View.VISIBLE);
        name.setEnabled(true);
        modifloc.setEnabled(false);
        modifdouche.setEnabled(false);
        modifball.setEnabled(false);
        modifnum.setEnabled(false);
        modifbttl.setEnabled(false);
        editball.setEnabled(false);
        editdouche.setEnabled(false);
        editbtl.setEnabled(false);
        numero.setEnabled(false);
        localisation.setEnabled(false);
       enregistrer.setEnabled(true);

        modifball.setTextColor(getResources().getColor(R.color.gris1));

        modifName.setTextColor(getResources().getColor(R.color.vert2));
        modifloc.setTextColor(getResources().getColor(R.color.gris1));
        modifnum.setTextColor(getResources().getColor(R.color.gris1));
        modifbttl.setTextColor(getResources().getColor(R.color.gris1));
        modifdouche.setTextColor(getResources().getColor(R.color.gris1));




    }
});

modifloc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        two=true;

        enregistrer.setVisibility(View.VISIBLE);
        annuler.setVisibility(View.VISIBLE);
        localisation.setEnabled(true);
        modifloc.setEnabled(false);
        modifdouche.setEnabled(false);
        modifball.setEnabled(false);
        modifnum.setEnabled(false);
        modifbttl.setEnabled(false);
        editball.setEnabled(false);
        editdouche.setEnabled(false);
        editbtl.setEnabled(false);
        numero.setEnabled(false);
        modifName.setEnabled(false);

        name.setEnabled(false);
        modifball.setTextColor(getResources().getColor(R.color.gris1));

        modifloc.setTextColor(getResources().getColor(R.color.vert2));
        modifName.setTextColor(getResources().getColor(R.color.gris1));
        modifnum.setTextColor(getResources().getColor(R.color.gris1));
        modifbttl.setTextColor(getResources().getColor(R.color.gris1));
        modifdouche.setTextColor(getResources().getColor(R.color.gris1));


    }
});

modifnum.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        three=true;
        enregistrer.setVisibility(View.VISIBLE);
        annuler.setVisibility(View.VISIBLE);
       enregistrer.setEnabled(true);
        numero.setEnabled(true);
        modifloc.setEnabled(false);
        modifdouche.setEnabled(false);
        modifball.setEnabled(false);
        modifnum.setEnabled(false);
        modifbttl.setEnabled(false);
        editball.setEnabled(false);
        editdouche.setEnabled(false);
        editbtl.setEnabled(false);
        name.setEnabled(false);
        modifName.setEnabled(false);
        localisation.setEnabled(false);
        modifball.setTextColor(getResources().getColor(R.color.gris1));
        modifnum.setTextColor(getResources().getColor(R.color.vert2));
        modifloc.setTextColor(getResources().getColor(R.color.gris1));
        modifName.setTextColor(getResources().getColor(R.color.gris1));
        modifbttl.setTextColor(getResources().getColor(R.color.gris1));
        modifdouche.setTextColor(getResources().getColor(R.color.gris1));


    }
});
        modifball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                four=true;
                enregistrer.setVisibility(View.VISIBLE);
                annuler.setVisibility(View.VISIBLE);
                enregistrer.setEnabled(true);
                editball.setEnabled(true);
                modifloc.setEnabled(false);
                modifdouche.setEnabled(false);
                modifball.setEnabled(false);
                modifnum.setEnabled(false);
                modifbttl.setEnabled(false);
                name.setEnabled(false);
                editdouche.setEnabled(false);
                editbtl.setEnabled(false);
                numero.setEnabled(false);
                localisation.setEnabled(false);
                modifName.setEnabled(false);
                modifball.setTextColor(getResources().getColor(R.color.vert2));
                modifnum.setTextColor(getResources().getColor(R.color.gris1));
                modifloc.setTextColor(getResources().getColor(R.color.gris1));
                modifName.setTextColor(getResources().getColor(R.color.gris1));
                modifbttl.setTextColor(getResources().getColor(R.color.gris1));
                modifdouche.setTextColor(getResources().getColor(R.color.gris1));


            }
        });
        modifdouche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                five=true;
                enregistrer.setVisibility(View.VISIBLE);
                annuler.setVisibility(View.VISIBLE);
                enregistrer.setEnabled(true);
                editdouche.setEnabled(true);
                modifloc.setEnabled(false);
                modifdouche.setEnabled(false);
                modifball.setEnabled(false);
                modifnum.setEnabled(false);
                modifbttl.setEnabled(false);
                name.setEnabled(false);
                editball.setEnabled(false);
                editbtl.setEnabled(false);
                numero.setEnabled(false);
                modifName.setEnabled(false);
                localisation.setEnabled(false);
                modifdouche.setTextColor(getResources().getColor(R.color.vert2));
                modifball.setTextColor(getResources().getColor(R.color.gris1));

                modifnum.setTextColor(getResources().getColor(R.color.gris1));
                modifloc.setTextColor(getResources().getColor(R.color.gris1));
                modifName.setTextColor(getResources().getColor(R.color.gris1));
                modifbttl.setTextColor(getResources().getColor(R.color.gris1));

            }
        });

       enregistrer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final ProgressDialog progressDialog = new ProgressDialog(InfoEdit.this);

               if( one==true && name.getText().toString().length()>0){
                   if(!name.getText().toString().equals(stade.getFirstName())){
                       progressDialog.setTitle("Enregistrement...");
                       progressDialog.show();
                       myRef.child(id).child("firstName").setValue(name.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                             stade.setFirstName(name.getText().toString());
                               progressDialog.dismiss();
                           }
                       });

                       Toast.makeText(getApplicationContext(), id , Toast.LENGTH_SHORT).show();

                       Toast.makeText(getApplicationContext(), "Changement bien enregistré name", Toast.LENGTH_SHORT).show();
                       changement=true;
                   }
               }

               if(two==true && localisation.getText().toString().length()>0 && !localisation.getText().toString().equals(stade.getLocalisation())){
                   progressDialog.setTitle("Enregistrement...");
                   progressDialog.show();
                   myRef.child(id).child("localisation").setValue(localisation.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
stade.setLocalisation(localisation.getText().toString());
                           progressDialog.dismiss();;
                       }
                   });

                   Toast.makeText(getApplicationContext(), "Changement bien enregistré localisation", Toast.LENGTH_SHORT).show();
                   changement=true;

               }

               if(three==true && numero.getText().toString().length()>0&& !numero.getText().toString().equals(stade.getMobile())){
                   progressDialog.setTitle("Enregistrement...");
                   progressDialog.show();
                   myRef.child(id).child("phoneNumber").setValue(numero.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
stade.setMobile(Integer.parseInt(numero.getText().toString()));
                          progressDialog.dismiss();
                       }
                   });

                   Toast.makeText(getApplicationContext(), "Changement bien enregistré number", Toast.LENGTH_SHORT).show();
                   changement=true;

               }
               if(zero==true && editbtl.getText().toString().length()>0&& !editbtl.getText().toString().equals(stade.getBottelnumb())){
                   progressDialog.setTitle("Enregistrement...");
                   progressDialog.show();
                   myRef.child(id).child("bottelnumb").setValue(editbtl.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           stade.setBottelnumb(Integer.parseInt(editbtl.getText().toString()));
                           progressDialog.dismiss();
                       }
                   });

                   Toast.makeText(getApplicationContext(), "Changement bien enregistré", Toast.LENGTH_SHORT).show();
                   changement=true;

               }
               if(four==true && editball.getText().toString().length()>0&& !editball.getText().toString().equals(stade.getBallnumb())){
                   progressDialog.setTitle("Enregistrement...");
                   progressDialog.show();
                   myRef.child(id).child("ballnumb").setValue(editball.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           stade.setBallnumb(Integer.parseInt(editball.getText().toString()));
                            progressDialog.dismiss();
                       }
                   });

                   Toast.makeText(getApplicationContext(), "Changement bien enregistré nombre de ballons", Toast.LENGTH_SHORT).show();
                   changement=true;

               }
               if(five==true && editdouche.getText().toString().length()>0&& !editdouche.getText().toString().equals(stade.getDouchenumb())){
                   progressDialog.setTitle("Enregistrement...");
                   progressDialog.show();
                   myRef.child(id).child("douchenumb").setValue(editdouche.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           stade.setBallnumb(Integer.parseInt(editdouche.getText().toString()));
                           progressDialog.dismiss();
                       }
                   });

                   Toast.makeText(getApplicationContext(), "Changement bien enregistré nombre de douches", Toast.LENGTH_SHORT).show();
                   changement=true;

               }

               if (changement){
                   localisation.setEnabled(false);
                   name.setEnabled(false);
                   numero.setEnabled(false);
                   editbtl.setEnabled(false);
                   editball.setEnabled(false);
                   enregistrer.setVisibility(View.INVISIBLE);
                   annuler.setVisibility(View.INVISIBLE);
                   changement=false;
                   one=false ; two=false; three=false; zero = false;four=false;five=false;
                   modifName.setEnabled(true);
                   modifnum.setEnabled(true);
                   modifloc.setEnabled(true);
                   modifbttl.setEnabled(true);
                   modifball.setEnabled(true);
                   modifdouche.setEnabled(true);


               }
               modifName.setTextColor(getResources().getColor(R.color.vert2));
               modifloc.setTextColor(getResources().getColor(R.color.vert2));
               modifnum.setTextColor(getResources().getColor(R.color.vert2));
               modifbttl.setTextColor(getResources().getColor(R.color.vert2));
               modifball.setTextColor(getResources().getColor(R.color.vert2));
               modifdouche.setTextColor(getResources().getColor(R.color.vert2));


           }
       });
       annuler.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               localisation.setEnabled(false);
               name.setEnabled(false);
               numero.setEnabled(false);
               editbtl.setEnabled(false);
               editdouche.setEnabled(false);
               editball.setEnabled(false);
               enregistrer.setVisibility(View.INVISIBLE);
               annuler.setVisibility(View.INVISIBLE);
               changement=false;
               one=false ; two=false; three=false;
               modifName.setEnabled(true);
               modifnum.setEnabled(true);
               modifloc.setEnabled(true);
               modifball.setEnabled(true);
               modifbttl.setEnabled(true);
               modifdouche.setEnabled(true);
               modifball.setTextColor(getResources().getColor(R.color.vert2));
               modifName.setTextColor(getResources().getColor(R.color.vert2));
               modifloc.setTextColor(getResources().getColor(R.color.vert2));
               modifnum.setTextColor(getResources().getColor(R.color.vert2));
               modifbttl.setTextColor(getResources().getColor(R.color.vert2));
               modifdouche.setTextColor(getResources().getColor(R.color.vert2));


           }
       });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Do nothing or catch the keys you want to block
        return false;
    }
}
