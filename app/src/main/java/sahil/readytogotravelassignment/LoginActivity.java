package sahil.readytogotravelassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText name,phone;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final PreferenceHandler handler=new PreferenceHandler(this);
        String status=handler.getPreferences(PreferenceHandler.loginStatus);
        if(status!=null && (status.compareTo("true")==0))
        {
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();
        }
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        login=(Button) findViewById(R.id.login);
        name=(EditText) findViewById(R.id.name);
        phone=(EditText) findViewById(R.id.phone);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name==null || phone.length()!=10)
                {
                    Toast.makeText(getApplicationContext(),"Invalid details",Toast.LENGTH_SHORT).show();
                }
                else {
                    handler.setPreference(PreferenceHandler.loginStatus,"true");
                    Toast.makeText(getApplicationContext(),"Logging in...",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    finish();
                }
            }
        });
    }
}
