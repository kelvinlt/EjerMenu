package kelvinlt.ejermenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.w3c.dom.Text;

/**
 * Created by alu2012095 on 19/10/2017.
 */

public class AccessActivity extends AppCompatActivity {
    private ImageView imgVista;
    private ImageButton takeFoto , searchFoto;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.access);

        final EditText editUsername = (EditText) findViewById(R.id.username_textfield);
        Button saveTextFoto = (Button) findViewById(R.id.save_username_and_foto);

        imgVista = (ImageView) findViewById(R.id.user_image);
        takeFoto = (ImageButton) findViewById(R.id.take_foto);
        searchFoto = (ImageButton) findViewById(R.id.search_foto);

        editUsername.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(editUsername.getText().equals("Insert your username"))
                editUsername.setText("");
            }
        });

    }
}
