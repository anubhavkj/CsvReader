package dev.codescreen.task.books.stats;

import java.util.Comparator;
import java.util.Set;
import java.util.function.Predicate;

public class BestsellingBooksStatsGenerator {

  private BooksCsvParser booksCsvParser;

  public BestsellingBooksStatsGenerator(BooksCsvParser booksCsvParser) {
    this.booksCsvParser = booksCsvParser;
  }

  /**
   * Finds the title of the book with the highest number of reviews that is in the given genre and released in the given year.
   *
   * You can assume that the given genre will always be valid (either Fiction or Non-Fiction),
   * and the given year will always be a valid year between 2009 and 2019.
   */
  public String getTitleOfBookWithMostReviews(String genre, int year) {
	try{
		
		Set<Books> allbooks = booksCsvParser.getAllBooks();
		
		 //filter 1
		Predicate<Books> isYear = e -> e.getYear() == year;

		//filter2
		Predicate<Books> isGenre = e -> e.getGenre().equals(genre);
         
        
		Books book = allbooks.stream().filter(isYear.and(isGenre))
				.max(Comparator.comparing(Books::getReview))
				.get();
		return book.getName();
	}catch(Exception e){
		  throw new UnsupportedOperationException();
	}
  }
  
  /**
   * Finds the average number of reviews (rounded to the nearest integer) created for a book in the 
   * given genre and released in the given year.
   *
   * You can assume that the given genre will always be valid (either Fiction or Non-Fiction),
   * and the given year will always be a valid year between 2009 and 2019.
   */
  public int getAverageReviews(String genre, int year) {
	  try{
			
		Set<Books> allbooks = booksCsvParser.getAllBooks();
			
		//filter 1
	        Predicate<Books> isYear = e -> e.getYear() == year;
	 
	        //filter2
	        Predicate<Books> isGenre = e -> e.getGenre().equals(genre);
	        
		int avg = (int) allbooks.stream().filter(isYear.and(isGenre))
					.mapToInt(Books::getReview).average().orElse(0);
		return avg;
		}catch(Exception e){
			throw new UnsupportedOperationException();
		}
  }

}
