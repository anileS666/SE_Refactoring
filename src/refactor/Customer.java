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
            double thisAmount = 0;
            Rental currentRental = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = amountFor(currentRental);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((currentRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && currentRental.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            statement += "\t" + currentRental.getMovie().getTitle()+ "\t" + "\t" + currentRental.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        statement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return statement;
    }

    private double amountFor(Rental currentRental) {
        double result = 0;
        switch (currentRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (currentRental.getDaysRented() > 2)
                    result += (currentRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += currentRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (currentRental.getDaysRented() > 3)
                    result += (currentRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }

}
    
