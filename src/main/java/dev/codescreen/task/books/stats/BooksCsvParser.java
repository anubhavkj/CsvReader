package dev.codescreen.task.books.stats;

import java.util.HashSet;
import java.util.List;
import java.io.File;
import java.util.Set;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class BooksCsvParser {

  private static final String BEST_SELLING_BOOKS_FILE_PATH = "src/main/resources/best-selling-books.csv";

  public BooksCsvParser() {

  }

  /**
   * Parses the best-selling-books.csv file and returns the data.
   */
  public Set<Books> getAllBooks() {
	  try{
		  File csvFile = new File(BEST_SELLING_BOOKS_FILE_PATH);
		  CsvMapper csvMapper = new CsvMapper();

	      CsvSchema csvSchema = csvMapper
	              .typedSchemaFor(Books.class)
	              .withHeader()
	              .withColumnSeparator(',')
	              .withComments();

	      MappingIterator<Books> allbooksIter = csvMapper
	              .readerWithTypedSchemaFor(Books.class)
	              .with(csvSchema)
	              .readValues(csvFile);

	    
		Set<Books> allbooks = new HashSet<Books>(allbooksIter.readAll());
		
	    return allbooks;
	  }catch(Exception e){
		  throw new UnsupportedOperationException();
	  }
	  
  }

}
