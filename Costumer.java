/**
Represents a cafe customer.
Customers may be students and earn loyalty points.
@author Acibron & Leguis
@version 1.0
*/
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
    Creates a default customer.
    */
    public Customer() {
        name = "Guest";
        student = false;
        loyaltyPoints = 0;
    }

    /**
    Creates a customer with a name.
    @param name customer name
    */
    public Customer(String name) {
        this.name = name;
        student = false;
        loyaltyPoints = 0;
    }

    /**
    Creates a customer with a name and student status.
    @param name customer name
    @param student student status
    */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        loyaltyPoints = 0;
    }

    /**
    Adds loyalty points directly.
    @param points points to add
    */
    public void addPoints(int points) {
        if (points >= 0) {
            loyaltyPoints += points;
        }
    }

    /**
    Adds one point for every 50 pesos spent.
    @param amountSpent purchase amount
    */
    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) {
            loyaltyPoints += (int) (amountSpent / 50);
        }
    }

    /**
    Returns customer name.
    @return customer name
    */
    public String getName() {
        return name;
    }

    /**
    Sets customer name.
    @param name customer name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    Checks student status.
    @return true if student
    */
    public boolean isStudent() {
        return student;
    }

    /**
    Sets student status.
    @param student student status
    */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
    Returns loyalty points.
    @return loyalty points
    */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
    Sets loyalty points if valid.
    @param loyaltyPoints loyalty points
    */
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}
