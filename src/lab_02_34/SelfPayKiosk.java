package lab_02_34;

public class SelfPayKiosk {
    private final double SALES_TAX = 0.07;
    private int numCustomers;
    private double totalSales;
    private double amountDue;
    private boolean checkedOut;

    // Constructor
    public SelfPayKiosk() {
        numCustomers = 0;
        totalSales = 0;
        amountDue = 0;
        checkedOut = false;
    }

    // Return total daily sales
    public double getTotalSales() {
        return totalSales;
    }

    // Return current amount due
    public double getAmountDue() {
        return amountDue;
    }

    // Return number of customers served
    public int getNumCustomers() {
        return numCustomers;
    }

    // Scan one item
    public void scanItem(double price) {
        if (price > 0) {
            amountDue += price;
        }
    }

    // Apply sales tax to current purchases
    public void checkOut() {
        amountDue += SALES_TAX * amountDue;
        checkedOut = true;
    }

    // Cancel current purchases
    public void cancelTransaction() {
        if (!checkedOut) {
            amountDue = 0;
        }
    }

    // Reset register for the day
    public void resetKiosk() {
        amountDue = 0;
        totalSales = 0;
        numCustomers = 0;
    }

    // Apply payment to amount due
    public void makePayment(double payment) {
        if (payment < 0 || !checkedOut) {
            return;
        }
        if (payment < amountDue) {
            amountDue -= payment;
            totalSales += payment;
        } else {
            totalSales += amountDue;
            amountDue = 0;
            numCustomers++;
            checkedOut = false;
        }
    }

    // Simulate multiple transactions
    public void simulateSales(int numSales, double initialPrice, double incrPrice) {
        double price = initialPrice;
        for (int i = 1; i <= numSales; i++) {
            scanItem(price);
            checkOut();
            makePayment(getAmountDue() + 1);
            price += incrPrice;
        }
    }
}
