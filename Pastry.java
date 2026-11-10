/**
Represents a pastry sold at the campus cafe.
A warmed pastry costs an additional fee.
@author Acibron & Leguis
@version 1.0
*/
public class Pastry extends MenuItem {

    private boolean warmed;

    /**
    Creates a default pastry.
    */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
    Creates a pastry with specified details.
    @param name pastry name
    @param basePrice pastry base price
    @param itemCode pastry code
    @param warmed whether pastry is warmed
    */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
    Computes pastry price.
    @return pastry price
    */
    @Override
    public double computePrice() {
        double price = basePrice;

        if (warmed) {
            price += 10;
        }

        return price;
    }

    /**
    Returns pastry description.
    @return pastry description
    */
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }

        return super.getDescription();
    }

    /**
    Checks if pastry is warmed.
    @return true if warmed
    */
    public boolean isWarmed() {
        return warmed;
    }

    /**
    Sets warmed status.
    @param warmed warmed status
    */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
