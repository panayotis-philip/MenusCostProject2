package ntua.hci.menuscost2;

public class Recipe {
    private String name;
    private int ingr;
    private String ingredient1, ingredient2,ingredient3,ingredient4;

    public Recipe(String name, int ingr, String ingredient1, String ingredient2, String ingredient3, String ingredient4) {
        this.name = name;
        this.ingr = ingr;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIngr() {
        return ingr;
    }

    public void setIngr(int ingr) {
        this.ingr = ingr;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        this.ingredient3 = ingredient3;
    }

    public String getIngredient4() {
        return ingredient4;
    }

    public void setIngredient4(String ingredient4) {
        this.ingredient4 = ingredient4;
    }
}
