import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        int nEnters;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of products: ");
        nEnters = scanner.nextInt();

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < nEnters; i++) {
            String name;
            double price;
            char type;

            System.out.println(STR."Product \{i + 1} data:");
            System.out.println("Common, used or imported (c/u/i)?");
            type = scanner.next().charAt(0);
            scanner.nextLine(); // Consumes the newline character

            System.out.print("Name: ");
            name = scanner.nextLine();

            System.out.println("Price: ");
            price = scanner.nextDouble();
            scanner.nextLine(); // Consumes the newline character

            Product p;

            switch (type) {
                case 'c':
                    p = new Product(name, price);
                    break;
                case 'u':
                    System.out.println("Enter manufacture date (dd/MM/yyyy):");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date d = format.parse(scanner.nextLine());
                    p = new UsedProduct(name, price, d);
                    break;
                case 'i':
                    System.out.println("Customs fee:");
                    double fee = scanner.nextDouble();
                    scanner.nextLine(); // Consumes the newline character
                    p = new ImportedProduct(name, price, fee);
                    break;
                default:
                    throw new IllegalStateException(STR."Unexpected value: \{type}");
            }
            products.add(p);
        }

        for (Product p : products) {
            System.out.println(STR."Product: \{p.name}");
            System.out.println(STR."Price: \{p.priceTag()}");
            System.out.println(STR."Type: \{p.getClass().getSimpleName()}");

            if (p instanceof UsedProduct usedProduct) {
                System.out.println(STR."Manufacture date: \{usedProduct.manufactureDate}");
            } else if (p instanceof ImportedProduct im) {
                System.out.println(STR."Customs fee: \{im.customFee}");
                System.out.println(STR."total Price: \{im.totalPrice()}\n");
            }
            System.out.println();
        }
    }
}
