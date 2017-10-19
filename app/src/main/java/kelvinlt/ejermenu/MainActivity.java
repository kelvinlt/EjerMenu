package kelvinlt.ejermenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button access = (Button) findViewById(R.id.btn_access);
        Button settings = (Button) findViewById(R.id.btn_settings);

//        access.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                setContentView(R.layout.access);
//            }
//        });

        access.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AccessActivity.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.ajustaments);
            }
        });


    }
}
