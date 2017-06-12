package sahil.readytogotravelassignment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FinalActivity extends AppCompatActivity {
    FloatingActionButton finalFab;
    Toolbar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        bar=(Toolbar) findViewById(R.id.finalToolbar);
        bar.setTitle("Final Activity");
        bar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_close));
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinalActivity.this,HomeActivity.class));
                finish();
            }
        });
        finalFab=(FloatingActionButton) findViewById(R.id.finalFab);
        finalFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinalActivity.this,HomeActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
