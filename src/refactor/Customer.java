package refactor;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    
    public Customer (String name){
        this.name = name;
    }
    
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }
    
    public String getName (){
        return name;
    }
    
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String statement = "Rental Record for " + this.getName() + "\n";
        statement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental currentRental = (Rental) enum_rentals.nextElement();

            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((currentRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && currentRental.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            statement += "\t" + currentRental.getMovie().getTitle()+ "\t" + "\t" + currentRental.getDaysRented() + "\t" + String.valueOf(currentRental.getCharge()) + "\n";
            totalAmount += currentRental.getCharge();
        }
        //add footer lines
        statement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return statement;
    }

}
    
