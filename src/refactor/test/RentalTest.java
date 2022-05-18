package refactor.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import refactor.Movie;
import refactor.Rental;

public class RentalTest {
	
	private Rental rental;
	Movie movie = new Movie("testMovie",2);
	
	@BeforeEach
	public void createRental() {
		rental = new Rental(movie, 5);
	}
	
	@Test
	public void getDaysRented() {
	        assertEquals(5, rental.getDaysRented());
	}
	
	@Test
	public void getMovie() {
	        assertEquals(movie, rental.getMovie());
	}
}
