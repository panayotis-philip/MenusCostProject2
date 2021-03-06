package ntua.hci.menuscost2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ShowIngredients extends AppCompatActivity {

    ImageView home,back;
    Button btnShow;
    ListView lv_ingredientList;

    ArrayAdapter ingredientArrayAdapter;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ingredients);

        home=findViewById(R.id.ImgHomePage);
        back=findViewById(R.id.imgBack);
        btnShow=findViewById(R.id.btnShowthem);

        lv_ingredientList=findViewById(R.id.ingredientsList);

        dataBaseHelper = new DataBaseHelper(ShowIngredients.this);

        ingredientArrayAdapter = new ArrayAdapter<IngredientModel>(ShowIngredients.this, android.R.layout.simple_list_item_1,dataBaseHelper.getEveryone());
        lv_ingredientList.setAdapter(ingredientArrayAdapter);

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
                startActivity(new Intent(getApplicationContext(),EnterIngredients.class));
                finish();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(ShowIngredients.this);
                //Toast.makeText(ShowIngredients.this, everyone.toString(), Toast.LENGTH_SHORT).show();
                ingredientArrayAdapter = new ArrayAdapter<IngredientModel>(ShowIngredients.this, android.R.layout.simple_list_item_1,dataBaseHelper.getEveryone());
                lv_ingredientList.setAdapter(ingredientArrayAdapter);
            }
        });





    }
}