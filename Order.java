/**
Represents a customer order containing up to three menu items.
@author Acibron & Leguis
@version 1.0
*/
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
    Creates an order for a customer.
    @param orderId order identification
    @param customer customer placing the order
    */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    /**
    Adds an item if the order is not full.
    @param item menu item
    @return true if item was added
    */
    public boolean addItem(MenuItem item) {
        if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add " +
                               item.getDescription() + ".");
            return false;
        } else if (item1 == null) {
            item1 = item;
            itemCount++;
            return true;
        } else if (item2 == null) {
            item2 = item;
            itemCount++;
            return true;
        } else if (item3 == null) {
            item3 = item;
            itemCount++;
            return true;
        } else {
            return false;
        }
    }

    /**
    Computes the subtotal using each item's price.
    @return subtotal
    */
    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    /**
    Computes total after student discount.
    @return total amount
    */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        double total;

        if (customer.isStudent()) {
            total = subtotal * 0.90;
        } else {
            total = subtotal;
        }

        return total;
    }

    /**
    Computes total after discount and voucher.
    @param voucher voucher amount
    @return final total
    */
    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    /**
    Prints the receipt and updates loyalty points.
    */
    public void printReceipt() {
        System.out.println("\nOrder #" + orderId + " — " +
                           customer.getName());

        if (customer.isStudent()) {
            System.out.println("(Student)");
        }

        if (item1 != null) {
            System.out.printf("%s ............ %.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("%s ............ %.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("%s ............ %.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        double subtotal = computeSubtotal();
        double total = computeTotal();

        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n",
                    subtotal * 0.10);
        }

        System.out.printf("TOTAL: %.2f%n", total);

        customer.addPoints(total);

        System.out.println("Loyalty points: " +
                           customer.getLoyaltyPoints());
    }

    /**
    Prints receipt with voucher.
    @param voucher voucher amount
    */
    public void printReceipt(double voucher) {
        System.out.println("\nOrder #" + orderId + " — " +
                           customer.getName());

        if (item1 != null) {
            System.out.printf("%s ............ %.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("%s ............ %.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("%s ............ %.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        System.out.printf("Subtotal: %.2f%n", computeSubtotal());
        System.out.printf("Voucher: -%.2f%n", voucher);

        double total = computeTotal(voucher);

        System.out.printf("TOTAL: %.2f%n", total);

        customer.addPoints(total);

        System.out.println("Loyalty points: " +
                           customer.getLoyaltyPoints());
    }
}
