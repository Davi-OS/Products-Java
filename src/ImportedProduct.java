public class ImportedProduct extends Product {

    public double customFee;

    public ImportedProduct(java.lang.String n, double price, double customFee) {
        super(n, price);
        this.customFee = customFee;
    }

    public double totalPrice() {
        return price + customFee;
    }
}
