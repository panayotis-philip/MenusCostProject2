package ntua.hci.menuscost2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Create_Ingredient extends AppCompatActivity {
    ImageView home,back;
    Button btnAddIngr;
    EditText edtIname, edtIcateg, edtIprice, edtIqual, edtIsup;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__ingredient);

        home=findViewById(R.id.ImgHomePage);
        back=findViewById(R.id.imgBack);

        btnAddIngr=findViewById(R.id.btnAddIngr);
        edtIname=findViewById(R.id.edtIname);
        edtIcateg=findViewById(R.id.edtIcateg);
        edtIprice=findViewById(R.id.edtIprice);
        edtIqual=findViewById(R.id.edtIqual);
        edtIsup=findViewById(R.id.edtIsup);

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

        btnAddIngr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IngredientModel ingredientModel;

                try{
                    ingredientModel = new IngredientModel(-1,edtIname.getText().toString(),edtIcateg.getText().toString(),Integer.parseInt(edtIprice.getText().toString()),Integer.parseInt(edtIqual.getText().toString()),edtIsup.getText().toString());
                    Toast.makeText(Create_Ingredient.this, "Ingredient Added: "+ ingredientModel.toString(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),EnterIngredients.class));
                    finish();
                }
                catch(Exception e){
                    Toast.makeText(Create_Ingredient.this, "Error creating customer", Toast.LENGTH_SHORT).show();
                    ingredientModel = new IngredientModel(-1,"error","error",-1,-1,"error");
                }
                DataBaseHelper dataBaseHelper = new DataBaseHelper(Create_Ingredient.this);

                boolean success = dataBaseHelper.addOne(ingredientModel);
                Toast.makeText(Create_Ingredient.this, "Success = "+success, Toast.LENGTH_SHORT).show();
            }
        });






    }
}