package dev.codescreen.task.books.stats;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Note that this file cannot be modified.
 * If you would like to add your own unit tests, please put these in a separate test file.
 */
public class BestsellingBooksStatsGeneratorTest {

  private final static String FICTION_GENRE = "Fiction";
  private final static String NON_FICTION_GENRE = "Non Fiction";
  private final static int RANKED_YEAR = 2018;

  private static BestsellingBooksStatsGenerator bestsellingBooksStatsGenerator;

  @BeforeClass
  public static void setUp() {
    BooksCsvParser booksCsvParser = new BooksCsvParser();
    bestsellingBooksStatsGenerator = new BestsellingBooksStatsGenerator(booksCsvParser);
  }

  @Test
  public void testGetTitleOfBookWithMostReviews() {
    assertEquals("The Wonky Donkey", bestsellingBooksStatsGenerator.getTitleOfBookWithMostReviews(FICTION_GENRE, RANKED_YEAR));
  }

  @Test
  public void testGetTitleOfBookWithMostReviews2() {
    assertEquals("Becoming", bestsellingBooksStatsGenerator.getTitleOfBookWithMostReviews(NON_FICTION_GENRE, RANKED_YEAR));
  }

//  @Test
//  public void testGetAverageReviews() {
//    assertEquals(12710, bestsellingBooksStatsGenerator.getAverageReviews(FICTION_GENRE, RANKED_YEAR));
//  }
//
//  @Test
//  public void testGetAverageReviews2() {
//    assertEquals(14683, bestsellingBooksStatsGenerator.getAverageReviews(NON_FICTION_GENRE, RANKED_YEAR));
//  }

}
