package refactor.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import refactor.Movie;

public class MovieTest {
	
	private Movie testMovie;

	@BeforeEach
	public void createMovie() {
		testMovie = new Movie("Test Movie",0);
	}
	
	@Test
	public void getPriceCode() {
		assertEquals(Movie.REGULAR, testMovie.getPriceCode());
	}
	@Test
	public void setPriceCode() {
		testMovie.setPriceCode(1);
		assertEquals(Movie.NEW_RELEASE, testMovie.getPriceCode());
	}
	@Test
	public void getTitle() {
		assertEquals("Test Movie", testMovie.getTitle());
	}

}
