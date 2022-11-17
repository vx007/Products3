import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Recipe {
    private String name;
    private double price;
    private HashMap<Product, Double> products;

    public Recipe(String name) {
        this(name, new HashMap<>());
    }

    public Recipe(String name, HashMap<Product, Double> products) {
        setName(name);
        setProducts(products);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public HashMap<Product, Double> getProducts() {
        return products;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не указано!");
        }
    }

    public void setProducts(HashMap<Product, Double> products) {
        this.products = products;
        calcPrice();

    }

    public void addProduct(Product product, Double amount) {
        if (product != null && !products.containsKey(product) && amount > 0d){
            this.products.put(product, amount);
        } else {
            throw new IllegalArgumentException("Неправильно добавлен продукт!");
        }
        calcPrice();
    }

    public void addProduct(Product product){
        this.addProduct(product, 1d);
    }

    public void calcPrice(){
        double price = 0d;
        for (Map.Entry<Product, Double> entry : products.entrySet()) {
            price += entry.getKey().getPrice() * entry.getValue();
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Рецепт '%s'=(продукты: %s, общая цена: %.2f)", name, products.toString(), price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Recipe recipe = (Recipe) obj;
        return name.equals(recipe.name) && Objects.equals(products, recipe.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }
}
