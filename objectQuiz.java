Using Notepad / Notepad++, create a Book class that:

contain at least three (3) instance variables
one of the instance variable mast be a relationship to an Author class.  
a Book "hasa" Author
contains at least two accessor (getters) methods
contains at least two modify (setters) methods
contains one helper method
equals( .. )
toString(..)

public class Book(){
	private static final String WINNER = "Is an Award Winner";
	private static final String NON_WINNER = "Is not an Award Winner";
	private static final boolean IS_WINNER = true;
	private static final boolean IS_NOT_WINNEER = false;
	private static final ISBN_LENGTH = 11;
	private String title;
	private int yearPublished;
	private int numberPages;
	private boolean authorIsAlive;
	int copyNumber;
	private String ISBN;
	private boolean awardWinner;

	public Book(){
	
	}
	
	public Book (String title, int yearPublished, int numberPages, boolean awardWinner, String ISBN, intCopyNumber) {
	this.title = title;
	this.yearPublished = yearPublished;
	this.numberPages = numberPages;
	this.awardWinner = awardWinner;
	this.ISBN = ISBN;
	this.copyNumber = copyNumber;
	}
	
	public void setCopyNumber(){
	if (copyNumber > 0){
		this.copyNumber = copyNumber;
	}
	}
	
	public void setISBN(String ISBN){
	if (ISBN.length() == ISBN_LENGTH){
		this.ISBN = ISBN;
	} else {
		System.out.println("Non-valid ISBN entered.");
	}
	}
	
	public void setTitle(String title){
		if (title != null){
			this.title = title;
		} else {
		System.out.println("Title entered is not valid.");
		}
	}
	
	public void setYearPublished(int yearPublished){
		if (yearPublished < 1300 || yearPublished > 2014){
			System.out.println("Year entered is not valid.");
		} else {
			this.yearPublished = yearPublished
		}
	
	}
	
	public void setNumberPages(int numberPages){
	if (numberPages > 0){
		this.numberPages = numberPages;
	} else {
		System.out.println("Number of pages entered is not valid");
	}
	
	}
	
	public void setAwardWinner(boolean awardWinner){
	this.awardWinner = awardWinner;
	}
	
	public void setAuthorIsAlive(Author author){
		this.authorIsAlive = author.getStateOfHealth();
	}
	
	public int getCopyNumber(){
	return copyNumber;
	}
	
	public String getTitle(){
	return title;
	}
	
	public int getYearPublished(){
	return yearPublished;
	}
	
	public int getNumberPages(){
	return numberPages;
	}
	
	public String getISBN(){
	return ISBN;
	}
	
	public String getAwardWinner(){
		if (IS_WINNER){
			return WINNER;
		} else {
			return NON_WINNER;
		}
	}
	
	public boolean equals(Book checkThisBook){
	if (checkThisBook.getISBN() != this.ISBN() || checkThisBook.getCopyNumber() != this.copyNumber){
		return false;
	} else {
		return true;
	}
	
	public String toString(Book printThisBook){
	System.out.println("Title: " + printThisBook.getTitle() + " Year Published: " + printThisBook.getYearPublished() + " Number Pages: " + printThisBook.getNumberPages + "ISBN: " +printThisBook.getISBN() + " Copy Number: " + printThisBook.getCopyNumber() + " Award Winner: " + printThisBook.getAwardWinner() );                                                                              
	}
	
	public boolean isValid(Book checkThisBook){
		if (checkThisBook.getISBN.length() == 9 && checkThisBook.getTitle() != null){
			return true;
		} else {
			return false;	
		} 
	}
	
	}




















}