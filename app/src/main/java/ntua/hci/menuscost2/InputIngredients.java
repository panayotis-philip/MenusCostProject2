package ntua.hci.menuscost2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InputIngredients extends AppCompatActivity {
    ImageView home;
    Button btnAdd,btnShowIngr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_ingredients);

        home=findViewById(R.id.ImgHomePage);
        btnAdd=findViewById(R.id.btnAdd);
        btnShowIngr.findViewById(R.id.btnShowIngr);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Create_Ingredient.class));
                finish();
            }
        });

        btnShowIngr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ShowIngredients.class));
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