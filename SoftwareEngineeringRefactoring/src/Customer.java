
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private double amount = 0;
    private Vector rentals = new Vector();
    public Customer (String newName){
        name = newName;
    };
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int borrowerPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            amount = rental.getCharge();
            borrowerPoints = rental.getBorrowerPoints();
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(amount) + "\n";
            totalAmount += amount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(borrowerPoints) + " borrower points";
        return result;
    }
}
    