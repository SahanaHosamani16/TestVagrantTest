import java.util.*;

class Product {
    String pname;
    double up;
    double gst;
    int q;

    public Product(String pname, double up, double gst, int q) {
        this.pname = pname;
        this.up = up;
        this.gst = gst;
        this.q = q;
    }

    public double calculateTotalPrice() {
        return up*q;
    }

    public double calculateGSTAmount() {
        return calculateTotalPrice() *(gst/100.0);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
       
        ArrayList<Product> b = new ArrayList<>();
        b.add(new Product("Leather Wallet", 1100, 18, 1));
        b.add(new Product("Umbrella", 900, 12, 4));
        b.add(new Product("Cigarette", 200, 28, 3));
        b.add(new Product("Honey", 100, 0, 2));

        
        Product mgp = b.get(0);
        double mga = mgp.calculateGSTAmount();

        for (Product product : b) {
            double ca = product.calculateGSTAmount();
            if (ca > mga) {
                mga = ca ;
                mgp = product;
            }
        }

        System.out.println("Product with Maximum GST Amount: " + mgp.pname);

        
        double totalAmount = 0;
        for (Product product : b) {
            totalAmount += product.calculateTotalPrice();
        }

        System.out.println("Total Amount: " + totalAmount);
    }
}

