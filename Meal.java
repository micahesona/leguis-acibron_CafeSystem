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