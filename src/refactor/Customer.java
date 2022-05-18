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
       
        Enumeration enum_rentals = rentals.elements();	    
        String statement = "Rental Record for " + this.getName() + "\n";
        statement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental currentRental = (Rental) enum_rentals.nextElement();

            statement += "\t" + currentRental.getMovie().getTitle()+ "\t" + "\t" + currentRental.getDaysRented() + "\t" + String.valueOf(currentRental.getCharge()) + "\n";
            
        }
        //add footer lines
        statement += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        statement += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
        return statement;
    }
    
    private int getFrequentRenterPoints() {
    	int result = 0;
    	Enumeration enum_rentals = rentals.elements();
    	 while (enum_rentals.hasMoreElements()) {
    	 Rental currentRental = (Rental) enum_rentals.nextElement();
    	 result += currentRental.getFrequentRenterPoints();
    	 }
    	 return result;
	}

	private double getTotalCharge() {
    	double result = 0;
    	Enumeration enum_rentals = rentals.elements();
    	 while (enum_rentals.hasMoreElements()) {
    	 Rental currentRental = (Rental) enum_rentals.nextElement();
    	 result += currentRental.getCharge();
    	 }
    	 return result;

    }

}
    
    
