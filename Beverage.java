/**
Represents a beverage sold at the campus cafe.
The price depends on the selected size.
@author Acibron & Leguis
@version 1.0
*/
public class Beverage extends MenuItem {

    private String size;

    /**
    Creates a default beverage.
    */
    public Beverage() {
        super();
        size = "S";
    }

    /**
    Creates a beverage with specified details.
    @param name beverage name
    @param basePrice beverage base price
    @param itemCode beverage code
    @param size beverage size
    */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    /**
    Computes beverage price based on size.
    @return beverage price
    */
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

    /**
    Returns beverage description.
    @return description with size
    */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
    Returns beverage size.
    @return size
    */
    public String getSize() {
        return size;
    }

    /**
    Sets beverage size if valid.
    @param size S, M, or L
    */
    public void setSize(String size) {
        if (size != null &&
            (size.equals("S") || size.equals("M") || size.equals("L"))) {
            this.size = size;
        } else {
            System.out.println("Invalid beverage size.");
        }
    }
}
