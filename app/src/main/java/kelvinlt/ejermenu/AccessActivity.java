package kelvinlt.ejermenu;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;

/**
 * Created by alu2012095 on 19/10/2017.
 */

public class AccessActivity extends AppCompatActivity {
    private ImageView imgVista;
    private ImageButton takeFoto, searchFoto;
    private String userName;
    private Intent data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.access);

        final EditText editUsername = (EditText) findViewById(R.id.username_textfield);
        Button saveTextFoto = (Button) findViewById(R.id.save_username_and_foto);

        imgVista = (ImageView) findViewById(R.id.user_image);
        takeFoto = (ImageButton) findViewById(R.id.take_foto);
        searchFoto = (ImageButton) findViewById(R.id.search_foto);

        searchFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPhoto();
            }
        });

        takeFoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                takePhoto();
            }
        });

    }
    @Override
     public void onPause() {
        emptyImageViewer();
        super.onPause();
    }
//
    public void emptyImageViewer() {
         Drawable drawable = imgVista.getDrawable();
         if (drawable != null) {
             ((BitmapDrawable)drawable).getBitmap().recycle();
             }
        imgVista.setImageURI(null);
         }

    private final static int SELECT_PHOTO = 1;
    private final static int CAPTURE_PHOTO = 2;
    private Uri photoUri;

    public void selectPhoto() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(
                Intent.createChooser(intent, "Select␣Source"), SELECT_PHOTO
        );
    }

    public void takePhoto() {
        File dir = getExternalFilesDir(null);
        if (dir == null) {
            Toast.makeText(this, "Unable␣to␣mount␣the␣filesystem",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        File file = new File(dir, "photo.jpg");
        photoUri = Uri.fromFile(file);
        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, photoUri);
        startActivityForResult(i, CAPTURE_PHOTO);
    }
    @Override
     protected void onActivityResult(int requestCode , int resultCode, Intent data) {
         super.onActivityResult(requestCode , resultCode, data);
//         if (resultCode != RESULT_OK) return;
//         emptyImageViewer();
         if (requestCode == CAPTURE_PHOTO) {
             imgVista.setImageURI(photoUri);
             }
         else {
             Uri img = data.getData();
             if (img != null) {
                 imgVista.setImageURI(img);
                 }
             }
        imgVista.invalidate();
         }
}
