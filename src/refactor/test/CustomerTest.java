package refactor.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import refactor.Customer;
import refactor.Movie;
import refactor.Rental;

public class CustomerTest {
	
	private Customer customer;
	private String expectedStatement = 
			"Rental Record for Björn\n"
			+ "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n"
			+ "\t" + "first Movie"+ "\t" + "\t" + 8 + "\t" + 11.0 + "\n"
			+ "\t" + "second Movie"+ "\t" + "\t" + 3 + "\t" + 9.0 + "\n"
			+ "\t" + "third Movie"+ "\t" + "\t" + 12 + "\t" + 15.0 + "\n"
			+ "Amount owed is " + 35.0 + "\n"
			+ "You earned " + 4 + " frequent renter points";
					
	
	@BeforeEach
	public void createCustomer() {
		customer = new Customer("Björn");
	}
	
	@Test
	public void getName() {
		assertEquals("Björn", customer.getName());
	}
	
	@Test
	public void statement() {
		customer.addRental(new Rental(new Movie("first Movie",0 ),8));
		customer.addRental(new Rental(new Movie("second Movie",1 ),3));
		customer.addRental(new Rental(new Movie("third Movie",2 ),12));
		assertEquals(expectedStatement, customer.statement());
	}
	

}
