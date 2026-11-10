/**
Represents the parent class of all cafe menu items.
Contains common item information and pricing behavior.
@author Marlita C. Acibron
@version 1.0
*/
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
    Creates a default menu item.
    */
    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    /**
    Creates a menu item with specified details.
    @param name item name
    @param basePrice item base price
    @param itemCode item code
    */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /**
    Computes the item's price.
    @return computed price
    */
    public abstract double computePrice();

    /**
    Returns the item's description.
    @return item name and code
    */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
    Returns the item name.
    @return item name
    */
    public String getName() {
        return name;
    }

    /**
    Sets the item name.
    @param name item name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    Returns the base price.
    @return base price
    */
    public double getBasePrice() {
        return basePrice;
    }

    /**
    Sets the base price if it is valid.
    @param basePrice new base price
    */
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    /**
    Returns the item code.
    @return item code
    */
    public String getItemCode() {
        return itemCode;
    }

    /**
    Sets the item code.
    @param itemCode item code
    */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
