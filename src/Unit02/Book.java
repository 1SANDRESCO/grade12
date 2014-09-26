/* 
 */
package Unit02;

/**
 * Example Book Class
 */
public class Book {
    
    // Class Variables / Constants
    public static final int PUBLISHER_PENGUIN_BOOKS = 0;
    public static final int PUBLISHER_MCGRAW_HILL = 1;
    public static final int PUBLISHER_OTHER = 2;
    
    // Object Variables; Properties
    private String title;
    private String author;        
    private String publisher;
    private double price;    
    private int isbnNumber;
    private int copyNumber;
    private int numberOfPages;    
    private boolean hardCover;
    private boolean used;

    /**
     * Constructor; Empty
     */
    public Book() {
    }
    
    /**
     * Constructor; Primary Key
     */
    public Book( int isbnNumber, int copyNumber ) {
        this.isbnNumber = isbnNumber;
        this.copyNumber = copyNumber;
    }
    
    /**
     * Constructor; All Properties
     */
    public Book( String title, String author, String publisher, double price, int isbnNumber, int copyNumber, boolean hardCover, boolean used ) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.isbnNumber = isbnNumber;
        this.copyNumber = copyNumber;
        this.hardCover = hardCover;
        this.used = used;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor( String author ) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher( String publisher ) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice( double price ) {
        this.price = price;
    }

    public int getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber( int isbnNumber ) {
        this.isbnNumber = isbnNumber;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber( int copyNumber ) {
        this.copyNumber = copyNumber;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages( int numberOfPages ) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isHardCover() {
        return hardCover;
    }

    public void setHardCover( boolean hardCover ) {
        this.hardCover = hardCover;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed( boolean used ) {
        this.used = used;
    }

    @Override
    public String toString() {
        return  "---------------------------------" +
                "Book Object: " + 
                "\n\ttitle=" + title + 
                "\n\tauthor=" + author + 
                "\n\tpublisher=" + publisher + 
                "\n\tisbnNumber=" + isbnNumber + 
                "\n\tcopyNumber=" + copyNumber;
    }

    /**
    * "Same Object" - same ISBN #, same COPY #
    */
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Book other = (Book) obj;
        if ( this.isbnNumber != other.isbnNumber ) {
            return false;
        }
        if ( this.copyNumber != other.copyNumber ) {
            return false;
        }
        return true;
    }
    
}