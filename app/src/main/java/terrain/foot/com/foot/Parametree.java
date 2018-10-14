package terrain.foot.com.foot;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Parametree  extends AppCompatActivity {
ImageView back;
ListView parametre ;
     String  id,Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametres);
        back=findViewById(R.id.back01);
        parametre= findViewById(R.id.parametre);
        Intent intent = getIntent();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View decorView = this.getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);
        id = intent.getStringExtra("id");
        Email = intent.getStringExtra("Email");

        final String[] items = new String[]{"Informations générales", "Changer mot de passe"};
  ParametreAdapter adapter = new ParametreAdapter(this, items);
        parametre.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Parametree.this, Profile.class);
                i.putExtra("id", id);
                i.putExtra("Email", Email);
                startActivity(i);
                finish();
            }
        });
      //  parametre.getChildAt(1).setBackground(R.drawable.calendar);
parametre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id1) {

       if(position==0) {

           Intent i = new Intent(Parametree.this, InfoEdit.class);
           i.putExtra("id", id);
           i.putExtra("Email", Email);
           startActivity(i);
           finish();
       }
       else if (position==1) {
           Intent i ;

           i = new Intent(Parametree.this, MotDePass.class);
           i.putExtra("id", id);
           i.putExtra("Email", Email);
           startActivity(i);
       }
    }
});

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Do nothing or catch the keys you want to block
        return false;
    }
}
