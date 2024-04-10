import java.util.Date;

public class UsedProduct extends Product {
    public Date manufactureDate;
    public UsedProduct(java.lang.String n, double price, Date date) {
        super(n, price);
        this.manufactureDate = date;
    }
}
