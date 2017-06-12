package sahil.readytogotravelassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText name,phone;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final PreferenceHandler handler=new PreferenceHandler(this);
        String status=handler.getPreferences(PreferenceHandler.loginStatus);
        if(status!=null && !(status.compareTo("true")==0))
        {
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        login=(Button) findViewById(R.id.login);
        name=(EditText) findViewById(R.id.name);
        phone=(EditText) findViewById(R.id.phone);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.setPreference(PreferenceHandler.loginStatus,"true");
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }
        });
    }
}
