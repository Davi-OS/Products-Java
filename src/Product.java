public class Product {

    public String name;
    protected double price;

    public Product(String n, double price) {

        this.name = n;
        this.price = price;
    }

    public String priceTag() {
        return STR." R$ \{String.valueOf(this.price)}";
    }
}
