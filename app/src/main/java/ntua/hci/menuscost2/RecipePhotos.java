package ntua.hci.menuscost2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecipePhotos extends AppCompatActivity {
    ImageView home,back,ivPhoto;
    Button btnTake,btnLoad,btnList;
    static final int REQUEST_TAKE_PHOTO = 1;
    //name of the file that is saved by the camera
    String currentPhotoPath;
    TextView tv_message;
    static final int SELECT_A_PHOTO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_photos);


        home=findViewById(R.id.ImgHomePage);
        back=findViewById(R.id.imgBack);
        btnList=findViewById(R.id.btnList);
        btnLoad=findViewById(R.id.btnLoad);
        btnTake=findViewById(R.id.btnTake);
        ivPhoto=findViewById(R.id.ivPhoto);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomePage.class));
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),OldRecipe.class));
                finish();
            }
        });

        btnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,SELECT_A_PHOTO);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivPhoto.setImageBitmap(imageBitmap);
        }
        if (requestCode == SELECT_A_PHOTO && resultCode == RESULT_OK) {
            Uri selectedPhoto = data.getData();
            ImageView iv_photo;
            iv_photo=findViewById(R.id.ivPhoto);
            Glide.with(this).load(selectedPhoto).into(iv_photo);


        }
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //get the bitmap from the filename

            ivPhoto=findViewById(R.id.ivPhoto);
            //Bitmap takenImage = BitmapFactory.decodeFile(currentPhotoPath);
            Glide.with(this).load(currentPhotoPath).into(ivPhoto);
            //set the image to the iv_photo View



            //show the filename in the tv_message
           // TextView tv_message;
           // tv_message=findViewById(R.id.tv_message);
          //  tv_message.setText(currentPhotoPath);
        }
    }*/

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }



    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}