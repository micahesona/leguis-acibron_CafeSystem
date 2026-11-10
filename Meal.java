/**
Represents a rice meal sold at the campus cafe.
Meals may be upsized and have extra sides.
@author Acibron & Leguis
@version 1.0
*/
public class Meal extends MenuItem {

    private boolean upsized;
    private int extraSides;

    /**
    Creates a default meal.
    */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
    Creates a meal with specified details.
    @param name meal name
    @param basePrice meal base price
    @param itemCode meal code
    @param upsized whether meal is upsized
    @param extraSides number of extra sides
    */
    public Meal(String name, double basePrice, String itemCode,
                boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    /**
    Computes meal price.
    @return meal price
    */
    @Override
    public double computePrice() {
        double price = basePrice;

        if (upsized) {
            price += 20;
        }

        price += extraSides * 12;
        return price;
    }

    /**
    Returns meal description.
    @return meal description
    */
    @Override
    public String getDescription() {
        String status;

        if (upsized) {
            status = "Upsized";
        } else {
            status = "Regular";
        }

        return super.getDescription() + " " + status +
               ", " + extraSides + " side(s)";
    }

    /**
    Checks if meal is upsized.
    @return true if upsized
    */
    public boolean isUpsized() {
        return upsized;
    }

    /**
    Sets upsize status.
    @param upsized upsize status
    */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
    Returns extra sides.
    @return number of extra sides
    */
    public int getExtraSides() {
        return extraSides;
    }

    /**
    Sets extra sides if valid.
    @param extraSides number of extra sides
    */
    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}

