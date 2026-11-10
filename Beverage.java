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