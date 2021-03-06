package ntua.hci.menuscost2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class DeleteIngredients extends AppCompatActivity {
    ImageView home,back;
    ListView lv_ingredientList;
    ArrayAdapter ingredientArrayAdapter;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_ingredients);

        home=findViewById(R.id.ImgHomePage);
        back=findViewById(R.id.imgBack);
        lv_ingredientList=findViewById(R.id.ingredientsList);

        dataBaseHelper = new DataBaseHelper(DeleteIngredients.this);

        ingredientArrayAdapter = new ArrayAdapter<IngredientModel>(DeleteIngredients.this, android.R.layout.simple_list_item_1,dataBaseHelper.getEveryone());
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

        lv_ingredientList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IngredientModel clickedIngredient = (IngredientModel) parent.getItemAtPosition(position);
                dataBaseHelper.deleteOne(clickedIngredient);
                ingredientArrayAdapter = new ArrayAdapter<IngredientModel>(DeleteIngredients.this, android.R.layout.simple_list_item_1,dataBaseHelper.getEveryone());
                lv_ingredientList.setAdapter(ingredientArrayAdapter);
                Toast.makeText(DeleteIngredients.this, "Deleted: "+clickedIngredient, Toast.LENGTH_SHORT).show();
            }
        });

    }
}