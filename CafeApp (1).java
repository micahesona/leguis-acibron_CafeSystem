abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    public abstract double computePrice();

    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}

class Beverage extends MenuItem {
    private String size;

    public Beverage() {
        super();
        size = "S";
    }

    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    @Override
    public double computePrice() {
        if (size.equals("L")) {
            return basePrice + 25;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size != null && (size.equals("S") || size.equals("M") || size.equals("L"))) {
            this.size = size;
        } else {
            System.out.println("Invalid beverage size.");
        }
    }
}

class Pastry extends MenuItem {
    private boolean warmed;

    public Pastry() {
        super();
        warmed = false;
    }

    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    @Override
    public double computePrice() {
        double price = basePrice;
        if (warmed) price += 10;
        return price;
    }

    @Override
    public String getDescription() {
        if (warmed) return super.getDescription() + " (Warmed)";
        return super.getDescription();
    }

    public boolean isWarmed() {
        return warmed;
    }

    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}

class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    @Override
    public double computePrice() {
        double price = basePrice;
        if (upsized) price += 20;
        price += extraSides * 12;
        return price;
    }

    @Override
    public String getDescription() {
        String status = upsized ? "Upsized" : "Regular";
        return super.getDescription() + " " + status + ", " + extraSides + " side(s)";
    }

    public boolean isUpsized() {
        return upsized;
    }

    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    public int getExtraSides() {
        return extraSides;
    }

    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}

class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() {
        name = "Guest";
        student = false;
        loyaltyPoints = 0;
    }

    public Customer(String name) {
        this.name = name;
        student = false;
        loyaltyPoints = 0;
    }

    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        loyaltyPoints = 0;
    }

    public void addPoints(int points) {
        if (points >= 0) loyaltyPoints += points;
    }

    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) loyaltyPoints += (int)(amountSpent / 50);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}

class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    public boolean addItem(MenuItem item) {
        if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add " + item.getDescription() + ".");
            return false;
        } else if (item1 == null) {
            item1 = item; itemCount++; return true;
        } else if (item2 == null) {
            item2 = item; itemCount++; return true;
        } else if (item3 == null) {
            item3 = item; itemCount++; return true;
        } else {
            return false;
        }
    }

    public double computeSubtotal() {
        double subtotal = 0;
        if (item1 != null) subtotal += item1.computePrice();
        if (item2 != null) subtotal += item2.computePrice();
        if (item3 != null) subtotal += item3.computePrice();
        return subtotal;
    }

    public double computeTotal() {
        double subtotal = computeSubtotal();
        return customer.isStudent() ? subtotal * 0.90 : subtotal;
    }

    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;
        return total < 0 ? 0 : total;
    }

    public void printReceipt() {
        System.out.println("\nOrder #" + orderId + " — " + customer.getName());
        if (customer.isStudent()) System.out.println("(Student)");
        if (item1 != null) System.out.printf("%s ............ %.2f%n", item1.getDescription(), item1.computePrice());
        if (item2 != null) System.out.printf("%s ............ %.2f%n", item2.getDescription(), item2.computePrice());
        if (item3 != null) System.out.printf("%s ............ %.2f%n", item3.getDescription(), item3.computePrice());

        double subtotal = computeSubtotal();
        double total = computeTotal();
        System.out.printf("Subtotal: %.2f%n", subtotal);
        if (customer.isStudent()) System.out.printf("Student discount (10%%): -%.2f%n", subtotal * 0.10);
        System.out.printf("TOTAL: %.2f%n", total);
        customer.addPoints(total);
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
    }

    public void printReceipt(double voucher) {
        System.out.println("\nOrder #" + orderId + " — " + customer.getName());
        if (item1 != null) System.out.printf("%s ............ %.2f%n", item1.getDescription(), item1.computePrice());
        if (item2 != null) System.out.printf("%s ............ %.2f%n", item2.getDescription(), item2.computePrice());
        if (item3 != null) System.out.printf("%s ............ %.2f%n", item3.getDescription(), item3.computePrice());

        System.out.printf("Subtotal: %.2f%n", computeSubtotal());
        System.out.printf("Voucher: -%.2f%n", voucher);
        double total = computeTotal(voucher);
        System.out.printf("TOTAL: %.2f%n", total);
        customer.addPoints(total);
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
    }
}

public class CafeApp {
     public static void main(String[] args) {
         Customer customer1 = new Customer("Liza Marquez", true);
         Customer customer2 = new Customer("Karl Santos");

         Beverage drink1 = new Beverage("Mango Smoothie", 85, "B‑01", "L");
         Pastry pastry1 = new Pastry("Cheese Bread", 40, "P‑01", true);
         Meal meal1 = new Meal("Pork Sinigang", 120, "M‑01", true, 1);
         Pastry pastry2 = new Pastry("Butter Cookie", 28, "P‑02", false);

         Order order1 = new Order("1001", customer1);
         order1.addItem(drink1);
         order1.addItem(pastry1);
         order1.addItem(meal1);
         order1.addItem(pastry2);
         order1.printReceipt();

         Beverage drink2 = new Beverage();
         drink2.setName("Taro Milk Tea");
         drink2.setBasePrice(-5);
         drink2.setBasePrice(75);
         drink2.setItemCode("B‑02");
         drink2.setSize("M");

         Meal meal2 = new Meal("Grilled Bangus", 125, "M‑02", false, 0);
         Order order2 = new Order("1002", customer2);
         order2.addItem(drink2);
         order2.addItem(meal2);
         order2.printReceipt(15);
     }
}