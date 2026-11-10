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