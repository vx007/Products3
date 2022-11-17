import java.util.ArrayList;

public class Main {
    public static ArrayList<Recipe> recipes = new ArrayList<>();
     public static void main(String[] args) {
        try {
            Recipe sandwich = new Recipe("Бутерброд");
            sandwich.addProduct(new Product("Хлеб", 20d));
            sandwich.addProduct(new Product("Масло", 100d));
            recipes.add(sandwich);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            Recipe salad = new Recipe("Салад");
            salad.addProduct(new Product("Помидор", 100d), 10d);
            salad.addProduct(new Product("Огурец", 70d), 10d);
            salad.addProduct(new Product("Майонез", 150d));
            recipes.add(salad);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

         System.out.println(recipes);
     }
}
