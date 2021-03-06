package ntua.hci.menuscost2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewRecipe extends AppCompatActivity {

    ImageView home;
    EditText edtRecipeName;
    Button btnCreate2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        home=findViewById(R.id.ImgHomePage);
        edtRecipeName=findViewById(R.id.recipe_name);
        btnCreate2=findViewById(R.id.btnCreate2);


        btnCreate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipe_name = edtRecipeName.getText().toString().trim();

                if(TextUtils.isEmpty(recipe_name)){
                    edtRecipeName.setError("Name is required");
                    return;
                }
                Toast.makeText(NewRecipe.this, "Creating new recipe with the name: " +recipe_name+" ...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),EnterIngredients.class));
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomePage.class));
                finish();
            }
        });
    }
}