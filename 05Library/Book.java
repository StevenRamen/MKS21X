public class Book {
    private String author;
    private String title;
    private String ISBN;

    public Book() {
	
    }
    
    public Book(String author, String title, String ISBN) {
	author = this.author;
	title = this.title;
	ISBN = this.ISBN;
    }

    
    public String getAuthor() {
	return author;
    }
    public String getTitle() {
	return title;
    }
    public String getISBN() {
	return ISBN;
    }

    public String toString() {
	return title + ", " + author + ", " + ISBN;
    }
    
    
}
