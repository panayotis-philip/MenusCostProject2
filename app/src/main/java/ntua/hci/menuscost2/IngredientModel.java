package ntua.hci.menuscost2;

public class IngredientModel {
    private int id;
    private String name;
    private String category;
    private int price;
    private int quality;
    private String supermarket;

    public IngredientModel(int id, String name, String category, int price, int quality, String supermarket) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quality = quality;
        this.supermarket = supermarket;
    }

    public IngredientModel() {
    }

    @Override
    public String toString() {
        return "IngredientModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quality=" + quality +
                ", supermarket='" + supermarket + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(String supermarket) {
        this.supermarket = supermarket;
    }
}
