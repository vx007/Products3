import java.util.Objects;

public class Product {
    private String name;
    private double price;

    public Product(String name, Double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не указано!");
        }
    }

    public void setPrice(Double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Цена указана неверно!");
        }
    }

    @Override
    public String toString() {
        return String.format("'%s'=(цена: %.2f)", name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
