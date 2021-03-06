package ntua.hci.menuscost2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String INGREDIENTS_TABLE = "INGREDIENTS_TABLE";
    public static final String COLUMN_INGREDIENT_NAME = "INGREDIENT_NAME";
    public static final String COLUMN_INGREDIENT_CATEGORY = "INGREDIENT_CATEGORY";
    public static final String COLUMN_INGREDIENT_SUPERMARKET = "INGREDIENT_SUPERMARKET";
    public static final String COLUMN_INGREDIENT_PRICE = "INGREDIENT_PRICE";
    public static final String COLUMN_INGREDIENT_QUALITY = "INGREDIENT_QUALITY";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context,"menuscost.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + INGREDIENTS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_INGREDIENT_NAME + " TEXT, " + COLUMN_INGREDIENT_CATEGORY + " TEXT, " + COLUMN_INGREDIENT_PRICE + " INT, " + COLUMN_INGREDIENT_QUALITY + " INT, " + COLUMN_INGREDIENT_SUPERMARKET + " TEXT)";
        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(IngredientModel ingredientModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_INGREDIENT_NAME,ingredientModel.getName());
        cv.put(COLUMN_INGREDIENT_CATEGORY,ingredientModel.getCategory());
        cv.put(COLUMN_INGREDIENT_PRICE,ingredientModel.getPrice());
        cv.put(COLUMN_INGREDIENT_QUALITY,ingredientModel.getQuality());
        cv.put(COLUMN_INGREDIENT_SUPERMARKET,ingredientModel.getSupermarket());

        long insert = db.insert(INGREDIENTS_TABLE, null, cv);
        if(insert==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean deleteOne(IngredientModel ingredientModel){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + INGREDIENTS_TABLE + " WHERE " + COLUMN_ID + " = " + ingredientModel.getId();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }

    }

    public List<IngredientModel> getEveryone(){
        List<IngredientModel> returnAllList = new ArrayList<>();
        String queryString = "SELECT * FROM " + INGREDIENTS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            do{
                int ingredientID = cursor.getInt(0);
                String ingredientName = cursor.getString(1);
                String ingredientCategory = cursor.getString(2);
                int ingredientPrice = cursor.getInt(3);
                int ingredientQuality = cursor.getInt(4);
                String ingredientSuper = cursor.getString(5);

                IngredientModel newIngredient = new IngredientModel(ingredientID,ingredientName,ingredientCategory,ingredientPrice,ingredientQuality,ingredientSuper);
                returnAllList.add(newIngredient);
            }while(cursor.moveToNext());
        }else{

        }

        cursor.close();
        db.close();

        return returnAllList;
    }

}
